package com.example.orderapp;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    List<OrderModel> orderModelList;
    Context context;

    public OrderAdapter(Context context, List<OrderModel> orderModelList) {
        this.context = context;
        this.orderModelList = orderModelList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        // set product details to model class which select from list

        String nameOfProduct = orderModelList.get(position).getmProductName();
        String descOfProduct = orderModelList.get(position).getmProductDesc();
        int imgProduct = orderModelList.get(position).getmProductimg();

        holder.mProductName.setText(nameOfProduct);
        holder.mProductDesc.setText(descOfProduct);
        holder.mProductImg.setImageResource(imgProduct);

    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mProductName, mProductDesc;
        ImageView mProductImg;

        public ViewHolder(View itemView) {
            super(itemView);

            mProductName = itemView.findViewById(R.id.producName);
            mProductDesc = itemView.findViewById(R.id.description);
            mProductImg = itemView.findViewById(R.id.productImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            // Start java activity according to product based on position in list

            int position = getAdapterPosition();

            if (position == 0) {
                Intent intent = new Intent(context, product1.class);
                context.startActivity(intent);
            }
            if (position == 1) {
                Intent intent = new Intent(context, product2.class);
                context.startActivity(intent);
            }
            if (position == 2) {
                Intent intent = new Intent(context, product3.class);
                context.startActivity(intent);
            }
            if (position == 3) {
                Intent intent = new Intent(context, product4.class);
                context.startActivity(intent);
            }
            if (position == 4) {
                Intent intent = new Intent(context, product5.class);
                context.startActivity(intent);
            }
            if (position == 5) {
                Intent intent = new Intent(context, product6.class);
                context.startActivity(intent);
            }
            if (position == 6) {
                Intent intent = new Intent(context, product7.class);
                context.startActivity(intent);
            }
            if (position == 7) {
                Intent intent = new Intent(context, product8.class);
                context.startActivity(intent);
            }
            if (position == 8) {
                Intent intent = new Intent(context, product9.class);
                context.startActivity(intent);
            }





        }
    }
}
