package com.example.orderapp;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.orderapp.Database.OrderContract;
import com.example.orderapp.Database.OrderHelper;

public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public CartAdapter mAdapter;
    public static final int LOADER = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView totPrice = findViewById(R.id.totPrice);
        Button clearthedata = findViewById(R.id.clearthedatabase);
        Button backtoList = findViewById(R.id.backtoList);
        Button chkout = findViewById(R.id.chkout);

        chkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryActivity.this, shippingInfo.class);
                startActivity(intent);

            }
        });



        clearthedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
            }
        });

        backtoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryActivity.this, ProductList.class);
                startActivity(intent);

            }
        });

        OrderHelper db = OrderHelper.getInstance(this);
        totPrice.setText("Rs." + db.sumPriceCartItems());

        getLoaderManager().initLoader(LOADER, null, this);

        ListView listView = findViewById(R.id.list);
        mAdapter = new CartAdapter(this, null);
        listView.setAdapter(mAdapter);



    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SIZE,
        };

        return new CursorLoader(this, OrderContract.OrderEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdapter.swapCursor(null);
    }








}