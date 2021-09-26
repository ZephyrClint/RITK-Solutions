package com.example.lemon_cafe.database;

import android.provider.BaseColumns;

public class UsersMaster {
    private UsersMaster() {}

    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_FIRST_NAME = "firstName";
        public static final String COLUMN_NAME_LAST_NAME = "lastName";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_MOBILE_NO = "mobileNo";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }

}
