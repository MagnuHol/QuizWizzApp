package com.example.quizappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    private int currentQuestion = 1;
    private int selectedAns = 0;
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

    public Question setQuestion() {

        questions = getQuestions();
        Question question = questions.get(currentQuestion - 1);

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
                currentQuestion++;
                if (currentQuestion <= questions.size()) {
                    setQuestion();
                    findViewById(R.id.textView_option1).setClickable(true);
                    findViewById(R.id.textView_option2).setClickable(true);
                    findViewById(R.id.textView_option3).setClickable(true);
                    findViewById(R.id.textView_option4).setClickable(true);
                } else {
                    Intent intent = new Intent(view.getContext(), ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("activity", "History");
                    startActivity(intent);
                }

            } else {
                Question question = questions.get(currentQuestion - 1);

                if (question.correctAns != selectedAns) {
                    answerView(selectedAns, R.drawable.wrong_textview_button);
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                } else {
                    answerView(question.correctAns, R.drawable.correct_textview_button);
                    score++;
                }
                if (currentQuestion == questions.size()) {
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
        ArrayList<Question> QuestionList = new ArrayList<>();
        Question one = new Question(1, "who is this famous leader?", "Napoleon Bonaparte", "Winston Churchill", "Franklin.D.Roosevelt", "Harry Truman", 2, R.drawable.winston);
        Question two = new Question(1, "who is this famous leader?", "Mister Myagi", "Charles Dickens", "George Orwell", "Oswald Mosley", 2 ,R.drawable.charlesdick);
        Question three = new Question(1, "who is this famous leader?", "Li Sung Mao", "Mao Kim Suk", "Mao Zedong", "Mao Analog", 3 ,R.drawable.mao);
        Question four = new Question(1, "who is this famous leader?", "Napoleon Bonaparte", "Louis Bonaparte", "Charles Leon", "Mr.Bean", 1, R.drawable.napoleon);
        Question five = new Question(1, "who is this famous leader?", "Thomas Jefferson", "Thomas Eddison", "Winston Churchill", "Oswald Mosley", 4 ,R.drawable.oswaldmosley);
        Question six = new Question(1, "who is this famous leader?", "Vladimir Lenin", "Joseph Stalin", "Karl Marx", "Leon Trotsky", 1,R.drawable.vladlenin);
        Question seven = new Question(1, "who is this famous leader?", "Thomas Jefferson", "Thomas Eddison", "George Orwell", "Ted Charles", 1,R.drawable.thomasjeff);

        QuestionList.add(one);
        QuestionList.add(two);
        QuestionList.add(three);
        QuestionList.add(four);
        QuestionList.add(five);
        QuestionList.add(six);
        QuestionList.add(seven);


        return QuestionList;
    }
}