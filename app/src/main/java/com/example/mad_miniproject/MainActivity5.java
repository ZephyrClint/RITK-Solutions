package com.example.mad_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {

    TextView tv_Dessert_title;
    TextView tv_Total_Dessert;
    TextView textView3;

    Button btn_Next_Dessert;
    ImageView imageView6;
    ImageView imageView9;
    ImageButton imageButton45;
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
        setContentView(R.layout.activity_main5);

        tv_Dessert_title = findViewById(R.id.tv_Dessert_title);
        tv_Total_Dessert = findViewById(R.id.tv_Total_Dessert);
        textView3 = findViewById(R.id.textView3);
        btn_Next_Dessert = findViewById(R.id.btn_Next_Dessert);
        imageView6 = findViewById(R.id.imageView6);
        imageView9 = findViewById(R.id.imageView9);
        imageButton45 = findViewById(R.id.imageButton45);
        imageButton46 = findViewById(R.id.imageButton46);
        imageButton47 = findViewById(R.id.imageButton47);
        imageButton48 = findViewById(R.id.imageButton48);
        imageButton49 = findViewById(R.id.imageButton49);
        imageButton50 = findViewById(R.id.imageButton50);
        imageButton51 = findViewById(R.id.imageButton51);
        imageButton52 = findViewById(R.id.imageButton52);
        imageButton53 = findViewById(R.id.imageButton53);

    }

    public void openSixth(View view) {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

}