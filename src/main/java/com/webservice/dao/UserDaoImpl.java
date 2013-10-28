package com.webservice.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.webservice.data.User;

@Repository("userDao")
@Transactional(propagation=Propagation.REQUIRED)
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public List<User> getAllUser() {
		Session session = getSession();
		Query query = session.createQuery("from User");
		query.setLockOptions(LockOptions.UPGRADE);
		@SuppressWarnings("unchecked")
		List<User> result = query.list();
		evict(result);
		return result;
	}

}
