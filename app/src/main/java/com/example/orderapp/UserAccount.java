package com.example.orderapp;


import static androidx.appcompat.app.AlertDialog.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import com.example.orderapp.Database.DBHelperUser;

public class UserAccount extends AppCompatActivity {


    Button deleteAccount;


    String email;

    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            Toast.makeText(UserAccount.this, "Got Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(UserAccount.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }



    public void personalDetails(View view) {
        getIntentData();
        Intent intent1 = new Intent(getApplicationContext(), personalDetails.class);
        intent1.putExtra("email", String.valueOf(email));
        startActivity(intent1);
    }
    public void feedbacks(View view) {
        getIntentData();
        Intent intent2 = new Intent(this, User_feedbacks.class);
        intent2.putExtra("email", String.valueOf(email));
        startActivity(intent2);
    }
    public void changePassword(View view) {
        getIntentData();
        Intent intent3 = new Intent(this, change_password.class);
        intent3.putExtra("email", String.valueOf(email));
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

        getIntentData();

        deleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelperUser dbHelperUser = new DBHelperUser(UserAccount.this);
                //confirmDelete(email);

                boolean checkDelete = dbHelperUser.deleteInfo(email);
                if(checkDelete == true){
                    Toast.makeText(UserAccount.this, "Delete Successful", Toast.LENGTH_SHORT).show();
                    Intent intent6 = new Intent(getApplicationContext(),intro_02.class);
                    startActivity(intent6);
                }else{
                    Toast.makeText(UserAccount.this, "Some thing went wrong.", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    void confirmDelete(String email) {
        Builder builder = new Builder(UserAccount.this);
        builder.setTitle("Delete");
        builder.setMessage("Are you sure You want to delete your Account??");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBHelperUser dbHelperUser = new DBHelperUser(UserAccount.this);
                dbHelperUser.deleteInfo(email);
                Toast.makeText(UserAccount.this, "Delete Successful", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });
    }
}



