package com.java8.function;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class PartialFunctions {

	Function<Integer, Function<Integer, Function<BinaryOperator<Integer>, Integer>>> someComputation = i1 -> i2 -> f -> f
			.apply(i1, i2);

	BinaryOperator<Integer> mult = (i, j) -> i * j;
	BinaryOperator<Integer> divide = (i, j) -> i / j;
	BinaryOperator<Integer> sumSquares = (i, j) -> (i * i) + (j * j);

}