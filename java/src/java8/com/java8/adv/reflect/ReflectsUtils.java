package com.java8.adv.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.mchange.v2.reflect.ReflectUtils;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public final class ReflectsUtils {

	private ReflectsUtils() {
	}

	public static <T> T newInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Status实现类生成失败", e);
		}
	}

	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			IntrospectionException {
		Person p = new Person("zhangsan", 9);
		// Map<String, Object> attributesByIntrospector =
		// ReflectUtils.getAttributesByIntrospector(p);
		// Iterator<Entry<String, Object>> iterator =
		// attributesByIntrospector.entrySet().iterator();
		// while (iterator.hasNext()) {
		// Entry<String, Object> entry = iterator.next();
		// System.out.println("key===" + entry.getKey() + "\tValue===" +
		// entry.getValue());
		// }

		// Map<String, Object> attributesByIntrospector =
		// ReflectUtils.getAttributes(p);
		// Iterator<Entry<String, Object>> iterator =
		// attributesByIntrospector.entrySet().iterator();
		// while (iterator.hasNext()) {
		// Entry<String, Object> entry = iterator.next();
		// System.out.println("key===" + entry.getKey() + "\tValue===" +
		// entry.getValue());
		// }

		Object valueByKey = ReflectsUtils.getValueByKeyByIntroObject(p, "age");
		System.out.println(valueByKey);
		// import org.apache.commons.beanutils.BeanUtils;
		// 使用BeanUtils工具包操作JavaBean
		// 28 String userName=BeanUtils.getProperty(userInfo, propertyName);
		// 29 System.out.println("userName="+userName);
		// 30 BeanUtils.setProperty(userInfo, propertyName, "linjiqin");
		// 31 userName=BeanUtils.getProperty(userInfo, propertyName);
		// 32 System.out.println("userName="+userName);
	}

	/**
	 * 将对象的所有属性值 转为map形式
	 * 
	 * @param object
	 * @return
	 */
	public static Map<String, Object> getAttributes(Object object) {
		Field[] declaredFields = object.getClass().getDeclaredFields();
		if (null != declaredFields && declaredFields.length > 0) {
			Map<String, Object> attributesMap = new HashMap<String, Object>();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object fieldValue = new Object();
				try {
					fieldValue = field.get(object);
					attributesMap.put(fieldName, fieldValue);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return attributesMap;
		} else {
			return null;
		}
	}

	/**
	 * 通过java 内省机制 将map值 封装到Object上
	 * 
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 * @throws IllegalAccessException
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass)
			throws Exception, IllegalAccessException {
		if (null == map || map.size() <= 0) {
			return null;
		}
		Object obj = beanClass.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass(),
				Object.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			Method writeMethod = propertyDescriptor.getWriteMethod();
			if (null != writeMethod) {
				writeMethod.invoke(obj, map.get(writeMethod.getName()));
			}
		}
		return obj;
	}

	/**
	 * 将对象的所有属性值 转为map形式
	 * 
	 * @param object
	 * @return
	 * @throws IntrospectionException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> getAttributesByIntrospector(Object object)
			throws SecurityException, IntrospectionException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			Method readMethod = propertyDescriptor.getReadMethod();
			if (null != readMethod) {
				String name = readMethod.getName();
				Object invoke = readMethod.invoke(object);
				attributesMap.put(name, invoke);
			}
		}
		return attributesMap;

	}

	/**
	 * 根据key值 获取对应value 反射机制 或者内省机制
	 * 
	 * @param object
	 * @param key
	 * @return
	 */
	public static Object getValueByKey(Object object, String key) {
		Object val = null;
		try {
			Field[] declaredFields = object.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				if (field.getName().equals(key)) {
					val = field.get(object);
				}
			}
			return val;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据key值 获取对应value 反射机制 或者内省机制
	 * 
	 * @param object
	 * @param key
	 * @return
	 * @throws IntrospectionException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getValueByKeyByIntroObject(Object object, String key)
			throws IntrospectionException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Object val = null;
		PropertyDescriptor property = new PropertyDescriptor(key,
				object.getClass());
		Method readMethod = property.getReadMethod();
		if (null != readMethod) {
			val = readMethod.invoke(object);

		}
		return val;
	}

}