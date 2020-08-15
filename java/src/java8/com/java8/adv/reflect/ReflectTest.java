package com.java8.adv.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectTest {

	public static void main(String[] args) {

		createVO1();
		createVO2();
		getFiled();
		testMethod();
		try {
			testDemo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * test load lop tu file config
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	public static void testDemo() throws IOException, Exception {
		// 1.加载配置文件
		Properties pro = new Properties();
		ClassLoader classLoader = ReflectTest.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("reflect.properties");
		pro.load(is);

		// 2.读取信息
		String className = pro.getProperty("className");
		String methodName = pro.getProperty("methodNmae");

		// 3.利用反射
		Class cls = Class.forName(className);
		// 创建对象
		Object obj = cls.newInstance();
		// 获取方法
		Method method = cls.getMethod(methodName);
		// 执行方法
		method.invoke(obj);
	}

	public static void createVO1() {
		Class cls = Student.class;
		try {
			Student stu = (Student) cls.newInstance();
			System.out.println(stu);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createVO2() {
		try {
			Class cls = Class.forName(ReflectsTest.packageName + ".Student");
			// 指定参数的Class,来决定调用那个构造函数
			Constructor cons = cls.getConstructor(String.class, int.class);
			Student stu = (Student) cons.newInstance("zero", 10);
			System.out.println(stu);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | NoSuchMethodException
				| SecurityException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void getFiled() {
		try {
			Class cls = Student.class;// 首先得到class
			Field[] fields = cls.getFields(); // 只能获取public修饰的field
			for (Field field : fields) {
				System.out.println(field.getName());
			}

			fields = cls.getDeclaredFields(); // 获取所有声明过的field
			for (Field field : fields) {
				System.out.println(field.getName());
			}

			Student stu = new Student("zero", 12);
			Field stuFiled = stu.getClass().getDeclaredField("name"); // 获取private的field
			stuFiled.setAccessible(true);// private访问权限打开，否则抛出java.lang.IllegalAccessException
			System.out.println(stuFiled.get(stu));// 获取stu的name

			Student student = Student.class.newInstance();
			Field sFiled = Student.class.getDeclaredField("name");
			sFiled.setAccessible(true);
			sFiled.set(student, "zero123");// 为name字段设置值
			System.out.println(sFiled.get(student));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void testMethod() {
		Method[] methods = Student.class.getMethods();
		for (Method method : methods) {// 只获取Student的public修饰的method，以及Object的public修饰的method
			System.out.println(method.getName());
		}

		Method[] methodss = Student.class.getDeclaredMethods();
		for (Method method : methodss) { // 只获取Student所有的method，不包括Object的method
			System.out.println(method.getName());
		}

		try {
			Student student = new Student();
			Method setMethod = student.getClass().getDeclaredMethod(
					"setGender", String.class);// 获取参数为String的setGender方法
			setMethod.invoke(student, "man");

			Method getMethod = student.getClass()
					.getDeclaredMethod("getGender");// 获取getGender方法
			getMethod.setAccessible(true);// getGender方法是private，应该打开访问权限
			String gender = (String) getMethod.invoke(student);
			System.out.println(gender);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}