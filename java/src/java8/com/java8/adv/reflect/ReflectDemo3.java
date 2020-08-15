package com.java8.adv.reflect;

import java.lang.reflect.Constructor;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectDemo3 {

	public static void main(String[] args) throws Exception {
		// Person的Class对象
		// 类名.class
		Class personClass = Person.class;
		/*
		 * Returns a Constructor object that reflects the specified public
		 * constructor of the class represented by this Class object.
		 */
		// 可变参数，本质上就是一个数组
		Constructor constructor = personClass.getConstructor(String.class,
				int.class);
		System.out.println(constructor);

		Object person = constructor.newInstance("小明", 12);
		System.out.println(person);

		System.out.println("-------------");
		Constructor constructor2 = personClass.getConstructor();
		System.out.println(constructor2);
		// 创建对象
		Object person2 = constructor2.newInstance();
		System.out.println(person2);

		// 如果使用的是空参的Constructor，可以简化，用Class.newInstance();
		Object o = personClass.newInstance();
		System.out.println(o);

	}

}