package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderapp.Database.DBHelperUser;

public class personalDetailsEdit extends AppCompatActivity {

    EditText editfirstName, editLastName, editAddress, editEmail, editMobileNo;
    Button savebtn;
    DBHelperUser dbHelperUser;
    String email;
    Activity activity;

    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            //Toast.makeText(personalDetailsEdit.this, "Got Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(personalDetailsEdit.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details_edit);
        dbHelperUser = new DBHelperUser(personalDetailsEdit.this);
        getIntentData();
        TextView firstNameView = (TextView)findViewById(R.id.editfirstName);
        TextView lastNameView = (TextView)findViewById(R.id.editLastName);
        TextView addressView = (TextView)findViewById(R.id.editAddress);
        TextView mobileNoView = (TextView)findViewById(R.id.editMobileNo);

        Cursor res = dbHelperUser.getInfo(email);
        if(res.getCount()==0){
            Toast.makeText(personalDetailsEdit.this, "No Data", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(res.moveToNext()) {
                firstNameView.setText(res.getString(1));
                lastNameView.setText(res.getString(2));
                addressView.setText(res.getString(4));
                mobileNoView.setText(res.getString(5));

            }
        }

        editfirstName = findViewById(R.id.editfirstName);
        editLastName = findViewById(R.id.editLastName);
        editAddress = findViewById(R.id.editAddress);
        editMobileNo = findViewById(R.id.editMobileNo);
        savebtn = findViewById(R.id.savebtn);


        savebtn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                getIntentData();
                String first_name = editfirstName.getText().toString();
                String last_name = editLastName.getText().toString();
                String address = editAddress.getText().toString();
                String mobile_no = editMobileNo.getText().toString();



                Boolean checkUpdateData = dbHelperUser.updateInfo(first_name,last_name,address,email,mobile_no);
                if(first_name.isEmpty() || mobile_no.isEmpty()){
                    Toast.makeText(personalDetailsEdit.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }else if(checkUpdateData==true){
                    Toast.makeText(personalDetailsEdit.this, "Update Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),personalDetails.class);
                    intent.putExtra("email", String.valueOf(email));
                    startActivity(intent);
                }else{
                    Toast.makeText(personalDetailsEdit.this,"Something went wrong;(\nTry Again.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}