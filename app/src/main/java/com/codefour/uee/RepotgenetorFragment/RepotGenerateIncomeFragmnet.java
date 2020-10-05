package com.codefour.uee.RepotgenetorFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codefour.uee.CreateIncome;
import com.codefour.uee.R;

public class RepotGenerateIncomeFragmnet extends Fragment {
    String TAG="RepotGenerateIncomeFragmnet";
    Button createIncome;


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


    }
}
