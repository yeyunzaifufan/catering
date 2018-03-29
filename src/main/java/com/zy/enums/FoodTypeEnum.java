package com.zy.enums;

public enum FoodTypeEnum {
    MEAT(1,"肉类"),
    VEGETABLES(2,"菜类"),
    SOUP(3,"汤类"),
    STAPLEFOOD(4,"主食类"),
    BEVERAGE(5,"饮料类");

    private int type;
    private String value;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    FoodTypeEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }
}
