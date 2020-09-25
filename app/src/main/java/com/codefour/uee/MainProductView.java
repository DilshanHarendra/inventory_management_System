package com.codefour.uee;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import static android.Manifest.permission.CAMERA;


public class MainProductView extends AppCompatActivity {

    public static int frag=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product_view);




    }



    @Override
    public void onBackPressed() {


        if (frag==2){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            transaction.replace(R.id.productViewFrag, new ProductListFrag());
            transaction.commit();
            frag=1;
        }else{
            super.onBackPressed();
        }



    }
}
