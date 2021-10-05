package com.example.orderapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit_feedback extends AppCompatActivity {

    EditText description;
    Button editFeedbackSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_feedback);

        description = findViewById(R.id.editFeedback);
        editFeedbackSave = findViewById(R.id.editFeedbackSave);
        editFeedbackSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        getIntentFeedbackData();
    }
    String emailfeedback,descriptionView,nameView;
    void getIntentFeedbackData(){
        if(getIntent().hasExtra("email") && getIntent().hasExtra("description")){
            emailfeedback = getIntent().getStringExtra("email");
            descriptionView = getIntent().getStringExtra("description");
            nameView = getIntent().getStringExtra("name");

            description.setText(descriptionView);


        }else{
            Toast.makeText(edit_feedback.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}