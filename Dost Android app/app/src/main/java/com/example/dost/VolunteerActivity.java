package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VolunteerActivity extends AppCompatActivity {

    public EditText volunteerEmailEditText, volunteerPasswordEditText;
    private Button volunteerLoginButton;
    private TextView volunteerRegisterButton;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        volunteerEmailEditText = findViewById(R.id.volunteerEmailEditText);
        volunteerPasswordEditText = findViewById(R.id.volunteerPasswordEditText);
        volunteerLoginButton = findViewById(R.id.voulteerLoginButton);
        volunteerRegisterButton = findViewById(R.id.volunteerRegisterButton);

        volunteerLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(volunteerEmailEditText.getText().toString(), volunteerPasswordEditText.getText().toString());
                //Log.i("VolunteerActivity", volunteerEmailEditText.getText().toString() + " " + volunteerPasswordEditText.getText().toString());
            }
        });
    }

    private void validate(String volunteerUserName, String volunteerPassowrd) {

        Log.i("UserName and Password", volunteerUserName + " " + volunteerPassowrd);

        if((volunteerUserName.equals("Admin")) && (volunteerPassowrd.equals("1234"))) {
            Intent volunteerFeedIntent = new Intent(VolunteerActivity.this, volunteerQuizActivity.class);
            startActivity(volunteerFeedIntent);
        } else {
            counter--;
            Toast.makeText(this, "Incorrect Username Or Password", Toast.LENGTH_SHORT).show();
            if(counter == 0){
                volunteerLoginButton.setEnabled(false);
                volunteerLoginButton.setText("5 Failed Attempts");
            }
        }
    }
}
