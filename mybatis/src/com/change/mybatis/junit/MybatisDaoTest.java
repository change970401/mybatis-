package com.change.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import com.change.mybatis.pojo.*;
import com.change.mybatis.userDAO.UserDao;
import com.change.mybatis.userDAO.UserDaoImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisDaoTest {
	public SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void before() throws Exception{
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testDao() throws Exception{
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(1);
		System.out.println(user);
	}

}
