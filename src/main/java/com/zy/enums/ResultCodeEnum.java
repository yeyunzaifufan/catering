package com.zy.enums;

public enum ResultCodeEnum {

    SUCCESS(1, "处理成功"),
    FAILED(-1,"处理失败!");

    private int status;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    ResultCodeEnum(int status, String message){
        this.status = status;
        this.message = message;
    }
}
