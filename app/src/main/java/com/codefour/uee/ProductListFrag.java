package com.codefour.uee;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.codefour.uee.Products.Product;
import com.codefour.uee.Products.ProductsController;

import java.util.List;


public class ProductListFrag extends Fragment {


    private ListView listView;
    private List<Product> products;
    private Button addNewBtn;
    public static final int RUNTIME_PERMISSION_CODE = 7;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_list, container, false);

        listView= view.findViewById(R.id.productList);
        addNewBtn=view.findViewById(R.id.addNewProductBtn);


        products= ProductsController.getAllProucts(getActivity());
        Log.d("ueeIn","product"+products.size());
        ProductListAdepter productListAdepter = new ProductListAdepter(getActivity(),R.layout.one_product_row,products);
        listView.setAdapter(productListAdepter);

        addNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.productViewFrag, new AddNewProductFrag());
                transaction.commit();

            }
        });



    return view;
    }






}
