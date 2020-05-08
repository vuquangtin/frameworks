package com.java8.reflection.generics;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 * @see http://blog.vityuk.com/2011/03/java-generics-and-reflection.html
 *
 */
public class MethodParameterType {
	<T extends List<T>> void m(String p1, T p2, List<?> p3, List<T> p4) {
	}

	public static void main(String[] args) {
		for (Method method : MethodParameterType.class.getDeclaredMethods()) {
			for (Type type : method.getGenericParameterTypes()) {
				System.out.println(method.getName() + " - " + Generics.typeToString(type));
			}
		}
	}
}