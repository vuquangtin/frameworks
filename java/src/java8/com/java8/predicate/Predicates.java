package com.java8.predicate;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Predicates {

	public static <T> Predicate<T> or(Predicate<T>... predicates) {
		return Stream.of(predicates).reduce(Predicate::or).get();
	}

	public static <T> Predicate<T> and(Predicate<T>... predicates) {
		return Stream.of(predicates).reduce(Predicate::and).get();
	}
}
