package com.java8.adv.reflect;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectDemo1 {

	public static void main(String[] args) throws ClassNotFoundException {

		// 1.Class.forName("类全名");
		Class cls1 = Class.forName(ReflectsTest.packageName + ".Person");
		System.out.println(cls1);
		// 2.类名.class
		Class cls2 = Person.class;
		System.out.println(cls2);
		// 3.对象.getClass();
		Person p = new Person();
		Class cls3 = p.getClass();
		System.out.println(cls3);

		// == 比较是哪个对象
		System.out.println(cls1 == cls2);
		System.out.println(cls1 == cls3);

		Class cls4 = Student.class;
		System.out.println(cls4 == cls1);

	}

}