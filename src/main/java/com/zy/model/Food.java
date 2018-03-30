package com.zy.model;

public class Food {

    private Long id;
    private Integer foodType;
    private String foodName;
    private Double foodPrice;
    private Long chefId;
    private String foodImagePath;
    private String foodId;
    private Long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFoodType() {
        return foodType;
    }

    public void setFoodType(Integer foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Long getChefId() {
        return chefId;
    }

    public void setChefId(Long chefId) {
        this.chefId = chefId;
    }

    public String getFoodImagePath() {
        return foodImagePath;
    }

    public void setFoodImagePath(String foodImagePath) {
        this.foodImagePath = foodImagePath;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
