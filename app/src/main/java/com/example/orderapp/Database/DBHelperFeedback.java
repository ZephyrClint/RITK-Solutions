package com.example.orderapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperFeedback extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserDetails.db";

    public DBHelperFeedback(Context context){
        super(context, DATABASE_NAME, null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE  Feedbacks (ID INTEGER PRIMARY KEY AUTOINCREMENT,description TEXT,Name TEXT,email TEXT)");
    }
    public boolean addFeedback(
            String description,
            String name,
            String email

    ){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valuesFeedbacks = new ContentValues();

        valuesFeedbacks.put(feedbackMaster.Feedbacks.COLUMN_NAME_DESCRIPTION, description);
        valuesFeedbacks.put(feedbackMaster.Feedbacks.COLUMN_NAME_NAME, name);
        valuesFeedbacks.put(feedbackMaster.Feedbacks.COLUMN_NAME_EMAIL, email);

        long newRowID = database.insert(feedbackMaster.Feedbacks.TABLE_NAME,null,valuesFeedbacks);

        if (newRowID == -1){
            return false;
        }else{
            return true;
        }
    }



    public Cursor getFeedbacks(
            String email
    ){

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT*from Feedbacks where email=?",new String[]{email});
        return cursor;
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

