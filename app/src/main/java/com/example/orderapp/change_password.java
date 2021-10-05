package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp.Database.DBHelperUser;

public class change_password extends AppCompatActivity {

    String email;
    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            //Toast.makeText(personalDetailsEdit.this, "Got Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(change_password.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }


    EditText changePassword_current,changePassword_new;
    Button changePasswordSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        changePassword_current = findViewById(R.id.changePassword_current);
        changePassword_new = findViewById(R.id.changePassword_new);



        changePasswordSaveBtn = findViewById(R.id.savebtn);

        DBHelperUser dbHelperUser = new DBHelperUser(this);

        changePasswordSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntentData();

                String changePasswordNew = changePassword_new.getText().toString();
                String changePasswordCurrent = changePassword_current.getText().toString();



                Boolean checkUpdateData = dbHelperUser.updatePassword(changePasswordNew, email, changePasswordCurrent);
                if(changePasswordNew.isEmpty() || changePasswordCurrent.isEmpty()){
                    Toast.makeText(change_password.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }
                else if (checkUpdateData == true) {
                    Toast.makeText(change_password.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(change_password.this, "Something went wrong;(\nTry Again.", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
}