package com.zy.controller;

/**
 * Created by Liu-Yang on 2018/3/28.
 */
public class LoginUserController {

    private static String userName;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        LoginUserController.userName = userName;
    }
}
