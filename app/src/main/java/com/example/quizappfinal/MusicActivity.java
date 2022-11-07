package com.example.quizappfinal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {
    private int currentQuestion = 1;
    private int selectedAns = 0;
    private int score = 0;
    ArrayList<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        setQuestion();
        findViewById(R.id.textView_option1).setOnClickListener(this);
        findViewById(R.id.textView_option2).setOnClickListener(this);
        findViewById(R.id.textView_option3).setOnClickListener(this);
        findViewById(R.id.textView_option4).setOnClickListener(this);
        findViewById(R.id.button_confirm).setOnClickListener(this);

    }

    public Question setQuestion(){

        questions = getQuestions();
        Question question = questions.get(currentQuestion - 1);

        altView();

        Button button = findViewById(R.id.button_confirm);
        button.setText("Confirm");

        Button button_playSong = findViewById(R.id.button_playSong);

        button_playSong.setOnClickListener(view -> {
            MediaPlayer mediaPlayer = question.mediaPlayer;
            mediaPlayer.start();
        });

        TextView questiontext = findViewById(R.id.textView_question);
        TextView opt1text = findViewById(R.id.textView_option1);
        TextView opt2text = findViewById(R.id.textView_option2);
        TextView opt3text = findViewById(R.id.textView_option3);
        TextView opt4text = findViewById(R.id.textView_option4);

        questiontext.setText(question.question);
        opt1text.setText(question.option1);
        opt2text.setText(question.option2);
        opt3text.setText(question.option3);
        opt4text.setText(question.option4);

        return question;
    }

    public void altView(){

        findViewById(R.id.textView_option1).setBackground(ContextCompat.getDrawable(this,R.drawable.textview_button));
        findViewById(R.id.textView_option2).setBackground(ContextCompat.getDrawable(this,R.drawable.textview_button));
        findViewById(R.id.textView_option3).setBackground(ContextCompat.getDrawable(this,R.drawable.textview_button));
        findViewById(R.id.textView_option4).setBackground(ContextCompat.getDrawable(this,R.drawable.textview_button));
    }

    @Override
    public void onClick(View view) {

        Button button = findViewById(R.id.button_confirm);

        if(view.getId() == findViewById(R.id.textView_option1).getId()) {
            selectedAltView(findViewById(R.id.textView_option1), 1);
        }
        else if(view.getId() == findViewById(R.id.textView_option2).getId()){
            selectedAltView(findViewById(R.id.textView_option2), 2);
        }
        else if(view.getId() == findViewById(R.id.textView_option3).getId()){
            selectedAltView(findViewById(R.id.textView_option3), 3);
        }
        else if(view.getId() == findViewById(R.id.textView_option4).getId()){
            selectedAltView(findViewById(R.id.textView_option4), 4);
        }
        else {
            if(selectedAns ==0){
                currentQuestion++;
                if(currentQuestion <= questions.size()){
                    setQuestion();
                    findViewById(R.id.textView_option1).setClickable(true);
                    findViewById(R.id.textView_option2).setClickable(true);
                    findViewById(R.id.textView_option3).setClickable(true);
                    findViewById(R.id.textView_option4).setClickable(true);
                }
                else {
                    Intent intent = new Intent(view.getContext(), ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("activity", "music");
                    startActivity(intent);
                }
            }
            else{
                Question question = questions.get(currentQuestion-1);

                if(question.correctAns != selectedAns){
                    answerView(selectedAns, R.drawable.wrong_textview_button);
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                }
                else {
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                    score++;
                }
                if(currentQuestion == questions.size()){
                    button.setText("Finish Quiz");
                }
                else{
                    button.setText("Next");
                }
                findViewById(R.id.textView_option1).setClickable(false);
                findViewById(R.id.textView_option2).setClickable(false);
                findViewById(R.id.textView_option3).setClickable(false);
                findViewById(R.id.textView_option4).setClickable(false);
                selectedAns =0;
                MediaPlayer mediaPlayer = question.mediaPlayer;
                mediaPlayer.stop();
            }
        }
    }

    public void answerView(int answer, int answerView){

        if(answer == 1){
            findViewById(R.id.textView_option1).setBackground(ContextCompat.getDrawable(this, answerView));
        }
        else if (answer == 2){
            findViewById(R.id.textView_option2).setBackground(ContextCompat.getDrawable(this, answerView));
        }
        else if (answer == 3){
            findViewById(R.id.textView_option3).setBackground(ContextCompat.getDrawable(this, answerView));
        }
        else if (answer == 4){
            findViewById(R.id.textView_option4).setBackground(ContextCompat.getDrawable(this, answerView));
        }
    }

    public void selectedAltView(TextView textView, int selectedAlternative){
        altView();
        selectedAns = selectedAlternative;
        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_button));
    }

    public ArrayList<Question> getQuestions (){

        ArrayList<Question> listOfQuestions = new ArrayList<>();
        Question one = new Question(1, "What song is this?", MediaPlayer.create(getApplicationContext(),R.raw.hurrylove), "Hurry love", "Gone in the wind", "Showbiz", "The Void", 1);
        Question two = new Question(1, "What song is this?", MediaPlayer.create(getApplicationContext(), R.raw.intheair), "One more night", "Sunburn", "In the air tonight", "Piano Thing", 3);
        Question three = new Question(1, "What song is this?", MediaPlayer.create(getApplicationContext(), R.raw.easylover), "Unintended", "Falling Away With You", "Citizen Erased", "Eternally Missed", 3);
        Question four = new Question(1, "What song is this?", MediaPlayer.create(getApplicationContext(), R.raw.paradise), "Stranger like me", "Another day in paradise", "Think twice", "Feeling Good", 3);
        Question five = new Question(1, "What song is this?", MediaPlayer.create(getApplicationContext(), R.raw.strangers), "Tell me more", "two hearts", "Songs sang", "Stranger like me", 4);

        listOfQuestions.add(one);
        listOfQuestions.add(two);
        listOfQuestions.add(three);
        listOfQuestions.add(four);
        listOfQuestions.add(five);

        return listOfQuestions;
    }
}