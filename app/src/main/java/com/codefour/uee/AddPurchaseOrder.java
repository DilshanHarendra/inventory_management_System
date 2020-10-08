package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddPurchaseOrder extends AppCompatActivity {

    ImageButton purchaseBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase_order);

        purchaseBack=findViewById(R.id.purchaseBack);

        purchaseBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddPurchaseOrder.this,ViewPurchaseOrder.class));
            }
        });
    }
}