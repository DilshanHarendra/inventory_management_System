package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.codefour.uee.Popup.ShowPopups;

public class Login extends AppCompatActivity {

    private Button loginBtn;
    private EditText email;
    private EditText password;
    private TextView heading;
    private TextView forgotPassword;
    private TextView register;
    private TextView question;
    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        register=findViewById(R.id.salesSave);
        loginBtn=findViewById(R.id.loginBtn);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
    }

    @Override
    protected void onResume() {
        super.onResume();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Regsiter.class);

                startActivity(i);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i2=new Intent(Login.this,Home.class);
//                startActivity(i2);

                if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
                {
                    Intent i2=new Intent(Login.this,Home.class);
                startActivity(i2);

                    Toast.makeText(getBaseContext(),"Successfully logged in" ,Toast.LENGTH_LONG).show();
                }else{

                    ShowPopups showPopups=new ShowPopups();
                    LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                    showPopups.ShowErrorPopup(v,inflater).showAtLocation(v, Gravity.CENTER, 0, 0);

                    Toast.makeText(getBaseContext(),"Invalid Credentials. type username:- admin password: admin" ,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}