package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class volunteerQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_quiz);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button submitQuizButton = findViewById(R.id.submitQuizButton);

        submitQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volunteerFeedIntent = new Intent(volunteerQuizActivity.this, VolunteerFeedActivity.class);
                startActivity(volunteerFeedIntent);
            }
        });
    }
}
