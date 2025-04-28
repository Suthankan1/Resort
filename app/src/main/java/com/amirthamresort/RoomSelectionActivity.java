package com.amirthamresort;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RoomSelectionActivity extends AppCompatActivity {

    private GridLayout roomGridLayout;
    private Button proceedButton;
    private int selectedFloor = 1;
    private int numberOfDays = 1;

    // Track selected rooms
    private ArrayList<Integer> selectedRooms = new ArrayList<>();

    // Store unavailable rooms (first and last rooms always unavailable)
    private final ArrayList<Integer> unavailableRooms = new ArrayList<Integer>() {{
        add(1);
        add(20);
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_selection);

        roomGridLayout = findViewById(R.id.roomGridLayout);
        proceedButton = findViewById(R.id.proceedButton);

        // Get selected floor and days from previous activity
        Intent intent = getIntent();
        selectedFloor = intent.getIntExtra("floor", 1);
        numberOfDays = intent.getIntExtra("days", 1);

        setupRoomGrid();

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedRooms.isEmpty()) {
                    Toast.makeText(RoomSelectionActivity.this, "Please select at least one room!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent bookingIntent = new Intent(RoomSelectionActivity.this, BookingSummaryActivity.class);
                    bookingIntent.putIntegerArrayListExtra("selectedRooms", selectedRooms);
                    bookingIntent.putExtra("days", numberOfDays);
                    startActivity(bookingIntent);
                    finish();
                }
            }
        });
    }

    private void setupRoomGrid() {
        int totalRooms = 20; // 4 rows × 5 columns = 20 rooms

        roomGridLayout.setRowCount(4);
        roomGridLayout.setColumnCount(5);

        for (int i = 1; i <= totalRooms; i++) {
            TextView roomView = new TextView(this);

            // Set basic layout params
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = 200;
            params.height = 200;
            params.setMargins(10, 10, 10, 10);
            roomView.setLayoutParams(params);
            roomView.setGravity(Gravity.CENTER);
            roomView.setTextSize(18);
            roomView.setTextColor(Color.WHITE);

            // Set room type letter
            String roomLabel = getRoomLabel(i);
            roomView.setText(roomLabel + "\n" + i);

            // Set color based on availability
            if (unavailableRooms.contains(i)) {
                roomView.setBackgroundColor(Color.parseColor("#800000")); // Dull Red
                roomView.setEnabled(false); // Can't click
            } else {
                roomView.setBackgroundColor(Color.GRAY); // Available (grey)

                roomView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int roomNumber = Integer.parseInt(((TextView) v).getText().toString().split("\n")[1]);

                        if (selectedRooms.contains(roomNumber)) {
                            // Deselect
                            selectedRooms.remove(Integer.valueOf(roomNumber));
                            v.setBackgroundColor(Color.GRAY);
                        } else {
                            // Select
                            selectedRooms.add(roomNumber);
                            v.setBackgroundColor(Color.GREEN);
                        }
                    }
                });
            }

            roomGridLayout.addView(roomView);
        }
    }

    private String getRoomLabel(int roomNum) {
        if (roomNum >= 1 && roomNum <= 10) return "S"; // Single room
        if (roomNum >= 11 && roomNum <= 15) return "C"; // Couple room
        return "F"; // Family room
    }
}
