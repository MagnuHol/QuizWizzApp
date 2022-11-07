package com.example.quizappfinal;

import android.media.Image;
import android.media.MediaPlayer;
import android.widget.ImageView;

public class Question {
    public int id;
    public String question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public int correctAns;
    public MediaPlayer mediaPlayer;
    public int image;



    public Question(int id, String question, String option1, String option2, String option3, String option4, int correctAns, int image) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = correctAns;
        this.image = image;
    }


    public Question(int id, String question, String option1, String option2, String option3, String option4, int correctAns) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = correctAns;
    }


    public Question(int id, String question, MediaPlayer mediaPlayer, String option1, String option2, String option3, String option4, int correctAns) {
        this.id = id;
        this.question = question;
        this.mediaPlayer = mediaPlayer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAns = correctAns;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public int getImage() { return image; }

    public void setImage(int image) { this.image = image; }



}