package com.codefour.uee;

import android.content.Context;

import android.net.Uri;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codefour.uee.Products.Product;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductListAdepter extends ArrayAdapter<Product> {


    private Context context;
    private int mSource;
    public ProductListAdepter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.mSource=resource;
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater =LayoutInflater.from(this.context);
        convertView=inflater.inflate(mSource,parent,false);
        TextView name=(TextView) convertView.findViewById(R.id.proNameOne);
        CircleImageView imageView=(CircleImageView) convertView.findViewById(R.id.proImageOne);

        name.setText(getItem(position).getProName());
        String img=getItem(position).getProImgUrl();
        if (!img.equals("NoImage")){
            try {
               imageView.setImageURI(Uri.parse(img));
            }catch (Exception e){
                Log.d("ueeIn","err "+e);
            }


        }


        return convertView;
    }



}
