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
class Invoker {
	public void foo(String name) {
		System.out.println("Hello, " + name);
	}
}

public class TestClassLoad {
	public static void main(String[] args) throws Exception {
		Class<?> clz = Class.forName(ReflectsTest.packageName + ".Invoker");
		Object o = clz.newInstance();
		Method m = clz.getMethod("foo", String.class);
		for (int i = 0; i < 160; i++) {
			m.invoke(o, Integer.toString(i));
			Thread.sleep(500);
		}

		System.out.println(11);
	}
}