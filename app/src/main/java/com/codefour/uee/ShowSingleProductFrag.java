package com.codefour.uee;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codefour.uee.Products.Product;


public class ShowSingleProductFrag extends Fragment {

    TextView textViews[] =new TextView[7];
    ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MainProductView.frag=3;
        Product product = MainProductView.product;
        View view=inflater.inflate(R.layout.fragment_show_single_product, container, false);
        imageView =view.findViewById(R.id.sproImage);

        try {
            Log.d("ueeIn","err "+product.getProName());

            if (!product.getProImgUrl().equals("NoImage")){
                try {
                    imageView.setImageURI(Uri.parse(product.getProImgUrl()));
                }catch (Exception e){
                    Log.d("ueeIn","err "+e);
                }


            }

            textViews[0]=view.findViewById(R.id.singleProTopic);
            textViews[1]=view.findViewById(R.id.spName);
            textViews[2]=view.findViewById(R.id.spID);
            textViews[3]=view.findViewById(R.id.spQuantity);
            textViews[4]=view.findViewById(R.id.spLocation);
            textViews[5]=view.findViewById(R.id.spAveragePrice);
            textViews[6]=view.findViewById(R.id.spAlert);

            textViews[0].setText(product.getProName());
            textViews[1].setText(product.getProName());
            textViews[2].setText(product.getProId());
            textViews[3].setText(product.getProQuantity());
            textViews[4].setText(product.getProLocation());
            textViews[5].setText(product.getProPrice());
            textViews[6].setText(product.getProAlertQty());
        }catch (Exception e){
            Log.d("ueeIn","err "+e);
        }




        return view;
    }



}
