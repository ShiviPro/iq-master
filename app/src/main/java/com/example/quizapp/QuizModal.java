package com.example.quizapp;

public class QuizModal {

    // variables for id, quizName, pointsPerQuestion, numberOfQuestions and minutesPerQuestion.
    private String questionName;
    private String options;
    private String correctAnswer;
    private int id;

    // creating getter and setter methods
    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public QuizModal(String questionName, String options, String correctAnswer) {
        this.questionName = questionName;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}