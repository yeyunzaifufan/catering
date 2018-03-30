package com.zy.enums;

public enum OrderStatusEnum {
    OPEN(1,"点餐中"),
    MAKING(2,"制作中"),
    EATING(3,"用餐中"),
    PAY(4,"完成"),
    CANCEL(5,"取消");

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
