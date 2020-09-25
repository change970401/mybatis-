package com.change.mybatis.junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.change.mybatis.mapper.UserMapper;
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

}
