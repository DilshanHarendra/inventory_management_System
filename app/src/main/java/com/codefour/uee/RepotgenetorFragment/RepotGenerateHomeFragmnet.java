package com.codefour.uee.RepotgenetorFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.codefour.uee.R;

public class RepotGenerateHomeFragmnet extends Fragment {
    String TAG="RepotGenerateHomeFragmnet";
    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"HomeFregement");
        return inflater.inflate(R.layout.repothomefragmet,null);
    }
}
