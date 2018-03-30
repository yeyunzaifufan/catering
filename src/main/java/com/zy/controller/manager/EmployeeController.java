package com.zy.controller.manager;

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
@RequestMapping("/manager/employee")
public class EmployeeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(User user){
        Result result = userService.addUser(user);
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(User user){
        Result result = userService.deleteUser(user);
        return JSON.toJSONString(result);
    }
}
