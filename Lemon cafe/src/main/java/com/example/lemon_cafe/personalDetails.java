package com.example.lemon_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lemon_cafe.UserAccount;
import com.example.lemon_cafe.database.DBHelper;
import com.example.lemon_cafe.database.UsersMaster;

public class personalDetails extends AppCompatActivity {

    public final static String MESSAGE_KEY ="com.example.message_key";

    public void back(View view) {

        Intent intent = new Intent(this, UserAccount.class);
        intent.putExtra(MESSAGE_KEY,email);
        startActivity(intent);
    }

    Intent intentEmail = getIntent();
    String email = intentEmail.getStringExtra(MESSAGE_KEY);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        DBHelper dbHelper = new DBHelper(this);

        TextView txv1 = (TextView) findViewById(R.id.firstNameView);
        TextView txv2 = (TextView) findViewById(R.id.lastNameView);
        TextView txv3 = (TextView) findViewById(R.id.addressView);
        TextView txv4 = (TextView) findViewById(R.id.emailView);
        TextView txv5 = (TextView) findViewById(R.id.mobileNoView);

        Cursor res = dbHelper.getInfo(email);
        if(res.getCount()==0){
            Toast.makeText(personalDetails.this, "Sorry!", Toast.LENGTH_SHORT).show();
        }
        txv1.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_FIRST_NAME)));
        txv2.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_LAST_NAME)));
        txv3.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_ADDRESS)));
        txv4.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_EMAIL)));
        txv5.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_MOBILE_NO)));
    }
    public void personalDetails(View view) {
        Intent intent = new Intent(this, personalDetailsEdit.class);
        intent.putExtra(MESSAGE_KEY,email);
        startActivity(intent);
    }


}