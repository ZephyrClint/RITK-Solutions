package com.example.lemon_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lemon_cafe.database.DBHelper;
import com.example.lemon_cafe.database.UsersMaster;

public class personalDetailsEdit extends AppCompatActivity {



    public final static String MESSAGE_KEY ="com.example.message_key";

    public void back(View view) {

        Intent intent = new Intent(this, personalDetails.class);

        startActivity(intent);
    }

    Intent intentEmail = getIntent();
    String email = intentEmail.getStringExtra(MESSAGE_KEY);

    EditText editfirstName, editLastName, editAddress, editEmail, editMobileNo;
    Button savebtn;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details_edit);

        TextView txv1 = (TextView) findViewById(R.id.editfirstName);
        TextView txv2 = (TextView) findViewById(R.id.editLastName);
        TextView txv3 = (TextView) findViewById(R.id.editAddress);
        TextView txv4 = (TextView) findViewById(R.id.editEmail);
        TextView txv5 = (TextView) findViewById(R.id.editMobileNo);

        Cursor res = dbHelper.getInfo(email);
        txv1.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_FIRST_NAME)));
        txv2.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_LAST_NAME)));
        txv3.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_ADDRESS)));
        txv4.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_EMAIL)));
        txv5.setText(res.getString(res.getColumnIndexOrThrow(UsersMaster.Users.COLUMN_NAME_MOBILE_NO)));

        editfirstName = findViewById(R.id.editfirstName);
        editLastName = findViewById(R.id.editLastName);
        editAddress = findViewById(R.id.editAddress);
        editEmail = findViewById(R.id.editEmail);
        editMobileNo = findViewById(R.id.editMobileNo);


        savebtn = findViewById(R.id.savebtn);

        dbHelper = new DBHelper(this);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first_name = editfirstName.getText().toString();
                String last_name = editLastName.getText().toString();
                String address = editAddress.getText().toString();
                String email = editEmail.getText().toString();
                String mobile_no = editMobileNo.getText().toString();


                Boolean checkUpdateData = dbHelper.updateInfo(first_name,last_name,address,email,mobile_no);
                if(first_name.isEmpty() || email.isEmpty() || mobile_no.isEmpty()){
                    Toast.makeText(personalDetailsEdit.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }else if(checkUpdateData==true){
                    Toast.makeText(personalDetailsEdit.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(personalDetailsEdit.this,"Something went wrong;(\nTry Again.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}