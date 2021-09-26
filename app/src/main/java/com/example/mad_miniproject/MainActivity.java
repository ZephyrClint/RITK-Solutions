package com.example.mad_miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mad_miniproject.database.DBHelper;
import com.example.mad_miniproject.database.ItemsMaster;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText e_txt_dt_1;
    EditText e_txt_tm_1;
    EditText e_txt_num_1;
    EditText e_txt_addr_1;
    TextView tv_menu;
    Button btn_mainCourse;
    Button btn_dessert;
    Button btn_appetizer;
    Button btn_other;
    Button btn_viewSelected;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_txt_dt_1 = findViewById(R.id.e_txt_dt_1);
        e_txt_tm_1 = findViewById(R.id.e_txt_tm_1);
        e_txt_num_1= findViewById(R.id.e_txt_num_1);
        e_txt_addr_1=findViewById(R.id.e_txt_addr_1);
        tv_menu = findViewById(R.id.tv_menu);
        btn_mainCourse = findViewById(R.id.btn_mainCourse);
        btn_dessert = findViewById(R.id.btn_dessert);
        btn_dessert = findViewById(R.id.btn_dessert);
        btn_appetizer=findViewById(R.id.btn_appetizer);
        btn_other = findViewById(R.id.btn_other);
        btn_viewSelected=findViewById(R.id.btn_viewSelected);
        imageView = findViewById(R.id.imageView);

    }

    //navigation
    public void openSecond(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void openThird(View view) {
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
    }
    public void openFourth(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    public void openFifth(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
    public void openSixth(View view) {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }


    //button click events

    //CREATION
    public void saveCaterOrder(View view) {
        String date = e_txt_dt_1.getText().toString();
        String time = e_txt_tm_1.getText().toString();
        String noOfPeople = e_txt_num_1 .getText().toString();
        String address = e_txt_addr_1 .getText().toString();

        DBHelper dbHelper = new DBHelper(this);

        if(date.isEmpty() || time.isEmpty() || noOfPeople.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Enter values", Toast.LENGTH_SHORT).show();
        } else {
            long inserted = dbHelper.addInfo(date, time, noOfPeople, address);

            if (inserted > 0) {
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Your Order ID: " + ItemsMaster.Items._ID, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void viewAll(View view) {
        DBHelper dbhelper = new DBHelper(this);

        List info = dbhelper.readAll();

        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Item Details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }



////VIEW SINGLE ITEM
//public void viewSingleOrderItem(View view) {
//    DBHelper dbhelper = new DBHelper(this);
//
//    String address = e_txt_addr_1.getText().toString();
//
//    List info = dbhelper.readSingleOrder(address);
//
//    if(address.isEmpty()){
//        Toast.makeText(this, "Please select order to view details", Toast.LENGTH_SHORT).show();
//    }else{
//
//        dbhelper.readSingleOrder(address);
//
//    }
//
//}



    //DELETION
    public void deleteInitialOrderDetails(View view){
        DBHelper dbHelper = new DBHelper(this);

        String address = e_txt_addr_1.getText().toString();

        if(address.isEmpty()){
            Toast.makeText(this, "Please select order to Delete", Toast.LENGTH_SHORT).show();
        }else{

            dbHelper.deleteInfo(address);

            Toast.makeText(this, "Cater order deleted!", Toast.LENGTH_SHORT).show();


            e_txt_addr_1.setText("");
            e_txt_num_1.setText("");
            e_txt_dt_1.setText("");
            e_txt_tm_1.setText("");
        }

    }



    //UPDATING
    public void updateInitialOrderDetails(View view){
        DBHelper dbHelper = new DBHelper(this);

//        String userName = edtName.getText().toString();
        String address = e_txt_addr_1.getText().toString();
        String time = e_txt_tm_1.getText().toString();
        String date = e_txt_dt_1.getText().toString();
        String noOfPeople = e_txt_num_1.getText().toString();

        if(address.isEmpty() || time.isEmpty() || date.isEmpty() || noOfPeople.isEmpty()){
            Toast.makeText(this, "Please select order to Update", Toast.LENGTH_SHORT).show();
        }else{

            dbHelper.updateInfo(view, time, date, noOfPeople, address);

            Toast.makeText(this, "Cater order updated!", Toast.LENGTH_SHORT).show();


            e_txt_addr_1.setText("");
            e_txt_num_1.setText("");
            e_txt_dt_1.setText("");
            e_txt_tm_1.setText("");
        }

    }

}

