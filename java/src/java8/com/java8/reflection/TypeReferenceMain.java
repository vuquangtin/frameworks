package com.java8.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
abstract class TypeReference<T> {

	private final Type type;
	private volatile Constructor<?> constructor;

	protected TypeReference() {
		Type superclass = getClass().getGenericSuperclass();
		if (superclass instanceof Class) {
			throw new RuntimeException("Missing type parameter.");
		}
		this.type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
	}

	/**
	 * Instantiates a new instance of {@code T} using the default, no-arg
	 * constructor.
	 */
	@SuppressWarnings("unchecked")
	public T newInstance()
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		if (constructor == null) {
			Class<?> rawType = type instanceof Class<?> ? (Class<?>) type
					: (Class<?>) ((ParameterizedType) type).getRawType();
			constructor = rawType.getConstructor();
		}
		return (T) constructor.newInstance();
	}

	/**
	 * Gets the referenced type.
	 */
	public Type getType() {
		return this.type;
	}

}

public class TypeReferenceMain {
	public static void main(String[] args) throws Exception {
		List<String> l1 = new TypeReference<ArrayList<String>>() {
		}.newInstance();
		l1.add("haha");
		List l2 = new TypeReference<ArrayList>() {
		}.newInstance();
		System.out.println(l1.get(0));
	}
}