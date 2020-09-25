package com.codefour.uee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.codefour.uee.RepotgenetorFragment.RepotGenerateDetailsFragmnet;
import com.codefour.uee.RepotgenetorFragment.RepotGenerateExpenceFragmnet;
import com.codefour.uee.RepotgenetorFragment.RepotGenerateHomeFragmnet;
import com.codefour.uee.RepotgenetorFragment.RepotGenerateIncomeFragmnet;
import com.codefour.uee.RepotgenetorFragment.RepotGenerateLostFragmnet;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ReportGenerate extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    String TAG="ReportGenerate";
    android.app.Fragment reportFragmnt=null;

    BottomNavigationView bottomNavigationView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_report_generate);



        backButton=findViewById(R.id.back_btn);
        bottomNavigationView=findViewById(R.id.botton_navigator);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        loadFragment(new RepotGenerateHomeFragmnet());
        navigateToBack();


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment=null;

        switch (item.getItemId()){
            case  R.id.repothome:
                fragment=new RepotGenerateHomeFragmnet();
                 Log.i(TAG,"Home Fragments");


                break;
            case R.id.repotexpens:
                fragment=new RepotGenerateExpenceFragmnet();
                 Log.i(TAG,"Expence Fragments");
                break;

            case R.id.repotincome:
                fragment=new RepotGenerateIncomeFragmnet();
                 Log.i(TAG,"Income Fragments");

                break;
            case R.id.reportlost:
                fragment=new RepotGenerateLostFragmnet();
                 Log.i(TAG,"Lost Fragments");

                break;

            case R.id.repotdetaild:
                fragment=new RepotGenerateDetailsFragmnet();
                 Log.i(TAG,"Details Fragments");

                break;

        }


        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment reportFragmnt){
        if (reportFragmnt!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,reportFragmnt).commit();
            return true;
        }
        return  false;

    }

    public void navigateToBack(){
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(intent);
                finish();
             }
        });
    }

}