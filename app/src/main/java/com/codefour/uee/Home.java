package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class Home extends AppCompatActivity {

    private RelativeLayout inventoryItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inventoryItems=findViewById(R.id.inventoryBtn);

        inventoryItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Home.this,MainProductView.class));
                finish();

            }
        });
    }
}
