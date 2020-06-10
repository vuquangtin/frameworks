package com.java8.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java.frameworks.base.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class FunctionalProgramming06 extends TemplateMethod {

	public static void main(String[] args) {
		new FunctionalProgramming06().runTemplateMethod(args);

	}

	public static boolean evaluate(final int value) {
		System.out.println("evaluating..." + value);
		simulateTimeConsumingOp(2000);
		return value > 100;
	}

	public static void simulateTimeConsumingOp(final int millseconds) {
		try {
			Thread.sleep(millseconds);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void eagerEvaluator(final boolean input1, final boolean input2) {
		System.out.println("eagerEvaluator called...");
		System.out.println("accept?: " + (input1 && input2));
	}

	public static void lazyEvaluator(final Supplier<Boolean> input1, final Supplier<Boolean> input2) {
		System.out.println("lazyEvaluator called...");
		System.out.println("accept?: " + (input1.get() && input2.get()));
	}

	/***
	 * Evaluation
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		System.out.println("//" + "START:EAGER_OUTPUT");
		eagerEvaluator(evaluate(1), evaluate(2));
		System.out.println("//" + "END:EAGER_OUTPUT");

		System.out.println("//" + "START:LAZY_OUTPUT");
		lazyEvaluator(() -> evaluate(1), () -> evaluate(2));
		System.out.println("//" + "END:LAZY_OUTPUT");

	}

	class Heavy {
		public Heavy() {
			System.out.println("Heavy constructor");
		}

		public String toString() {
			return "quite heavy";
		}
	}

	private Heavy heavy;

	public synchronized Heavy getHeavy() {
		if (heavy == null) {
			heavy = new Heavy();
		}
		return heavy;
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {

		System.out.println("deferring heavy creation...");
		System.out.println(this.getHeavy());
		System.out.println(this.getHeavy());

	}

	private static int length(final String name) {
		System.out.println("getting length for " + name);
		return name.length();
	}

	private static String toUpper(final String name) {
		System.out.println("converting to uppercase: " + name);
		return name.toUpperCase();
	}

	/***
	 * LazyStreams
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe", "Mike", "Susan", "George", "Robert",
				"Julia", "Parker", "Benson");
		swingForTheFence(names);
		peekingIntoLaziness(names);
	}

	private static void swingForTheFence(List<String> names) {
		System.out.println("begin swingForTheFence");
		final String firstNameWith3Letters = names.stream().filter(name -> length(name) == 3).map(name -> toUpper(name))
				.findFirst().get();
		System.out.println(firstNameWith3Letters);
		System.out.println("end swingForTheFence");
	}

	private static void peekingIntoLaziness(List<String> names) {
		System.out.println("begin peekingIntoLaziness");
		Stream<String> namesWith3Letters = names.stream().filter(name -> length(name) == 3).map(name -> toUpper(name));

		System.out.println("Stream created, filtered, mapped...");
		System.out.println("ready to call findFirst...");
		final String firstNameWith3Letters = namesWith3Letters.findFirst().get();
		System.out.println(firstNameWith3Letters);
		System.out.println("end peekingIntoLaziness");
	}

	public static boolean isPrime(final int number) {
		boolean isPrime = number > 1
				&& IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(divisor -> number % divisor == 0);
		return isPrime;
	}

	/***
	 * NaivePrimes
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		try {
			primes(1);
		} catch (StackOverflowError ex) {
			System.out.println(ex);
		}
	}

	public static List<Integer> concat(final int number, final List<Integer> numbers) {
		final List<Integer> values = new ArrayList<>();
		values.add(number);
		values.addAll(numbers);
		return values;
	}

	// don't try this at the office
	public static List<Integer> primes(final int number) {
		if (isPrime(number)) {
			return concat(number, primes(number + 1));
		} else {
			return primes(number + 1);
		}
	}

	private static int primeAfter(final int number) {
		if (isPrime(number + 1)) {
			return number + 1;
		} else {
			return primeAfter(number + 1);
		}
	}

	public static List<Integer> primes(final int fromNumber, final int count) {
		return Stream.iterate(primeAfter(fromNumber - 1), FunctionalProgramming06::primeAfter).limit(count)
				.collect(Collectors.<Integer> toList());
	}

	/***
	 * Primes
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		System.out.println("10 primes from 1: " + primes(1, 10));

		System.out.println("5 primes from 100: " + primes(100, 5));

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
