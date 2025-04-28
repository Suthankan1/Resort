package com.amirthamresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BookingConfirmationActivity extends AppCompatActivity {

    private Button homeButton, newBookingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirmation);

        homeButton = findViewById(R.id.homeButton);
        newBookingButton = findViewById(R.id.newBookingButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingConfirmationActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        newBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingConfirmationActivity.this, DaysSelectionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
