package com.example.orderapp;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.orderapp.Database.OrderContract;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class shippingInfo extends AppCompatActivity {

    private EditText editTextCreditCardNumber;
    EditText custName, cvv, contact, address, date, cardNum ;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;
    //lolll



    //number validation format
    String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    Matcher m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        createNotificationonChannel();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping_info);

        Button Order = findViewById(R.id.orderBasket2);
        Button cancelOrder = findViewById(R.id.cancelOrder);

        custName = findViewById(R.id.editCustName);
        cvv = findViewById(R.id.editTextCvv);
        date = findViewById(R.id.editTextDate);
        cardNum = findViewById(R.id.editText_creditCardNumber);
        contact = findViewById(R.id.editTpnum);
        address = findViewById(R.id.editTextTextPostalAddress);


        this.editTextCreditCardNumber = (EditText) this.findViewById(R.id.editText_creditCardNumber);

        TextWatcher textWatcher = new CreditCardNumberTextWatcher(this.editTextCreditCardNumber);
        this.editTextCreditCardNumber.addTextChangedListener(textWatcher);

        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
                Toast.makeText(shippingInfo.this, "Order Canceled Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(shippingInfo.this, ProductList.class);
                startActivity(intent);
            }
        });



        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                saveShipping();
                Pattern r = Pattern.compile(pattern);
                if (!contact.getText().toString().isEmpty() && !custName.getText().toString().isEmpty() && !cvv.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !date.getText().toString().isEmpty() && !cardNum.getText().toString().isEmpty()) {
                    m = r.matcher(contact.getText().toString().trim());
                    if (m.find()) {

                        Toast.makeText(shippingInfo.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(shippingInfo.this,notifactionBox.class);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(shippingInfo.this, 0,intent,0);

                        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                        long timeButtonClick = System.currentTimeMillis();
                        long secstomilisecs = 1000*3;

                        alarmManager.set(AlarmManager.RTC_WAKEUP,               //wakup device when time arrived
                                timeButtonClick + secstomilisecs,
                                pendingIntent);

                    } else {
                        Toast.makeText(shippingInfo.this, "Entre a Valid mobile number", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(shippingInfo.this, "Please fill all", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(shippingInfo.this, shippingInfo.class);
//                        startActivity(intent);
                }
            }
        });
    }

    private boolean saveShipping() {

        // getting the values from our views
        String sCustName = custName.getText().toString();
        String sCardNumber = editTextCreditCardNumber.getText().toString();
        String sCvv = cvv.getText().toString();
        String sContact = contact.getText().toString();
        String sAddress = address.getText().toString();
        String sDate = date.getText().toString();

        ContentValues values = new ContentValues();

        values.put(OrderContract.OrderEntry.SICUSTOMER_NAME, sCustName);
        values.put(OrderContract.OrderEntry.SICARD_NUMBER, sCardNumber);
        values.put(OrderContract.OrderEntry.SI_CVV, sCvv);
        values.put(OrderContract.OrderEntry.SIEXP_DATE, sContact);
        values.put(OrderContract.OrderEntry.SICONTACT_NUMBER, sAddress);
        values.put(OrderContract.OrderEntry.SIDEL_ADDRESS, sDate);


        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI2, values);
            if (newUri == null) {
                Toast.makeText(this, "Failed to add Shipping Details", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding Shipping Details", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;


    }


    private void createNotificationonChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "orderSuccessMsg";
            String description = "Order Placed Successfully";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("OrderPlaced" ,name, importance);
            channel.setDescription(description);


            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

}