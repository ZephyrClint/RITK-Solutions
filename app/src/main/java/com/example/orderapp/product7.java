package com.example.orderapp;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderapp.Database.OrderContract;

public class product7 extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, productName, productPrice,productDesc;
    Button addtoCart;
    RadioButton smallPrice,mediumPrice,largePrice;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        addtoCart = findViewById(R.id.addtocart);
        smallPrice = findViewById(R.id.smallSize);
        mediumPrice = findViewById(R.id.mediumSize);
        largePrice = findViewById(R.id.largeSize);
        productDesc = findViewById(R.id.descriptioninfo);

        productName.setText("Peking Roasted Duck");
        imageView.setImageResource(R.drawable.peking);
        productDesc.setText(getString(R.string.RoastedDuck));

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(product7.this, SummaryActivity.class);
                startActivity(intent);

                //save data to cart
                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set intial price
                int basePrice = 2800;
                quantity++;
                displayQuantity();
                int pPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(pPrice);
                productPrice.setText(setnewPrice);


                //radio button calculation
                int ifRadioButton = CalculatePrice(smallPrice, mediumPrice, largePrice);

                productPrice.setText("Rs. " + ifRadioButton);

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 1500;
                if (quantity == 0) {
                    Toast.makeText(product7.this, "Cannot select lower than 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int pPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(pPrice);
                    productPrice.setText(setnewPrice);


                    //radio button calculation
                    int ifRadioButton = CalculatePrice(smallPrice, mediumPrice, largePrice);

                    productPrice.setText("Rs. " + ifRadioButton);
                }
            }
        });



    }

    private boolean SaveCart() {

        // getting the values from our views
        String name = productName.getText().toString();
        String price = productPrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        if (smallPrice.isChecked()) {
            values.put(OrderContract.OrderEntry.COLUMN_SIZE, "Size: Small");

        } else if (mediumPrice.isChecked()){
            values.put(OrderContract.OrderEntry.COLUMN_SIZE, "Size: Medium");

        } else if (largePrice.isChecked()){
            values.put(OrderContract.OrderEntry.COLUMN_SIZE, "Size: Large");
        } else {
            values.put(OrderContract.OrderEntry.COLUMN_SIZE, "Size: Medium");
        }


        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private int CalculatePrice(RadioButton smallPrice, RadioButton mediumPrice, RadioButton largePrice) {

        int basePrice = 1500;

        if (smallPrice.isChecked()) {
            basePrice = basePrice / 2;

        }else if(mediumPrice.isChecked()){
            basePrice = basePrice / 1;

        }else if(largePrice.isChecked()){
            basePrice = basePrice * 2;
        } else {
            basePrice = basePrice / 1;
        }

        return basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,
                OrderContract.OrderEntry.COLUMN_SIZE,

        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);
            int size = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_SIZE);



            String dproductName = cursor.getString(name);
            String dproductPrice = cursor.getString(price);
            String dqty = cursor.getString(quantity);
            String dsize = cursor.getString(size);

            productName.setText(dproductName);
            productPrice.setText(dproductPrice);
            quantitynumber.setText(dqty);
            productPrice.setText(dsize);
        }


    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {


        productName.setText("");
        productPrice.setText("");
        quantitynumber.setText("");

    }
}