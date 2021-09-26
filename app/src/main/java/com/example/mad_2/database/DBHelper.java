package com.example.mad_2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="UserInfo.db";
    private SQLiteDatabase db;

    public DBHelper(Context context) {super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" +
                        UsersMaster.Users._ID+ " INTEGER PRIMARY KEY," +
                        UsersMaster.Users.COLUMN_NAME_TIME+ " TEXT," +
                        UsersMaster.Users.COLUMN_NAME_DATE+ "TEXT," +
                        UsersMaster.Users.COLUMN_NAME_PEOPLE+ "TEXT," +
                        UsersMaster.Users.COLUMN_NAME_ORDER+ "TEXT)";

                db.execSQL(SQL_CREATE_ENTRIES);
    }

    public Long addInfo(String time, String date, String no_of_persons, String order_something){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(UsersMaster.Users.COLUMN_NAME_TIME, time);
        values.put(UsersMaster.Users.COLUMN_NAME_DATE, date);
        values.put(UsersMaster.Users.COLUMN_NAME_PEOPLE, no_of_persons);
        values.put(UsersMaster.Users.COLUMN_NAME_ORDER, order_something);

        return db.insert(UsersMaster.Users.TABLE_NAME, null, values);
    }

    public List readAll(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                UsersMaster.Users._ID,
                UsersMaster.Users.COLUMN_NAME_TIME,
                UsersMaster.Users.COLUMN_NAME_DATE,
                UsersMaster.Users.COLUMN_NAME_PEOPLE,
                UsersMaster.Users.COLUMN_NAME_ORDER

        };

        String sortOrder = UsersMaster.Users._ID + "DESC";

        Cursor cursor = db.query(
                UsersMaster.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List info = new ArrayList<>();

        while (cursor.moveToNext()){
            String time = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_TIME));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_DATE));
            String no_of_persons = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PEOPLE));
            String order_something = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_ORDER));

            info.add(time+":"+date+":"+no_of_persons+":"+order_something);

        }
        cursor.close();

        return info;



    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
