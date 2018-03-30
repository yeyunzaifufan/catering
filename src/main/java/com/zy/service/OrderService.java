package com.zy.service;

import com.zy.base.Result;
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
     * @param userName
     * @param foodId
     * @param count
     */
    public Result orderDetail(String userName, Long foodId, Long count){
        Result result = new Result();
        try {
            Order order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
            if (null == order) {//创建订单和订单详情
                order = new Order();
                order.setUserName(userName);
                order.setStatus(OrderStatusEnum.OPEN.getType());
                orderDao.insertOrder(order);

                order = orderDao.findOrderByUserNameAndStatus(userName, OrderStatusEnum.OPEN.getType());
                orderFoodDetailDao.insertOrderFoodDetail(this.buildOrderFoodDetail(order, foodId, count));
            } else {
                OrderFoodDetail orderFoodDetail = orderFoodDetailDao.findOrderFoodDetailByFoodIdAndOrderId(foodId, order.getId());
                if (null == orderFoodDetail) {
                    orderFoodDetailDao.insertOrderFoodDetail(this.buildOrderFoodDetail(order, foodId, count));
                } else {
                    orderFoodDetailDao.updateCountById(orderFoodDetail.getId(), count);
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

    private OrderFoodDetail buildOrderFoodDetail(Order order, Long foodId, Long count ){
        OrderFoodDetail orderFoodDetail = new OrderFoodDetail();
        orderFoodDetail.setOrderId(order.getId());
        orderFoodDetail.setFoodId(foodId);
        orderFoodDetail.setCount(count);
        orderFoodDetail.setStatus(OrderFoodDetailEnum.OPEN.getType());
        return orderFoodDetail;
    }
}
