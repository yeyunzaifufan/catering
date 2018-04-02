package com.zy.service;

import com.zy.dao.FoodDao;
import com.zy.dao.OrderDao;
import com.zy.dao.OrderFoodDetailDao;
import com.zy.enums.OrderStatusEnum;
import com.zy.model.Food;
import com.zy.model.Order;
import com.zy.model.OrderFoodDetail;
import com.zy.utils.NumberUtil;
import com.zy.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderFoodDetailDao orderFoodDetailDao;

    public List<Food> getFoodList(String userName, Integer foodType){
        List<Food> foodList = foodDao.findFoodList(foodType);
        for(Food food : foodList){
            food.setCount(0L);
        }
        Order order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
        if(null != order){
            List<OrderFoodDetail> orderFoodDetailList = orderFoodDetailDao.findOrderFoodDetailByOrderId(order.getId());
            if (orderFoodDetailList.size()>0){
                for(Food food : foodList){
                    for (OrderFoodDetail orderFoodDetail : orderFoodDetailList){
                        if(food.getId().equals(orderFoodDetail.getFoodId())){
                            food.setCount(orderFoodDetail.getCount());
                        }
                    }
                }
            }
        }
        return foodList;
    }

    public OrderDetailVo getOrderDetailVo(String userName, Integer orderStatus){
        OrderDetailVo orderDetailVo = new OrderDetailVo();
        List<Food> foodList = orderDao.findOrderDetailByUserNameAndStatus(userName, orderStatus);
        Double totalPrice = 0D;
        for (Food food : foodList){
            Double foodTotalPrice = NumberUtil.doubleMultiply(food.getFoodPrice(), food.getCount());
            food.setFoodTotalPrice(foodTotalPrice);
            totalPrice = NumberUtil.doubleAdd(totalPrice, foodTotalPrice);
        }
        orderDetailVo.setFoodList(foodList);
        orderDetailVo.setTotalPrice(totalPrice);
        return orderDetailVo;
    }
}
