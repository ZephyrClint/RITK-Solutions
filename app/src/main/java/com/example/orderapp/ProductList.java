package com.example.orderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

        // creating an arraylist

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