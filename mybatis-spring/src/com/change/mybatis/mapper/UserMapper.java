package com.change.mybatis.mapper;

import com.change.mybatis.pojo.User;

public interface UserMapper {
	
	public User findUserByName(String name);

}
