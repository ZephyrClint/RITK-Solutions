package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    TextView tv_MainCourse_title;
    TextView tv_MainCourse_Breakfast;
    TextView tv_MainCourse_Lunch;
    TextView tv_MainCourse_Dinner;
    TextView tv_maincourse_tot;
    TextView tv_Total_MainCourse;
    Button btn_Next_MainCourse;
    ImageView imageView5;
    ImageView imageView8;
    ImageButton imageButton36;
    ImageButton imageButton37;
    ImageButton imageButton38;
    ImageButton imageButton39;
    ImageButton imageButton40;
    ImageButton imageButton41;
    ImageButton imageButton42;
    ImageButton imageButton43;
    ImageButton imageButton44;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv_MainCourse_title = findViewById(R.id.tv_MainCourse_title);
        tv_MainCourse_Breakfast = findViewById(R.id.tv_MainCourse_Breakfast);
        tv_MainCourse_Lunch = findViewById(R.id.tv_MainCourse_Lunch);
        tv_MainCourse_Dinner = findViewById(R.id.tv_MainCourse_Dinner);
        tv_maincourse_tot = findViewById(R.id.tv_maincourse_tot);
        tv_Total_MainCourse = findViewById(R.id.tv_Total_MainCourse);
        btn_Next_MainCourse = findViewById(R.id.btn_Next_MainCourse);
        imageView5 = findViewById(R.id.imageView5);
        imageView8 = findViewById(R.id.imageView8);
        imageButton36 = findViewById(R.id.imageButton36);
        imageButton37 = findViewById(R.id.imageButton36);
        imageButton38 = findViewById(R.id.imageButton36);
        imageButton39 = findViewById(R.id.imageButton36);
        imageButton40 = findViewById(R.id.imageButton36);
        imageButton41 = findViewById(R.id.imageButton36);
        imageButton42 = findViewById(R.id.imageButton36);
        imageButton43 = findViewById(R.id.imageButton36);
        imageButton44 = findViewById(R.id.imageButton36);

    }

    public void openFifth(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

}