package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class intro_02 extends AppCompatActivity {

    public void signup(View view) {
        Intent intent = new Intent(this, sign_up.class);
        startActivity(intent);
    }
    public void signin(View view) {
        Intent intent1 = new Intent(this, sign_in.class);
        startActivity(intent1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro02);
    }
}
