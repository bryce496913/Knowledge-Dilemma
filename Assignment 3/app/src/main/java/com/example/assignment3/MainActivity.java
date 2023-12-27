package com.example.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        // Initialize UI elements.
        buttonStart = findViewById(R.id.buttonStart);
        buttonHighScore = findViewById(R.id.buttonHighScore);

        // Set click listeners for the Start and High Score buttons.
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the game
                Intent gameIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });

        buttonHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the high score layout
                Intent highScoreIntent = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(highScoreIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        // Stop back button press
    }
}


