package com.example.lemon_cafe.database;

import android.provider.BaseColumns;

public class feedbackMaster {
    private feedbackMaster() {}

    public static class Feedbacks implements BaseColumns {
        public static final String TABLE_NAME = "Feedbacks";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
    }
}
