package com.zy.dao;

import com.zy.base.BaseDao;
import com.zy.model.OrderFoodDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Liu-Yang on 2018/3/29.
 */
public interface OrderFoodDetailDao extends BaseDao {

    Integer insertOrderFoodDetail(OrderFoodDetail orderFoodDetail);

    OrderFoodDetail findOrderFoodDetailByFoodIdAndOrderId(@Param("foodId") Long foodId, @Param("orderId") Long orderId);

    List<OrderFoodDetail> findOrderFoodDetailByOrderId(@Param("orderId") Long orderId);
}