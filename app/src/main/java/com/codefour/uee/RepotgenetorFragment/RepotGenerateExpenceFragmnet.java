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

import com.codefour.uee.CreateExpense;
import com.codefour.uee.R;

public class RepotGenerateExpenceFragmnet extends Fragment {
    Button createExpenss;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reportexpensfragment,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createExpenss=view.findViewById(R.id.createExpenss);
        createExpenss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), CreateExpense.class);
                startActivity(intent);
            }
        });
    }
}
