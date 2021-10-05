package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class home extends AppCompatActivity {

    String email;


    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            Toast.makeText(home.this, "Got Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(home.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btn1 = (Button)findViewById(R.id.menuRsh);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(home.this, frontMenu.class);
                startActivity(intent);

            }
        });

    }
    public void sign_out(View view) {
        Intent intent1 = new Intent(this, sign_in.class);
        startActivity(intent1);
        Toast.makeText(home.this, "Sign Out Successfully", Toast.LENGTH_SHORT).show();
    }



    public void userProfile(View view) {
        getIntentData();
        Intent intent2 = new Intent(this, UserAccount.class);
        intent2.putExtra("email", String.valueOf(email));
        startActivity(intent2);
    }
    public void addfeedback(View view) {
        getIntentData();
        Intent intent3 = new Intent(this, giveFeedback.class);
        intent3.putExtra("email", String.valueOf(email));
        startActivity(intent3);
    }





}


