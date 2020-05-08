package com.generic.service;

import java.io.Serializable;

import com.generic.dao.base.GenericDAOImpl;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class ServiceImpl<T, ID extends Serializable> {
	private GenericDAOImpl<T, ID> impl;

	public ServiceImpl() {
		impl=new GenericDAOImpl<>();
	}

	public void check() {
		Class<T> classT=impl.getPersistentClass();
		System.out.println(classT.toGenericString());
	}
}
