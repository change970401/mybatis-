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
}
