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

        Button button_trivia = findViewById(R.id.button_history);

        button_trivia.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SportActivity.class);

            startActivity(intent);
        });

        Button button_recognize = findViewById(R.id.sports);

        button_recognize.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MusicActivity.class);

            startActivity(intent);
        });

        Button button_lyrics = findViewById(R.id.button_music);

        button_lyrics.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), HistoryActivity.class);

            startActivity(intent);
        });
    }
}