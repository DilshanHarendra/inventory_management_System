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

public class AddPurchaseOrder extends AppCompatActivity {

    ImageButton purchaseBack;

    Button purchaseSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase_order);

        purchaseBack=findViewById(R.id.purchaseBack);

        purchaseSave=findViewById(R.id.purchaseSave);


        purchaseBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddPurchaseOrder.this,ViewPurchaseOrder.class));
            }
        });


        purchaseSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ShowPopups showPopups=new ShowPopups();
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                showPopups.ShowSuccesfulPopup(v,inflater).showAtLocation(v, Gravity.CENTER, 0, 0);


            }
        });
    }
}