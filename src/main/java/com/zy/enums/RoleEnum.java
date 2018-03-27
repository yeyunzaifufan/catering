package com.zy.enums;

public enum RoleEnum {

    MANAGER(1,"经理"),
    CUSTOMER(2,"顾客"),
    WAITER(3,"服务员"),
    CHEF(4,"厨师");

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

    RoleEnum(int type, String value){
        this.type = type;
        this.value = value;
    }
}
