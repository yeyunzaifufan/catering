package com.zy.service;

import com.zy.base.Result;
import com.zy.common.ResultMsgConstants;
import com.zy.controller.LoginController;
import com.zy.controller.LoginUserController;
import com.zy.dao.UserDao;
import com.zy.enums.ResultCodeEnum;
import com.zy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Liu-Yang on 2018/3/26.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Result login(User userLogin){
        Result<User> result = new Result<>();
        User user = userDao.findUserByUserName(userLogin.getUserName());
        if(null == user || !userLogin.getPassword().equals(user.getPassword())){
            result.setMessage(ResultMsgConstants.LOGIN_WRONG_MSG);
        } else {
            LoginUserController.setUserName(userLogin.getUserName());
            result.setCode(ResultCodeEnum.SUCCESS.getStatus());
            result.setBean(user);
        }
        return result;
    }

    public List<User> findUserByRole(Integer role){
        return userDao.findUserByRole(role);
    }

    public Result addUser(User user){
        Result result = new Result();
        Integer i = userDao.insertUser(user);
        if(i==ResultCodeEnum.SUCCESS.getStatus()){
            result.setMessage("增加成功！");
        } else{
            result.setMessage("增加失败！");
        }
        return result;
    }

    public Result deleteUser(User user){
        Result result = new Result();
        Integer i = userDao.deleteUser(user.getId());
        if(i==ResultCodeEnum.SUCCESS.getStatus()){
            result.setMessage("删除成功！");
        } else{
            result.setMessage("删除失败！");
        }
        return result;
    }
}
