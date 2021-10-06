package com.example.mad_miniproject.database;

import android.provider.BaseColumns;

public final class ItemsMaster {
    private ItemsMaster() { }

    public static class cOrders implements BaseColumns {
        public static final String TABLE_NAME = "cOrders";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_NO_OF_PEOPLE = "noOfPeople";
        public static final String COLUMN_ADDRESS = "address";
    }

    public static class AppetizerItemsInfo implements BaseColumns {
        public static final String TABLE_NAME_APTZR = "aptzr_items";
        public static final String COLUMN_C_ORDER_ID = "apt_c_order_id";
        public static final String COLUMN_ITEM_NAME = "apt_item_name";
        public static final String COLUMN_ITEM_PRICE = "apt_item_price";
        public static final String COLUMN_ITEM_TOT_PRICE = "apt_total_price";
    }

}
