package com.zy.enums;

/**
 * Created by Liu-Yang on 2018/3/29.
 */
public enum OrderFoodDetailEnum {

    OPEN(1,"点餐中"),
    MAKING(2,"制作中"),
    OVER(3,"完成"),
    CANCEL(4,"取消");

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

    OrderFoodDetailEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }
}
