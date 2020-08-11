package com.change.mybatis.mapper;
import java.util.List;

import com.change.mybatis.pojo.*;

public interface UserMapper {
	//遵循四个原则
	//1.接口方法名与 .xml中的id名一致
	//2.方法入参与.xml中相对应id名的入参一致
	//3.方法返回值类型与.xml中相对应id的返回类型一致
	//4. .xml文件中namespace名为该接口的路径名
	User queryUserById(Integer id);
	List<User> findUserByName(String name);
	List<User> queryUserByQueryVo(QueryVo vo);
	Integer countUserByQueryVo();
	
	//根据用户名和性别查询用户
	public List<User> selectUserBySexAndUserName(User user);
	
	//根据用户id查询多个用户
	public List<User> selectUserByIds(Integer[] ids);
	
	//根据用户id查询多个用户 通过QueryVo
	public List<User> selectUserByQueryIds(QueryVo vo);
	
	//一对多映射 用户为核心 关联订单
	public List<User> selectByUserAndOrders();
}
