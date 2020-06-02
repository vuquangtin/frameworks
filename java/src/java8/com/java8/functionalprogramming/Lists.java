package com.java8.functionalprogramming;

import java.util.Arrays;
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
public class Lists {
	public static <T> List<T> of(T... a) {
		return Arrays.asList(a);
	}
}
