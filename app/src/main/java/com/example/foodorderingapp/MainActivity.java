package com.example.foodorderingapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderingapp.Adapters.FoodAdapter;
import com.example.foodorderingapp.Models.FoodModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    ArrayList<FoodModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        list.add(new FoodModel(R.drawable.burger,"Burger","50","A 100% wheat based fresh Buns, packing a crispy patty along with mouth watering flavours."));
        list.add(new FoodModel(R.drawable.pizza,"Pizza","500","Tasty round, flat base of leavened wheat-based dough topped with tomatoes, cheese."));
        list.add(new FoodModel(R.drawable.burgerpizza,"Burger Pizza","100","Seem like a burger, shape of a burger but taste of Pizza Burger"));
        list.add(new FoodModel(R.drawable.chaomien,"Chao-mien","30","Long and soft noddles of longevity made from the finest of ingredients and herbs"));
        list.add(new FoodModel(R.drawable.colddrink,"Cold Drink","30","A Simple Coke in a Glass but Hella expensive"));

        FoodAdapter adapter = new FoodAdapter(this,list);
        binding.recyclerView.setAdapter(adapter);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.MenuOrder:
                startActivity(new Intent(this,orderActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}