package com.example.mad_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_2.database.DBHelper;

import java.util.List;

public class second extends AppCompatActivity {

    EditText editTime, editDate, editNumber, editOrder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editTime = findViewById(R.id.editTime);
        editDate = findViewById(R.id.editDate);
        editNumber = findViewById(R.id.editNumber);
        editOrder = findViewById(R.id.editOrder);
    }

    public void saveUser(View view){
        String time = editTime.getText().toString();
        String date = editDate.getText().toString();
        String number = editNumber.getText().toString();
        String order = editOrder.getText().toString();

        DBHelper dbHelper = new DBHelper(this);

        if(date.isEmpty()||time.isEmpty()){
            Toast.makeText(this,  "Enter Values", Toast.LENGTH_SHORT).show();
        }else {
            dbHelper.addInfo(time, date, number, order);
        }
    }


    public void viewAll(View view){
        DBHelper dbHelper = new DBHelper(this);

        List info = dbHelper.readAll();

        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Order Details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();

    }
}