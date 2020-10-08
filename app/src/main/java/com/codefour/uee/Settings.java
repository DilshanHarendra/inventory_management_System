package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Settings extends AppCompatActivity {

    ExpandableListView expandableListView;

    ImageView settingBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        expandableListView=findViewById(R.id.eTV);

        settingBack=findViewById(R.id.backSetting);

        ExpandableTextView adapter = new ExpandableTextView(Settings.this);

        settingBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this,Home.class));
            }
        });

        expandableListView.setAdapter(adapter);
    }
}