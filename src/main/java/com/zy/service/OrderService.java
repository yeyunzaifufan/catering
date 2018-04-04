package com.zy.service;

import com.zy.base.Result;
import com.zy.common.FoodCountConstants;
import com.zy.dao.OrderDao;
import com.zy.dao.OrderFoodDetailDao;
import com.zy.enums.OrderFoodDetailEnum;
import com.zy.enums.OrderStatusEnum;
import com.zy.enums.ResultCodeEnum;
import com.zy.model.Order;
import com.zy.model.OrderFoodDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Liu-Yang on 2018/3/29.
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderFoodDetailDao orderFoodDetailDao;

    /**
     * 查看是否存在订单
     *  不存在：新建订单和订单详情
     *  存在：查看是否在订单详情中存在该菜品
     *      存在：修改count
     *      不存在：在订单详情中新增该菜品
     */
    public Result orderDetail(String userName, Long foodId, String countSign){
        Result result = new Result();
        try {
            Order order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
            if (null == order) {//创建订单和订单详情
                order = new Order();
                order.setUserName(userName);
                order.setStatus(OrderStatusEnum.OPEN.getType());
                order.setPriceTotal(0D);
                orderDao.insertOrder(order);

                order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
                orderFoodDetailDao.insertOrderFoodDetail(this.buildOrderFoodDetail(order, foodId, countSign));
            } else {
                OrderFoodDetail orderFoodDetail =
                        orderFoodDetailDao.findOrderFoodDetailByFoodIdAndOrderId(foodId, order.getId(), OrderFoodDetailEnum.OPEN.getType());
                if (null == orderFoodDetail) {
                    orderFoodDetailDao.insertOrderFoodDetail(this.buildOrderFoodDetail(order, foodId, countSign));
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

    public Result cancelOrder(String userName){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAILED.getStatus());
        Order order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
        orderDao.cancelOrderByUserName(userName);
        orderFoodDetailDao.cancelOrderDetailByUserName(order.getId());
        result.setCode(ResultCodeEnum.SUCCESS.getStatus());
        return result;
    }

    public Result submitOrder(String userName, Double totalPrice){
        Result result = new Result();
        result.setCode(ResultCodeEnum.FAILED.getStatus());
        Order order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
        orderDao.submitOrderByUserName(userName, totalPrice);
        orderFoodDetailDao.submitOrderDetailByUserName(order.getId());
        result.setCode(ResultCodeEnum.SUCCESS.getStatus());
        return result;
    }
}
