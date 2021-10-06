package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp.Database.DBHelperKalindu;

public class ReservationView extends AppCompatActivity {

    EditText editTime, editDate, editNumber, editOrder;

    String time;
    String date;
    String number;
    String order;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_view);

        editTime = findViewById(R.id.editTimeKalindu);
        editDate = findViewById(R.id.editDateKalindu);
        editNumber = findViewById(R.id.editNumberKalindu);
        editOrder = findViewById(R.id.editOrderKalindu);

        Button btnkalindu = (Button)findViewById(R.id.mainmenukalindu);
        btnkalindu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ReservationView.this, frontMenu.class);
                startActivity(intent);

            }
        });


        //getting data from previous ui
        Intent intent = getIntent();
        time = intent.getStringExtra("time");
        date = intent.getStringExtra("date");
        number = intent.getStringExtra("number");
        order = intent.getStringExtra("order");
        id = intent.getStringExtra("_id");


        editTime.setText(time);
        editDate.setText(date);
        editNumber.setText(number);
        editOrder.setText(order);
    }




//    public void viewAll(View view){
//        DBHelper dbHelper = new DBHelper(this);
//
//        List info = dbHelper.readAll();
//
//        String[] infoArray = (String[]) info.toArray(new String[0]);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Order Details");
//
//        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//
//
//        AlertDialog dialog = builder.create();
//        dialog.show();
//
//    }


    public void deleteReservation(View view) {
        DBHelperKalindu dbHelperKalindu = new DBHelperKalindu(this);

        String date = editDate.getText().toString();

        if(date.isEmpty()){
            Toast.makeText(this, "Please select order to Delete", Toast.LENGTH_SHORT).show();
        }else{

            dbHelperKalindu.deleteInfo(date);

            Toast.makeText(this, "Reservation deleted!", Toast.LENGTH_SHORT).show();


            editTime.setText("");
            editDate.setText("");
            editNumber.setText("");
            editOrder.setText("");
        }

    }

    public void updateReservation(View view){
        DBHelperKalindu dbHelperKalindu = new DBHelperKalindu(this);

        String time = editTime.getText().toString();
//        String date = editDate.getText().toString();
        String Date = date.toString();
        String noOfPersons = editNumber.getText().toString();
        String order = editOrder.getText().toString();
        Toast.makeText(this, " ", Toast.LENGTH_SHORT).show();

//        if(order.isEmpty() || time.isEmpty() || date.isEmpty() || noOfPersons.isEmpty())
        if(order.isEmpty() || time.isEmpty() || noOfPersons.isEmpty()){
            Toast.makeText(this, "Please select reservation to Update", Toast.LENGTH_SHORT).show();
        }else{

            dbHelperKalindu.updateInfo(Date, time, noOfPersons, order);

            Toast.makeText(this, "Reservation updated!", Toast.LENGTH_SHORT).show();

        }

    }

}