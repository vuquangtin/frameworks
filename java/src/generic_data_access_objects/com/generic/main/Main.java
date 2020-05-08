package com.generic.main;

import com.generic.dao.impl.CategoryDAO;
import com.generic.dao.models.Category;
import com.generic.service.ServiceImpl;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Main {

	public static void main(String[] args) {
		ServiceImpl<CategoryDAO, Category> sevice = new ServiceImpl<>();
		sevice.check();

	}

}
