package com.example.mad_2.database;

import android.provider.BaseColumns;

public final class UsersMaster {
    private UsersMaster(){}

    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_PEOPLE = "no_of_persons";
        public static final String COLUMN_NAME_ORDER = "order_something";
    }

}
