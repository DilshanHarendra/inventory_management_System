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

public class supplierMain extends AppCompatActivity {

    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_main);

        ListView lt = (ListView) findViewById(R.id.listview);
        generateListContent();
        lt.setAdapter(new supplierMain.MyListAdapter(this, R.layout.activity_item_list, data));
    }

    private void generateListContent() {
        for (int i = 0; i < 10; i++) {
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
            supplierMain.ViewHolder mainView = null;

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                supplierMain.ViewHolder view = new supplierMain.ViewHolder();
                view.thumbnail = (ImageView) convertView.findViewById(R.id.list_item_thumbnail);
                view.title = (TextView) convertView.findViewById(R.id.list_item_text);
                view.edit = (Button) convertView.findViewById(R.id.list_item_edit);
                view.delete = (Button) convertView.findViewById(R.id.list_item_delete);

                view.edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Data can be edited, position: " + position, Toast.LENGTH_SHORT).show();
                    }
                });

                view.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Data can be deleted, position: " + position, Toast.LENGTH_SHORT).show();
                    }
                });
                convertView.setTag(view);
            } else {
                mainView = (supplierMain.ViewHolder) convertView.getTag();
                mainView.title.setText(getItem(position));
            }
            return convertView;
        }
    }

    public class ViewHolder {
        ImageView thumbnail;
        TextView title;
        Button edit, delete;
    }

    public void launchAddSup(View view) {
        Intent intent = new Intent(this, supplier.class);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}