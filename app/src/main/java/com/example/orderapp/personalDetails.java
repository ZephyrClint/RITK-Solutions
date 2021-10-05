package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderapp.Database.DBHelperUser;

public class personalDetails extends AppCompatActivity {



    String email;


    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            //Toast.makeText(personalDetails.this, "Got Data", Toast.LENGTH_SHORT).show();
        }else{
            //Toast.makeText(personalDetails.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        DBHelperUser dbHelperUser = new DBHelperUser(this);
        getIntentData();
        TextView firstNameView = (TextView)findViewById(R.id.firstNameView);
        TextView lastNameView = (TextView)findViewById(R.id.lastNameView);
        TextView addressView = (TextView)findViewById(R.id.addressView);
        TextView emailView = (TextView)findViewById(R.id.emailView);
        TextView mobileNoView = (TextView)findViewById(R.id.mobileNoView);

        Cursor res = dbHelperUser.getInfo(email);

        if(res.getCount()==0){
            Toast.makeText(personalDetails.this, "No Data", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(res.moveToNext()) {
                firstNameView.setText(res.getString(1));
                lastNameView.setText(res.getString(2));
                emailView.setText(res.getString(3));
                addressView.setText(res.getString(4));
                mobileNoView.setText(res.getString(5));

            }
        }


    }
    public void editPersonalDetails(View view) {
        getIntentData();
        Intent intent1 = new Intent(getApplicationContext(), personalDetailsEdit.class);
        intent1.putExtra("email", String.valueOf(email));
        startActivity(intent1);
    }


}

