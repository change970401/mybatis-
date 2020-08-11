package com.change.mybatis.mapper;

import java.util.List;

import com.change.mybatis.pojo.Orders;

public interface OrderMapper {
	
	public List<Orders> selectByOrder();
	
	//一对一关联 以orders表为核心关联用户表
	public List<Orders> queryOrderUserResultMap();

}
