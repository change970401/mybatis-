package com.change.mybatis.userDAO;

import com.change.mybatis.pojo.User;

public interface UserDao {

	public User selectUserById(Integer id);
}
