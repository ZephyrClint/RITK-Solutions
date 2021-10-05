package com.example.orderapp;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList description,name,email;

    CustomAdapter(
            Context context,
            ArrayList description,
            ArrayList name){

        this.context = context;
        this.description = description;
        this.name = name;
        this.email = email;
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {

        holder.descriptionTxt.setText(String.valueOf(description.get(position)));
        holder.nameTxt.setText(String.valueOf(name.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, edit_feedback.class);
                //intent.putExtra("email",String.valueOf(email.get(position)));
                intent.putExtra("description",String.valueOf(description.get(holder.getAdapterPosition())));
                //intent.putExtra("name",String.valueOf(name.get(position)));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView descriptionTxt,nameTxt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            descriptionTxt = itemView.findViewById(R.id.descriptionView);
            nameTxt = itemView.findViewById(R.id.nameView);
            mainLayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}

