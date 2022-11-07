package com.example.quizappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Button buttonHistory = findViewById(R.id.historybutton);
        buttonHistory.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SportActivity.class);
            startActivity(intent);
        });
        Button ButtonSport = findViewById(R.id.sportsbutton);
        ButtonSport.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MusicActivity.class);
            startActivity(intent);
        });
        Button ButtonMusic = findViewById(R.id.musicbutton);
        ButtonMusic.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), HistoryActivity.class);
            startActivity(intent);
        });
    }
}