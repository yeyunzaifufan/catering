package com.zy.dao;

import com.zy.base.BaseDao;
import com.zy.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends BaseDao {

    Integer insertUser(User user);

    User findUserByUserNameAndRole(@Param("userName") String userName, @Param("role") int role);
}
