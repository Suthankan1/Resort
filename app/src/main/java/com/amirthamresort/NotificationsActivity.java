package com.amirthamresort;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationsActivity extends AppCompatActivity {

    private TextView notificationsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        notificationsTextView = findViewById(R.id.notificationsTextView);
        notificationsTextView.setText("Notifications Coming Soon...");
    }
}
