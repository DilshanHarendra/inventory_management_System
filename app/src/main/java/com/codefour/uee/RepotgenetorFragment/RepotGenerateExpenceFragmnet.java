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

import com.codefour.uee.CreateExpense;
import com.codefour.uee.R;
import com.codefour.uee.ShowReport;

public class RepotGenerateExpenceFragmnet extends Fragment {

    String TAG= this.getClass().getName();
    Button createExpenss;
    ListView listview;
    ArrayAdapter adapter;

    String[] expensArray =
            {"Expens report 2020-09-10","Expens report 2020-09-15",
            "Expens report 2020-09-20","Expens report 2020-10-4",
            "Expens report 2020-09-25","Expens report 2020-10-4",
            "Expens report 2020-09-30","Expens report 2020-10-4",
            "Expens report 2020-10-9","Expens report 2020-10-4",
            "Expens report 2020-10-14","Expens report 2020-10-19",
            "Expens report 2020-10-24","Expens report 2021-10-30",
             "Expens report 2020-09-30","Expens report 2020-10-4",
                    "Expens report 2020-10-9","Expens report 2020-10-4",
                    "Expens report 2020-10-14","Expens report 2020-10-19",
                    "Expens report 2020-10-24","Expens report 2022-10-30",
    };

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.reportexpensfragment,null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createExpenss=view.findViewById(R.id.createIncome);
        createExpenss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), CreateExpense.class);
                startActivity(intent);
            }
        });

        adapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.activity_listview, expensArray);
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
