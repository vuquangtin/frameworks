package com.java8.adv.jls14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.java.frameworks.base.ExtendTemplateMethod;
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
public class Chapter15_2 extends ExtendTemplateMethod {

	public static void main(String[] args) {
		new Chapter15_2().runTemplateMethod(args);

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		List<String> ls = Arrays.asList();

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		List<String> ls = args.length > 0 ? Arrays.asList() : Arrays.asList(
				"a", "b");

	}

	static class ArrayReferenceThrow extends RuntimeException {
	}

	static class IndexThrow extends RuntimeException {
	}

	static class RightHandSideThrow extends RuntimeException {
	}

	static class IllustrateSimpleArrayAssignment {
		static Object[] objects = { new Object(), new Object() };
		static Thread[] threads = { new Thread(), new Thread() };

		static Object[] arrayThrow() {
			throw new ArrayReferenceThrow();
		}

		static int indexThrow() {
			throw new IndexThrow();
		}

		static Thread rightThrow() {
			throw new RightHandSideThrow();
		}

		static String name(Object q) {
			String sq = q.getClass().getName();
			int k = sq.lastIndexOf('.');
			return (k < 0) ? sq : sq.substring(k + 1);
		}

		static void testFour(Object[] x, int j, Object y) {
			String sx = x == null ? "null" : name(x[0]) + "s";
			String sy = name(y);
			System.out.println();
			try {
				System.out.print(sx + "[throw]=throw => ");
				x[indexThrow()] = rightThrow();
				System.out.println("Okay!");
			} catch (Throwable e) {
				System.out.println(name(e));
			}
			try {
				System.out.print(sx + "[throw]=" + sy + " => ");
				x[indexThrow()] = y;
				System.out.println("Okay!");
			} catch (Throwable e) {
				System.out.println(name(e));
			}
			try {
				System.out.print(sx + "[" + j + "]=throw => ");
				x[j] = rightThrow();
				System.out.println("Okay!");
			} catch (Throwable e) {
				System.out.println(name(e));
			}
			try {
				System.out.print(sx + "[" + j + "]=" + sy + " => ");
				x[j] = y;
				System.out.println("Okay!");
			} catch (Throwable e) {
				System.out.println(name(e));
			}
		}

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		try {
			System.out.print("throw[throw]=throw => ");
			IllustrateSimpleArrayAssignment.arrayThrow()[IllustrateSimpleArrayAssignment
					.indexThrow()] = IllustrateSimpleArrayAssignment
					.rightThrow();
			System.out.println("Okay!");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println(IllustrateSimpleArrayAssignment.name(e));
		}
		try {
			System.out.print("throw[throw]=Thread => ");
			IllustrateSimpleArrayAssignment.arrayThrow()[IllustrateSimpleArrayAssignment
					.indexThrow()] = new Thread();
			System.out.println("Okay!");
		} catch (Throwable e) {
			System.out.println(IllustrateSimpleArrayAssignment.name(e));
		}
		try {
			System.out.print("throw[1]=throw => ");
			IllustrateSimpleArrayAssignment.arrayThrow()[1] = IllustrateSimpleArrayAssignment
					.rightThrow();
			System.out.println("Okay!");
		} catch (Throwable e) {
			System.out.println(IllustrateSimpleArrayAssignment.name(e));
		}
		try {
			System.out.print("throw[1]=Thread => ");
			IllustrateSimpleArrayAssignment.arrayThrow()[1] = new Thread();
			System.out.println("Okay!");
		} catch (Throwable e) {
			System.out.println(IllustrateSimpleArrayAssignment.name(e));
		}

