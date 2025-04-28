package com.amirthamresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DaysSelectionActivity extends AppCompatActivity {

    private EditText daysInput;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_selection);

        daysInput = findViewById(R.id.daysInput);
        proceedButton = findViewById(R.id.proceedButton);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String daysStr = daysInput.getText().toString().trim();
                if (!daysStr.isEmpty()) {
                    int days = Integer.parseInt(daysStr);
                    Intent intent = new Intent(DaysSelectionActivity.this, FloorSelectionActivity.class);
                    intent.putExtra("days", days);
                    startActivity(intent);
                } else {
                    Toast.makeText(DaysSelectionActivity.this, "Please enter number of days", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
