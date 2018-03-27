package com.zy.controller;

import com.alibaba.fastjson.JSON;
import com.zy.base.Result;
import com.zy.model.User;
import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user){
        Result result = userService.login(user);
        return JSON.toJSONString(result);
    }

}
