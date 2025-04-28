package com.amirthamresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BookingSummaryActivity extends AppCompatActivity {

    private TextView bookingDetailsTextView;
    private TextView totalAmountTextView;
    private TextView numberOfDaysTextView;
    private TextView colorCodesTextView;
    private Button confirmBookingButton;

    private ArrayList<Integer> selectedRooms; // Global variable
    private int days; // Store days globally if needed in future

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_summary);

        bookingDetailsTextView = findViewById(R.id.bookingDetailsTextView);
        totalAmountTextView = findViewById(R.id.totalAmountTextView);
        numberOfDaysTextView = findViewById(R.id.numberOfDaysTextView);
        colorCodesTextView = findViewById(R.id.colorCodesTextView);
        confirmBookingButton = findViewById(R.id.confirmBookingButton);

        // Get passed data
        selectedRooms = getIntent().getIntegerArrayListExtra("selectedRooms");
        days = getIntent().getIntExtra("days", 1);

        if (selectedRooms == null) {
            selectedRooms = new ArrayList<>();
        }

        // Set booking details
        showBookingDetails();

        // Confirm Booking Button Click
        confirmBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedRooms.isEmpty()) {
                    Toast.makeText(BookingSummaryActivity.this, "Please select rooms before confirming.", Toast.LENGTH_SHORT).show();
                } else {
                    // Booking confirmed, move to Confirmation Page
                    Intent intent = new Intent(BookingSummaryActivity.this, BookingConfirmationActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void showBookingDetails() {
        StringBuilder bookingDetails = new StringBuilder();
        int totalPrice = 0;

        for (int roomNum : selectedRooms) {
            String roomType = getRoomType(roomNum);
            int pricePerDay = getRoomPrice(roomNum);

            bookingDetails.append("Room ").append(roomNum)
                    .append(" (").append(roomType)
                    .append(") - Rs.").append(pricePerDay)
                    .append("/day\n");

            totalPrice += pricePerDay;
        }

        totalPrice *= days; // Multiply by number of days

        numberOfDaysTextView.setText("Number of Days: " + days);
        bookingDetailsTextView.setText(bookingDetails.toString());
        totalAmountTextView.setText("Total Amount: Rs. " + totalPrice);

        colorCodesTextView.setText(
                "Color Codes:\n"
                        + "Grey = Available\n"
                        + "Red = Unavailable\n"
                        + "Green = Selected"
        );
    }

    private String getRoomType(int roomNum) {
        if (roomNum >= 1 && roomNum <= 10) return "Single";
        if (roomNum >= 11 && roomNum <= 15) return "Couple";
        return "Family";
    }

    private int getRoomPrice(int roomNum) {
        if (roomNum >= 1 && roomNum <= 10) return 1000;
        if (roomNum >= 11 && roomNum <= 15) return 2000;
        return 5000;
    }
}
