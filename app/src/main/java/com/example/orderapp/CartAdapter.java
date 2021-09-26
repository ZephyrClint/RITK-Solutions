package com.example.orderapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.orderapp.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // getting theviews
        TextView productName, size, price, quantity;

        productName = view.findViewById(R.id.productNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);
        size = view.findViewById(R.id.sizeInOrderSummary);
        quantity = view.findViewById(R.id.quantityinOrderSummary);

        // getting the values by first getting the position of their columns
        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofproduct = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
        int qtyofproduct = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
        int productSize = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SIZE);

        String c_nameofproduct = cursor.getString(name);
        String c_priceofproduct = cursor.getString(priceofproduct);
        String c_qtyofproduct = cursor.getString(qtyofproduct);
        String c_sizeofproduct = cursor.getString(productSize);

        productName.setText(c_nameofproduct);
        price.setText(c_priceofproduct);
        size.setText(c_sizeofproduct);
        quantity.setText(c_qtyofproduct);

    }
}
