package com.java8.generics;

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
public class BoundedTypes extends TemplateMethod {

	public static void main(String[] args) {
		new BoundedTypes().runTemplateMethod(args);
		Object o;

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// try {
		// Arrays.asList("http://localhost/",
		// "https://github.com").stream().map(URL::new)
		// .collect(Collectors.toList());
		// } catch (MalformedURLException e) {
		//
		// e.printStackTrace();
		// }

	}

	class Bound<T extends A> {

		private T objRef;

		public Bound(T obj) {
			this.objRef = obj;
		}

		public void doRunTest() {
			this.objRef.displayClass();
		}
	}

	class A {
		public void displayClass() {
			System.out.println("Inside super class A");
		}
	}

	class B extends A {
		public void displayClass() {
			System.out.println("Inside sub class B");
		}
	}

	class C extends A {
		public void displayClass() {
			System.out.println("Inside sub class C");
		}
	}

	interface D {
		public void displayClass();
	}

	class M implements D {
		public void displayClass() {
			System.out.println("Inside super class A");
		}
	}

	class BoundAnd<T extends M & D> {

		private T objRef;

		public BoundAnd(T obj) {
			this.objRef = obj;
		}

		public void doRunTest() {
			this.objRef.displayClass();
		}
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {

		// Creating object of sub class C and
		// passing it to Bound as a type parameter.
		Bound<C> bec = new Bound<C>(new C());
		bec.doRunTest();

		// Creating object of sub class B and
		// passing it to Bound as a type parameter.
		Bound<B> beb = new Bound<B>(new B());
		beb.doRunTest();

		// similarly passing super class A
		Bound<A> bea = new Bound<A>(new A());
		bea.doRunTest();

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// Creating object of sub class A and
		// passing it to Bound as a type parameter.
		BoundAnd<M> bea = new BoundAnd<M>(new M());
		bea.doRunTest();

	}
	// determines the largest of three Comparable objects

	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x; // assume x is initially the largest

		if (y.compareTo(max) > 0) {
			max = y; // y is the largest so far
		}

		if (z.compareTo(max) > 0) {
			max = z; // z is the largest now
		}
		return max; // returns the largest object
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

		System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
				maximum("pear", "apple", "orange"));

	}

	public static <T extends Number & Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;
		if (y.compareTo(max) > 0) {
			max = y;
		}

		if (z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}

	// Compiler throws error in case of below declaration
	/*
	 * public static <T extends Comparable<T> & Number> T maximum1(T x, T y, T
	 * z) { T max = x; if(y.compareTo(max) > 0) { max = y; }
	 * 
	 * if(z.compareTo(max) > 0) { max = z; } return max; }
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		System.out.printf("Max of %d, %d and %d is %d\n\n", 3, 4, 5, maximum(3, 4, 5));

		System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

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
