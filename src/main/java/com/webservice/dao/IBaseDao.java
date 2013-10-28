package com.webservice.dao;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBaseDao<E> {
	public Class<E> getEntityClass();
	public E getById(Long id);
	public void saveOrUpdate(E e);
	public void delete(E e);
}
