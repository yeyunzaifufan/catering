package com.zy.controller;

import com.alibaba.fastjson.JSON;
import com.zy.base.Result;
import com.zy.enums.ResultCodeEnum;
import com.zy.model.User;
import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public String login(User user, HttpSession session){
        Result result = userService.login(user);
        if(result.getCode() == ResultCodeEnum.SUCCESS.getStatus()){
            session.setAttribute("userId",user.getUserName());
        }
        return JSON.toJSONString(result);
    }

}
