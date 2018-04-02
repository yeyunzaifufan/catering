package com.zy.dao;

import com.zy.base.BaseDao;
import com.zy.model.Food;
import com.zy.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Liu-Yang on 2018/3/29.
 */
public interface OrderDao extends BaseDao {

    Order findOrderByUserNameAndStatus(@Param("userName") String userName, @Param("status") Integer status);

    Integer insertOrder(Order order);

    List<Food> findOrderDetailByUserNameAndStatus(@Param("userName") String userName, @Param("status") Integer status);
}
