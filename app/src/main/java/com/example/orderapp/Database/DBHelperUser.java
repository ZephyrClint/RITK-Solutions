package com.example.orderapp.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.orderapp.UserAccount;
import com.example.orderapp.personalDetailsEdit;
import com.example.orderapp.sign_up;

public class DBHelperUser extends SQLiteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME = "UserDetails.db";



    public DBHelperUser(Context context){
        super(context, DATABASE_NAME, null,  1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + UsersMaster.Users.TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,firstName TEXT,lastName TEXT,email TEXT,address TEXT,mobileNo TEXT,password TEXT)");

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

        ContentValues cv = new ContentValues();

        cv.put(UsersMaster.Users.COLUMN_NAME_FIRST_NAME, firstName);
        cv.put(UsersMaster.Users.COLUMN_NAME_LAST_NAME, lastName);
        cv.put(UsersMaster.Users.COLUMN_NAME_ADDRESS,address);
        cv.put(UsersMaster.Users.COLUMN_NAME_MOBILE_NO,mobileNo);


        long newRowID = database.update(
                UsersMaster.Users.TABLE_NAME,
                cv, "email=?", new String[]{email});
        //return database.insert(UsersMaster.Users.TABLE_NAME,null,valuesUsers);

        if (newRowID == -1) {
            return false;
        } else {
            return true;
        }

    }




    public boolean deleteInfo(
            String email
    ){
        SQLiteDatabase database = this.getWritableDatabase();
        long delete = database.delete(
                UsersMaster.Users.TABLE_NAME,
                "email=?", new String[]{email});

        if (delete == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor getInfo(
            String email
    ){


        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT*from Users where email=?",new String[]{email});
        return cursor;
    }




    public boolean checkEmail(String email){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select*from Users where email = ?", new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkEmailPassword(String email,String password){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select*from Users where email = ? and password=?", new String[]{email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkPassword(String email,String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select*from Users where email = ?", new String[]{email});
        while (cursor.moveToNext()) {
            String a = cursor.getString(6);


            if (cursor.getCount() > 0) {
                if (a == password) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsersMaster.Users.TABLE_NAME);
        onCreate(db);
    }







    public boolean updatePassword(
            String passwordNew,
            String email,
            String currentPassword
    ) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues valuesUsers = new ContentValues();

        valuesUsers.put(UsersMaster.Users.COLUMN_NAME_PASSWORD, passwordNew);

        Cursor cursor = database.rawQuery("Select*from Users where email = ?", new String[]{email});
        while (cursor.moveToNext()) {
            String dbcurrentPassword = cursor.getString(cursor.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));


            if (cursor.getCount() > 0) {
                if (dbcurrentPassword == currentPassword) {
                    long newRowID = database.update(
                            UsersMaster.Users.TABLE_NAME,
                            valuesUsers, "email=?", new String[]{passwordNew});


                    if (newRowID == -1) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } return false;
    }
}

