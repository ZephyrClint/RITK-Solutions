package com.example.mad_miniproject.database;

import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

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
                "CREATE TABLE " + ItemsMaster.Items.TABLE_NAME + " (" +
                        ItemsMaster.Items._ID+ " INTEGER PRIMARY KEY," +
                        ItemsMaster.Items.COLUMN_DATE+ " TEXT," +
                        ItemsMaster.Items.COLUMN_TIME+ " TEXT," +
                        ItemsMaster.Items.COLUMN_NO_OF_PEOPLE+ " TEXT," +
                        ItemsMaster.Items.COLUMN_ADDRESS+ " TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES);
    }


    //Creation
    public Long addInfo(String date, String time, String noOfPeople, String address) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ItemsMaster.Items.COLUMN_DATE, date);
        values.put(ItemsMaster.Items.COLUMN_TIME, time);
        values.put(ItemsMaster.Items.COLUMN_NO_OF_PEOPLE, noOfPeople);
        values.put(ItemsMaster.Items.COLUMN_ADDRESS, address);

        return db.insert(ItemsMaster.Items.TABLE_NAME, null, values);
    }


    //Read
    public List readAll() {
        SQLiteDatabase db = getReadableDatabase();
        String [] projection = {
                ItemsMaster.Items._ID,
                ItemsMaster.Items.COLUMN_DATE,
                ItemsMaster.Items.COLUMN_TIME,
                ItemsMaster.Items.COLUMN_NO_OF_PEOPLE,
                ItemsMaster.Items.COLUMN_ADDRESS
        };

        String sortOrder = ItemsMaster.Items.COLUMN_DATE + " DESC";

        Cursor cursor = db.query(
                ItemsMaster.Items.TABLE_NAME,
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
            String date = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_DATE));
            String time = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_TIME));
            int noOfPeople = cursor.getInt(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_NO_OF_PEOPLE));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_ADDRESS));

            info.add(date + "\t\t" + time + "\t\t\t" + noOfPeople + "\t\t\t\t" + address);
        }
        cursor.close();

        return info;
    }



    //READ - SINGLE
        public List readSingleOrder(String Address) {
            SQLiteDatabase db = getReadableDatabase();
            String [] projection = {
                    ItemsMaster.Items._ID,
                    ItemsMaster.Items.COLUMN_DATE,
                    ItemsMaster.Items.COLUMN_TIME,
                    ItemsMaster.Items.COLUMN_NO_OF_PEOPLE,
                    ItemsMaster.Items.COLUMN_ADDRESS
            };

            //SEARCH
            String selection = ItemsMaster.Items.COLUMN_ADDRESS + " = ?";
            String[] selectionArgs = { "My title" };

            //SORT
            String sortOrder = ItemsMaster.Items.COLUMN_DATE + " DESC";

            Cursor cursor = db.query(
                    ItemsMaster.Items.TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder
            );


            List itemsInfo = new ArrayList<>();

            while (cursor.moveToNext()) {
                String date = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_DATE));
                String time = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_TIME));
                int noOfPeople = cursor.getInt(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_NO_OF_PEOPLE));
                String address = cursor.getString(cursor.getColumnIndexOrThrow(ItemsMaster.Items.COLUMN_ADDRESS));

                itemsInfo.add(date + ":" + time + ":" + noOfPeople + ":" + address);
            }
            cursor.close();

            return itemsInfo;
        }





    //DELETION
    public void deleteInfo(String address ){
        SQLiteDatabase db = getReadableDatabase();
        String selection = ItemsMaster.Items.COLUMN_ADDRESS + " LIKE ?";
        String [] selectionArgs = { address };
        db.delete(ItemsMaster.Items.TABLE_NAME,selection,selectionArgs);

    }

    //UPDATING
    public void updateInfo(View view, String date, String time, String noOfPeople, String address){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(ItemsMaster.Items.COLUMN_DATE, date);
        values.put(ItemsMaster.Items.COLUMN_TIME, time);
        values.put(ItemsMaster.Items.COLUMN_NO_OF_PEOPLE, noOfPeople);
//        values.put(ItemsMaster.Items.COLUMN_ADDRESS, address);

        String selection = ItemsMaster.Items.COLUMN_ADDRESS + " Like ?";
        String[] selectionArgs = { address };

        int count = db.update(
                ItemsMaster.Items.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );

        Snackbar snackbar = Snackbar.make(view, count + " rows effected",Snackbar.LENGTH_LONG);
        snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
        snackbar.show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
