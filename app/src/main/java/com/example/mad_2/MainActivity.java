package com.example.mad_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_2.database.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText editTime, editDate, editNumber, editOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTime = findViewById(R.id.editTime);
        editDate = findViewById(R.id.editDate);
        editNumber = findViewById(R.id.editNumber);
        editOrder = findViewById(R.id.editOrder);
    }
    //navigation
    public void openSecond(View view){

        Intent intent = new Intent(this, second.class);

        String time = editTime.getText().toString();
        String date = editDate.getText().toString();
        String number = editNumber.getText().toString();
        String order = editOrder.getText().toString();


        startActivity(intent);
    }

}