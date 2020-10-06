package com.codefour.uee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class reportMain extends AppCompatActivity {

    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_main);

        ListView lt = (ListView) findViewById(R.id.listview);
        generateListContent();
        lt.setAdapter(new reportMain.MyListAdapter(this, R.layout.activity_report_list, data));
    }

    private void generateListContent(){
        for(int i =0 ; i < 10 ; i++){
            data.add("This is row number " + i);
        }
    }

    private class MyListAdapter extends ArrayAdapter<String> {
        private int layout;
        public MyListAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            layout = resource;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            reportMain.ViewHolder mainView = null;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                reportMain.ViewHolder view = new reportMain.ViewHolder();
                view.thumbnail = (ImageView) convertView.findViewById(R.id.list_report_pic);
                view.title = (TextView) convertView.findViewById(R.id.list_report_title);
                view.view = (Button) convertView.findViewById(R.id.list_report_view);

                view.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(reportMain.this,Analitics.class));
                        finish();
                    }
                });

                convertView.setTag(view);
            }
            else{
                mainView = (reportMain.ViewHolder) convertView.getTag();
                mainView.title.setText(getItem(position));
            }
            return convertView;
        }
    }

    public class ViewHolder{
        ImageView thumbnail;
        TextView title;
        Button view;
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }


}