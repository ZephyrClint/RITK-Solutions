package com.example.mad_miniproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

//Database Creation
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ItemsInfo.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + ItemsMaster.cOrders.TABLE_NAME + " (" +
                        ItemsMaster.cOrders._ID+ " INTEGER PRIMARY KEY," +
                        ItemsMaster.cOrders.COLUMN_DATE+ " TEXT," +
                        ItemsMaster.cOrders.COLUMN_TIME+ " TEXT," +
                        ItemsMaster.cOrders.COLUMN_NO_OF_PEOPLE+ " TEXT," +
                        ItemsMaster.cOrders.COLUMN_ADDRESS+ " TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES);



        String SQL_CREATE_APTZR_ITEM_ENTRIES =
                "CREATE TABLE " + ItemsMaster.AppetizerItemsInfo.TABLE_NAME_APTZR + " (" +
                        ItemsMaster.AppetizerItemsInfo._ID+ " INTEGER PRIMARY KEY," +
                        ItemsMaster.AppetizerItemsInfo.COLUMN_C_ORDER_ID+ " TEXT," +
                        ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_NAME+ " TEXT," +
                        ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_PRICE+ " INTEGER," +
                        ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_TOT_PRICE+ " INTEGER)";
        db.execSQL(SQL_CREATE_APTZR_ITEM_ENTRIES);




    }


    //Creation
    public Long addInfo(String date, String time, String noOfPeople, String address) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ItemsMaster.cOrders.COLUMN_DATE, date);
        values.put(ItemsMaster.cOrders.COLUMN_TIME, time);
        values.put(ItemsMaster.cOrders.COLUMN_NO_OF_PEOPLE, noOfPeople);
        values.put(ItemsMaster.cOrders.COLUMN_ADDRESS, address);

        return db.insert(ItemsMaster.cOrders.TABLE_NAME, null, values);
    }


    //Read
    public List readAll() {
        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                ItemsMaster.cOrders._ID,
                ItemsMaster.cOrders.COLUMN_DATE,
                ItemsMaster.cOrders.COLUMN_TIME,
                ItemsMaster.cOrders.COLUMN_NO_OF_PEOPLE,
                ItemsMaster.cOrders.COLUMN_ADDRESS
        };

        String sortOrder = ItemsMaster.cOrders._ID + " ASC";

        Cursor cursor = db.query(
                ItemsMaster.cOrders.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List info = new ArrayList<>();
        info.add("Order \t \t \t Date\t\t\t\tTime\t\t\t\tNumber\t\tAddress");
        info.add(" ID \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t Of People");

        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders._ID));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_DATE));
            String time = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_TIME));
            int noOfPeople = cursor.getInt(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_NO_OF_PEOPLE));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_ADDRESS));

            info.add(id + "\t\t\t" + date + "\t" + time + "\t\t\t\t" + noOfPeople + "\t\t\t\t\t\t" + address );
        }
        cursor.close();

        return info;
    }





    //READ - SINGLE

    public List readSingleOrder(String Address) {
        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                ItemsMaster.cOrders._ID,
                ItemsMaster.cOrders.COLUMN_DATE,
                ItemsMaster.cOrders.COLUMN_TIME,
                ItemsMaster.cOrders.COLUMN_NO_OF_PEOPLE,
                ItemsMaster.cOrders.COLUMN_ADDRESS
        };

        //SEARCH
        String selection = ItemsMaster.cOrders.COLUMN_ADDRESS + " = ?";
        String[] selectionArgs = { "My title" };

        //SORT
        String sortOrder = ItemsMaster.cOrders.COLUMN_DATE + " DESC";

        Cursor cursor = db.query(
                ItemsMaster.cOrders.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );


        List itemsInfo = new ArrayList<>();

        while (cursor.moveToNext()) {
            String date = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_DATE));
            String time = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_TIME));
            int noOfPeople = cursor.getInt(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_NO_OF_PEOPLE));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.cOrders.COLUMN_ADDRESS));

            itemsInfo.add(date + ":" + time + ":" + noOfPeople + ":" + address);
        }
        cursor.close();

        return itemsInfo;
    }


    //DELETION

    public long deleteInfo(String id ){
//        String id = ItemsMaster.cOrders._ID;
//        id = (String)ItemsMaster.cOrders._ID;

        SQLiteDatabase db = getReadableDatabase();
//        String selection = ItemsMaster.cOrders.COLUMN_ADDRESS + " LIKE ?";
//        String [] selectionArgs = { address };

        String selection = ItemsMaster.cOrders._ID + " LIKE ?";
        String [] selectionArgs = { id };

        return (db.delete(ItemsMaster.cOrders.TABLE_NAME,selection,selectionArgs));

    }
    //UPDATING

    public void updateInfo(View view, String id, String date, String time, String noOfPeople, String address){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

//        String id = ItemsMaster.cOrders._ID;

        values.put(ItemsMaster.cOrders.COLUMN_DATE, date);
        values.put(ItemsMaster.cOrders.COLUMN_TIME, time);
        values.put(ItemsMaster.cOrders.COLUMN_NO_OF_PEOPLE, noOfPeople);
        values.put(ItemsMaster.cOrders.COLUMN_ADDRESS, address);

        String selection = ItemsMaster.cOrders._ID + " Like ?";
        String[] selectionArgs = { id };

        int count = db.update(
                ItemsMaster.cOrders.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        Snackbar snackbar = Snackbar.make(view, count + " rows effected",Snackbar.LENGTH_LONG);
        snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
        snackbar.show();

    }



    //APPETIZERS
    //CREATION
    public Long addApptzrInfo(String aptzr_name, int aptzr_price, int number, int id) {
        SQLiteDatabase db1 = getWritableDatabase();
        ContentValues values = new ContentValues();

//        int noOfPeople;
//        noOfPeople = Integer.valueOf(number);
        int total;
        total = number*aptzr_price;

        values.put(ItemsMaster.AppetizerItemsInfo.COLUMN_C_ORDER_ID, id );
        values.put(ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_NAME, aptzr_name );
        values.put(ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_PRICE, aptzr_price );
        values.put(ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_TOT_PRICE, total );

//        ItemsMaster.AppetizerItemsInfo._ID+ " INTEGER PRIMARY KEY," +
//                ItemsMaster.AppetizerItemsInfo.COLUMN_C_ORDER_ID+ " TEXT," +
//                ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_NAME+ " TEXT," +
//                ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_PRICE+ " INTEGER," +
//                ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_TOT_PRICE+ " INTEGER)";

        return db1.insert(ItemsMaster.AppetizerItemsInfo.TABLE_NAME_APTZR, null, values);

    }

    //READ
    public List readAllApptzr() {
        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                ItemsMaster.AppetizerItemsInfo._ID,
                ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_NAME,
                ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_PRICE,
                ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_TOT_PRICE
        };

        String sortOrder = ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_NAME + " DESC";

        Cursor cursor = db.query(
                ItemsMaster.AppetizerItemsInfo.TABLE_NAME_APTZR,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List info = new ArrayList<>();
        info.add("\tDate\t\t\t\tTime\t\tNo Of People\t\tAddress");

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_NAME));
            String price = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_PRICE));
            String tot_price = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.AppetizerItemsInfo.COLUMN_ITEM_TOT_PRICE));

            info.add(name + "\t\t" + price + "\t\t\t" + tot_price);
        }
        cursor.close();

        return info;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}