package com.example.quizappfinal;

public class Score {


    public String name;
    public int score;

    public Score(String name, int score) {

        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
