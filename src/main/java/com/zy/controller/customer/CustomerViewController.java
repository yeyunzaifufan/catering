package com.zy.controller.customer;

import com.zy.enums.FoodTypeEnum;
import com.zy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerViewController {

    @Autowired
    private FoodService foodService;

    //------------------------------点餐界面------------------------------
    @RequestMapping("/food/meat")
    public String toMeat(Model model){
        model.addAttribute("meatList", foodService.getFoodList(FoodTypeEnum.MEAT.getType()));
        return "/customer/food/meat";
    }

    @RequestMapping("/food/vegetables")
    public String toVegetables(Model model){
        model.addAttribute("vegetablesList", foodService.getFoodList(FoodTypeEnum.VEGETABLES.getType()));
        return "/customer/food/vegetables";
    }

    @RequestMapping("/food/soup")
    public String toSoup(Model model){
        model.addAttribute("soupList", foodService.getFoodList(FoodTypeEnum.SOUP.getType()));
        return "/customer/food/soup";
    }

    @RequestMapping("/food/staplefood")
    public String toStapleFood(Model model){
        model.addAttribute("staplefoodList", foodService.getFoodList(FoodTypeEnum.STAPLEFOOD.getType()));
        return "/customer/food/staplefood";
    }

    @RequestMapping("/food/beverage")
    public String toBeverage(Model model){
        model.addAttribute("beverageList", foodService.getFoodList(FoodTypeEnum.BEVERAGE.getType()));
        return "/customer/food/beverage";
    }
}
