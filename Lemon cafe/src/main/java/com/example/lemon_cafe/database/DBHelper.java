package com.example.lemon_cafe.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "UserDetails.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE  Users (ID INTEGER PRIMARY KEY AUTOINCREMENT,firstName TEXT,lastName TEXT,email TEXT,address TEXT,mobileNo TEXT,password TEXT)");

    }

    public boolean addInfo(
            String firstName,
            String lastName,
            String address,
            String email,
            String mobileNo,
            String password
    ){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valuesUsers = new ContentValues();

        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_FIRST_NAME, firstName);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_LAST_NAME, lastName);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_EMAIL, email);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_ADDRESS,address);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_MOBILE_NO,mobileNo);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,password);




        long newRowID = database.insert(UsersMaster.Users.TABLE_NAME,null,valuesUsers);
        //return database.insert(UsersMaster.Users.TABLE_NAME,null,valuesUsers);

        if (newRowID==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean updateInfo(
            String firstName,
            String lastName,
            String address,
            String mobileNo,
            String email
    ){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valuesUsers = new ContentValues();

        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_FIRST_NAME, firstName);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_LAST_NAME, lastName);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_EMAIL, email);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_ADDRESS,address);
        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_MOBILE_NO,mobileNo);
        Cursor cursor = database.rawQuery("Select*from Users where email = ?", new String[]{email});


        if(cursor.getCount()>0) {

            long newRowID = database.update(
                    UsersMaster.Users.TABLE_NAME,
                    valuesUsers, "email=?", new String[]{email});
            //return database.insert(UsersMaster.Users.TABLE_NAME,null,valuesUsers);

            if (newRowID == -1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }




        public boolean deleteInfo(
                String email
    ){
            SQLiteDatabase database = this.getWritableDatabase();

            Cursor cursor = database.rawQuery("Select*from Users where email = ?", new String[]{email});


            if(cursor.getCount()>0) {


                long newRowID = database.delete(
                        UsersMaster.Users.TABLE_NAME,
                         "email=?", new String[]{email});
                //return database.insert(UsersMaster.Users.TABLE_NAME,null,valuesUsers);

                if (newRowID == -1) {
                    return false;
                } else {
                    return true;
                }
            }else{
                return false;
            }
    }

    public Cursor getInfo(
            String email
    ){
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("Select*from Users where email = ?", new String[]{email});
        return cursor;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean updatePassword(
            String passwordNew,
            String email,
            String currentPassword
    ){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valuesUsers = new ContentValues();

        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,passwordNew);

        Cursor cursor = database.rawQuery("Select*from Users where email = ?", new String[]{email});
        String dbcurrentPassword = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));


        if(cursor.getCount()>0) {
            if(dbcurrentPassword==currentPassword) {
                long newRowID = database.update(
                        UsersMaster.Users.TABLE_NAME,
                        valuesUsers, "email=?", new String[]{passwordNew});
                //return database.insert(UsersMaster.Users.TABLE_NAME,null,valuesUsers);

            if (newRowID == -1) {
                return false;
            } else {
                return true;
            }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
