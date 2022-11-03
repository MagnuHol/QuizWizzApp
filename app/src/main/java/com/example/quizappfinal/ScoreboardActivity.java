package com.example.quizappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        Button button_mainActivity = findViewById(R.id.button_mainActivity);

        setHighscoreHistory();

        button_mainActivity.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        });



    }


    public void setHighscoreHistory(){
        TextView textView_HighscoreHistory = findViewById(R.id.textView_HighscoreHistory);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quizappfinal-77f04-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("HighscoreHistory");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    // TODO: handle the post

                    String name = postSnapshot.child("name").getValue().toString();
                    String score = postSnapshot.child("score").getValue().toString();

                    ArrayList<String> highscores = new ArrayList<>();
                    highscores.add(name + "  -  "  + score + "/10");

                    textView_HighscoreHistory.setText(highscores.get(0));

                    Log.d("FIREBASE", highscores.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("FIREBASE", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
    }



}