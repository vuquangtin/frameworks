package com.java8.adv.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectionGetAllElement {
	public static void main(String[] args) throws ClassNotFoundException {
		String name;
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入一个类名（例如：java.lang.String）");
			name = sc.nextLine();
		}
		Class clazz = Class.forName(name);// 获取类的class类对象
		Class superClass = clazz.getSuperclass();// 获取父类的class对象
		String modifiers = Modifier.toString(clazz.getModifiers());// 获取类的修饰符
		// 获取接口
		Class[] interfaces = clazz.getInterfaces();
		String interfacesNames = "";
		if (interfaces.length > 1) {
			for (int i = 0; i < interfaces.length; i++) {
				interfacesNames += interfaces[i].getName();
				if (i != interfaces.length - 1) {
					interfacesNames += ",";
				}
			}
		}
		// 按定义类的格式输出
		if (modifiers.length() > 0) {
			System.out.print(modifiers + " ");
		}
		System.out.print("class " + name);
		if (superClass != null && superClass != Object.class) {
			System.out.print(" extends " + superClass.getName());
		}
		if (interfaces != null) {
			System.out.println();
			System.out.print("  implements " + interfacesNames);
		}
		System.out.print(" {\n");
		// 打印所有构造方法
		printConstructors(clazz);
		System.out.println();
		// 打印所有成员方法，静态方法
		printMethods(clazz);
		System.out.println();
		// 打印所有成员变量，静态变量
		printFields(clazz);
		System.out.println("}");
	}

	public static void printConstructors(Class cl) {
		Constructor[] constructors = cl.getDeclaredConstructors();

		for (Constructor constructor : constructors) {
			// 获取构造方法修饰符
			String modifiers = Modifier.toString(constructor.getModifiers());
			// 获取构造方法名称
			String name = constructor.getName();
			// 获取构造方法参数列表
			Class[] types = constructor.getParameterTypes();

			// 按格式打印方法
			System.out.print("\t");
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(name + "(");
			for (int i = 0; i < types.length; i++) {
				if (i > 0) {
					System.out.print(", ");
				}
				System.out.print(types[i].getName());
			}
			System.out.println(");");
		}
	}

	public static void printMethods(Class cl) {
		// 获取方法
		Method[] methods = cl.getDeclaredMethods();
		for (Method method : methods) {
			// 获取方法名
			String name = method.getName();
			// 获取修饰符
			String modifiers = Modifier.toString(method.getModifiers());
			// 获取方法参数列表
			Class[] types = method.getParameterTypes();

			// 按格式打印
			System.out.print("\t");
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.print(name + "(");
			for (int i = 0; i < types.length; i++) {
				if (i > 0) {
					System.out.print(", ");
				}
				System.out.print(types[i].getName());
			}
			System.out.println(");");
		}

	}

	public static void printFields(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		for (Field field : fields) {
			// 获取变量名
			String name = field.getName();
			// 获取修饰符
			String modifiers = Modifier.toString(field.getModifiers());
			// 获取类型
			Class type = field.getType();

			// 按格式打印
			System.out.print("\t");
			if (modifiers.length() > 0) {
				System.out.print(modifiers + " ");
			}
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}