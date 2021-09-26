package com.example.orderapp;

public class OrderModel {


    String mProductName;
    String mProductDesc;
    int mProductimg;

    public OrderModel(String mProductName, String mProductDesc, int mProductimg) {
        this.mProductName = mProductName;
        this.mProductDesc = mProductDesc;
        this.mProductimg = mProductimg;
    }




    public String getmProductName() {
        return mProductName;
    }

    public String getmProductDesc() {
        return mProductDesc;
    }

    public int getmProductimg() {
        return mProductimg;
    }
}
