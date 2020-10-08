package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.codefour.uee.Popup.ShowPopups;

public class Regsiter extends AppCompatActivity {

    private ImageButton registerback;

    private Button registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_regsiter);


        registerback=findViewById(R.id.backRegister);

        registerbtn=findViewById(R.id.registerbtn);

        registerback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Regsiter.this,Login.class));
            }
        });




        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ShowPopups showPopups=new ShowPopups();
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                showPopups.ShowSuccesfulPopup(v,inflater).showAtLocation(v, Gravity.CENTER, 0, 0);


            }
        });
    }
}