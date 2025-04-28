package com.amirthamresort;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MedicalServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_service);

        TextView textView = findViewById(R.id.medicalServiceText);
        textView.setText("Medical Service Coming Soon...");
    }
}
