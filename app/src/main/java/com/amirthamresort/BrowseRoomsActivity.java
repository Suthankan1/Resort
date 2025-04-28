package com.amirthamresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class BrowseRoomsActivity extends AppCompatActivity {

    private EditText numDaysInput;
    private Button selectFloorButton;
    private Button proceedButton;  // <-- changed here

    private int numDays = 0;
    private int selectedFloor = -1; // -1 means no floor selected yet

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_rooms);

        numDaysInput = findViewById(R.id.numDaysInput);
        selectFloorButton = findViewById(R.id.selectFloorButton);
        proceedButton = findViewById(R.id.proceedButton); // <-- changed here

        selectFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!numDaysInput.getText().toString().isEmpty()) {
                    numDays = Integer.parseInt(numDaysInput.getText().toString());
                    Intent intent = new Intent(BrowseRoomsActivity.this, FloorSelectionActivity.class);
                    intent.putExtra("numDays", numDays);
                    startActivityForResult(intent, 1);
                } else {
                    numDaysInput.setError("Please enter number of days");
                }
            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numDays > 0 && selectedFloor >= 0) {
                    Intent intent = new Intent(BrowseRoomsActivity.this, RoomSelectionActivity.class);
                    intent.putExtra("numDays", numDays);
                    intent.putExtra("selectedFloor", selectedFloor);
                    startActivity(intent);
                } else {
                    if (numDays == 0) {
                        numDaysInput.setError("Please enter number of days");
                    }
                    if (selectedFloor < 0) {
                        selectFloorButton.setError("Please select a floor");
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            selectedFloor = data.getIntExtra("selectedFloor", -1);
            selectFloorButton.setText("Floor: " + selectedFloor);
        }
    }
}
