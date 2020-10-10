package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.codefour.uee.Popup.ShowPopups;

public class AddSales extends AppCompatActivity {

    ImageButton salesBack;

    Button salesSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sales);

        salesBack=findViewById(R.id.salesBack);

        salesSave=findViewById(R.id.salesSave);

        salesBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddSales.this,ViewSalesOrder.class));
            }
        });



        salesSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ShowPopups showPopups=new ShowPopups();
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                showPopups.ShowSuccesfulPopup(v,inflater).showAtLocation(v, Gravity.CENTER, 0, 0);


            }
        });


    }
}