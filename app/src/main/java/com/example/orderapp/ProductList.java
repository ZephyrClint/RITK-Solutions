package com.example.orderapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    List<OrderModel> orderModelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listning);

        ImageView bckMainMenue  =findViewById(R.id.bckMainMenue3330);

        bckMainMenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductList.this, frontMenu.class);
                startActivity(intent);
            }
        });

        // creating an arraylist of products

        orderModelList = new ArrayList<>();
        orderModelList.add(new OrderModel("Hotpot", getString(R.string.Hotpot), R.drawable.hotpot));
        orderModelList.add(new OrderModel("Sichuan Pork", getString(R.string.SichuanPork), R.drawable.sichuan));
        orderModelList.add(new OrderModel("Braised Pork Balls in Gravy", getString(R.string.PorkBalls), R.drawable.braised));
        orderModelList.add(new OrderModel("Shrimp with Vermicelli and Garlic", getString(R.string.Shrimp), R.drawable.shrimp1));
        orderModelList.add(new OrderModel("Dumplings", getString(R.string.Dumplings), R.drawable.dumplings));
        orderModelList.add(new OrderModel("Chow Mein", getString(R.string.ChowMein), R.drawable.chow));
        orderModelList.add(new OrderModel("Peking Roasted Duck", getString(R.string.RoastedDuck), R.drawable.peking));
        orderModelList.add(new OrderModel("Steamed Vermicelli Rolls", getString(R.string.SteamedVermicelli), R.drawable.steamed));
        orderModelList.add(new OrderModel("Fried Shrimp with Cashew Nuts", getString(R.string.FriedShrimp), R.drawable.shrimp2));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));


        // adapter
        mAdapter = new OrderAdapter(this, orderModelList);
        recyclerView.setAdapter(mAdapter);

    }
}