package com.amirthamresort;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SelectRoomActivity extends AppCompatActivity {

    private TextView textViewSelectionSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room);

        textViewSelectionSummary = findViewById(R.id.textViewSelectionSummary);

        // Get the data passed from BrowseRoomsActivity
        int numberOfDays = getIntent().getIntExtra("NUMBER_OF_DAYS", 0);
        String selectedFloor = getIntent().getStringExtra("SELECTED_FLOOR");

        // Show a summary to user
        String summary = "You selected:\n" +
                "Number of Days: " + numberOfDays + "\n" +
                "Floor: " + selectedFloor;

        textViewSelectionSummary.setText(summary);
    }
}
