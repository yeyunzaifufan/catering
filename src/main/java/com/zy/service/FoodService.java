package com.zy.service;

import com.zy.dao.FoodDao;
import com.zy.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;

    public List<Food> getFoodList(Integer foodType){
        List<Food> foodList = foodDao.findFoodList(foodType);
        for(Food food : foodList){
            food.setCount(0L);
        }
        return foodList;
    }
}
