package com.webservice.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBaseDao<E> implements IBaseDao<E>{
	@Autowired
	private SessionFactory sessionFactory;
	private Class<E> entityClass;
	
	public AbstractBaseDao(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void evict(E e){
		getSession().evict(e);
	}
	
	public void evict(List<E> eList){
		if(eList != null){
			for(E e : eList){
				evict(e);
			}
		}
	}

	@Override
	public Class<E> getEntityClass() {
		return entityClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getById(Long id) {
		E e = (E)getSession().get(getEntityClass(), id);
		evict(e);
		return e;
	}

	@Override
	public void saveOrUpdate(E e) {
		getSession().saveOrUpdate(e);
		getSession().flush();
		evict(e);
	}

	@Override
	public void delete(E e) {
		getSession().delete(e);
		getSession().flush();
		evict(e);
	}
	
	
}
