package com.example.foodorderingapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderingapp.DBHelper;
import com.example.foodorderingapp.MainActivity;
import com.example.foodorderingapp.Models.OrderModel;
import com.example.foodorderingapp.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{

    Context context;
    ArrayList<OrderModel> list;

    public OrderAdapter(Context context, ArrayList<OrderModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.sample_order,parent,false);
        return new viewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrderModel model = list.get(position);
        String orderFoodName = model.getOrderFoodName();
        String orderId = model.getOrderId();
        String orderPrice = model.getOrderPrice();
        int image = model.getOrderImage();

        holder.orderNameTextView.setText(orderFoodName);
        holder.orderIdTextView.setText(orderId);
        holder.orderPriceTextView.setText(orderPrice);
        holder.orderImageView.setImageResource(image);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                 new AlertDialog.Builder(context)
                        .setTitle("Delete Item")
                        .setMessage("Are You Sure... you want to delete this Order")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                DBHelper dbHelper = new DBHelper(context);
                                if(dbHelper.deleteOrder(orderId)>0) {

                                    Toast.makeText(context, "Delete Successful", Toast.LENGTH_SHORT).show();
                                    v.notify();

                                }
                                else
                                    Toast.makeText(context, "Error.", Toast.LENGTH_SHORT).show();



                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                }
                        }).show();


                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView orderImageView;
        TextView orderNameTextView, orderIdTextView, orderPriceTextView;

        public viewHolder(@NonNull View itemView,Context context) {
            super(itemView);
                orderImageView = itemView.findViewById(R.id.foodOrderImage);
                orderNameTextView = itemView.findViewById(R.id.foodOrderName);
                orderIdTextView = itemView.findViewById(R.id.foodOrderId);
                orderPriceTextView = itemView.findViewById(R.id.foodOrderPrice);
        }
    }
}
