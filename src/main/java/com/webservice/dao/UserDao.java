package com.webservice.dao;

import java.util.List;

import com.webservice.data.User;

public interface UserDao extends IBaseDao<User>{
	public List<User> getAllUser();
}
