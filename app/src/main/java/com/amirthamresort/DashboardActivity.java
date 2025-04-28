package com.amirthamresort;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private Button browseRoomsButton;
    private Button foodServiceButton;
    private Button medicalServiceButton;
    private Button notificationsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initializeViews();
        setupListeners();
    }

    private void initializeViews() {
        browseRoomsButton = findViewById(R.id.browseRoomsButton);
        foodServiceButton = findViewById(R.id.foodServiceButton);
        medicalServiceButton = findViewById(R.id.medicalServiceButton);
        notificationsButton = findViewById(R.id.notificationsButton);
    }

    private void setupListeners() {
        browseRoomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, DaysSelectionActivity.class);
                startActivity(intent);
            }
        });

        foodServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, FoodServiceActivity.class);
                startActivity(intent);
            }
        });

        medicalServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MedicalServiceActivity.class);
                startActivity(intent);
            }
        });

        notificationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });
    }
}
