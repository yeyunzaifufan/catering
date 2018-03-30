package com.zy.controller.customer;

import com.zy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer/order")
public class CustomerOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/add")
    public String add(Model model,
                           HttpServletRequest request,
                           @RequestParam(value = "foodId") Long footId,
                           @RequestParam(value = "count") Long count){
        count++;
        String userName = request.getSession().getAttribute("userId").toString();
        model.addAttribute("foodList",orderService.orderDetail(userName,footId, count));
        return orderService.getFoodPage(footId);
    }

    @RequestMapping("/subtract")
    public String subtract(Model model,
                           HttpServletRequest request,
                           @RequestParam(value = "foodId") Long footId,
                           @RequestParam(value = "count") Long count){
        if(count > 0){
            count--;
        }
        String userName = request.getSession().getAttribute("userId").toString();
        model.addAttribute("foodList",orderService.orderDetail(userName,footId, count));
        return orderService.getFoodPage(footId);
    }

}
