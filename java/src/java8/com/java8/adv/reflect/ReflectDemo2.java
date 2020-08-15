package com.java8.adv.reflect;

import java.lang.reflect.Field;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectDemo2 {

	int b;

	public void say() {
		int a = 10;
		System.out.println(a);
		System.out.println(b);
	}

	public static void main(String[] args) throws Exception {
		// Person的Class对象
		// 类名.class
		Class personClass = Person.class;

		// 获取成员属性
		/**
		 * Returns an array containing Field objects reflecting all the
		 * accessible public fields of the class or interface represented by
		 * this Class object
		 */
		// 获取所有public修饰的成员属性/成员变量
		Field[] fields = personClass.getFields();
		// JDK1.5 增强for循环
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("----------");
		Field a = personClass.getField("a");
		// Returns the value of the field
		// represented by this Field, on the specified object
		// 获取属性a的值
		Person p = new Person();
		Object value = a.get(p);
		System.out.println(value);

		/**
		 * Sets the field represented by this Field object on the specified
		 * object argument to the specified new value
		 */
		// 设值
		a.set(p, 9999);
		System.out.println(p);

		System.out.println("----------");
		/**
		 * Returns an array of Field objects reflecting all the fields declared
		 * by the class or interface represented by this Class object.
		 */
		Field[] fields2 = personClass.getDeclaredFields();
		for (Field field : fields2) {
			System.out.println(field);
		}
		System.out.println("----------");
		/*
		 * Returns a Field object that reflects the specified declared field of
		 * the class or interface represented by this Class object.
		 */
		Field d = personClass.getDeclaredField("d");
		// 暴力反射，忽略访问权限修饰符
		d.setAccessible(true);
		Object value2 = d.get(p);
		System.out.println(value2);

	}

}