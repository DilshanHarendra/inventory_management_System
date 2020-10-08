package com.codefour.uee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class purchaseAdapter extends ArrayAdapter {

    private Context mCtx;
    private int resource;
    private List<purchaseModel> purchaseList;

public purchaseAdapter(Context mCtx, int resource, List<purchaseModel> purchaseList)
{
    super(mCtx,resource,purchaseList);

    this.mCtx=mCtx;
    this.resource=resource;
    this.purchaseList=purchaseList;
}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(R.layout.purchase_list,null);

        TextView title=view.findViewById(R.id.listtitle);

        purchaseModel purchase = purchaseList.get(position);

        title.setText(purchase.getTitle());

        return view;
    }
}
