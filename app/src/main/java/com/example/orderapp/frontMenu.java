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

    String email;

    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            Toast.makeText(frontMenu.this, "Got Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(frontMenu.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_menu01);

        int images[] = {R.drawable.slide1,R.drawable.slide2,R.drawable.slide3 };

        v_flipper = findViewById(R.id.v_flipper);
        ImageView orderButton = (ImageView)findViewById(R.id.orderButtonImg);
        ImageView userButton = (ImageView)findViewById(R.id.userButtonImg);
        ImageView cateringButton = (ImageView)findViewById(R.id.cateringButtonImg);
        ImageView reservationButton = (ImageView)findViewById(R.id.reservationButtonImg);


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
                getIntentData();
                Intent intent2 = new Intent(frontMenu.this, home.class);
                intent2.putExtra("email", String.valueOf(email));
                startActivity(intent2);

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
                Intent intent = new Intent(frontMenu.this, ReservationForm.class);
                startActivity(intent);

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
