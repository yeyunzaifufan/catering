package com.zy.dao;

import com.zy.base.BaseDao;
import com.zy.model.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodDao extends BaseDao {

    List<Food> findFoodList(@Param("foodType") Integer foodType);
}
