package com.example.dost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AfflictedFeedActivity extends AppCompatActivity {

    ListView afflictedFeedListView;
    ArrayList<String> afflictedFeedArrayList;
    ArrayAdapter afflictedFeedArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afflicted_feed);

        afflictedFeedListView = findViewById(R.id.afflictedFeedListView);

        afflictedFeedArrayList= new ArrayList<>();
        afflictedFeedArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, afflictedFeedArrayList);
        afflictedFeedListView.setAdapter(afflictedFeedArrayAdapter);

        afflictedFeedArrayList.add("Arsh");

        afflictedFeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent chatIntentAfflicted = new Intent(AfflictedFeedActivity.this, AfflictedChatActivity.class);
                startActivity(chatIntentAfflicted);
            }
        });


    }
}
