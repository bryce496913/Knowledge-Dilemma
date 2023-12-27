package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class HighScoreAdapter extends ArrayAdapter<HighScore> {
    private final Context context;
    private final int resource;

    public HighScoreAdapter(Context context, int resource, List<HighScore> highScores) {
        super(context, resource, highScores);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        // Get the HighScore object at the current position.
        HighScore highScore = getItem(position);

        if (highScore != null) {
            TextView playerNameTextView = convertView.findViewById(R.id.textViewUsername);
            TextView scoreTextView = convertView.findViewById(R.id.textViewScore);

            // Set the player name and score in the item layout.
            playerNameTextView.setText(highScore.getPlayerName());
            scoreTextView.setText(String.valueOf(highScore.getScore()));
        }

        return convertView;
    }
}

