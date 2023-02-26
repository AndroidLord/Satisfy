package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorderingapp.Adapters.OrderAdapter;
import com.example.foodorderingapp.Models.OrderModel;
import com.example.foodorderingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class orderActivity extends AppCompatActivity {

    ArrayList<OrderModel> list;


    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper dbHelper = new DBHelper(this);
        list = dbHelper.getOrderList();

        OrderAdapter orderAdapter = new OrderAdapter(this,list);
        orderAdapter.notifyDataSetChanged();
        binding.OrderRecycleView.setLayoutManager(new GridLayoutManager(this,1));
        binding.OrderRecycleView.setAdapter(orderAdapter);

    }



}