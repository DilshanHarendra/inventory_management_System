package com.codefour.uee;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.codefour.uee.ProductFagments.ProductListFrag;
import com.codefour.uee.Products.Product;




public class MainProductView extends AppCompatActivity {

    public static int frag=1;
    public static Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product_view);

        Window window = MainProductView.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(ContextCompat.getColor(MainProductView.this, R.color.statusBarColor));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


    }



    @Override
    public void onBackPressed() {


        if (frag==2){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            transaction.replace(R.id.productViewFrag, new ProductListFrag());
            transaction.commit();
            frag=1;
        }else if(frag==3){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            transaction.replace(R.id.productViewFrag, new ProductListFrag());
            transaction.commit();
            frag=1;
        } else{
            super.onBackPressed();
        }



    }
}
