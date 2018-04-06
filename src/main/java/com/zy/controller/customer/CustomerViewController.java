package com.zy.controller.customer;

import com.zy.enums.FoodTypeEnum;
import com.zy.enums.OrderStatusEnum;
import com.zy.model.Order;
import com.zy.service.FoodService;
import com.zy.service.OrderService;
import com.zy.utils.NumberUtil;
import com.zy.vo.FoodVo;
import com.zy.vo.OrderDetailVo;
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
    @Autowired
    private OrderService orderService;

    //------------------------------点餐界面------------------------------
    @RequestMapping("/food/meat")
    public String toMeat(HttpServletRequest request, Model model) {
        model.addAttribute("foodVoList",
                foodService.getFoodVoList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.MEAT.getType()));
        return "/customer/food/meat";
    }

    @RequestMapping("/food/vegetables")
    public String toVegetables(HttpServletRequest request, Model model) {
        model.addAttribute("foodVoList",
                foodService.getFoodVoList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.VEGETABLES.getType()));
        return "/customer/food/vegetables";
    }

    @RequestMapping("/food/soup")
    public String toSoup(HttpServletRequest request, Model model) {
        model.addAttribute("foodVoList",
                foodService.getFoodVoList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.SOUP.getType()));
        return "/customer/food/soup";
    }

    @RequestMapping("/food/staplefood")
    public String toStapleFood(HttpServletRequest request, Model model) {
        model.addAttribute("foodVoList",
                foodService.getFoodVoList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.STAPLEFOOD.getType()));
        return "/customer/food/staplefood";
    }

    @RequestMapping("/food/beverage")
    public String toBeverage(HttpServletRequest request, Model model) {
        model.addAttribute("foodVoList",
                foodService.getFoodVoList(request.getSession().getAttribute("userId").toString(), FoodTypeEnum.BEVERAGE.getType()));
        return "/customer/food/beverage";
    }

    //------------------------------提交订单------------------------------
    @RequestMapping("/submitOrder")
    public String toSubmitOrder(HttpServletRequest request, Model model){
        OrderDetailVo orderDetailVo = orderService.getOrderDetailListVo(request.getSession().getAttribute("userId").toString(), OrderStatusEnum.OPEN.getType()).get(0);
        if(orderDetailVo.getFoodVoList().size() > 0){
            Double totalPrice = 0D;
            for(FoodVo foodVo : orderDetailVo.getFoodVoList()){
                totalPrice = NumberUtil.doubleAdd(totalPrice, foodVo.getFoodTotalPrice());
            }
            Order order = orderDetailVo.getOrder();
            order.setPriceTotal(totalPrice);
            orderDetailVo.setOrder(order);
        }
        model.addAttribute("orderDetailVo", orderDetailVo);
        return "customer/submitOrder";
    }

}
