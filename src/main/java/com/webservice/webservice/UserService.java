package com.webservice.webservice;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webservice.dao.UserDao;
import com.webservice.data.User;
import com.webservice.error.CustomError;
import com.webservice.exception.BadRequestException;

@Component
@Path("/user")
public class UserService {
	private static final Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@DefaultValue("0")@PathParam("id") Long id) throws Exception{
		if(id == 0){
			throw new BadRequestException(new CustomError("E0001", "Bad Id"), MediaType.APPLICATION_JSON_TYPE);
		}
		User user = userDao.getById(id);
		logger.debug("user = " + user);
		return user;
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<User> getAllUser() throws Exception{
		List<User> user = userDao.getAllUser();
		return user;
	}	
}
