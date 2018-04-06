package com.zy.service;

import com.zy.dao.FoodDao;
import com.zy.dao.OrderDao;
import com.zy.dao.OrderFoodDetailDao;
import com.zy.enums.OrderFoodDetailEnum;
import com.zy.enums.OrderStatusEnum;
import com.zy.model.Food;
import com.zy.model.Order;
import com.zy.model.OrderFoodDetail;
import com.zy.utils.NumberUtil;
import com.zy.vo.FoodVo;
import com.zy.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderFoodDetailDao orderFoodDetailDao;

    public List<FoodVo> getFoodVoList(String userName, Integer foodType){
        List<FoodVo> foodVoList = new ArrayList<>();
        List<Food> foodList = foodDao.findFoodList(foodType);
        if(foodList.size()>0){
            for(Food food : foodList){
                FoodVo foodVo = new FoodVo();
                foodVo.setFood(food);
                foodVo.setCount(0L);
                foodVo.setFoodTotalPrice(NumberUtil.doubleMultiply(foodVo.getFood().getFoodPrice(), foodVo.getCount()));
                foodVoList.add(foodVo);
            }

            List<Order> orderList = orderDao.findOrderListByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
            if(orderList.size()>0){
                List<OrderFoodDetail> orderFoodDetailList = orderFoodDetailDao.findOrderFoodDetailByOrderId(orderList.get(0).getId());
                if (orderFoodDetailList.size()>0){
                    for(FoodVo foodVo : foodVoList){
                        for (OrderFoodDetail orderFoodDetail : orderFoodDetailList){
                            if(foodVo.getFood().getId().equals(orderFoodDetail.getFoodId())){
                                foodVo.setCount(orderFoodDetail.getCount());
                                foodVo.setFoodTotalPrice(NumberUtil.doubleMultiply(foodVo.getFood().getFoodPrice(), foodVo.getCount()));
                            }
                        }
                    }
                }
            }
        }
        return foodVoList;
    }
}
