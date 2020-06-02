package com.java8.function.test;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class LambdaExamples {

	@Test
	public void example1() {

		Supplier<String> s = String::new;
		System.out.println(s.get().toString());

		Function<String, String> f = String::new;
		System.out.println(f.apply("hi").toString());
	}

	@Test
	public void example2() {

		Function<Integer, Integer> f = x -> x + 1;

		System.out.println(f.apply(4));
	}

	@Test
	public void example3() {

		IntBinaryOperator f = (int x, int y) -> x + y;

		System.out.println(f.applyAsInt(4, 5));
	}

	@Test
	public void example4() {

		VarArgConsumer f = (String fmt, Object... args) -> String.format(fmt, args);

		System.out.println(f.apply("%s %d %s", "I have", 5, "Ruppes"));
	}

	@Test
	public void example5() {

	}

}