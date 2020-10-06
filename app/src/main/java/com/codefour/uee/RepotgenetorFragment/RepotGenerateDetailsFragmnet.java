package com.codefour.uee.RepotgenetorFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codefour.uee.R;
import com.codefour.uee.ShowReport;

public class RepotGenerateDetailsFragmnet extends Fragment {
    String TAG= this.getClass().getName();


    ListView listview;
    ArrayAdapter adapter;

    String[] detailsArray =
            {"Detailed report 2020-09-10","Detailed report 2020-09-15",
                    "Detailed report 2020-09-20","Detailed report 2020-10-4",
                    "Detailed report 2020-09-25","Detailed report 2020-10-4",
                    "Detailed report 2020-09-30","Detailed report 2020-10-4",
                    "Detailed report 2020-10-9","Detailed report 2020-10-4",
                    "Detailed report 2020-10-14","Detailed report 2020-10-19",
                    "Detailed report 2020-10-24","Detailed report 2021-10-30",
                    "Detailed report 2020-09-30","Detailed report 2020-10-4",
                    "Detailed report 2020-10-9","Detailed report 2020-10-4",
                    "Detailed report 2020-10-14","Detailed report 2020-10-19",
                    "Detailed report 2020-10-24","Detailed report 2022-10-30",
            };
    
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      
       
        return inflater.inflate(R.layout.repotdetailsfragment,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.activity_listview, detailsArray);
        listview=view.findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG,"Item click");
                Intent intent =new Intent(getContext(), ShowReport.class);
                startActivity(intent);
            }
        });
    }
}
