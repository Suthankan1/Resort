package com.amirthamresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DaysInputActivity extends AppCompatActivity {

    private EditText editTextDays;
    private Spinner spinnerFloor;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_input);

        editTextDays = findViewById(R.id.editTextDays);
        spinnerFloor = findViewById(R.id.spinnerFloor);
        buttonNext = findViewById(R.id.buttonNext);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.floor_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFloor.setAdapter(adapter);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String days = editTextDays.getText().toString();
                String floor = spinnerFloor.getSelectedItem().toString();

                if (days.isEmpty() || floor.equals("Select Floor")) {
                    Toast.makeText(DaysInputActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DaysInputActivity.this, BrowseRoomsActivity.class);
                    intent.putExtra("DAYS", days);
                    intent.putExtra("FLOOR", floor);
                    startActivity(intent);
                }
            }
        });
    }
}
