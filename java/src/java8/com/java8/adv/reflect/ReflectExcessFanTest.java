package com.java8.adv.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectExcessFanTest {
	public static void main(String[] args) throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		// 获取list的class文件
		Class clazz = list.getClass();
		Method method = clazz.getMethod("add", Object.class);
		method.invoke(list, 8);

		System.out.println(list);// [hello, 8]
	}
}