package com.example.lemon_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lemon_cafe.database.DBHelper;

public class UserAccount extends AppCompatActivity {

    public final static String MESSAGE_KEY ="com.example.message_key";
    Intent intentEmail = getIntent();
    String email = intentEmail.getStringExtra(MESSAGE_KEY);

    Button deleteAccount;
    DBHelper dbHelper;


    public void personalDetails(View view) {
        Intent intent1 = new Intent(this, personalDetails.class);
        intent1.putExtra(MESSAGE_KEY,email);
        startActivity(intent1);
    }
    public void feedbacks(View view) {
        Intent intent2 = new Intent(this, User_feedbacks.class);
        intent2.putExtra(MESSAGE_KEY,email);
        startActivity(intent2);
    }
    public void changePassword(View view) {
        Intent intent3 = new Intent(this, change_password.class);
        intent3.putExtra(MESSAGE_KEY,email);
        startActivity(intent3);
    }
    public void signOut(View view) {
        Intent intent4 = new Intent(this, intro_02.class);
        startActivity(intent4);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);


        deleteAccount = findViewById(R.id.deleteAccount);

        dbHelper = new DBHelper(this);

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean checkDeleteData = dbHelper.deleteInfo(email);
                if(checkDeleteData==true){
                    Toast.makeText(UserAccount.this, "Deleted Account  Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(UserAccount.this,"Something went wrong;(\nTry Again.",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}