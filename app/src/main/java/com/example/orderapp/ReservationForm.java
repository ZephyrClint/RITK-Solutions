package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderapp.Database.DBHelperKalindu;

public class ReservationForm extends AppCompatActivity {

    EditText editTime, editDate, editNumber, editOrder;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_form);

        editTime = findViewById(R.id.editTimeKalindu);
        editDate = findViewById(R.id.editDateKalindu);
        editNumber = findViewById(R.id.editNumberKalindu);
        editOrder = findViewById(R.id.editOrderKalindu);
        textView = findViewById(R.id.textView);
    }
    //navigation
    public void openSecond(View view){

        Intent intent = new Intent(this, ReservationView.class);

        String time = editTime.getText().toString();
        String date = editDate.getText().toString();
        String number = editNumber.getText().toString();
        String order = editOrder.getText().toString();

        intent.putExtra("time", time);
        intent.putExtra("date",date);
        intent.putExtra("number",number);
        intent.putExtra("order",order);

        startActivity(intent);

    }

    public void saveUser(View view){
        String time = editTime.getText().toString();
        String date = editDate.getText().toString();
        String number = editNumber.getText().toString();
        String order = editOrder.getText().toString();

        DBHelperKalindu dbHelperKalindu = new DBHelperKalindu(this);

        if(date.isEmpty()||time.isEmpty()||number.isEmpty()){
            Toast.makeText(this,  "Enter Values", Toast.LENGTH_SHORT).show();
        }else {
            long inserted = dbHelperKalindu.addInfo(time, date, number, order);

            if(inserted>0.0){
                Toast.makeText(this,  "Data inserted successfully", Toast.LENGTH_SHORT).show();
            }else {
                while(inserted==0.0) {
                    Toast.makeText(this, "Something went wrong ", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(this, UsersMaster.Users._ID,Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}