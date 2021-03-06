package com.zy.controller;

import com.alibaba.fastjson.JSON;
import com.zy.base.Result;
import com.zy.enums.ResultCodeEnum;
import com.zy.model.User;
import com.zy.mq.Message;
import com.zy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    @ResponseBody
    public String login(User user, HttpSession session){
        Result result = userService.login(user);
        if(result.getCode() == ResultCodeEnum.SUCCESS.getStatus()){
            logger.info("-----------{}：登录成功---------------",user.getUserName());
            jmsTemplate.send("user", new Message(user));
            session.setAttribute("userId",user.getUserName());
        }
        return JSON.toJSONString(result);
    }

}
