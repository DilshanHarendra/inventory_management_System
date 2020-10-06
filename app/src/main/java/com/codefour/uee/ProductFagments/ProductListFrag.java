package com.codefour.uee.ProductFagments;


import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ListView;
import android.widget.SearchView;

import com.codefour.uee.MainProductView;
import com.codefour.uee.ProductListAdepter;
import com.codefour.uee.Products.Product;
import com.codefour.uee.Products.ProductsController;
import com.codefour.uee.R;

import java.util.ArrayList;
import java.util.List;


public class ProductListFrag extends Fragment {


    private ListView listView;
    private List<Product> products;
    private Button addNewBtn;
    private SearchView search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_product_list, container, false);
        MainProductView.frag=1;
        listView= view.findViewById(R.id.productList);
        addNewBtn=view.findViewById(R.id.addNewProductBtn);
        search=view.findViewById(R.id.productSearch);

        products= ProductsController.getAllProucts(getActivity());

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("ueeIn","product"+i);
                MainProductView.product= products.get(i);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.productViewFrag, new ShowSingleProductFrag());
                transaction.commit();
            }
        });


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                setFilterdItems(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                setFilterdItems(s);
                return false;
            }
        });



    return view;
    }

    public void setFilterdItems(String key){
        List<Product> list = new ArrayList<>();
        for (Product product : products  ){
            if(product.getProName().toLowerCase().startsWith(key.toLowerCase())){
                list.add(product);
            }
        }
        ProductListAdepter productListAdepter = new ProductListAdepter(getActivity(),R.layout.one_product_row,list);
        listView.setAdapter(productListAdepter);
    }





}
