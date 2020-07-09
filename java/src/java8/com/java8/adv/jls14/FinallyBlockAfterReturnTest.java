package com.java8.adv.jls14;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class FinallyBlockAfterReturnTest {
	public static void main(String[] args) {
		System.out.println(count());
		System.out.println(myTestingFuncn());
	}

	public static int count() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			System.out
					.println("Finally block will execute even after a return statement in a method");
		}
	}

	/***
	 * Does finally block Override the values returned by try-catch block?
	 * 
	 * Yes. Finally block overrides the value returned by try and catch blocks,
	 * lets take an example to understand this:
	 * 
	 * This program would return value 19 since the value returned by try has
	 * been overridden by finally.
	 * 
	 * @return
	 */
	public static int myTestingFuncn() {
		try {
			int x = 100 / 0;
			return 5;
		} finally {
			return 19;
		}
	}
}