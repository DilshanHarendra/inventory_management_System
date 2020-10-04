package com.codefour.uee.Products;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.codefour.uee.DatabaseHandler.DatabaseHandler;

import java.util.ArrayList;

public class ProductsController {

    //private DatabaseHandler databaseHandler = ;

    public static String addNewProduct(Context context,String name,String proID,String categeory,String location,String quantity,String price,String alertQty,String imgUrl ){
        DatabaseHandler databaseHandler=new DatabaseHandler(context);
        try {
            String query="INSERT INTO products VALUES(null,'"+name+"','"+proID+"', '"+categeory+"','"+location+"',"+Integer.parseInt(quantity)+","+Integer.parseInt(price)+","+Integer.parseInt(alertQty)+",'"+imgUrl+"')";
            Log.d("ueeIn",query);

            return databaseHandler.IUDtoDb(query);
        }catch (Exception e){
            Log.d("ueeIn","product insert err"+e);
            return e.toString();
        }
    }

    public static ArrayList<Product> getAllProucts(Context context){
        ArrayList<Product> arrayList = new ArrayList();
        try {
            String query="SELECT * from products";
           Cursor cursor = new DatabaseHandler(context).getData(query);
            if (cursor.moveToFirst()){
                do {
                   // Log.d("ueeIn","db data"+cursor.getString(8));
                   //Product(proName, proId, proCategeory, proLocation, proImgUrl, proQuantity, proPrice, proAlertQty, id)
                    Product product = new Product(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(8),Integer.parseInt(cursor.getString(5)),Integer.parseInt(cursor.getString(6)),Integer.parseInt(cursor.getString(7)),Integer.parseInt(cursor.getString(0)));
                    arrayList.add(product);
                }while (cursor.moveToNext());
            }


        }catch (Exception e){
            Log.d("ueeIn","product getall err"+e);

        }
        return arrayList;
    }



}
