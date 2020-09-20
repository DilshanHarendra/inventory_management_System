package com.codefour.uee.DatabaseHandler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {



    public DatabaseHandler(Context context) {
        super(context, "ueeInventory", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {

            sqLiteDatabase.execSQL(Dbtables.productTable);
        }catch (Exception e){
            Log.d("ueeIn","db create err"+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("");
        this.onCreate(sqLiteDatabase);
    }

    public String IUDtoDb(String query){
        try {

            getWritableDatabase().execSQL(query);
            return "Success";
        }catch (Exception e){
            Log.d("ueeIn","db insert err"+e);
            return e.toString();
        }
    }

    public Cursor getData(String query){
        try {
            return (Cursor)getReadableDatabase().rawQuery(query,null);
        }catch (Exception e){
            Log.d("ueeIn","db getData err"+e);
            return null;
        }
    }





}



class Dbtables {
    public static String productTable="CREATE TABLE products (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "proName text," +
            "proId text UNIQUE," +
            "proCategeory ,"+
            "proLocation text," +
            "proQuantity INTEGER," +
            "proPrice INTEGER," +
            "proAlertQty INTEGER," +
            "proImgUrl text" +
            ")";
}