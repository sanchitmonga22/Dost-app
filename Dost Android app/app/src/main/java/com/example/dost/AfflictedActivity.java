package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AfflictedActivity extends AppCompatActivity {

    EditText afflictedNameEditText;
    Button afflictedEnterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afflicted);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        afflictedNameEditText = findViewById(R.id.afflictedNameEditText);
        afflictedEnterButton = findViewById(R.id.afflictedEnterButton);

        afflictedEnterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (afflictedNameEditText.getText().toString().isEmpty()) {
                    Toast.makeText(AfflictedActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent feedIntentAfflicted = new Intent(AfflictedActivity.this, AfflictedFeedActivity.class);
                    startActivity(feedIntentAfflicted);
                }
            }

        });

    }

}
