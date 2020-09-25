package com.change.mybatis.junit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.change.mybatis.mapper.OrderMapper;
import com.change.mybatis.mapper.UserMapper;
import com.change.mybatis.pojo.Orders;
import com.change.mybatis.pojo.QueryVo;
import com.change.mybatis.pojo.User;

public class MybatisAssoTest {

	//一对一关联
	@Test
	public void testOneToOneAsso() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> userList= (List<Orders>) orderMapper.queryOrderUserResultMap();
		for(Orders user2: userList)
			System.out.println(user2);
	}
	
	//一对多关联
	@Test
	public void testOneToMoreAsso() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.selectByUserAndOrders();
		for(User user2: userList)
			System.out.println(user2);
	}
	
}
