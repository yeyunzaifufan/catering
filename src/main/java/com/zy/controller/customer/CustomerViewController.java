package com.zy.controller.customer;

import com.zy.enums.FoodTypeEnum;
import com.zy.enums.OrderStatusEnum;
import com.zy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {

    @Autowired
    private FoodService foodService;

    //------------------------------点餐界面------------------------------
    @RequestMapping("/food/meat")
    public String toMeat(HttpServletRequest request, Model model) {
        model.addAttribute("foodList",
                foodService.getFoodList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.MEAT.getType()));
        return "/customer/food/meat";
    }

    @RequestMapping("/food/vegetables")
    public String toVegetables(HttpServletRequest request, Model model) {
        model.addAttribute("foodList",
                foodService.getFoodList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.VEGETABLES.getType()));
        return "/customer/food/vegetables";
    }

    @RequestMapping("/food/soup")
    public String toSoup(HttpServletRequest request, Model model) {
        model.addAttribute("foodList",
                foodService.getFoodList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.SOUP.getType()));
        return "/customer/food/soup";
    }

    @RequestMapping("/food/staplefood")
    public String toStapleFood(HttpServletRequest request, Model model) {
        model.addAttribute("foodList",
                foodService.getFoodList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.STAPLEFOOD.getType()));
        return "/customer/food/staplefood";
    }

    @RequestMapping("/food/beverage")
    public String toBeverage(HttpServletRequest request, Model model) {
        model.addAttribute("foodList",
                foodService.getFoodList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.BEVERAGE.getType()));
        return "/customer/food/beverage";
    }

    //------------------------------提交订单------------------------------
    @RequestMapping("/submitOrder")
    public String toSubmitOrder(HttpServletRequest request, Model model){
        model.addAttribute("orderDetailVo",
                foodService.getOrderDetailVo(request.getSession().getAttribute("userId").toString(), OrderStatusEnum.OPEN.getType()));
        return "customer/submitOrder";
    }

}
