package com.java8.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class GenericsReflection {

	public static void main(String[] args) {
		ParameterizedType type = (ParameterizedType) InterfaceInteger.class.getGenericInterfaces()[0];
		System.out.println(type.getActualTypeArguments()[0]);

		BaseClass obj2 = new Second2();
		ParameterizedType type2 = (ParameterizedType) obj2.getClass().getGenericSuperclass();
		System.out.println(type2.getActualTypeArguments()[0]);

		try {
			Object s = InterfaceInteger.class.getConstructor().newInstance();
			System.out.println(s);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

interface Interface<T> {
}

class InterfaceInteger implements Interface<Integer> {
	public InterfaceInteger() {
	}
}

class InterfaceString implements Interface<String> {
}

class BaseClass<T> {
}

class First2 extends BaseClass<Integer> {
}

class Second2 extends BaseClass<String> {
}