		IllustrateSimpleArrayAssignment.testFour(null, 1, new StringBuffer());
		IllustrateSimpleArrayAssignment.testFour(null, 9, new Thread());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.objects, 1, new StringBuffer());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.objects, 1, new Thread());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.objects, 9, new StringBuffer());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.objects, 9, new Thread());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.threads, 1, new StringBuffer());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.threads, 1, new Thread());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.threads, 9, new StringBuffer());
		IllustrateSimpleArrayAssignment.testFour(
				IllustrateSimpleArrayAssignment.threads, 9, new Thread());

	}

	/****
	 * Here are some examples of lambda expressions:
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		Runnable r = () -> {
			logger.debug("RUN");
		};
		r.run();
		// No parameters; result is void
		Callable<Integer> r1 = () -> 42;
		// No parameters, expression body
		Callable r2 = () -> null;
		// No parameters, expression body
		Callable<Integer> r3 = () -> {
			return 42;
		};
		// No parameters, block body with return
		Runnable r4 = () -> {
			System.gc();
		};
		// No parameters, void block body

		Callable<Integer> r5 = () -> {
			// Complex block body with returns
			if (true)
				return 12;
			else {
				int result = 15;
				for (int i = 1; i < 10; i++)
					result *= i;
				return result;
			}
		};

		Function<Integer, Integer> c = (Integer x) -> x + 1;
		// Single declared-type parameter
		Function<Integer, Integer> f = (Integer x) -> {
			return x + 1;
		};
		// Single declared-type parameter
		Function<Integer, Integer> c2 = (x) -> x + 1;
		// Single inferred-type parameter
		Function<Integer, Integer> c3 = x -> x + 1;
		// Parentheses optional for
		// single inferred-type parameter

		Function<String, Integer> f2 = (String s) -> s.length();
		// Single declared-type parameter
		Consumer<Thread> c4 = (Thread t) -> {
			t.start();
		};

		// Single declared-type parameter
		Function<String, Integer> f23 = s -> s.length();
		// Single inferred-type parameter
		Consumer<Thread> k = t -> {
			t.start();
		};
		// Single inferred-type parameter

		FuncInterface ff = (int x, int y) -> x + y;
		logger.debug(ff.abstractFun(100, 300));
		// Multiple declared-type parameters
		FuncInterface ff2 = (x, y) -> x+y;
		// Multiple inferred-type parameters
		FuncInterface ff3 =  (x, int y) -> x+y;
		// Illegal: can't mix inferred and declared types
		FuncInterface ff4 = (x, final y) -> x+y
		// Illegal: no modifiers with inferred types

	}

	interface FuncInterface {
		// An abstract function
		int abstractFun(int x, int y);

		// A non-abstract (or default) function
		default void normalFun() {
			System.out.println("Hello");
		}
	}

	interface BooleanFI {
		boolean check(boolean a, boolean b);
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		BooleanFI fi = (x, z) -> true;

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();
		// Predicate has a boolean result
		java.util.function.Predicate<String> p = s -> list.add(s);
		// Consumer has a void result
		java.util.function.Consumer<String> c = s -> list.add(s);
		// list=new ArrayList<String>();
		list.add("dfsdf");
	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		int n = 10;
		int k;
		while (true) {
			k = n;
			if (k >= 5)
				break;
			n = 6;
		}
		System.out.println(k);

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		int n = 2;
		int k;
		// dk n<4 trinh bien dich se ko hieu truong hop hien tai co chay vao
		// while ko?
		// nen mac dinh k se ko dc khoi tao

		while (n < 4) {
			k = n;
			if (k >= 5)
				break;
			n = 6;
		}
		System.out.println(k);

		/*
		 * k is not "definitely assigned" before this statement
		 */

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		boolean test = true;
		int n = 10;
		int k;
		while (test) {
			k = n;
			if (k >= 5)
				break;
			n = 6;
		}
		System.out.println(k);

	}

	/****
	 * Example 16-2. Definite Assignment Does Not Consider Values of Expressions
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionTen(String[] args) throws Exception {
		int k;
		// final int n = 5;-->OK
		int n = 5;
		if (n > 2)
			k = 3;
		System.out.println(k);
		/*
		 * k is not "definitely assigned" before this statement
		 */

	}

	@Override
	public void implementionEleven(String[] args) throws Exception {
		boolean flag = true;
		int k;
		if (flag)
			k = 3;
		else
			k = 4;
		System.out.println(k);

	}

	/**
	 * as far as definite assignment of k is concerned, because the rules
	 * outlined in this section allow it to tell that k is assigned no matter
	 * whether the flag is true or false . But the rules do not accept the
	 * variation:
	 *
	 *
	 * and so compiling this program must cause a compile-time error to occur.
	 */
	@Override
	public void implementionTwelve(String[] args) throws Exception {
		boolean flag = true;
		int k;
		if (flag)
			k = 3;
		if (!flag)
			k = 4;
		System.out.println(k);
		/*
		 * k is not "definitely assigned" before this statement
		 */

	}

	/*
	 * Example 16-3. Definite Unassignment
	 * 
	 * A Java compiler will accept the code:
	 */
	void unflow(boolean flag) {
		final int k;
		if (flag) {
			k = 3;
			System.out.println(k);
		} else {
			k = 4;
			System.out.println(k);
		}
	}

	/*
	 * as far as definite unassignment of k is concerned, because the rules
	 * outlined in this section allow it to tell that k is assigned at most once
	 * (indeed, exactly once) no matter whether the flag is true or false . But
	 * the rules do not accept the variation:
	 * 
	 * and so compiling this program must cause a compile-time error to occur.
	 */
	@Override
	public void implementionThirteen(String[] args) throws Exception {
		boolean flag = false;
		final int k;
		if (flag) {
			k = 3;
			System.out.println(k);
		}
		if (!flag) {
			k = 4;
			System.out.println(k);
			/*
			 * k is not "definitely unassigned" before this statement
			 */
		}

	}

	@Override
	public void implementionFourteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFifteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEighteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNineteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTwenty(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}
