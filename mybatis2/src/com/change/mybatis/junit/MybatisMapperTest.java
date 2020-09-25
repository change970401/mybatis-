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

public class MybatisMapperTest {
	@Test
	public void test() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.queryUserById(10);
		System.out.println(user);
	}
	
	@Test
	public void test1() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList= (List<User>) userMapper.findUserByName("何炅");
		for(User user: userList)
			System.out.println(user);
	}
	
	@Test
	public void testQueryUserByQueryVo() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("五");
		vo.setUser(user);
		List<User> userList= (List<User>) userMapper.queryUserByQueryVo(vo);
		for(User user1: userList)
			System.out.println(user1);
	}
	
	@Test
	public void testCountUserByQueryVo() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer res =  userMapper.countUserByQueryVo();
		System.out.println(res);
	}
	

	@Test
	public void testOrder() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> orderList= (List<Orders>) orderMapper.selectByOrder();
		for(Orders order: orderList)
			System.out.println(order);
	}
	
	@Test
	public void testSelectUserBySexAndName() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("男");
		user.setUsername("曾志伟");
		List<User> userList= (List<User>) userMapper.selectUserBySexAndUserName(user);
		for(User user2: userList)
			System.out.println(user2);
	}
	
	@Test
	public void testSelectUserByIds() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		Integer[] idsIntegers = new Integer[]{1,10, 16};
		List<User> userList= (List<User>) userMapper.selectUserByIds(idsIntegers);
		for(User user2: userList)
			System.out.println(user2);
	}
	
	@Test
	public void testSelectUserByQueryIds() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		List<Integer> idsList = new ArrayList<Integer>();
		idsList.add(1);
		idsList.add(10);
		vo.setIdsList(idsList);
		List<User> userList= (List<User>) userMapper.selectUserByQueryIds(vo);
		for(User user2: userList)
			System.out.println(user2);
	}
}
