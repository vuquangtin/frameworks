package com.java8.adv.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
public class TReflects {

	static final ClassLoader mainCl = TReflects.class.getClassLoader();

	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClassInstance(T object) {
		return (Class<T>) object.getClass();
	}

	public static <T> T newInstance(Class<T> c) {
		try {
			return c.newInstance();
		} catch (IllegalAccessException | InstantiationException
				| NullPointerException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T newInstance(String className) {
		try {
			return (T) mainCl.loadClass(className).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T newInstance(String className,
			Class<?>[] parameterTypes, Object... parameters) {
		try {
			return (T) mainCl.loadClass(className)
					.getConstructor(parameterTypes).newInstance(parameters);
		} catch (InstantiationException | IllegalAccessException
				| InvocationTargetException | NoSuchMethodException
				| ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/** Create an object with dummy values if there is no default constructor. */
	public static <T> T newInstanceGetConstructors(Class<T> cls) {
		Constructor<T> c = (Constructor<T>) cls.getConstructors()[0];

		List<Object> params = new ArrayList<>();
		for (Class<?> pType : c.getParameterTypes()) {
			params.add(getDefaultValue(pType));
		}

		try {
			return c.newInstance(params.toArray());
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static <T> T getDefaultValue(Class<T> clazz) {
		return (T) Array.get(Array.newInstance(clazz, 1), 0);
	}

	public static Class<?> forName(String fullName) {
		if (fullName == null || fullName.isEmpty()) {
			throw new IllegalArgumentException("class name is null or empty");
		}
		try {
			return Class.forName(fullName);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static <T> T newInstance(Constructor<T> constructor, Object... args) {
		try {
			return constructor.newInstance(args);
		} catch (Exception e) {
			throw new IllegalArgumentException("Constructor not valid "
					+ constructor + " error message" + e);
		}
	}
}