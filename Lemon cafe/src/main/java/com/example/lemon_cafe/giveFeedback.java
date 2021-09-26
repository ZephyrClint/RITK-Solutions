package com.example.lemon_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lemon_cafe.database.*;

public class giveFeedback extends AppCompatActivity {

    EditText description, name, email;
    Button feedbackSubmit;
    DBHelperFeedback dbHelperFeedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_feedback);

        description = findViewById(R.id.description);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        feedbackSubmit = findViewById(R.id.feedbackSubmit);

        dbHelperFeedback = new DBHelperFeedback(this);

        feedbackSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descriptionTXT = description.getText().toString();
                String nameTXT = name.getText().toString();
                String emailTXT = email.getText().toString();

                Boolean checkInsertData = dbHelperFeedback.addFeedback(descriptionTXT,descriptionTXT,descriptionTXT);
                if(descriptionTXT.isEmpty() || descriptionTXT.isEmpty() || descriptionTXT.isEmpty()){
                    Toast.makeText(giveFeedback.this, "Please Fill the Field", Toast.LENGTH_SHORT).show();
                }else if(checkInsertData==true){
                    Toast.makeText(giveFeedback.this, "Feedback Given Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(giveFeedback.this,"Something went wrong;(\nTry Again.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}