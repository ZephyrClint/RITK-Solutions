package com.example.orderapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelperKalindu extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="UserInfo.db";
//    private SQLiteDatabase db;

    public DBHelperKalindu(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMasterKalindu.Users.TABLE_NAME + " (" +
                        UsersMasterKalindu.Users._ID+ " INTEGER PRIMARY KEY," +
                        UsersMasterKalindu.Users.COLUMN_NAME_TIME+ " TEXT," +
                        UsersMasterKalindu.Users.COLUMN_NAME_DATE+ " TEXT," +
                        UsersMasterKalindu.Users.COLUMN_NAME_PEOPLE+ " TEXT," +
                        UsersMasterKalindu.Users.COLUMN_NAME_ORDER+ " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public Long addInfo(String time, String date, String number, String order){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMasterKalindu.Users.COLUMN_NAME_TIME, time);
        values.put(UsersMasterKalindu.Users.COLUMN_NAME_DATE, date);
        values.put(UsersMasterKalindu.Users.COLUMN_NAME_PEOPLE, number);
        values.put(UsersMasterKalindu.Users.COLUMN_NAME_ORDER, order);

        return db.insert(UsersMasterKalindu.Users.TABLE_NAME, null, values);
    }
    //Read
    public List readAll(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMasterKalindu.Users._ID,
                UsersMasterKalindu.Users.COLUMN_NAME_TIME,
                UsersMasterKalindu.Users.COLUMN_NAME_DATE,
                UsersMasterKalindu.Users.COLUMN_NAME_PEOPLE,
                UsersMasterKalindu.Users.COLUMN_NAME_ORDER

        };

        String sortOrder = UsersMasterKalindu.Users._ID + "DESC";

        Cursor cursor = db.query(
                UsersMasterKalindu.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List info = new ArrayList<>();

        while (cursor.moveToNext()){
            String time = cursor.getString(cursor.getColumnIndexOrThrow(UsersMasterKalindu.Users.COLUMN_NAME_TIME));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(UsersMasterKalindu.Users.COLUMN_NAME_DATE));
            String no_of_persons = cursor.getString(cursor.getColumnIndexOrThrow(UsersMasterKalindu.Users.COLUMN_NAME_PEOPLE));
            String order_something = cursor.getString(cursor.getColumnIndexOrThrow(UsersMasterKalindu.Users.COLUMN_NAME_ORDER));

            info.add(time+":"+date+":"+no_of_persons+":"+order_something);

        }
        cursor.close();

        return info;

    }

    //DELETION
    public void deleteInfo(String date ){
        SQLiteDatabase db = getReadableDatabase();
        String selection = UsersMasterKalindu.Users.COLUMN_NAME_DATE + " LIKE ?";
        String [] selectionArgs = { date };
        db.delete(UsersMasterKalindu.Users.TABLE_NAME,selection,selectionArgs);

    }


    public void updateInfo(String date, String time, String noOfPeople, String order){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMasterKalindu.Users.COLUMN_NAME_DATE, date);
        values.put(UsersMasterKalindu.Users.COLUMN_NAME_TIME, time);
        values.put(UsersMasterKalindu.Users.COLUMN_NAME_PEOPLE, noOfPeople);
        values.put(UsersMasterKalindu.Users.COLUMN_NAME_ORDER, order);

        String selection = UsersMasterKalindu.Users.COLUMN_NAME_DATE + " Like ?";
        String[] selectionArgs = { date };

        int count = db.update(
                UsersMasterKalindu.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );


//        Snackbar snackbar = Snackbar.make(view, count + " rows effected",Snackbar.LENGTH_LONG);
//        snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE);
//        snackbar.show();


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}

