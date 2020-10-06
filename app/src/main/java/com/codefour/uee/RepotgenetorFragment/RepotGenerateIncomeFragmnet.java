package com.codefour.uee.RepotgenetorFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codefour.uee.CreateIncome;
import com.codefour.uee.R;
import com.codefour.uee.ShowReport;

public class RepotGenerateIncomeFragmnet extends Fragment {
    String TAG= this.getClass().getName();
    Button createIncome;
    ListView listview;
    ArrayAdapter adapter;

    String[] incomeArry =
            {
                    "Income report 2020-09-20","Income report 2020-10-4",
                    "Details report 2020-09-25","Income report 2020-10-4",
                    "Income report 2020-09-30","Income report 2020-10-4",
                    "Expens report 2020-10-9","Income report 2020-10-4",
                    "Income report 2020-10-14","Income report 2020-10-19",
                    "Expens report 2020-10-24","Income report 2021-10-30",
                    "Income report 2020-09-30","Income report 2020-10-4",
                    "Details report 2020-10-9","Income report 2020-10-4",
                    "Expens report 2020-10-14","Income report 2020-10-19",
                    "Income report 2020-10-24","Income report 2022-10-30",
            };


    Button createIncomeIntent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reportincomefragment,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createIncomeIntent =view.findViewById(R.id.createIncome);
        createIncomeIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent incomeIntent =new Intent(getContext(), CreateIncome.class);
                startActivity(incomeIntent);
            }
        });

        adapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.activity_listview, incomeArry);
        listview=view.findViewById(R.id.listview_income);
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
