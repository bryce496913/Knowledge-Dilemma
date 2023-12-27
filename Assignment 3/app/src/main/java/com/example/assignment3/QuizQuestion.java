package com.example.assignment3;

public class QuizQuestion {
    private final String fact;
    private final boolean isTrue;
    private final int imageResourceId;

    public QuizQuestion(String fact, boolean isTrue, int imageResourceId) {
        this.fact = fact;
        this.isTrue = isTrue;
        this.imageResourceId = imageResourceId;
    }

    public String getFact() {
        return fact;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

