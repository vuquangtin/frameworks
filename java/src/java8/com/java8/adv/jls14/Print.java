package com.java8.adv.jls14;

import java.io.PrintStream;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Print {
	// Print with a newline:
	public static void print(Object obj) {
		System.out.println(obj);
	}

	// Print a newline by itself:
	public static void print() {
		System.out.println();
	}

	// Print with no line break:
	public static void printnb(Object obj) {
		System.out.print(obj);
	}

	// The new Java SE5 printf() (from C):
	public static PrintStream printf(String format, Object... args) {
		return System.out.printf(format, args);
	}
} // /:~