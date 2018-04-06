package com.zy.vo;

import com.zy.model.Food;

public class FoodVo {

    private Food food;
    private Long count;
    private Double foodTotalPrice;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getFoodTotalPrice() {
        return foodTotalPrice;
    }

    public void setFoodTotalPrice(Double foodTotalPrice) {
        this.foodTotalPrice = foodTotalPrice;
    }
}
