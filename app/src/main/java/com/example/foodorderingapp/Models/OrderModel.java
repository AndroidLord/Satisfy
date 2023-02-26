package com.example.foodorderingapp.Models;

import android.app.Application;

public class OrderModel {

    int orderImage;
    String orderUserName,
            orderUserPhoneNo,
            orderFoodName,
            orderId,
            orderPrice,
            quantity;


    public OrderModel() {
    }

    public OrderModel(int orderImage, String orderUserName, String orderUserPhoneNo, String orderFoodName, String orderId, String orderPrice, String quantity) {
        this.orderImage = orderImage;
        this.orderUserName = orderUserName;
        this.orderUserPhoneNo = orderUserPhoneNo;
        this.orderFoodName = orderFoodName;
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getOrderUserPhoneNo() {
        return orderUserPhoneNo;
    }

    public void setOrderUserPhoneNo(String orderUserPhoneNo) {
        this.orderUserPhoneNo = orderUserPhoneNo;
    }

    public String getOrderFoodName() {
        return orderFoodName;
    }

    public void setOrderFoodName(String orderFoodName) {
        this.orderFoodName = orderFoodName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }
}
