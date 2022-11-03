package com.example.quizappfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class SportActivity extends AppCompatActivity implements View.OnClickListener{

    private int selectedAns = 0;
    private int qNUmber = 1;
    private int score = 0;
    ArrayList<Question> questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        setQuestion();
        getQuestion();

        findViewById(R.id.textView_option1).setOnClickListener(this);
        findViewById(R.id.textView_option2).setOnClickListener(this);
        findViewById(R.id.textView_option3).setOnClickListener(this);
        findViewById(R.id.textView_option4).setOnClickListener(this);
        findViewById(R.id.button_confirm).setOnClickListener(this);

    }

    public Question setQuestion(){

        questions = getQuestion();
        Question question = questions.get(qNUmber - 1);

        altView();

        Button button = findViewById(R.id.button_confirm);
        button.setText("Confirm");

        TextView questionText = findViewById(R.id.textView_question);
        TextView opt1text = findViewById(R.id.textView_option1);
        TextView opt2text = findViewById(R.id.textView_option2);
        TextView opt3text = findViewById(R.id.textView_option3);
        TextView opt4text = findViewById(R.id.textView_option4);

        questionText.setText(question.question);
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


    @SuppressLint("SetTextI18n")
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
                qNUmber++;
                if(qNUmber <= questions.size()){
                    setQuestion();
                    findViewById(R.id.textView_option1).setClickable(true);
                    findViewById(R.id.textView_option2).setClickable(true);
                    findViewById(R.id.textView_option3).setClickable(true);
                    findViewById(R.id.textView_option4).setClickable(true);
                }
                else {
                    Intent intent = new Intent(view.getContext(),com.example.quizappfinal.ScoreActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("activity", "sport");
                    startActivity(intent);
                }

            }
            else{
                Question question = questions.get(qNUmber-1);

                if(question.correctAns != selectedAns){
                    answerView(selectedAns, R.drawable.wrong_textview_button);
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                }
                else {
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                    score++;
                }

                if(qNUmber == questions.size()){
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

    public static ArrayList<Question> getQuestion() {
        ArrayList<Question> lisOfQuestions = new ArrayList<>();

        Question q1 = new Question(1, "Who won the world cup in 1998", "France", "Germany", "England", "Italy", 1);
        Question q2 = new Question(1, "Who has won Ballon d'Or most times", "Christiano Ronaldo", "Lionel Messi", "Ronaldinho", "Johan Cryuff", 2);
        Question q3 = new Question(1, "Which sport involves tucks and pikes", "Wrestling", "Kickboxing", "Diving", "Javelin", 3);
        Question q4 = new Question(1, "The Chicago Cubs and Boston Red Sox play which sport?", "American Fotball", "Baseball", "Basketball", "Ice Hokey", 2);
        Question q5 = new Question(1, "How many grandslams has Serena Williams won", "22", "19", "23", "14", 3);
        Question q6 = new Question(1, "How many regulation strokes are there in swimming?", "3", "4", "5", "6", 2);
        Question q7 = new Question(1, "What has Muhammad Ali’s original name? ", "Cassius Clay", "Roger Bronson", "Muhammad Keita", "Don Jonson", 1);
        Question q8 = new Question(1, "who was awarded best player 2022", "Braut Haaland", "Karim Benzema", "Lionel Messi", "Lewandowski", 2);

        lisOfQuestions.add(q1);
        lisOfQuestions.add(q2);
        lisOfQuestions.add(q3);
        lisOfQuestions.add(q4);
        lisOfQuestions.add(q5);
        lisOfQuestions.add(q6);
        lisOfQuestions.add(q7);
        lisOfQuestions.add(q8);

        return lisOfQuestions;
    }
}