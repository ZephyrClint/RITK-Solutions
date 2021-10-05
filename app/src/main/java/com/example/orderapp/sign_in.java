package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp.Database.DBHelperUser;

public class sign_in extends AppCompatActivity {
    EditText signInEmail, signInPassword;
    Button signIn;
    DBHelperUser dbHelperUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInEmail = findViewById(R.id.signInEmail);
        signInPassword = findViewById(R.id.signInPassword);

        signIn = findViewById(R.id.signIn);

        dbHelperUser = new DBHelperUser(this);



        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signin_email = signInEmail.getText().toString();
                String signin_password = signInPassword.getText().toString();


                if (signin_email.isEmpty() ||signin_password.isEmpty()) {
                    Toast.makeText(sign_in.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }else{
                    boolean checkDetails = dbHelperUser.checkEmailPassword(signin_email,signin_password);
                    if(checkDetails == true){
                        Toast.makeText(sign_in.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),frontMenu.class);
                        intent.putExtra("email", String.valueOf(signin_email));
                        startActivity(intent);
                    }else{
                        Toast.makeText(sign_in.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }
               /* Cursor res = dbHelper.getInfo(signin_email);
                    if(res.getCount()==0){
                        Toast.makeText(sign_in.this, "Check Login Credentials", Toast.LENGTH_SHORT).show();

                    }
                String dbEmail = res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_EMAIL));
                String dbPassword = res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_PASSWORD));

                if((dbEmail == signin_email) && (dbPassword == signin_password)){
                    Toast.makeText(sign_in.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Toast.makeText(sign_in.this, "Redirecting....", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(sign_in.this, "Check Login Credentials", Toast.LENGTH_SHORT).show();
                }*/

        });


    }


}
