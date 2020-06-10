package com.java8.functionalprogramming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
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
public class FunctionalProgramming07 extends TemplateMethod {

	public static void main(String[] args) {
		new FunctionalProgramming07().runTemplateMethod(args);

	}

	@FunctionalInterface
	public interface TailCall<T> {

		TailCall<T> apply();

		default boolean isComplete() {
			return false;
		}

		default T result() {
			throw new Error("not implemented");
		}

		default T invoke() {
			return Stream.iterate(this, TailCall::apply).filter(TailCall::isComplete).findFirst().get().result();
		}
	}

	public static BigInteger decrement(final BigInteger number) {
		return number.subtract(BigInteger.ONE);
	}

	public static BigInteger multiply(final BigInteger first, final BigInteger second) {
		return first.multiply(second);
	}

	final static BigInteger ONE = BigInteger.ONE;
	final static BigInteger FIVE = new BigInteger("5");
	final static BigInteger TWENTYK = new BigInteger("20000");

	public static <T> TailCall<T> call(final TailCall<T> nextCall) {
		return nextCall;
	}

	public static <T> TailCall<T> done(final T value) {
		return new TailCall<T>() {
			@Override
			public boolean isComplete() {
				return true;
			}

			@Override
			public T result() {
				return value;
			}

			@Override
			public TailCall<T> apply() {
				throw new Error("not implemented");
			}
		};
	}

	private static TailCall<BigInteger> factorialTailRec(final BigInteger factorial, final BigInteger number) {
		if (number.equals(BigInteger.ONE)) {
			return done(factorial);
		} else {
			return call(() -> factorialTailRec(multiply(factorial, number), decrement(number)));
		}
	}

	public static BigInteger factorial(final BigInteger number) {
		return factorialTailRec(BigInteger.ONE, number).invoke();
	}

	/***
	 * BigFactorial
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		System.out.println(factorial(FIVE));
		System.out.println(String.format("%.10s", factorial(TWENTYK)));

	}

	public static int factorialRec(final int number) {
		if (number == 1) {
			return number;
		} else {
			return number * factorialRec(number - 1);
		}
	}

	public static int factorial(final int number) {
		return factorialTailRec(1, number).invoke();
	}

	public static TailCall<Integer> factorialTailRec(final int factorial, final int number) {
		if (number == 1) {
			return done(factorial);
		} else {
			return call(() -> factorialTailRec(factorial * number, number - 1));
		}
	}

	/***
	 * Factorial
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		System.out.println("// factorialRec( 5 ) start");
		System.out.println(factorialRec(5));
		System.out.println("// factorialRec( 5 ) end\n");

		System.out.println("// factorialRec( 20000 ) start");
		try {
			System.out.println(factorialRec(20000));
		} catch (StackOverflowError ex) {
			System.out.println(ex);
		}
		System.out.println("// factorialRec( 20000 ) end\n");

		System.out.println("// factorialTailRec( 1, 5 ) start");
		System.out.println(factorialTailRec(1, 5).invoke());
		System.out.println("// factorialTailRec( 1, 5 ) end\n");

		System.out.println("// factorialTailRec( 1, 20000 ) start");
		System.out.println(factorialTailRec(1, 20000).invoke());
		System.out.println("// factorialTailRec( 1, 20000 ) end\n");

		System.out.println("// factorial( 5 ); factorial( 20000 ); start");
		System.out.println(factorial(5));
		System.out.println(factorial(20000));
		System.out.println("// factorial( 5 ); factorial( 20000 ); end\n");

	}

	/***
	 * Memoizer
	 */
	public static <T, R> R callMemoized(final BiFunction<Function<T, R>, T, R> function, final T input) {
		Function<T, R> memoized = new Function<T, R>() {
			{
				/*
				 * WingDing thinks maybe this Map is in the wrong place since
				 * the Price list was fixed at RodCutterMemoizer why wasn't this
				 * Map fixed down at that time as well.
				 */
				System.out.println("new Function called");
			}
			private final Map<T, R> store = new HashMap<>();

			public R apply(final T input) {
				return store.computeIfAbsent(input, key -> function.apply(this, key));
			}
		};
		return memoized.apply(input);
	}

	static class RodCutterBasic {
		final List<Integer> prices;

		public RodCutterBasic(final List<Integer> pricesForLength) {
			prices = pricesForLength;
		}

		public int maxProfit(final int length) {
			int profit = (length <= prices.size()) ? prices.get(length - 1) : 0;
			for (int i = 1; i < length; i++) {
				int priceWhenCut = maxProfit(i) + maxProfit(length - i);
				if (profit < priceWhenCut) {
					profit = priceWhenCut;
				}
			}
			return profit;
		}

		public static List<Integer> priceValues = Arrays.asList(2, 1, 1, 2, 2, 2, 1, 8, 9, 15);

		public void run(final RodCutterBasic rodCutter) {
			System.out.println(rodCutter.maxProfit(5));
			System.out.println(rodCutter.maxProfit(22));
		}

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		final RodCutterBasic rodCutter = new RodCutterBasic(RodCutterBasic.priceValues);
		rodCutter.run(rodCutter);

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
