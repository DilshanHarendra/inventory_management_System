package com.codefour.uee;



import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    Button login;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);


//       startActivity(new Intent(MainActivity.this,Home.class));
//       finish();









handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
        finish();
    }
},3000);


    }


}
