package com.java8.reflection.generics;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Method Return Type
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class MethodReturnType {
	List mRaw() {
		return null;
	}

	List<String> mTypeString() {
		return null;
	}

	List<?> mWildcard() {
		return null;
	}

	List<? extends Number> mBoundedWildcard() {
		return null;
	}

	<T extends List<String>> List<T> mTypeLiteral() {
		return null;
	}

	public static void main(String[] args) {
		for (Method method : MethodReturnType.class.getDeclaredMethods()) {
			Type type = method.getGenericReturnType();
			System.out.println(method.getName() + " - " + Generics.typeToString(type));
		}
	}
}