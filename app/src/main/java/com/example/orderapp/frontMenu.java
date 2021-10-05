package com.example.orderapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class frontMenu extends AppCompatActivity {
    ViewFlipper v_flipper;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_menu01);

        int images[] = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3 };

        v_flipper = findViewById(R.id.v_flipper);
        ImageView orderButton = (ImageView)findViewById(R.id.orderButtonImg);
        ImageView userButton = (ImageView)findViewById(R.id.userButtonImg);
        ImageView cateringButton = (ImageView)findViewById(R.id.cateringButtonImg);
        ImageView reservationButton = (ImageView)findViewById(R.id.userButtonImg);


        for(int image : images){
            flipperImages(image);
        }

        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(frontMenu.this, ProductList.class);
                startActivity(intent);

            }
        });

        userButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(frontMenu.this, "not yet", Toast.LENGTH_SHORT).show();

            }
        });

        cateringButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(frontMenu.this, MainActivity.class);
                startActivity(intent);

            }
        });

        reservationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(frontMenu.this, "not yet", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void flipperImages (int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }





}
