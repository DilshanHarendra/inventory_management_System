package com.codefour.uee.RepotgenetorFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codefour.uee.CreateIncome;
import com.codefour.uee.R;

public class RepotGenerateHomeFragmnet extends Fragment {
    String TAG="RepotGenerateHomeFragmnet";
    Button createIncome;
    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        Log.i(TAG,"HomeFregement");
        return inflater.inflate(R.layout.repothomefragmet,null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
