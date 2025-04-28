package com.amirthamresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FloorSelectionActivity extends AppCompatActivity {

    private Spinner floorSpinner;
    private Button proceedButton;
    private int selectedFloor = 1; // Default floor is 1
    private int numberOfDays = 1;  // Default days is 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_selection);

        floorSpinner = findViewById(R.id.floorSpinner);
        proceedButton = findViewById(R.id.proceedButton);

        // Get days passed from DaysSelectionActivity
        numberOfDays = getIntent().getIntExtra("days", 1);

        // Set up floor selection spinner
        String[] floors = {"Floor 1", "Floor 2", "Floor 3", "Floor 4"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, floors);
        floorSpinner.setAdapter(adapter);

        floorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFloor = position + 1; // Floor 1,2,3,4
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Default
                selectedFloor = 1;
            }
        });

        // Proceed to Room Selection
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FloorSelectionActivity.this, RoomSelectionActivity.class);
                intent.putExtra("floor", selectedFloor);
                intent.putExtra("days", numberOfDays);
                startActivity(intent);
            }
        });
    }
}
