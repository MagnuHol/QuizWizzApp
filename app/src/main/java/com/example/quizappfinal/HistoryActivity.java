package com.example.quizappfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    private int selectedAns = 0;
    private int qNUmber = 1;
    private int score = 0;
    ArrayList<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        setQuestion();


        findViewById(R.id.textView_option1).setOnClickListener(this);
        findViewById(R.id.textView_option2).setOnClickListener(this);
        findViewById(R.id.textView_option3).setOnClickListener(this);
        findViewById(R.id.textView_option4).setOnClickListener(this);
        findViewById(R.id.button_confirm).setOnClickListener(this);


    }

    @SuppressLint("ResourceType")
    public Question setQuestion() {

        questions = getQuestions();
        Question question = questions.get(qNUmber - 1);

        altView();

        Button button = findViewById(R.id.button_confirm);
        button.setText("Confirm");

        ImageView image = findViewById(R.id.ImageView_image);
        TextView questionText = findViewById(R.id.textView_question);
        TextView option1 = findViewById(R.id.textView_option1);
        TextView option2 = findViewById(R.id.textView_option2);
        TextView option3 = findViewById(R.id.textView_option3);
        TextView option4 = findViewById(R.id.textView_option4);

        image.setImageResource(question.image);
        questionText.setText(question.question);
        option1.setText(question.option1);
        option2.setText(question.option2);
        option3.setText(question.option3);
        option4.setText(question.option4);



        return question;
    }

    public void altView() {

        findViewById(R.id.textView_option1).setBackground(ContextCompat.getDrawable(this, R.drawable.textview_button));
        findViewById(R.id.textView_option2).setBackground(ContextCompat.getDrawable(this, R.drawable.textview_button));
        findViewById(R.id.textView_option3).setBackground(ContextCompat.getDrawable(this, R.drawable.textview_button));
        findViewById(R.id.textView_option4).setBackground(ContextCompat.getDrawable(this, R.drawable.textview_button));

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        Button button = findViewById(R.id.button_confirm);

        if (view.getId() == findViewById(R.id.textView_option1).getId()) {
            selectedAltView(findViewById(R.id.textView_option1), 1);
        } else if (view.getId() == findViewById(R.id.textView_option2).getId()) {
            selectedAltView(findViewById(R.id.textView_option2), 2);
        } else if (view.getId() == findViewById(R.id.textView_option3).getId()) {
            selectedAltView(findViewById(R.id.textView_option3), 3);
        } else if (view.getId() == findViewById(R.id.textView_option4).getId()) {
            selectedAltView(findViewById(R.id.textView_option4), 4);
        } else {
            if (selectedAns == 0) {
                qNUmber++;
                if (qNUmber <= questions.size()) {
                    setQuestion();
                    findViewById(R.id.textView_option1).setClickable(true);
                    findViewById(R.id.textView_option2).setClickable(true);
                    findViewById(R.id.textView_option3).setClickable(true);
                    findViewById(R.id.textView_option4).setClickable(true);
                } else {
                    Intent intent = new Intent(view.getContext(), com.example.quizappfinal.ScoreActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("activity", "History");
                    startActivity(intent);
                }

            } else {
                Question question = questions.get(qNUmber - 1);

                if (question.correctAns != selectedAns) {
                    answerView(selectedAns, R.drawable.wrong_textview_button);
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                } else {
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                    score++;
                }

                if (qNUmber == questions.size()) {
                    button.setText("Finish Quiz");
                } else {
                    button.setText("Next");
                }
                findViewById(R.id.textView_option1).setClickable(false);
                findViewById(R.id.textView_option2).setClickable(false);
                findViewById(R.id.textView_option3).setClickable(false);
                findViewById(R.id.textView_option4).setClickable(false);
                selectedAns = 0;


            }


        }

    }

    public void answerView(int answer, int answerView) {

        if (answer == 1) {
            findViewById(R.id.textView_option1).setBackground(ContextCompat.getDrawable(this, answerView));
        } else if (answer == 2) {
            findViewById(R.id.textView_option2).setBackground(ContextCompat.getDrawable(this, answerView));
        } else if (answer == 3) {
            findViewById(R.id.textView_option3).setBackground(ContextCompat.getDrawable(this, answerView));
        } else if (answer == 4) {
            findViewById(R.id.textView_option4).setBackground(ContextCompat.getDrawable(this, answerView));
        }
    }


    public void selectedAltView(TextView textView, int selectedAlternative) {
        altView();
        selectedAns = selectedAlternative;
        textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_button));
    }

    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> lisOfQuestions = new ArrayList<>();
        Question q1 = new Question(1, "who is this famous leader?", "Napoleon Bonaparte", "Winston Churchill", "Franklin.D.Roosevelt", "Harry Truman", 2, R.drawable.winston);
        Question q2 = new Question(1, "who is this famous leader?", "Mister Myagi", "Charles Dickens", "George Orwell", "Oswald Mosley", 2 ,R.drawable.charlesdick);
        Question q3 = new Question(1, "who is this famous leader?", "Li Sung Mao", "Mao Kim Suk", "Mao Zedong", "Mao Analog", 3 ,R.drawable.mao);
        Question q4 = new Question(1, "who is this famous leader?", "Napoleon Bonaparte", "Louis Bonaparte", "Charles Leon", "Mr.Bean", 1, R.drawable.napoleon);
        Question q5 = new Question(1, "who is this famous leader?", "Thomas Jefferson", "Thomas Eddison", "Winston Churchill", "Oswald Mosley", 4 ,R.drawable.oswaldmosley);
        Question q6 = new Question(1, "who is this famous leader?", "Vladimir Lenin", "Joseph Stalin", "Karl Marx", "Leon Trotsky", 1,R.drawable.vladlenin);
        Question q7 = new Question(1, "who is this famous leader?", "Thomas Jefferson", "Thomas Eddison", "George Orwell", "Ted Charles", 1,R.drawable.thomasjeff);
       

        lisOfQuestions.add(q1);
        lisOfQuestions.add(q2);
        lisOfQuestions.add(q3);
        lisOfQuestions.add(q4);
        lisOfQuestions.add(q5);
        lisOfQuestions.add(q6);
        lisOfQuestions.add(q7);


        return lisOfQuestions;
    }
}