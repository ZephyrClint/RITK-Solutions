package com.example.orderapp.Database;

import static com.example.orderapp.Database.OrderContract.OrderEntry.COLUMN_PRICE;
import static com.example.orderapp.Database.OrderContract.OrderEntry.OTABLE_NAME;
import static com.example.orderapp.Database.OrderContract.OrderEntry.SITABLE_NAME;
import static com.example.orderapp.Database.OrderContract.OrderEntry.TABLE_NAME;
import static com.example.orderapp.Database.OrderContract.OrderEntry._ORDERSHIPMENTID;
import static com.example.orderapp.Database.OrderContract.OrderEntry._SID;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABSE_NAME = "ord.db";
    private static OrderHelper sOrderHelper;


    public OrderHelper(Context context) {
        super(context, DATABSE_NAME, null, DATABASE_VERSION);
    }

    public static OrderHelper getInstance(Context context) {
        if (sOrderHelper == null) {
            sOrderHelper = new OrderHelper(context);
        }
        return sOrderHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + OrderContract.OrderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OrderContract.OrderEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.COLUMN_QUANTITY + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.COLUMN_PRICE + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.COLUMN_SIZE + " TEXT ); ";

        String SQL_TABLE2 = "CREATE TABLE " + SITABLE_NAME + " ("
                + _SID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OrderContract.OrderEntry.SICUSTOMER_NAME + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.SICARD_NUMBER + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.SI_CVV + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.SIEXP_DATE + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.SICONTACT_NUMBER + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.SIDEL_ADDRESS + " TEXT NOT NULL ); ";

        String SQL_TABLE3 = "CREATE TABLE " + OTABLE_NAME + " ("
                + OrderContract.OrderEntry._OID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OrderContract.OrderEntry.OCOLUMN_NAME + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.OCOLUMN_QUANTITY + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.OCOLUMN_PRICE + " TEXT NOT NULL, "
                + OrderContract.OrderEntry.OCOLUMN_SIZE + " TEXT NOT NULL, "
                + _ORDERSHIPMENTID + " INTEGER NOT NULL,"
                +" FOREIGN KEY ("+_ORDERSHIPMENTID+") REFERENCES "+SITABLE_NAME+"("+_SID+"));";

        db.execSQL(SQL_TABLE);
        db.execSQL(SQL_TABLE2);
        db.execSQL(SQL_TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+"");
        db.execSQL("DROP TABLE IF EXISTS "+SITABLE_NAME+"");
        db.execSQL("DROP TABLE IF EXISTS "+OTABLE_NAME+"");


    }

    public int sumPriceCartItems() {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM("+ COLUMN_PRICE + ") from " + TABLE_NAME,  null);
        if (cursor.moveToFirst()) result = cursor.getInt(0);
        cursor.close();
        db.close();
        return result;
    }



}
