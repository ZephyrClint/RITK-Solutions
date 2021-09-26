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

public class change_password extends AppCompatActivity {

    public final static String MESSAGE_KEY ="com.example.message_key";
    Intent intentEmail = getIntent();
    String email = intentEmail.getStringExtra(MESSAGE_KEY);

    EditText changePassword_current,changePassword_new;
     Button changePasswordSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        changePassword_current = findViewById(R.id.changePassword_current);
        changePassword_new = findViewById(R.id.changePassword_new);



        changePasswordSaveBtn = findViewById(R.id.savebtn);

        DBHelper dbHelper = new DBHelper(this);

        changePasswordSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String changePasswordNew = changePassword_new.getText().toString();
                String changePasswordCurrent = changePassword_current.getText().toString();



                Boolean checkUpdateData = dbHelper.updatePassword(changePasswordNew,email,changePasswordCurrent);
                if(changePasswordNew.isEmpty() || changePasswordCurrent.isEmpty()){
                    Toast.makeText(change_password.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }else if(checkUpdateData==true){
                    Toast.makeText(change_password.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(change_password.this,"Something went wrong;(\nTry Again.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}