package com.example.lemon_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lemon_cafe.database.DBHelper;
import com.example.lemon_cafe.database.UsersMaster;

public class sign_in extends AppCompatActivity {
    EditText signInEmail, signInPassword;
    Button signIn;
    DBHelper dbHelper;

    View emailgive;
    String email;



    public void back(View view) {

        Intent intent = new Intent(this, intro_02.class);
        startActivity(intent);
    }
    /*public void userAccount(View view) {
        Intent intent = new Intent(this, UserAccount.class);
        emailgive = findViewById(R.id.signInEmail);
        email = signInEmail.getText().toString();
        startActivity(intent);
    }*/
    public final static String
            MESSAGE_KEY ="com.example.message_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInEmail = findViewById(R.id.signInEmail);
        signInPassword = findViewById(R.id.signInPassword);

        signIn = findViewById(R.id.signIn);

        dbHelper = new DBHelper(this);



        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signin_email = signInEmail.getText().toString();
                String signin_password = signInPassword.getText().toString();

                Cursor res = dbHelper.getInfo(signin_email);
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
                }

            }


        });


    }


}