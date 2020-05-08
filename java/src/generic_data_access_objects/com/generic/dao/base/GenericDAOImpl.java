package com.generic.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;

	/**
	 * The Constructor.
	 */
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	/**
	 * The Constructor.
	 *
	 * @param persistentClass
	 *            the persistent class
	 */
	public GenericDAOImpl(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Gets the persistent class.
	 *
	 * @return the persistent class
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#findById(java.io.Serializable)
	 */
	public T findById(ID id) {
		return null;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#findAll()
	 */
	public List<T> findAll() {
		return null;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#findByExample(java.lang.Object,
	 *      java.lang.String[])
	 */
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {

		return null;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#save(java.lang.Object)
	 */
	public T save(T entity) {

		return entity;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#update(java.lang.Object)
	 */
	public void update(T entity) {

	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#saveOrUpdate(java.lang.Object)
	 */
	public T saveOrUpdate(T entity) {
		// getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#makeTransient(java.lang.Object)
	 */
	public void makeTransient(T entity) {

	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#flush()
	 */
	public void flush() {

	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#clear()
	 */
	public void clear() {

	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#merge(java.lang.Object)
	 */
	public T merge(T detachedInstance) {
		return detachedInstance;
	}

	/**
	 * @see com.accenture.aiu.soa.registration.dao.base.GenericDAO#getOneInstance()
	 */
	public T getOneInstance() {
		T retval = null;
		// getHibernateTemplate().setMaxResults(1);
		// List list = getHibernateTemplate().loadAll(getPersistentClass());
		//
		// if (list != null && list.size() > 0) {
		// retval = (T) list.get(0);
		// }
		return retval;
	}

}