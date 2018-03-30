package com.zy.controller.customer;

import com.alibaba.fastjson.JSON;
import com.zy.base.Result;
import com.zy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer/order")
public class CustomerOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    @ResponseBody
    public String add(HttpServletRequest request,
                      @RequestParam(value = "foodId") Long foodId,
                      @RequestParam(value = "count") Long count){
        count++;
        String userName = request.getSession().getAttribute("userId").toString();
        return JSON.toJSONString(orderService.orderDetail(userName, foodId, count));
    }

    @RequestMapping(value = "/subtractFood", method = RequestMethod.POST)
    @ResponseBody
    public String subtract(HttpServletRequest request,
                           @RequestParam(value = "foodId") Long foodId,
                           @RequestParam(value = "count") Long count){
        if(count > 0){
            count--;
        }
        String userName = request.getSession().getAttribute("userId").toString();
        return JSON.toJSONString(orderService.orderDetail(userName, foodId, count));
    }

}
