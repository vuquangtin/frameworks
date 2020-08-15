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
public class Person {

	// 成员属性
	private String name;
	private int age;

	public int a;
	protected int b;
	int c;
	private int d;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", a=" + a + ", b="
				+ b + ", c=" + c + ", d=" + d + "]";
	}

	// 成员方法
	public void eat() {
		System.out.println("eat ... ");
	}

	public void eat(String food) {
		System.out.println("eat:" + food);
	}

}