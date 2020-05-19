package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button volunteerButton, afflictedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        volunteerButton = findViewById(R.id.volunteerButton);
        afflictedButton = findViewById(R.id.afflictedButton);

        volunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginVolunteerIntent = new Intent(MainActivity.this, VolunteerActivity.class);
                startActivity(loginVolunteerIntent);
            }
        });

        afflictedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginAfflictedIntent = new Intent(MainActivity.this, AfflictedActivity.class);
                startActivity(loginAfflictedIntent);
            }
        });
    }
}
