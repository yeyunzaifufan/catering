package com.zy.dao;

import com.zy.base.BaseDao;
import com.zy.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Liu-Yang on 2018/3/29.
 */
public interface OrderDao extends BaseDao {

    List<Order> findOrderListByUserNameAndStatus(@Param("userName") String userName, @Param("status") Integer status);

    Integer insertOrder(Order order);

    Integer cancelOrderByUserName(@Param("userName") String userName);

    Integer submitOrderByUserName(@Param("userName") String userName, @Param("totalPrice") Double totalPrice);
}
