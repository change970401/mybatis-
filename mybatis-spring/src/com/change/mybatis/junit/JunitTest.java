package com.change.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.change.mybatis.mapper.UserMapper;
import com.change.mybatis.pojo.User;

public class JunitTest {

	@Test
	public void testMapper() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = (UserMapper)ac.getBean(UserMapper.class);
		User user = mapper.findUserByName("曾志伟");
		System.out.println(user);
	}
}
