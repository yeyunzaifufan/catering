package com.zy.vo;

import com.zy.model.Order;

import java.util.List;

public class OrderDetailVo {

    private Order order;
    private List<FoodVo> foodVoList;
    private Long foodVoSize;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<FoodVo> getFoodVoList() {
        return foodVoList;
    }

    public void setFoodVoList(List<FoodVo> foodVoList) {
        this.foodVoList = foodVoList;
    }

    public Long getFoodVoSize() {
        return foodVoSize;
    }

    public void setFoodVoSize(Long foodVoSize) {
        this.foodVoSize = foodVoSize;
    }
}
