package com.zy.service;

import com.zy.dao.FoodDao;
import com.zy.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;

    public List<Food> getFoodList(Integer foodType){
        return foodDao.findFoodList(foodType);
    }
}
