package com.java8.adv.reflect;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class TReflectsTest {

	static void open(String namespace) throws Exception {
		try {
			String clsName = "graphdb.storage.factory.class";
			Student factory = TReflects.newInstance(clsName);

		} catch (Throwable t) {
			throw new Exception(t);
		}
	}
}