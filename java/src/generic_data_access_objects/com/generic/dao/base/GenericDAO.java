package com.generic.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * *
 * <p>
 * Interface GenericDAO
 * <p>
 * This interface defines functionality for a generic Data Access Object (DAO).
 * Common methods are described in order to bring support for extend classes.
 *
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */

public interface GenericDAO<T, ID extends Serializable> {
	/**
	 * Find an instance using its id as criteria.
	 */
	public abstract T findById(ID id);

	/**
	 * Find all instances in collection.
	 * 
	 * @return
	 */
	public abstract List<T> findAll();

	/**
	 * Find one item based on a particular instance.
	 * 
	 * @param exampleInstance
	 * @param excludeProperty
	 * @return
	 */
	public abstract List<T> findByExample(T exampleInstance, String... excludeProperty);

	/**
	 * Saves an instance.
	 * 
	 * @param entity
	 * @return
	 */
	public abstract T save(T entity);

	/**
	 * Deletes an instance from collection.
	 * 
	 * @param entity
	 */
	public abstract void makeTransient(T entity);

	/**
	 * Synchronizes session data with stored in data base.
	 */
	public abstract void flush();

	/**
	 * Clears all items in collection.
	 */
	public abstract void clear();

	/**
	 * Updates an instance.
	 * 
	 * @param entity
	 */
	public abstract void update(T entity);

	/**
	 * Merges the changes from the detached instance to the persistent instance.
	 *
	 * @param detachedInstance
	 *            the detached instance
	 * @return T the object updated object is returned
	 */
	public abstract T merge(T detachedInstance);

	/**
	 * Saves or updates one instance.
	 * 
	 * @param entity
	 * @return
	 */
	public abstract T saveOrUpdate(T entity);

	/**
	 * Returns the first T returned from the database. This method is for
	 * testing the application.
	 * 
	 * @return T the first object in the list
	 */
	public abstract T getOneInstance();

}