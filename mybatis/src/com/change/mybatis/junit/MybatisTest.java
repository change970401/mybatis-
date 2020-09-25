package com.change.mybatis.junit;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import com.change.mybatis.pojo.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisTest {
	private SqlSessionFactory sqlSessionFactory = null;
	
	@org.junit.Before
	public void init() throws Exception{
		//1.创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//2.加载SqlMapConfig.xml配置文件
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//3.创建SqlSessionFactory对象
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
	}
	@Test
	public void testQueryUserById() throws Exception{
		//4.创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行SqlSession对象执行查询，获取结果User
		//第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		Object user = sqlSession.selectOne("test.queryUserById", 1);
		//6.打印结果
		System.out.println(user);
		//7.释放资源
		sqlSession.close();
	}
	@Test
	public void testFindUserByName() throws Exception{
		//4.创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行SqlSession对象执行查询，获取结果User
		//第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		List<User> users = sqlSession.selectList("test.findUserByName", '五');
		//6.打印结果
		for(User user2: users)
			System.out.println(user2);
		//7.释放资源
		sqlSession.close();
	}
	
	@Test
	public void testInsertUser() throws Exception{
		//4.创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行SqlSession对象执行查询，获取结果User
		//第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = new User();
		user.setUsername("何炅");
		user.setBirthday(new Date());
		user.setSex("男");
		int i = sqlSession.insert("test.insertUser", user);
		sqlSession.commit();

		//7.释放资源
		sqlSession.close();
	}
	@Test
	public void testUpdateUserById() throws Exception{
		//4.创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行SqlSession对象执行查询，获取结果User
		//第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		User user = new User();
		user.setId(28);
		user.setUsername("何炅29");
		user.setBirthday(new Date());
		user.setSex("女");
		int i = sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
		//7.释放资源
		sqlSession.close();
	}
	
	@Test
	public void testDeleteUserById() throws Exception{
		//4.创建SqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//5.执行SqlSession对象执行查询，获取结果User
		//第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
		int i = sqlSession.update("test.deleteUserById", 28);
		sqlSession.commit();
		//7.释放资源
		sqlSession.close();
	}
	

}
