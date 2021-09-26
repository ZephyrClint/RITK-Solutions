package com.example.mad_miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView tv_Apptzr_title;
    TextView tv_Breakfast_Apptzr;
    TextView tv_Lunch_Apptzr;
    TextView tv_Dinner_Apptzr;
    TextView tv_apptzr_total;
    TextView tv_apptzr_tot_value;
    Button btn_Next_Apptzr;
    ImageView imageView3;
    ImageButton imageButton27;
    ImageButton imageButton28;
    ImageButton imageButton29;
    ImageButton imageButton30;
    ImageButton imageButton31;
    ImageButton imageButton32;
    ImageButton imageButton33;
    ImageButton imageButton34;
    ImageButton imageButton35;
    ImageView imageView7;

    //navigation
    public void openFourth(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_Apptzr_title = findViewById(R.id.tv_Apptzr_title);
        tv_Breakfast_Apptzr = findViewById(R.id.tv_Breakfast_Apptzr);
        tv_Lunch_Apptzr = findViewById(R.id.tv_Lunch_Apptzr);
        tv_Dinner_Apptzr = findViewById(R.id.tv_Dinner_Apptzr);
        tv_apptzr_total = findViewById(R.id.tv_apptzr_total);
        tv_apptzr_tot_value = findViewById(R.id.tv_apptzr_tot_value);
        btn_Next_Apptzr = findViewById(R.id.btn_Next_Apptzr);
        imageView3 = findViewById(R.id.imageView3);
        imageButton27 = findViewById(R.id.imageButton27);
        imageButton28 = findViewById(R.id.imageButton28);
        imageButton29 = findViewById(R.id.imageButton29);
        imageButton30 = findViewById(R.id.imageButton30);
        imageButton31 = findViewById(R.id.imageButton31);
        imageButton32 = findViewById(R.id.imageButton32);
        imageButton33 = findViewById(R.id.imageButton33);
        imageButton34 = findViewById(R.id.imageButton34);
        imageButton35 = findViewById(R.id.imageButton35);
        imageView7 = findViewById(R.id.imageView7);
    }


}