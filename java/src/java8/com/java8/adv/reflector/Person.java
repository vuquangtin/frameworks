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
public class Person {
	private String name;
	private int age = 0;

	Person() {
		name = "default name";
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	Person(String name) {
		this.name = name;
	}

	String selfIntroduction() {
		return "Hello!My name is '" + name + "'";
	}

	void say(String something) {
		System.out.println(name + "说：" + something);
	}

	boolean wasDead() {
		return age > 200;
	}

	public String getName() {
		return name;
	}
}