package com.zy.controller;

import com.zy.model.User;
import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catering")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/add")
    public String addUser(User user){
        userService.addUser(user);
        return "index";
    }
}
