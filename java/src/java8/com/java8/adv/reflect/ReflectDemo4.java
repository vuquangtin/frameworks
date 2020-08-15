package com.java8.adv.reflect;

import java.lang.reflect.Method;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectDemo4 {

	public static void main(String[] args) throws Exception {
		// Person的Class对象
		// 类名.class
		Class personClass = Person.class;
		// 获取指定名称的方法
		Method eat_method = personClass.getMethod("eat");
		Person person = new Person();
		// 执行方法
		eat_method.invoke(person);

		Method eat_method2 = personClass.getMethod("eat", String.class);
		// 执行方法
		eat_method2.invoke(person, "苹果");

		System.out.println("------------");
		Method[] methods = personClass.getMethods();
		for (Method method : methods) {
			System.out.println(method);
			System.out.println(method.getName());
			// method.setAccessible(true);
		}

		// personClass.getDeclaredMethod(name, parameterTypes)
		System.out.println("------------");
		// 获取类名
		String name = personClass.getName();
		String name2 = personClass.getSimpleName();
		System.out.println(name);
		System.out.println(name2);

	}

}