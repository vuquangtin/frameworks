package com.java8.adv.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public final class Reflects {
	private Reflects() throws Exception {
		throw new IllegalAccessException();
	}

	/**
	 * Maps primitive {@link Class}es to their corresponding wrapper
	 * {@link Class}.
	 */
	private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<>();

	/**
	 * Maps wrapper {@link Class}es to their corresponding primitive types.
	 */
	private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<>();

	static {
		primitiveWrapperMap.put(Boolean.TYPE, Boolean.class);
		primitiveWrapperMap.put(Byte.TYPE, Byte.class);
		primitiveWrapperMap.put(Character.TYPE, Character.class);
		primitiveWrapperMap.put(Short.TYPE, Short.class);
		primitiveWrapperMap.put(Integer.TYPE, Integer.class);
		primitiveWrapperMap.put(Long.TYPE, Long.class);
		primitiveWrapperMap.put(Double.TYPE, Double.class);
		primitiveWrapperMap.put(Float.TYPE, Float.class);
		primitiveWrapperMap.put(Void.TYPE, Void.TYPE);

		wrapperPrimitiveMap.put(Boolean.class, Boolean.TYPE);
		wrapperPrimitiveMap.put(Byte.class, Byte.TYPE);
		wrapperPrimitiveMap.put(Character.class, Character.TYPE);
		wrapperPrimitiveMap.put(Short.class, Short.TYPE);
		wrapperPrimitiveMap.put(Integer.class, Integer.TYPE);
		wrapperPrimitiveMap.put(Long.class, Long.TYPE);
		wrapperPrimitiveMap.put(Double.class, Double.TYPE);
		wrapperPrimitiveMap.put(Float.class, Float.TYPE);
		wrapperPrimitiveMap.put(Void.TYPE, Void.TYPE);
	}

	private static final ThreadLocal<ClassLoader> localClassLoader = new ThreadLocal<>();

	/**
	 * Creates a new object.
	 * 
	 * @param clazz
	 *            the class to instantiate
	 * @return new instance of clazz
	 */
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(Class<T> clazz, Object... args) {
		Class<?>[] parameterTypes = getTypes(args);

		Constructor constructor = null;
		for (Constructor c : clazz.getConstructors()) {
			if (c.getParameterCount() != parameterTypes.length) {
				continue;
			}
			Class<?>[] pTypes = c.getParameterTypes(); // 空参数返回：new Class[0]
			if (isAssignable(parameterTypes, pTypes, true)) {
				constructor = c;
			}
		}

		try {
			if (constructor != null) {
				return (T) constructor.newInstance(args);
			} else {
				// not found, so throw execption
				clazz.getConstructor(parameterTypes);
			}
		} catch (InstantiationException | IllegalAccessException
				| NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Creates a new object.
	 * 
	 * @param className
	 *            the class to instantiate
	 * @return new instance of clazz
	 */
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(String className, Object... args) {
		try {
			ClassLoader classLoader = localClassLoader.get();
			if (classLoader == null) {
				classLoader = Thread.currentThread().getContextClassLoader();
			}
			Class clazz = classLoader.loadClass(className);
			return (T) newInstance(clazz, args);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns the static value by name, on the specified {@code Class}. The
	 * value is automatically wrapped in an object if it has a primitive type.
	 * 
	 * @param clazz
	 *            the specified class
	 * @param name
	 *            the name of the represented field in class
	 * @return the value of the represented field in class
	 */
	public static Object getStaticValue(Class<?> clazz, String name) {
		Object value = null;
		try {
			Field fd = setAccessible(getField(clazz, name));
			value = fd.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * Sets new value by name, on the specified {@code Class}. The new value is
	 * automatically unwrapped if the underlying field has a primitive type.
	 * 
	 * @param clazz
	 *            the specified class
	 * @param name
	 *            the name of the the field in class
	 * @param value
	 *            the new value for the field in class
	 */
	public static void setStaticValue(Class<?> clazz, String name, Object value) {
		try {
			Field fd = setAccessible(getField(clazz, name));
			fd.set(null, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the value by name, on the specified object. The value is
	 * automatically wrapped in an object if it has a primitive type.
	 * 
	 * @param o
	 *            the specified object
	 * @param name
	 *            the name of the represented field in object
	 * @return the value of the represented field in object
	 */
	public static Object getValue(Object o, String name) {
		Object value = null;
		try {
			Field fd = setAccessible(getField(o.getClass(), name));
			value = fd.get(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * Sets new value by name, on the specified object. The new value is
	 * automatically unwrapped if the underlying field has a primitive type.
	 * 
	 * @param o
	 *            the specified object
	 * @param name
	 *            the name of the the field in object
	 * @param value
	 *            the new value for the field in object
	 */
	public static void setValue(Object o, String name, Object value) {
		try {
			Field fd = setAccessible(getField(o.getClass(), name));
			fd.set(o, value);
		} catch (Exception e) {
		}
	}

	public static Field getField(Class<?> clazz, String name)
			throws NoSuchFieldException {
		for (Class<?> cls = clazz; cls != null; cls = cls.getSuperclass()) {
			try {
				return cls.getDeclaredField(name);
			} catch (Throwable ignored) {
			}
		}
		throw new NoSuchFieldException(clazz.getName() + "#" + name);
	}

	private static Class<?>[] getTypes(Object[] args) {
		if (args == null || args.length == 0) {
			return new Class[0];
		}

		Class<?>[] types = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			types[i] = args[i].getClass();
		}
		return types;
	}

	@SuppressWarnings("unchecked")
	public static <T> T invoke(Object object, Method method, Object... args)
			throws Throwable {
		try {
			return (T) method.invoke(object, args);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw e.getCause();
		}
	}

	public static <T> T invoke(Object obj, String methodName, Object... args)
			throws Throwable {
		Class<?>[] parameterTypes = getTypes(args);

		Method method = null;
		for (Method s : obj.getClass().getDeclaredMethods()) {
			if (!s.getName().equals(methodName)
					|| s.getParameterCount() != parameterTypes.length) {
				continue;
			}
			Class<?>[] pTypes = s.getParameterTypes(); // 空参数返回：new Class[0]
			if (isAssignable(parameterTypes, pTypes, true)) {
				method = s;
			}
		}
		if (method == null) {
			String msg = Arrays
					.stream(parameterTypes)
					.map(e -> e.getName().substring(
							e.getName().lastIndexOf(".") + 1))
					.collect(Collectors.joining(", "));
			throw new NoSuchMethodException(obj.getClass().getName() + "#"
					+ methodName + "(" + msg + ")");
		}
		method.setAccessible(true);
		return invoke(obj, method, args);
	}

	/**
	 * Checks if an array of {@link Class}es can be assigned to another array of
	 * {@link Class}es.
	 */
	public static boolean isAssignable(Class<?>[] classArray,
			Class<?>[] toClassArray, final boolean autoboxing) {
		if (classArray.length != toClassArray.length) {
			return false;
		}

		for (int i = 0; i < classArray.length; i++) {
			if (!isAssignable(classArray[i], toClassArray[i], autoboxing)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if one {@link Class} can be assigned to a variable of another
	 * {@link Class}.
	 */
	public static boolean isAssignable(Class<?> cls, final Class<?> toClass,
			final boolean autoboxing) {
		if (toClass == null) {
			return false;
		}

		// have to check for null, as isAssignableFrom doesn't
		if (cls == null) {
			return !(toClass.isPrimitive());
		}

		// autoboxing
		if (autoboxing) {
			if (cls.isPrimitive() && !toClass.isPrimitive()) {
				cls = primitiveToWrapper(cls);
				if (cls == null) {
					return false;
				}
			}
			if (toClass.isPrimitive() && !cls.isPrimitive()) {
				cls = wrapperToPrimitive(cls);
				if (cls == null) {
					return false;
				}
			}
		}

		if (cls.equals(toClass)) {
			return true;
		}

		// 对于原子类型, 根据JLS的规则进行扩展
		if (cls.isPrimitive()) {
			if (!toClass.isPrimitive()) {
				return false;
			}
			if (Boolean.TYPE.equals(cls)) {
				return false;
			}
			if (Integer.TYPE.equals(cls)) {
				return Long.TYPE.equals(toClass) || Float.TYPE.equals(toClass)
						|| Double.TYPE.equals(toClass);
			}
			if (Long.TYPE.equals(cls)) {
				return Float.TYPE.equals(toClass)
						|| Double.TYPE.equals(toClass);
			}
			if (Float.TYPE.equals(cls)) {
				return Double.TYPE.equals(toClass);
			}
			if (Double.TYPE.equals(cls)) {
				return false;
			}
			if (Character.TYPE.equals(cls)) {
				return Integer.TYPE.equals(toClass)
						|| Long.TYPE.equals(toClass)
						|| Float.TYPE.equals(toClass)
						|| Double.TYPE.equals(toClass);
			}
			if (Short.TYPE.equals(cls)) {
				return Integer.TYPE.equals(toClass)
						|| Long.TYPE.equals(toClass)
						|| Float.TYPE.equals(toClass)
						|| Double.TYPE.equals(toClass);
			}
			if (Byte.TYPE.equals(cls)) {
				return Short.TYPE.equals(toClass)
						|| Integer.TYPE.equals(toClass)
						|| Long.TYPE.equals(toClass)
						|| Float.TYPE.equals(toClass)
						|| Double.TYPE.equals(toClass);
			}
			return false;
		}

		return toClass.isAssignableFrom(cls);
	}

	/**
	 * Converts the specified primitive {@link Class} object to its
	 * corresponding wrapper Class object.
	 */
	public static Class<?> primitiveToWrapper(final Class<?> cls) {
		Class<?> convertedClass = cls;
		if (cls != null && cls.isPrimitive()) {
			convertedClass = primitiveWrapperMap.get(cls);
		}
		return convertedClass;
	}

	/**
	 * Converts the specified wrapper {@link Class} to its corresponding
	 * primitive class.
	 */
	public static Class<?> wrapperToPrimitive(final Class<?> cls) {
		return wrapperPrimitiveMap.get(cls);
	}

	/**
	 * Set the {@code accessible} flag for this object to the indicated boolean
	 * value. Invoker value of {@code true} indicates that the reflected object
	 * should suppress Java language access checking when it is used. Invoker
	 * value of {@code false} indicates that the reflected object should enforce
	 * Java language access checks.
	 */
	private static Field setAccessible(Field fd) {
		if (!Modifier.isPublic(fd.getModifiers())
				|| !Modifier.isPublic(fd.getDeclaringClass().getModifiers())) {
			fd.setAccessible(true);
		}
		return fd;
	}

	/**
	 * 判断是否复杂类型，版本1.0.0不支持java.lang java.util java.sql包中的实体类
	 * 
	 * @param clazz
	 * @return boolean
	 */
	public static boolean isComplexType(Class<?> clazz) {
		if ((clazz.getName().startsWith("java.lang.")
				|| clazz.getName().startsWith("java.util.") || clazz.getName()
				.startsWith("java.sql."))
				&& !clazz.isArray()
				&& !Iterable.class.isAssignableFrom(clazz)) {
			return false;
		}
		return true;
	}

	/**
	 * 是否含有属性
	 * 
	 * @param clazz
	 * @return boolean
	 */
	public static boolean hasField(Class<?> clazz) {
		if (clazz.getDeclaredFields() == null
				|| clazz.getDeclaredFields().length == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 返回一个默认构造器产生的实例
	 * 
	 * @param clazz
	 * @return object
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T getInstance(Class<T> clazz)
			throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}

	/**
	 * 获取数组属性中所持有的类型
	 * 
	 * @param field
	 * @return class
	 */
	public static <T> Class<T> getArrayGenericType(Field field) {
		Type type = field.getGenericType();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			return (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
		return null;
	}
}