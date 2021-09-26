package com.example.mad_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {

    TextView tv_Other_title;
    TextView tv_Other_Breakfast;
    TextView tv_Other_Lunch;
    TextView tv_Other_Dinner;
    TextView tv_Total_Other;
    TextView textView2;
    Button btn_Next_Other;
    ImageView imageView4;
    ImageView imageView9;
    ImageButton imageButton18;
    ImageButton imageButton46;
    ImageButton imageButton47;
    ImageButton imageButton48;
    ImageButton imageButton49;
    ImageButton imageButton50;
    ImageButton imageButton51;
    ImageButton imageButton52;
    ImageButton imageButton53;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        tv_Other_title = findViewById(R.id.tv_Other_title);
        tv_Other_Breakfast = findViewById(R.id.tv_Other_Breakfast);
        tv_Other_Lunch = findViewById(R.id.tv_Other_Lunch);
        tv_Other_Dinner = findViewById(R.id.tv_Other_Dinner);
        tv_Total_Other = findViewById(R.id.tv_Total_Other);
        textView2 = findViewById(R.id.textView2);
        btn_Next_Other = findViewById(R.id.btn_Next_Other);
        imageView4 = findViewById(R.id.imageView4);
        imageView9 = findViewById(R.id.imageView9);
        imageButton18 = findViewById(R.id.imageButton18);
        imageButton46 = findViewById(R.id.imageButton46);
        imageButton47 = findViewById(R.id.imageButton47);
        imageButton48 = findViewById(R.id.imageButton48);
        imageButton49 = findViewById(R.id.imageButton49);
        imageButton50 = findViewById(R.id.imageButton50);
        imageButton51 = findViewById(R.id.imageButton51);
        imageButton52 = findViewById(R.id.imageButton52);
        imageButton53 = findViewById(R.id.imageButton53);

    }

    public void openSeventh(View view) {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }

}