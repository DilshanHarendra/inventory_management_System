package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.codefour.uee.Popup.ShowPopups;

public class CreateIncome extends AppCompatActivity {
    Button backButton;
    Button save_btn;
    Button cancel_button;
    Dialog successdialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_income);
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



                //Show successful popup
                ShowPopups showPopups=new ShowPopups();
                //create inflater object form SystemService
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                //set position for show popup
                showPopups.ShowSuccesfulPopup(v,inflater).showAtLocation(v, Gravity.CENTER, 0, 0);


            }
        });
    }







}