package com.java8.adv.reflector;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public enum Sex {
	BOY("男"), GIRL("女");
	final String displayName;

	Sex(String displayName) {
		this.displayName = displayName;
	}

	Sex() {
		this("人妖");
	}
}