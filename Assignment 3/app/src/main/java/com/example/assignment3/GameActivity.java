package com.example.assignment3;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class GameActivity extends AppCompatActivity {

    private TextView textViewFact;
    private Button buttonTrue;
    private Button buttonFalse;
    private TextView textViewScore;
    private TextView textViewProgress;
    private FrameLayout frameLayoutFeedback;
    private View viewCorrectFeedback;
    private View viewWrongFeedback;

    private int currentQuestionIndex = 0;
    private int score = 0;
    private int totalQuestions;
    private boolean feedbackShowing = false;
    private static final int FEEDBACK_DELAY = 1000;

    private ArrayList<QuizQuestion> quizQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initialize UI elements.
        textViewFact = findViewById(R.id.textViewFact);
        buttonTrue = findViewById(R.id.buttonTrue);
        buttonFalse = findViewById(R.id.buttonFalse);
        textViewScore = findViewById(R.id.textViewScore);
        textViewProgress = findViewById(R.id.textViewProgress);
        frameLayoutFeedback = findViewById(R.id.frameLayoutFeedback);
        viewCorrectFeedback = findViewById(R.id.viewCorrectFeedback);
        viewWrongFeedback = findViewById(R.id.viewWrongFeedback);

        // Get the quiz questions from QuizData.
        quizQuestions = QuizData.getQuizQuestions();
        totalQuestions = quizQuestions.size();

        // Display the first question.
        showQuestion();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the relevant state
        outState.putInt("currentQuestionIndex", currentQuestionIndex);
        outState.putInt("score", score);
        outState.putBoolean("feedbackShowing", feedbackShowing);

        //save other state data.
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore the relevant state data
        currentQuestionIndex = savedInstanceState.getInt("currentQuestionIndex");
        score = savedInstanceState.getInt("score");
        feedbackShowing = savedInstanceState.getBoolean("feedbackShowing");
    }

    private void showQuestion() {
        if (currentQuestionIndex < totalQuestions) {
            QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);
            textViewFact.setText(currentQuestion.getFact());

            ImageView imageViewQuestionImage = findViewById(R.id.imageViewQuestionImage);
            imageViewQuestionImage.setImageResource(currentQuestion.getImageResourceId());

            // Set click listeners for the True and False buttons.
            buttonTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(true);
                }
            });

            buttonFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(false);
                }
            });

            // Update progress text
            int currentQuestionNumber = currentQuestionIndex + 1;
            String progressText = String.format(Locale.getDefault(), "Question %d of %d", currentQuestionNumber, totalQuestions);
            textViewProgress.setText(progressText);

            // Hide feedback views
            frameLayoutFeedback.setVisibility(View.GONE);
            feedbackShowing = false;
        } else {
            // All questions have been answered. Display the final score.
            displayFinalScore();
        }
    }

    private void checkAnswer(boolean userAnswer) {
        if (feedbackShowing) {
            // Prevent multiple clicks while feedback is showing
            return;
        }

        QuizQuestion currentQuestion = quizQuestions.get(currentQuestionIndex);

        if (userAnswer == currentQuestion.isTrue()) {
            // User's answer is correct.
            score++;
            showFeedback(true);
        } else {
            // User's answer is wrong.
            showFeedback(false);
            displayFinalScore();
            return;
        }

        // Update the score text
        textViewScore.setText("Score: " + score);

        // Move to the next question after a delay.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                currentQuestionIndex++;
                showQuestion();
            }
        }, FEEDBACK_DELAY);
    }

    private void showFeedback(boolean isCorrect) {
        feedbackShowing = true;

        if (isCorrect) {
            // Show green background for correct answer
            viewCorrectFeedback.setAlpha(1f);
            viewWrongFeedback.setAlpha(0f);
        } else {
            // Show red background for wrong answer
            viewCorrectFeedback.setAlpha(0f);
            viewWrongFeedback.setAlpha(1f);
        }

        frameLayoutFeedback.setVisibility(View.VISIBLE);
    }

    private void displayFinalScore() {
        // Show the endgame layout with the final score.
        Intent endgameIntent = new Intent(GameActivity.this, EndgameActivity.class);
        endgameIntent.putExtra("final_score", score);
        startActivity(endgameIntent);
    }

    private void returnToOpeningActivity() {
        //return to the opening activity.
        Intent openingIntent = new Intent(this, MainActivity.class);
        startActivity(openingIntent);
    }

    @Override
    public void onBackPressed() {
        // Stop back button press
    }
}





