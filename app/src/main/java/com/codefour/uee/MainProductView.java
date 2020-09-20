package com.codefour.uee;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;



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
