package com.codefour.uee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Home extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private RelativeLayout inventoryItems,reports ,accountingReports;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        reports=findViewById(R.id.inventoryReportBtn);
        accountingReports=findViewById(R.id.accountingReportsBtn);


        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this,Analitics.class));
                finish();
            }
        });

        accountingReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,ReportGenerate.class));
            }
        });


        Window window = Home.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(ContextCompat.getColor(Home.this, R.color.statusBarColor));
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        inventoryItems=findViewById(R.id.inventoryBtn);

        inventoryItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(Home.this,MainProductView.class));


            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ImageView icon = new ImageView(this); // Create an icon
            icon.setImageDrawable(getDrawable(R.drawable.mainbtn));

            FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                    .setContentView(icon)
                    .build();
            SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
            ImageView itemIcon1 = new ImageView(this);
            itemIcon1.setImageDrawable(getDrawable(R.drawable.alertbtn));
            SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();

            ImageView itemIcon2 = new ImageView(this);
            itemIcon2.setImageDrawable(getDrawable(R.drawable.settingsbtn));
            SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();

            ImageView itemIcon3 = new ImageView(this);
            itemIcon3.setImageDrawable(getDrawable(R.drawable.logoutbtn));
            SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();



            SubActionButton.LayoutParams layoutParams1 = (SubActionButton.LayoutParams) button3.getLayoutParams();
            layoutParams1.width = 160;
            layoutParams1.height = 160;
            layoutParams1.bottomMargin = 40;
            layoutParams1.rightMargin = 100;



            FloatingActionButton.LayoutParams layoutParams2 = (FloatingActionButton.LayoutParams) actionButton.getLayoutParams();
            layoutParams2.width = 200;
            layoutParams2.rightMargin = 75;

            layoutParams2.bottomMargin = 110;
            layoutParams2.height = 200;

            FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this).setRadius(500)
                    .addSubActionView(button1)
                    .addSubActionView(button2)
                    .addSubActionView(button3)
                    .attachTo(actionButton)
                    .build();

        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action


        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
