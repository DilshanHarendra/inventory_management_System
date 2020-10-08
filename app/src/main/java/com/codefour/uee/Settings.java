package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

public class Settings extends AppCompatActivity {

    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        expandableListView=findViewById(R.id.eTV);

        ExpandableTextView adapter = new ExpandableTextView(Settings.this);

        expandableListView.setAdapter(adapter);
    }
}