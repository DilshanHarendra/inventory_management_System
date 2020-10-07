package com.codefour.uee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ViewPurchaseOrder extends AppCompatActivity {

    ListView list_view;
    //ArrayAdapter<String> adapter;
    //ArrayList<String> list=new ArrayList<String>();
    //ArrayList<String> list_items=new ArrayList<String>();

    private ImageButton purchaseAdd;

    ArrayList<purchaseModel> list_items=new ArrayList<purchaseModel>();
    List <purchaseModel> list;
    purchaseAdapter adapter;



    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_purchase_order);

        list_view=findViewById(R.id.purchaseList);

        purchaseAdd=findViewById(R.id.PurchaseAdd);

        purchaseAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPurchaseOrder.this,AddPurchaseOrder.class));
            }
        });

        list=new ArrayList<>();


        list.add(new purchaseModel("shanuka"));
        list.add(new purchaseModel("Miyura"));
        list.add(new purchaseModel("Dunish"));
        list.add(new purchaseModel("Vehan"));
        list.add(new purchaseModel("Sathira"));
        list.add(new purchaseModel("Twain"));


//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//        list.add("five");

       //adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //adapter=new ArrayAdapter<String>(new supplierMain.MyListAdapter(this, R.layout.activity_item_list, data));

      adapter=new purchaseAdapter(this,R.layout.purchase_list,list);

        list_view.setAdapter(adapter);

        //list_view.setAdapter(new ViewPurchaseOrder.MyListAdapter(this, R.layout.activity_item_list, list));


        list_view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        list_view.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {


            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                count=count+1;
                mode.setTitle(count+" Items selected") ;
                list_items.add(list.get(position));
           Log.e("position",list.get(position).getTitle());

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                Log.e("Create mode","Visited onCreateActionMode");
                MenuInflater inflater = mode.getMenuInflater();

                inflater.inflate(R.menu.context_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                Log.e("Action Item","Visited onActionItemClciked");
                switch (item.getItemId()){
                    case R.id.delete_id:
                        for(purchaseModel msg:list_items)
                        {
                            adapter.remove(msg);
                        }
                        Toast.makeText(getBaseContext(),count+ " items removed",Toast.LENGTH_SHORT).show();
                        count=0;
                        mode.finish();
                        return true;
                        //break;

                    default:
                        return false;
                        //break;
                }


                //return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }



}


