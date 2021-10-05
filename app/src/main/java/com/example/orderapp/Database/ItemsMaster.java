package com.example.orderapp.Database;

import android.provider.BaseColumns;

public final class ItemsMaster {
    private ItemsMaster() { }

    public static class Items implements BaseColumns {
        public static final String TABLE_NAME = "items";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_NO_OF_PEOPLE = "noOfPeople";
        public static final String COLUMN_ADDRESS = "address";

    }
}

