package com.java8.adv.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
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
public class ReflectsTest {
	public static final String packageName = "com.java8.adv.reflect";

	public static void main(String[] args) throws Throwable {

		Student student = Reflects.newInstance(Student.class);

		student = Reflects.newInstance(Student.class, "zero");
		student = Reflects.newInstance(Student.class, "zero", 134);

		Reflects.invoke(student, "say");
		System.out.println(student);
		Reflects.invoke(student, "say", 1);

		Student student1 = Reflects.newInstance(packageName + ".Student");
		Reflects.invoke(student1, "say");

		Map<String, Map<Integer, String>> map = new HashMap<>();
		Reflects.invoke(student1, "mapMethod", map);

		Method method = student1.getClass().getMethod("mapMethod", Map.class);
		System.out.println(Arrays.toString(method.getParameterTypes()));

	}
}