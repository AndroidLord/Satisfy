package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingapp.Models.CurrentFood;
import com.example.foodorderingapp.Models.FoodModel;
import com.example.foodorderingapp.Models.OrderModel;
import com.example.foodorderingapp.databinding.ActivityDetailBinding;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityDetailBinding binding;

    public static ArrayList<OrderModel> list;
     DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        CurrentFood food = CurrentFood.getInstance();

        // Taking values from the user

        // Getting and Setting the names from CurrentFood class
        binding.detaiFoodNameTextView.setText(food.getCurrentFoodName());
        binding.detailDescription.setText(food.getCurrentFoodDescription());
        binding.detailPrice.setText(food.getCurrentFoodPrice());
        binding.detailFoodImage.setImageResource(food.getCurrentFoodImage());

         helper = new DBHelper(this);

        binding.detailOrderNow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detailOrderNow:
                OrderFunction();
                break;
        }
    }

    private void OrderFunction() {

        String userName = binding.detailName.getText().toString().trim();
        String phoneNo = binding.detailPhoneNo.getText().toString().trim();

        if(!TextUtils.isEmpty(userName) &&
           !TextUtils.isEmpty(phoneNo)){

            if(phoneNo.length()==10){

                OrderModel order = new OrderModel();
                order.setOrderId(String.valueOf(123456));
                order.setOrderUserName(userName);
                order.setOrderUserPhoneNo(phoneNo);
                order.setOrderFoodName(CurrentFood.getInstance().getCurrentFoodName());
                order.setOrderPrice(CurrentFood.getInstance().getCurrentFoodPrice());
                order.setQuantity(binding.quantityNo.getText().toString().trim());
                order.setOrderImage(CurrentFood.getInstance().getCurrentFoodImage());

                boolean isInserted = helper.insertOrder(order);

                if(isInserted)
                    Toast.makeText(this, "Order Successful!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Order Unsuccessful!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);

                finish();
            }
            else
                Toast.makeText(this, "Your Phone No. is not 10 digit.", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(this, "Enter User Details!!", Toast.LENGTH_SHORT).show();

    }
}