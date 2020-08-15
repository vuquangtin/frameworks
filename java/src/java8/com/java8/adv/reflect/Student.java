package com.java8.adv.reflect;

import java.util.Map;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Student {
	public static int classId = 1;
	private static String className = "com.java8.adv.reflect.Student";

	private String name;
	public int age;
	protected String gender;

	public Student() {
	}

	// public <T> Map<String, T> gt(int a) {
	// if(a ==0){
	// return new HashMap<String, T>();
	// }
	// }

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private void say() {
		System.out.println("hello");
	}

	public void say(int a) {
		System.out.println("hello - " + a);
	}

	private String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void mapMethod(Map<String, Map<Integer, String>> m) {
		System.out.println("mapMethod");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender
				+ "]";
	}

	public void sleep() {
		System.out.println("sleep ...");
	}
}