package com.smart.quizapp;

public class Question {

    String question;
    String option1, option2, option3, option4;
    int correctAnswer; // 1,2,3,4

    public Question(String question, String option1, String option2,
                    String option3, String option4, int correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
    }
}