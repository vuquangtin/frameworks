package com.java8.annotations;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class MyClass extends MySuperClass {
	@Override
	public int overrideMethod() {
		super.overrideMethod();
		System.out.println("MyClass");
		//java.util.function.Predicate.isEqual(targetRef)
		return 200;
	}
}
