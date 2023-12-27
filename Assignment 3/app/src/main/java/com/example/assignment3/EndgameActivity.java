package com.example.assignment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EndgameActivity extends AppCompatActivity {

    private TextView textViewFinalScore;
    private Button buttonTryAgain;
    private Button buttonMainMenu;
    private Button buttonHighScore;
    private EditText editTextName;
    private Button buttonSubmitHighScore;

    private int finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);

        if (savedInstanceState != null) {
            finalScore = savedInstanceState.getInt("score");
        }

        // Initialize UI elements.
        textViewFinalScore = findViewById(R.id.textViewFinalScore);
        buttonTryAgain = findViewById(R.id.buttonTryAgain);
        buttonMainMenu = findViewById(R.id.buttonMainMenu);
        buttonHighScore = findViewById(R.id.buttonHighScore);
        editTextName = findViewById(R.id.editTextName);
        buttonSubmitHighScore = findViewById(R.id.buttonSubmitHighScore);

        // Get the final score
        finalScore = getIntent().getIntExtra("final_score", 0);

        textViewFinalScore.setText("Final Score: " + finalScore);

        // Set click listeners for buttons.
        buttonTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Restart the game.
                Intent gameIntent = new Intent(EndgameActivity.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });

        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Return to the main menu.
                Intent mainMenuIntent = new Intent(EndgameActivity.this, MainActivity.class);
                startActivity(mainMenuIntent);
            }
        });

        buttonHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //High Score
                Intent mainMenuIntent = new Intent(EndgameActivity.this, HighScoreActivity.class);
                startActivity(mainMenuIntent);
            }
        });

        buttonSubmitHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = editTextName.getText().toString().trim();
                if (!playerName.isEmpty()) {
                    // Save the high score using SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("HighScores", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    int previousHighScore = sharedPreferences.getInt("HighScore", 0);

                    if (finalScore > previousHighScore) {
                        editor.putString("PlayerName", playerName);
                        editor.putInt("HighScore", finalScore);
                        editor.apply();
                    }

                    // High Score page
                    Intent mainMenuIntent = new Intent(EndgameActivity.this, HighScoreActivity.class);
                    startActivity(mainMenuIntent);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Stop back button press
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score", finalScore);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
