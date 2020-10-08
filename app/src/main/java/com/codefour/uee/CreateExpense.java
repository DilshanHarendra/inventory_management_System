package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.codefour.uee.Popup.ShowPopups;

public class CreateExpense extends AppCompatActivity {
    Button backButton;
    Button cancel_button;
    Button save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_expense);

        backButton =findViewById(R.id.back_btn);
        cancel_button=findViewById(R.id.cancel_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save_btn=findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ShowPopups showPopups=new ShowPopups();
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                showPopups.ShowSuccesfulPopup(v,inflater).showAtLocation(v, Gravity.CENTER, 0, 0);


            }
        });
    }
}