package com.java8.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import com.java8.adv.abs.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class EFunctionalProgramming extends TemplateMethod {
	public static void main(String[] args) {
		new EFunctionalProgramming().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// make it work first, and make it better real soon
		// find the double of the first even number greater than 3

		List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
		int result = 0;
		for (int e : values) {
			if (e > 3 && e % 2 == 0) {
				result = e * 2;
				break;
			}
		}
		System.out.println(result);

		Predicate<Integer> isGreaterThan3 = number -> number > 3;
		Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number > pivot;

		// Higher-order functions
		// Lazy & composition
		System.out.println(values.stream().filter(isGreaterThan.apply(3))
				// .filter(AFunction::isGreaterThan3) //lazy
				.filter(EFunctionalProgramming::sampleIsEven) // lazy
				// .filter(e -> sampleIsEven(e)) // office space pattern
				.map(EFunctionalProgramming::doubleIt) // lazy
				.findFirst()); // terminal operation
		// .get());O

	}

	private static Integer doubleIt(Integer number) {
		System.out.println("Double it!");
		return number * 2;
	}

	private static boolean sampleIsEven(Integer number) {
		System.out.println(number + " is even");
		return number % 2 == 0;
	}

	public static boolean isGreaterThan3(Integer number) {
		System.out.println(number + " is greater than 3");
		return number > 3;
	}

	private static boolean isPrime(final int number) {
		// imperative - saying how
		// how
		// mutability
		// if(number % i == 0) return false;
		// }
		//
		// return number > 1;

		// declarative
		// what
		// immutability
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		System.out.println(isPrime(1));
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));
		System.out.println(isPrime(5));

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		// referential transparency
		System.out.println(
				// numbers.stream()
				numbers.parallelStream().mapToInt(EFunctionalProgramming::doubleIt).sum());

	}

	private static int doubleIt(int number) {
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
		}
		return number * 2;
	}

	interface Selector {
		public boolean pick(int value);
	}

	// example
	// class EvenSelector implements Selector {
	// @Override
	// public boolean pick (int value) {
	// return value % 2 == 0;
	// }
	// }
	public static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
		// int result = 0;
		// for(int e: numbers){
		// if (selector.test(e)) result += e;
		// }
		// return result;

		return numbers.stream().filter(selector).reduce(0, Math::addExact);
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

		System.out.println(totalValues(values, e -> true));
		System.out.println(totalValues(values, e -> e % 2 == 0));

		// mixing object composition along function composition

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
}
