package com.example.foodorderingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.DetailActivity;
import com.example.foodorderingapp.Models.CurrentFood;
import com.example.foodorderingapp.Models.FoodModel;
import com.example.foodorderingapp.R;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.viewHolder> {

    Context context;
    ArrayList<FoodModel> list;

    public FoodAdapter(Context context, ArrayList<FoodModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, int position) {

        final FoodModel foodModel = list.get(position);

        holder.foodName.setText(foodModel.getName());
        holder.foodPrice.setText(foodModel.getPrice());
        holder.foodDescription.setText(foodModel.getDescription());
        holder.foodImage.setImageResource(foodModel.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CurrentFood food = CurrentFood.getInstance();
                food.setCurrentFoodName(foodModel.getName());
                food.setCurrentFoodDescription(foodModel.getDescription());
                food.setCurrentFoodImage(foodModel.getImage());
                food.setCurrentFoodPrice(foodModel.getPrice());

                Intent intent = new Intent(context, DetailActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{

        TextView foodName,foodPrice,foodDescription;
        ImageView foodImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            foodName = itemView.findViewById(R.id.foodNameTextView);
            foodPrice = itemView.findViewById(R.id.foodPriceTextView);
            foodDescription = itemView.findViewById(R.id.foodDescriptionTextView);
            foodImage = itemView.findViewById(R.id.foodOrderImage);
        }

    }

}
