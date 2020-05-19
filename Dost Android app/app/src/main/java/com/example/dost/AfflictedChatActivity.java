package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import java.util.ArrayList;

public class AfflictedChatActivity extends AppCompatActivity {

    Button afflictedSendButton;
    EditText messageEditText;
    String afflictedUserMessage;

    ListView chatActivityList;
    ArrayList<String> afflictedChatArrayList;
    ArrayAdapter afflictedArrayAdapter;
    //client afflictedClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chat Room");

        setContentView(R.layout.activity_afflicted_chat);

        afflictedSendButton = (Button) findViewById(R.id.afflictedSendButton);
        messageEditText = findViewById(R.id.messageEditText);

        chatActivityList = findViewById(R.id.chatActivityList);
        afflictedChatArrayList = new ArrayList<>();
        afflictedArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, afflictedChatArrayList);

        afflictedSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                afflictedUserMessage = messageEditText.getText().toString();
                //afflictedClient.writer.println(afflictedUserMessage);
                //afflictedClient.writer.flush();
                afflictedChatArrayList.add("> You: " + afflictedUserMessage);
                messageEditText.setText("");
                chatActivityList.setAdapter(afflictedArrayAdapter);
            }
        });
    }
}

