package com.example.orderapp.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class OrderContract {

    public OrderContract() {
    }


    public static final String CONTENT_AUTHORITY = "com.example.orderapp";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH1 = "orderig";
    public static final String PATH2 = "shippingInfo";
    public static final String PATH3 = "custOrders";


    public static abstract class OrderEntry implements BaseColumns{

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH1);
        public static final Uri CONTENT_URI2 = Uri.withAppendedPath(BASE_URI, PATH2);
        public static final Uri CONTENT_URI3 = Uri.withAppendedPath(BASE_URI, PATH3);

        public static final String TABLE_NAME = "orderig";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_SIZE = "size";

        public static final String SITABLE_NAME = "shippingInfo";
        public static final String _SID = BaseColumns._ID;
        public static final String SICUSTOMER_NAME = "custName";
        public static final String SICARD_NUMBER = "cardNum";
        public static final String SI_CVV = "cvv";
        public static final String SIEXP_DATE = "expDate";
        public static final String SICONTACT_NUMBER = "contactNumber";
        public static final String SIDEL_ADDRESS = "delAddress";

        public static final String OTABLE_NAME = "custOrders";
        public static final String _OID = BaseColumns._ID;
        public static final String OCOLUMN_NAME = "name";
        public static final String OCOLUMN_QUANTITY = "quantity";
        public static final String OCOLUMN_PRICE = "price";
        public static final String OCOLUMN_SIZE = "size";
        public static final String _ORDERSHIPMENTID = "shipmentID";

    }
}
