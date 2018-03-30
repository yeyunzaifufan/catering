package com.zy.dao;

import com.zy.base.BaseDao;
import com.zy.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BaseDao {

    Integer insertUser(User user);

    User findUserByUserName(@Param("userName") String userName);

    List<User> findUserByRole(@Param("role") Integer role);

    Integer deleteUser(@Param("userId") Long userId);
}
