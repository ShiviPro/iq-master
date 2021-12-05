package com.example.quizapp;

public class AllQuizzesModal {

    // variables for id, quizName, pointsPerQuestion, numberOfQuestions and minutesPerQuestion.
    private String quizName;
    private int pointsPerQuestion;
    private int numberOfQuestions;
    private int minutesPerQuestion;
    private int id;

    // creating getter and setter methods
    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getPointsPerQuestion() {
        return pointsPerQuestion;
    }

    public void setPointsPerQuestion(int pointsPerQuestion) {
        this.pointsPerQuestion = pointsPerQuestion;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getMinutesPerQuestion() {
        return minutesPerQuestion;
    }

    public void setMinutesPerQuestion(int minutesPerQuestion) {
        this.minutesPerQuestion = minutesPerQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public AllQuizzesModal(String quizName, int pointsPerQuestion, int numberOfQuestions, int minutesPerQuestion) {
        this.quizName = quizName;
        this.pointsPerQuestion = pointsPerQuestion;
        this.numberOfQuestions = numberOfQuestions;
        this.minutesPerQuestion = minutesPerQuestion;
    }
}
