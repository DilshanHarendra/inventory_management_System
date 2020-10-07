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

public class SalesAdapter extends ArrayAdapter {

    private Context mCtx;
    private int resource;
    private List<SalesModel> SalesList;

    public SalesAdapter(Context mCtx, int resource, List<SalesModel> salesList) {
        super(mCtx,resource,salesList);

        this.mCtx = mCtx;
        this.resource = resource;
        this.SalesList = salesList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        View view = inflater.inflate(R.layout.sales_list,null);

        TextView titlesales=view.findViewById(R.id.Saleslisttitle);

        SalesModel sales = SalesList.get(position);

        titlesales.setText(sales.getTitle());

        return view;
    }
}
