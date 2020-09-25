package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    String TAG="MainActivity";

    Button reportGenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reportGenBtn=findViewById(R.id.repotgen_button);
        this.navigateToReportGenerator();
    }

    public void navigateToReportGenerator(){
        reportGenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reportGenerator =new Intent(getApplicationContext(),ReportGenerate.class);
                startActivity(reportGenerator);
                Log.i(TAG,"navigate to report generator");
            }
        });
    }
}
