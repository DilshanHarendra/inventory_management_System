package com.codefour.uee.RepotgenetorFragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.codefour.uee.CreateIncome;
import com.codefour.uee.R;

public class RepotGenerateHomeFragmnet extends Fragment {
    String TAG="RepotGenerateHomeFragmnet";

    ListView listview;
    ArrayAdapter adapter;

    String[] incomeArry =
            {
                    "Income report 2020-09-20","Income report 2020-10-4",
                    "Income report 2020-09-25","Income report 2020-10-4",
                    "Income report 2020-09-30","Income report 2020-10-4",
                    "Income report 2020-10-9","Income report 2020-10-4",
                    "Income report 2020-10-14","Income report 2020-10-19",
                    "Income report 2020-10-24","Income report 2021-10-30",
                    "Income report 2020-09-30","Income report 2020-10-4",
                    "Income report 2020-10-9","Income report 2020-10-4",
                    "Income report 2020-10-14","Income report 2020-10-19",
                    "Income report 2020-10-24","Income report 2022-10-30",
            };


    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Log.i(TAG,"HomeFregement");
        return inflater.inflate(R.layout.repothomefragmet,null);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ArrayAdapter<String>(view.getContext(),
                R.layout.activity_listview, incomeArry);
        listview=view.findViewById(R.id.listview_income);
        listview.setAdapter(adapter);



    }
}
