package com.change.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author chengzhiya
 *
 */
public class QueryVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private List<Integer> idsList;

	public List<Integer> getIdsList() {
		return idsList;
	}

	public void setIdsList(List<Integer> idsList) {
		this.idsList = idsList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
