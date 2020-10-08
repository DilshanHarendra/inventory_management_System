package com.codefour.uee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewSalesOrder extends AppCompatActivity {

    private int count=0;
    private ListView listview;

    private ImageButton addSales;

    private ImageButton backsales;

    ArrayList<SalesModel> list_itemsSales=new ArrayList<SalesModel>();

    private List<SalesModel> list;
    private SalesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sales_order);


        listview=findViewById(R.id.SalesList);

        addSales=findViewById(R.id.SalesAdd);

        backsales=findViewById(R.id.SalesBack);

        addSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewSalesOrder.this,AddSales.class));
            }
        });


        backsales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewSalesOrder.this,Home.class));
            }
        });



        list=new ArrayList<>();


        list.add(new SalesModel("Mr shanuka"));
        list.add(new SalesModel("Mr Miyura"));
        list.add(new SalesModel("Mr Dunish"));
        list.add(new SalesModel("Mr Vehan"));
        list.add(new SalesModel("Mr Sathira"));
        list.add(new SalesModel("Mr Twain"));


//        list.add("one");
//        list.add("two");
//        list.add("three");
//        list.add("four");
//        list.add("five");

        //adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //adapter=new ArrayAdapter<String>(new supplierMain.MyListAdapter(this, R.layout.activity_item_list, data));

        adapter=new SalesAdapter(this,R.layout.sales_list,list);

        listview.setAdapter(adapter);

        //list_view.setAdapter(new ViewPurchaseOrder.MyListAdapter(this, R.layout.activity_item_list, list));


        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        listview.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {


            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                count=count+1;
                mode.setTitle(count+" Items selected") ;
                list_itemsSales.add(list.get(position));
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
                        for(SalesModel msg:list_itemsSales)
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