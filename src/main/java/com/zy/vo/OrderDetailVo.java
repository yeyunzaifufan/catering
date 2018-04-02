package com.zy.vo;

import com.zy.model.Food;

import java.util.List;

public class OrderDetailVo {

    private List<Food> foodList;
    private Double totalPrice;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
