package com.zy.service;

import com.zy.base.Result;
import com.zy.common.FoodCountConstants;
import com.zy.dao.FoodDao;
import com.zy.dao.OrderDao;
import com.zy.dao.OrderFoodDetailDao;
import com.zy.enums.OrderFoodDetailEnum;
import com.zy.enums.OrderStatusEnum;
import com.zy.enums.ResultCodeEnum;
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

/**
 * Created by Liu-Yang on 2018/3/29.
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderFoodDetailDao orderFoodDetailDao;
    @Autowired
    private FoodDao foodDao;

    /**
     * 查看是否存在订单
     *  不存在：新建订单和订单详情
     *  存在：查看是否在订单详情中存在该菜品
     *      存在：修改count
     *      不存在：在订单详情中新增该菜品
     */
    public Result updateOrder(String userName, Long foodId, String countSign){
        Result result = new Result();
        try {
            List<Order> orderList = orderDao.findOrderListByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
            if(orderList.size()>0){
                OrderFoodDetail orderFoodDetail =
                        orderFoodDetailDao.findOrderFoodDetailByFoodIdAndOrderId(foodId, orderList.get(0).getId(), OrderFoodDetailEnum.OPEN.getType());
                if (null == orderFoodDetail) {
                    orderFoodDetailDao.insertOrderFoodDetail(this.buildOrderFoodDetail(orderList.get(0), foodId, countSign));
                } else {
                    Long count = orderFoodDetail.getCount();
                    if(countSign.equals(FoodCountConstants.ADD)){
                        count = count + 1;
                    } else{
                        if(count > 0){
                            count = count - 1;
                        }
                    }
                    Integer status = orderFoodDetail.getStatus();
                    if(count == 0){
                        status = OrderFoodDetailEnum.CANCEL.getType();
                    }
                    orderFoodDetailDao.updateCountById(orderFoodDetail.getId(), count, status);
                }
            } else {//创建订单和订单详情
                Order order = new Order();
                order.setUserName(userName);
                order.setStatus(OrderStatusEnum.OPEN.getType());
                order.setPriceTotal(0D);
                orderDao.insertOrder(order);

                order = orderDao.findOrderListByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType()).get(0);
                orderFoodDetailDao.insertOrderFoodDetail(this.buildOrderFoodDetail(order, foodId, countSign));
            }
        } catch (Exception e){
            result.setCode(ResultCodeEnum.FAILED.getStatus());
            result.setMessage(e.getMessage());
            return result;
        }
        result.setCode(ResultCodeEnum.SUCCESS.getStatus());
        return result;
    }

    private OrderFoodDetail buildOrderFoodDetail(Order order, Long foodId, String countSign ){
        OrderFoodDetail orderFoodDetail = new OrderFoodDetail();
        orderFoodDetail.setOrderId(order.getId());
        orderFoodDetail.setFoodId(foodId);
        if(countSign.equals(FoodCountConstants.ADD)){
            orderFoodDetail.setCount(1L);
        } else {
            orderFoodDetail.setCount(0L);
        }
        orderFoodDetail.setStatus(OrderFoodDetailEnum.OPEN.getType());
        return orderFoodDetail;
    }

    public List<OrderDetailVo> getOrderDetailListVo(String userName, Integer orderStatus){
        List<OrderDetailVo> orderDetailVoList = new ArrayList<>();
        List<Order> orderList = orderDao.findOrderListByUserNameAndStatus(userName, orderStatus);
        if(orderList.size() > 0){
            for(Order order : orderList){
                OrderDetailVo orderDetailVo = new OrderDetailVo();
                orderDetailVo.setOrder(order);
                List<FoodVo> foodVoList = new ArrayList<>();
                List<OrderFoodDetail> orderFoodDetailList = orderFoodDetailDao.findOrderFoodDetailByOrderId(order.getId());
                if(orderFoodDetailList.size()>0){
                    List<Food> foodList = foodDao.findFoodList(null);
                    for(OrderFoodDetail orderFoodDetail : orderFoodDetailList){
                        FoodVo foodVo = new FoodVo();
                        for(Food food : foodList){
                            if(orderFoodDetail.getFoodId().equals(food.getId())){
                                foodVo.setFood(food);
                            }
                        }
                        foodVo.setCount(orderFoodDetail.getCount());
                        foodVo.setFoodTotalPrice(NumberUtil.doubleMultiply(foodVo.getCount(), foodVo.getFood().getFoodPrice()));
                        foodVoList.add(foodVo);
                    }
                }
                orderDetailVo.setFoodVoList(foodVoList);
                orderDetailVoList.add(orderDetailVo);
            }
        }
        return orderDetailVoList;
    }


    public Result cancelOrder(String userName){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAILED.getStatus());
        Order order = orderDao.findOrderListByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType()).get(0);
        orderDao.cancelOrderByUserName(userName);
        orderFoodDetailDao.cancelOrderDetailByUserName(order.getId());
        result.setCode(ResultCodeEnum.SUCCESS.getStatus());
        return result;
    }

    public Result submitOrder(String userName, Double totalPrice){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAILED.getStatus());
        Order order = orderDao.findOrderListByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType()).get(0);
        orderDao.submitOrderByUserName(userName, totalPrice);
        orderFoodDetailDao.submitOrderDetailByUserName(order.getId());
        result.setCode(ResultCodeEnum.SUCCESS.getStatus());
        return result;
    }

}
