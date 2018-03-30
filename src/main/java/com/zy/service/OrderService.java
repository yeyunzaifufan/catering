package com.zy.service;

import com.zy.dao.FoodDao;
import com.zy.dao.OrderDao;
import com.zy.dao.OrderFoodDetailDao;
import com.zy.enums.FoodTypeEnum;
import com.zy.enums.OrderFoodDetailEnum;
import com.zy.enums.OrderStatusEnum;
import com.zy.model.Food;
import com.zy.model.Order;
import com.zy.model.OrderFoodDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liu-Yang on 2018/3/29.
 */
@Service
public class OrderService {

    @Autowired
    private FoodDao foodDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderFoodDetailDao orderFoodDetailDao;

    public List<Food> orderDetail(String userName, Long foodId, Long count){
        Order order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
        if(null == order){//创建订单和订单详情
            order = new Order();
            order.setUserName(userName);
            order.setStatus(OrderStatusEnum.OPEN.getType());
            orderDao.insertOrder(order);

            order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
            OrderFoodDetail orderFoodDetail = new OrderFoodDetail();
            orderFoodDetail.setOrderId(order.getId());
            orderFoodDetail.setFoodId(foodId);
            orderFoodDetail.setCount(count);
            orderFoodDetail.setStatus(OrderFoodDetailEnum.OPEN.getType());
            orderFoodDetailDao.insertOrderFoodDetail(orderFoodDetail);
        } else{
            OrderFoodDetail orderFoodDetail = orderFoodDetailDao.findOrderFoodDetailByFoodIdAndOrderId(order.getId(),foodId);
            if(null == orderFoodDetail){
                orderFoodDetail = new OrderFoodDetail();
                orderFoodDetail.setOrderId(order.getId());
                orderFoodDetail.setFoodId(foodId);
                orderFoodDetail.setCount(count);
                orderFoodDetail.setStatus(OrderFoodDetailEnum.OPEN.getType());
                orderFoodDetailDao.insertOrderFoodDetail(orderFoodDetail);
            }
        }
        List<OrderFoodDetail> orderFoodDetailList = orderFoodDetailDao.findOrderFoodDetailByOrderId(order.getId());
        List<Food> foodList = foodDao.findFoodList(foodDao.findFoodTypeByFoodId(foodId));
        for(Food food : foodList){
            food.setCount(0L);
            for(OrderFoodDetail orderFoodDetail : orderFoodDetailList){
                if (food.getId().equals(orderFoodDetail.getFoodId())){
                    food.setCount(orderFoodDetail.getCount());
                }
            }
        }
        return foodList;
    }

    public String getFoodPage(Long foodId){
        Integer foodType =  foodDao.findFoodTypeByFoodId(foodId);
        if(foodType == FoodTypeEnum.MEAT.getType()){
            return "/customer/food/meat";
        } else if(foodType == FoodTypeEnum.VEGETABLES.getType()){
            return "/customer/food/vegetables";
        } else if(foodType == FoodTypeEnum.SOUP.getType()){
            return "/customer/food/soup";
        } else if(foodType == FoodTypeEnum.STAPLEFOOD.getType()){
            return "/customer/food/staplefood";
        } else if(foodType == FoodTypeEnum.BEVERAGE.getType()){
            return "/customer/food/beverage";
        }
        return "/emptyPage";
    }
}
