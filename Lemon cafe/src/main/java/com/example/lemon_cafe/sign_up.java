package com.example.lemon_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lemon_cafe.database.*;


public class sign_up extends AppCompatActivity {

    EditText firstName, lastName, registerAddress, registeremail, registerMobileNo, registerPassword;
    Button signUp;
    DBHelper dbHelper;

    public void back(View view) {
        Intent intent = new Intent(this, intro_02.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        registerAddress = findViewById(R.id.registerAddress);
        registeremail = findViewById(R.id.registeremail);
        registerMobileNo = findViewById(R.id.registerMobileNo);
        registerPassword = findViewById(R.id.registerPassword);

        signUp = findViewById(R.id.buttonSignUp);

        dbHelper = new DBHelper(this);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name = firstName.getText().toString();
                String last_name = lastName.getText().toString();
                String address = registerAddress.getText().toString();
                String email = registeremail.getText().toString();
                String mobile_no = registerMobileNo.getText().toString();
                String password = registerPassword.getText().toString();

                Boolean checkInsertData = dbHelper.addInfo(first_name,last_name,address,email,mobile_no,password);
                if(first_name.isEmpty() || email.isEmpty() || mobile_no.isEmpty() || password.isEmpty()){
                    Toast.makeText(sign_up.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }else if(checkInsertData==true){
                    Toast.makeText(sign_up.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(sign_up.this,"Something went wrong;(\nTry Again.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }/*public void saveUser(View view) {
        String first_name = firstName.getText().toString();
        String last_name = lastName.getText().toString();
        String address = registerAddress.getText().toString();
        String email = registeremail.getText().toString();
        String mobile_no = registerMobileNo.getText().toString();
        String password = registerPassword.getText().toString();
        dbHelper = new DBHelper(this);

        if (first_name.isEmpty() || email.isEmpty() || mobile_no.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
        } else {
            long insertedUser= dbHelper.addInfo(first_name, last_name, address, password, mobile_no, email);

            if(insertedUser>0){
                Toast.makeText(this,"Data Inserted Successfully", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Something went wrong;(",Toast.LENGTH_SHORT).show();
            }

        }
    }*/
}