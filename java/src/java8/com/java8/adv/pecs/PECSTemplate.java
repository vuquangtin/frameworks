package com.java8.adv.pecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.java.frameworks.base.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 * @see https://www.hellojava.com/a/53806.html
 *
 */
public class PECSTemplate extends TemplateMethod {

	public static void main(String[] args) {
		new PECSTemplate().runTemplateMethod(args);

	}

	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
		for (Number num : nums)
			s += num.doubleValue();
		return s;
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		logger.debug(sum(ints) == 6.0);
		List<Double> doubles = Arrays.asList(2.78, 3.14);
		logger.debug(sum(doubles) == 5.92);
		List<Number> nums = Arrays.<Number> asList(1, 2, 2.78, 3.14);
		logger.debug(sum(nums) == 8.92);

	}

	/**
	 * Since, sum() method uses extends, all of the following calls are legal.
	 * The first two calls would not be legal if extends was not used.
	 * 
	 * EXCEPTION : You cannot put anything into a type declared with an extends
	 * wildcard—except for the value null, which belongs to every reference
	 * type:
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		nums.add(null); // ok
		// nums.add(10);
		assert nums.toString().equals("[1, 2, null]");

	}

	/**
	 * For Super Wildcard(put values i.e Consumer super)
	 * 
	 * Here is a method, that takes a collection of numbers and an int n, and
	 * puts the first n integers, starting from zero, into the collection:
	 * 
	 */
	public static void count(Collection<? super Integer> ints, int n) {
		for (int i = 0; i < n; i++)
			ints.add(i);
	}

	/**
	 * Let's call the method :
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		List<Integer> ints = new ArrayList<Integer>();
		count(ints, 5);
		assert ints.toString().equals("[0, 1, 2, 3, 4]");
		List<Number> nums = new ArrayList<Number>();
		count(nums, 5);
		nums.add(5.0);
		assert nums.toString().equals("[0, 1, 2, 3, 4, 5.0]");
		List<Object> objs = new ArrayList<Object>();
		count(objs, 5);
		objs.add("five");
		assert objs.toString().equals("[0, 1, 2, 3, 4, five]");

	}

	/**
	 * Since, count() method uses super, all of the following calls are legal:
	 * The last two calls would not be legal if super was not used.
	 * 
	 * EXCEPTION : you cannot get anything out from a type declared with a super
	 * wildcard—except for a value of type Object, which is a supertype of every
	 * reference type:
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		List<Object> objs = Arrays.<Object> asList(1, "two");
		List<? super Integer> ints = objs;
		String str = "";
		for (Object obj : ints)
			str += obj.toString();
		assert str.equals("1two");

	}

	/**
	 * When both Get and Put, don't Use wildcard
	 * 
	 * Whenever you both put values into and get values out of the same
	 * structure, you should not use a wildcard.
	 */
	public static double sumCount(Collection<Number> nums, int n) {
		count(nums, n);
		return sum(nums);
	}

	public class Test {

		public class A {
		}

		public class B extends A {
		}

		public class C extends B {
		}

		public void testCoVariance(List<? extends B> myBlist) {
			B b = new B();
			C c = new C();
			myBlist.add(b); // does not compile
			myBlist.add(c); // does not compile
			A a = myBlist.get(0);
		}

		public void testContraVariance(List<? super B> myBlist) {
			B b = new B();
			C c = new C();
			myBlist.add(b);
			myBlist.add(c);
			A a = myBlist.get(0); // does not compile
		}
	}

	class Shape {
		void draw() {
		}
	}

	class Circle extends Shape {
		void draw() {
		}
	}

	class Square extends Shape {
		void draw() {
		}
	}

	class Rectangle extends Shape {
		void draw() {
		}
	}

	public class TestContraVariance {
		/*
		 * Example for an upper bound wildcard (Get values i.e Producer
		 * `extends`)
		 */

		public void testCoVariance(List<? extends Shape> list) {
			list.add(new Shape()); // Error: is not applicable for the arguments
									// (Shape) i.e. inheritance is not
									// supporting
			list.add(new Circle()); // Error: is not applicable for the
									// arguments (Circle) i.e. inheritance is
									// not supporting
			list.add(new Square()); // Error: is not applicable for the
									// arguments (Square) i.e. inheritance is
									// not supporting
			list.add(new Rectangle()); // Error: is not applicable for the
										// arguments (Rectangle) i.e.
										// inheritance is not supporting
			Shape shape = list.get(0);// compiles so list act as produces only

			/*
			 * You can't add a Shape,Circle,Square,Rectangle to a List<? extends
			 * Shape> You can get an object and know that it will be an Shape
			 */
		}

		/*
		 * Example for a lower bound wildcard (Put values i.e Consumer`super`)
		 */
		public void testContraVariance(List<? super Shape> list) {
			list.add(new Shape());// compiles i.e. inheritance is supporting
			list.add(new Circle());// compiles i.e. inheritance is supporting
			list.add(new Square());// compiles i.e. inheritance is supporting
			list.add(new Rectangle());// compiles i.e. inheritance is supporting
			Shape shape = list.get(0); // Error: Type mismatch, so list acts
										// only as consumer
			Object object = list.get(0); // gets an object, but we don't know
											// what kind of Object it is.

			/*
			 * You can add a Shape,Circle,Square,Rectangle to a List<? extends
			 * Shape> You can't get an Shape(but can get Object) and don't know
			 * what kind of Shape it is.
			 */
		}
	}

	// copy Integer (? extends T) to its supertype (Number is super of Integer)
	private static <T> void copyElements2(Collection<? extends T> src,
			Collection<? super T> dest) {
		for (T n : src) {
			dest.add(n);
		}
	}

	static <T> void copyElements1(Collection<T> src, Collection<T> dest) {
		for (T n : src) {
			dest.add(n);
		}
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		// Source
		List<Integer> intList = Arrays.asList(1, 2, 3);
		List<Double> doubleList = Arrays.asList(2.78, 3.14);
		List<Number> numList = Arrays.asList(1, 2, 2.78, 3.14, 5);

		// Destination
		List<Integer> intList2 = new ArrayList<>();
		List<Double> doublesList2 = new ArrayList<>();
		List<Number> numList2 = new ArrayList<>();

		// Works
		copyElements1(intList, intList2); // from int to int
		copyElements1(doubleList, doublesList2); // from double to double

		// Let's try to copy intList to its supertype
		copyElements1(intList, numList2); // error, method signature just says
											// "T"
											// and here the compiler is given
											// two types: Integer and Number,
											// so which one shall it be?

		// PECS to the rescue!
		copyElements2(intList, numList2); // possible

	}

	class Creature {
	}// X

	class Animal extends Creature {
	}// Y

	class Fish extends Animal {
	}// Z

	class Shark extends Fish {
	}// A

	class HammerSkark extends Shark {
	}// B

	class DeadHammerShark extends HammerSkark {
	}// C

	@Override
	public void implementionSix(String[] args) throws Exception {
		List<? extends Shark> sharks = new ArrayList<>();
		sharks.add(new HammerShark());// will result in compilation error

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		List<? super Shark> sharks = new ArrayList<>();
		sharks.add(new Shark());
		sharks.add(new DeadHammerShark());
		sharks.add(new HammerSkark());

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		List<String> strings = new ArrayList<>();
		strings.add("Hello");
		strings.add("World");
		// strings.add(new Date()); // won't compile
		// Integer i = strings.get(0); // won't compile

		// for-each loop knows the contained data type is String
		for (String s : strings) {
			System.out.printf("%s has length %d%n", s, s.length());
		}

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
