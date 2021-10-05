package com.example.orderapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderapp.Database.*;

public class giveFeedback extends AppCompatActivity {

    EditText description, name;
    Button feedbackSubmit;
    DBHelperFeedback dbHelperFeedback;
    String email;

    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            Toast.makeText(giveFeedback.this, email, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(giveFeedback.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_feedback);

        description = findViewById(R.id.description);
        name = findViewById(R.id.name);

        feedbackSubmit = findViewById(R.id.feedbackSubmit);

        dbHelperFeedback = new DBHelperFeedback(this);

        feedbackSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntentData();
                String descriptionTXT = description.getText().toString();
                String nameTXT = name.getText().toString();
                Toast.makeText(giveFeedback.this, email, Toast.LENGTH_SHORT).show();

                if(descriptionTXT.isEmpty() || nameTXT.isEmpty()){
                    Toast.makeText(giveFeedback.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }else {
                    Boolean checkInsertData = dbHelperFeedback.addFeedback(descriptionTXT, nameTXT, email);
                    if (checkInsertData == true) {
                        Toast.makeText(giveFeedback.this, "Feedback Given Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),home.class);
                        intent.putExtra("email", String.valueOf(email));
                        startActivity(intent);

                    } else {
                        Toast.makeText(giveFeedback.this, "Something went wrong;(\nTry Again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
