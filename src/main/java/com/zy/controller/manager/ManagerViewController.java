package com.zy.controller.manager;

import com.zy.enums.RoleEnum;
import com.zy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerViewController {

    @Autowired
    private UserService userService;

    //------------------------------员工管理界面------------------------------
    @RequestMapping("/employee/chef")
    public String toChef(Model model){
        model.addAttribute("userList",userService.findUserByRole(RoleEnum.CHEF.getType()));
        return "/manager/employee/chef";
    }

    @RequestMapping("/employee/waiter")
    public String toWaiter(Model model){
        model.addAttribute("userList",userService.findUserByRole(RoleEnum.WAITER.getType()));
        return "/manager/employee/waiter";
    }
}
