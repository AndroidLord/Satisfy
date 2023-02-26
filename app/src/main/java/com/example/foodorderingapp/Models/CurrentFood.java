package com.example.foodorderingapp.Models;

import android.app.Application;

public class CurrentFood extends Application {

    private int currentFoodImage;
    private String currentFoodName,currentPhoneNo,CurrentFoodPrice,CurrentFoodDescription;

    private static CurrentFood instance;

    public CurrentFood() {
    }

    public static synchronized CurrentFood getInstance(){
    if(instance==null){
        instance = new CurrentFood();
    }
    return instance;
    }

    public int getCurrentFoodImage() {
        return currentFoodImage;
    }

    public void setCurrentFoodImage(int currentFoodImage) {
        this.currentFoodImage = currentFoodImage;
    }

    public String getCurrentFoodName() {
        return currentFoodName;
    }

    public void setCurrentFoodName(String currentFoodName) {
        this.currentFoodName = currentFoodName;
    }

    public String getCurrentPhoneNo() {
        return currentPhoneNo;
    }

    public void setCurrentPhoneNo(String currentPhoneNo) {
        this.currentPhoneNo = currentPhoneNo;
    }

    public String getCurrentFoodPrice() {
        return CurrentFoodPrice;
    }

    public void setCurrentFoodPrice(String currentFoodPrice) {
        CurrentFoodPrice = currentFoodPrice;
    }

    public String getCurrentFoodDescription() {
        return CurrentFoodDescription;
    }

    public void setCurrentFoodDescription(String currentFoodDescription) {
        CurrentFoodDescription = currentFoodDescription;
    }
}
