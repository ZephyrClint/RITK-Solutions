package com.example.orderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.orderapp.Database.DBHelperFeedback;

import java.util.ArrayList;

public class User_feedbacks extends AppCompatActivity {


    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    DBHelperFeedback dbFeedback;
    ArrayList<String> description,name;
    String email;

    void getIntentData(){
        if(getIntent().hasExtra("email")){
            email = getIntent().getStringExtra("email");
            Toast.makeText(User_feedbacks.this, "Got Data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(User_feedbacks.this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_feedbacks);

        recyclerView = findViewById(R.id.recyclerView);
        dbFeedback = new DBHelperFeedback(User_feedbacks.this);
        description = new ArrayList<>();
        name = new ArrayList<>();

        displaydata();
        customAdapter = new CustomAdapter(User_feedbacks.this,description,name);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(User_feedbacks.this));
    }
    void displaydata(){
        getIntentData();
        Cursor cursor = dbFeedback.getFeedbacks(email);
        if(cursor.getCount() == 0){
            Toast.makeText(User_feedbacks.this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                //Toast.makeText(User_feedbacks.this, "got", Toast.LENGTH_SHORT).show();
                description.add(cursor.getString(1));
                name.add(cursor.getString(2));
            }
        }
    }
}