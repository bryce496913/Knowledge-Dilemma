package com.example.assignment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HighScoreActivity extends AppCompatActivity {

    private ListView listViewHighScores;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        // Initialize UI elements.
        listViewHighScores = findViewById(R.id.listViewHighScores);
        buttonBack = findViewById(R.id.buttonBack);

        // Retrieve and display the high score from SharedPreferences.
        SharedPreferences sharedPreferences = getSharedPreferences("HighScores", Context.MODE_PRIVATE);
        String playerName = sharedPreferences.getString("PlayerName", "");
        int highScore = sharedPreferences.getInt("HighScore", 0);

        // Create a list of HighScore objects and add the current high score.
        List<HighScore> highScores = new ArrayList<>();
        highScores.add(new HighScore(playerName, highScore));

        // Create an adapter to display high scores in the ListView.
        HighScoreAdapter adapter = new HighScoreAdapter(this, R.layout.high_score_item, highScores);
        listViewHighScores.setAdapter(adapter);

        // Handle the "Back" button.
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(HighScoreActivity.this, MainActivity.class);
                startActivity(mainMenuIntent);
            }
        });
    }
}
