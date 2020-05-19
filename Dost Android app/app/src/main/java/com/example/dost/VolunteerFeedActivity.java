package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class VolunteerFeedActivity extends AppCompatActivity {

    Button volunteerSendButton, capsButton;
    EditText volunteerMessageEditText;
    String volunteerUserMessage;

    ListView volunteerChatListView;
    ArrayList<String> volunteerChatArrayList;
    ArrayAdapter volunteerArrayAdapter;
    //client volunteerClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voulnteer_feed);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chat Room");

        volunteerSendButton = findViewById(R.id.volunteerSendButton);

        capsButton = findViewById(R.id.capsButton);
        capsButton.setBackgroundColor(Color.RED);
        capsButton.setTextColor(Color.WHITE);

        volunteerMessageEditText = findViewById(R.id.volunteerMessageEditText);

        volunteerChatListView = findViewById(R.id.volunteerChatListView);
        volunteerChatArrayList = new ArrayList<>();
        volunteerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, volunteerChatArrayList);

        volunteerSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                volunteerUserMessage = volunteerMessageEditText.getText().toString();
                //volunteerClient.writer.println(volunteerUserMessage);
                //volunteerClient.writer.flush();
                volunteerChatArrayList.add("> You: " + volunteerUserMessage);
                volunteerMessageEditText.setText("");
                volunteerChatListView.setAdapter(volunteerArrayAdapter);
            }
        });

        capsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VolunteerFeedActivity.this, "Message Sent to Caps", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
