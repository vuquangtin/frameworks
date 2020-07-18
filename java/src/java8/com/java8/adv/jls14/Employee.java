package com.java8.adv.jls14;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Employee {
	public static int id;
	public final int index = id++;

	public Employee(String name) {
	}

	public Employee() {
	}

	@Override
	public String toString() {

		return "Employee " + index;
	}
}
