package com.zy.enums;

public class OrderStatusEnum {

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

    OrderStatusEnum(int type, String value) {
        this.type = type;
        this.value = value;
    }
}
