package com.example.quizappfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        String activity = getIntent().getStringExtra("activity");

        switch (activity) {
            case "sport":
                setHighscoresSportFirebase();
                setHighscoreSport();
                break;
            case "music":
                setHighscoresMusicFirebase();
                setHighscoresMusic();
                break;
            case "history":
                setHighscoresHistoryFirebase();
                setHighscoreHisory();
                break;
        }

        Button button_mainActivity = findViewById(R.id.button_mainActivity);

        button_mainActivity.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            startActivity(intent);
        });

    }

    public void setHighscoreSport(){
        TextView textView_highscore = findViewById(R.id.textView_highscore);
        SharedPreferences sport = getSharedPreferences("Sport", 0);
        int score = getIntent().getIntExtra("score", 0);

        TextView textView_score = findViewById(R.id.textView_score);
        textView_score.setText("Score: " + String.valueOf(score));
        int highscore = sport.getInt("HIGHSCORE", 0);

        if(score > highscore){
            textView_highscore.setText("Best Score: " + score);

            SharedPreferences.Editor editor = sport.edit();
            editor.putInt("HIGHSCORE", score);
            editor.apply();
        }
        else {
            textView_highscore.setText("Best Score: " + highscore);
        }


    }

    public void setHighscoresMusic(){
        TextView textView_highscore = findViewById(R.id.textView_highscore);
        SharedPreferences music = getSharedPreferences("RECOGNIZE", 0);
        int score = getIntent().getIntExtra("score", 0);

        TextView textView_score = findViewById(R.id.textView_score);
        textView_score.setText("Score: " + String.valueOf(score));
        int highscore = music.getInt("HIGHSCORE", 0);

        if(score > highscore){
            textView_highscore.setText("Best Score: " + score);

            SharedPreferences.Editor editor = music.edit();
            editor.putInt("HIGHSCORE", score);
            editor.apply();
        }
        else {
            textView_highscore.setText("Best Score: " + highscore);
        }


    }

    public void setHighscoreHisory(){
        TextView textView_highscore = findViewById(R.id.textView_highscore);
        SharedPreferences history = getSharedPreferences("Music", 0);
        int score = getIntent().getIntExtra("score", 0);

        TextView textView_score = findViewById(R.id.textView_score);
        textView_score.setText("Score: " + String.valueOf(score));
        int highscore = history.getInt("HIGHSCORE", 0);

        if(score > highscore){
            textView_highscore.setText("Best Score: " + score);

            SharedPreferences.Editor editor = history.edit();
            editor.putInt("HIGHSCORE", score);
            editor.apply();
        }
        else {
            textView_highscore.setText("Best Score: " + highscore);
        }


    }

    public void setHighscoresSportFirebase(){
        int score = getIntent().getIntExtra("score",0);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quizappfinal-77f04-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("HighscoresSport");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userName = user.getDisplayName();

        Score highscore = new Score(userName, score);

        myRef.push().setValue(highscore);
    }

    public void setHighscoresMusicFirebase(){
        int score = getIntent().getIntExtra("score",0);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quizappfinal-77f04-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("HighscoresMusic");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userName = user.getDisplayName();

        Score highscore = new Score(userName, score);

        myRef.push().setValue(highscore);
    }

    public void setHighscoresHistoryFirebase(){
        int score = getIntent().getIntExtra("score",0);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://quizappfinal-77f04-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("HighscoresHistory");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String userName = user.getDisplayName();

        Score highscore = new Score(userName, score);

        myRef.push().setValue(highscore);
    }



}