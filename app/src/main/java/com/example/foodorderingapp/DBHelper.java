package com.example.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderingapp.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int  DBVERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null , DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement," +
                        "userName text," +
                        "phoneNo text," +
                        "price text," +
                        "image int," +
                        "quantity text," +
                        "foodName text)"
        );

    }
    /*              0-id
                    1-username
                    2-phoneno
                    3-price
                    4-image
                    5-quantity
                    6-foodname
    * */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP table if exists orders");
        onCreate(db);
        }

        public boolean insertOrder(OrderModel order){

        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();

        String userName = order.getOrderUserName();
        String phoneNo = order.getOrderUserPhoneNo();
        String price = order.getOrderPrice();
        String foodName = order.getOrderFoodName();
        String quantity = order.getQuantity();
        int image = order.getOrderImage();

        values.put("userName", userName);
        values.put("phoneNo",phoneNo);
        values.put("price",price);
        values.put("image",image);
        values.put("foodName",foodName);
        values.put("quantity",quantity);

        long id = db.insert("orders",null,values);

            return id > 0;
        }

        public ArrayList<OrderModel> getOrderList(){

        ArrayList<OrderModel> list = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from orders",null);

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrderModel orderModel = new OrderModel();
                orderModel.setOrderId(cursor.getInt(0)+"");
                orderModel.setOrderImage(cursor.getInt(4));
                orderModel.setOrderFoodName(cursor.getString(6));
                orderModel.setOrderUserName(cursor.getString(1));
                orderModel.setOrderUserPhoneNo(cursor.getString(2));
                orderModel.setQuantity(cursor.getString(5));
                orderModel.setOrderPrice(cursor.getString(3));

                list.add(orderModel);
            }

        }
            return list;

        }

        public int deleteOrder(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("orders","id="+id,null);
        }
}
