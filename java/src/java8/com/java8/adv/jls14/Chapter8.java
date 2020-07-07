package com.java8.adv.jls14;

import java.io.RandomAccessFile;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.frameworks.base.ITemplateMethod;
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

public class Chapter8 extends TemplateMethod implements ITemplateMethod {

	public static int m;
	static {
		k = m;
	}
	public static int k;

	public static void main(String[] args) {
		new Chapter8().runTemplateMethod(args);
	}

	interface Frob {
		float v = 2.0f;
	}

	class SuperTest {
		int v = 3;
	}

	@Target({ ElementType.TYPE })
	@interface A1 {
	}

	class Test extends SuperTest implements Frob {
		void printV() {
			System.out.println((super.v + Frob.v) / 2);
		}
	}

	interface Color {
		int RED = 0, GREEN = 1, BLUE = 2;
	}

	interface TrafficLight {
		int RED = 0, YELLOW = 1, GREEN = 2;
	}

	class TestColor implements Color, TrafficLight {
		public void main(String[] args) {
			System.out.println(GREEN); // compile-time error
			System.out.println(Color.GREEN);
			System.out.println(RED);// compile-time error
			System.out.println(TrafficLight.RED);
		}
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		new Test().printV();

	}

	class Test1 {
		int i = j;
		// compile-time error:
		// incorrect forward reference
		int j = 1;
	}

	static {
		// x=100;
		// int k=x+1;
		int v = x = 3;
	}
	static int x;

	@Override
	public void implementionTwo(String[] args) throws Exception {

	}

	class TestParameter {
		TestParameter(/* ?? ?? */) {
		}

		// No receiver parameter is permitted in the constructor of
		// a top level class, as there is no conceivable type or name.
		void m(TestParameter this) {
		}

		// OK: receiver parameter in an instance method
		static void n(TestParameter this) {
		}

		// Illegal: receiver parameter in a static method
		class A {
			A(TestParameter TestParameter.this) {
			}

			// OK: the receiver parameter represents the instance
			// of Test which immediately encloses the instance
			// of A being constructed.
			void m(A this) {
			}

			// OK: the receiver parameter represents the instance
			// of A for which A.m() is invoked.
			class B {
				B(TestParameter.A A.this) {
				}

				// OK: the receiver parameter represents the instance
				// of A which immediately encloses the instance of B
				// being constructed.
				void m(TestParameter.A.B this) {
				}
				// OK: the receiver parameter represents the instance
				// of B for which B.m() is invoked.
			}
		}
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		new TestParameter().m();

	}

	class CollectionConverter {
		<T> List<T> toList(Collection<T> c) {
			return null;
		}
	}

	class Overrider extends CollectionConverter {
		List toList(Collection c) {
			return null;
		}
	}

	interface I1 {
		int foo();
	}

	interface I2 {
		int foo();
	}

	abstract class Test12 implements I1, I2 {
	}

	class concreteTest12 extends Test12 {

		@Override
		public int foo() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		I1 i1 = new concreteTest12();
		I2 i2 = new concreteTest12();
		logger.debug(i1.foo());
		logger.debug(i2.foo());

	}

	int pitch() {
		throw new RuntimeException("90 mph?!");
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		pitch();

	}

	class C<T> {
		T id(T x) {
			return x;
		}
	}

	interface I<T> {
		T id(T x);
	}

	class D extends C<Integer> implements I<Integer> {
		public String id(String x) {
			return x;
		}

		@Override
		public Integer id(Integer x) {
			// TODO Auto-generated method stub
			return null;
		}

		// public Integer id(Integer x) {return x;}
	}

	class Point {
		float x, y;
		public static final int M = 10;
		public static float ML = 10;

		void move(int dx, int dy) {
			x += dx;
			y += dy;
		}

		void move(float dx, float dy) {
			x += dx;
			y += dy;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	class Employee {
		String data;

		public <T> Employee(T data) {
			this.data = data.toString();
		}

		public void dsplay() {
			System.out.println("value: " + this.data);
		}
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		Employee emp1 = new Employee("Raju");
		emp1.dsplay();
		Employee emp2 = new Employee(12548);
		emp2.dsplay();

	}

	public class GenericMethod {
		<T> void sampleMethod(T[] array) {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);
			}
		}

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		GenericMethod obj = new GenericMethod();
		Integer intArray[] = { 45, 26, 89, 96 };
		obj.sampleMethod(intArray);
		String stringArray[] = { "Krishna", "Raju", "Seema", "Geeta" };
		obj.sampleMethod(stringArray);

	}

	class Student<T> {
		T age;

		Student(T age) {
			this.age = age;
		}

		public void display() {
			System.out.println("Value of age: " + this.age);
		}
	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		Student<Float> std1 = new Student<Float>(25.5f);
		std1.display();
		Student<String> std2 = new Student<String>("25");
		std2.display();
		Student<Integer> std3 = new Student<Integer>(25);
		std3.display();

	}

	class Outer {
		class Inner {
		}
	}

	class ChildOfInner extends Outer.Inner {
		ChildOfInner(Outer x) {
			x.super();
			// (new Outer()).super();
		}
	}

	enum ColorType {
		RED, GREEN, BLUE;
		ColorType() {
			colorMap.put(toString(), this);
		}

		static final Map<String, ColorType> colorMap = new HashMap<String, ColorType>();
		static {
			for (ColorType c : ColorType.values())
				colorMap.put(c.toString(), c);
		}
	}

	enum Season {
		WINTER, SPRING, SUMMER, FALL
	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		for (Season s : Season.values())
			System.out.println(s);
	}

	public enum Operation {
		PLUS {
			double eval(double x, double y) {
				return x + y;
			}
		},
		MINUS {
			double eval(double x, double y) {
				return x - y;
			}
		},
		TIMES {
			double eval(double x, double y) {
				return x * y;
			}
		},
		DIVIDED_BY {
			double eval(double x, double y) {
				return x / y;
			}
		};
		// Each constant supports an arithmetic operation
		abstract double eval(double x, double y);
	};

	strictfp class TestS {
		// all concrete methods here are
		// implicitly strictfp.
		public float getFloat() {
			return 100e12f;
		}
	}

	strictfp interface TestI {
		// all methods here becomes implicitly
		// strictfp when used during inheritance.
	}

	/*
	 * When a class or an interface is declared with strictfp modifier, then all
	 * methods declared in the class/interface, and all nested types declared in
	 * the class, are implicitly strictfp.
	 * 
	 * 
	 * strictfp cannot be used with abstract methods. However, it can be used
	 * with abstract classes/interfaces. Since methods of an interface are
	 * implicitly abstract, strictfp cannot be used with any method inside an
	 * interface.
	 * 
	 * 
	 * strictfp interface Test {
	 * 
	 * double sum();
	 * 
	 * strictfp double mul();
	 * 
	 * //compile-time error here
	 * 
	 * }
	 */
	@Override
	public void implementionTen(String[] args) throws Exception {
		double x = Double.parseDouble("10000d");
		double y = Double.parseDouble("50000d");
		for (Operation op : Operation.values())
			System.out.println(x + " " + op + " " + y + " = " + op.eval(x, y));

	}

	// calculating sum using strictfp modifier
	public strictfp double sum() {
		double num1 = 10e+10;

		double num2 = 6e+08;

		return (num1 + num2);

	}

	public static strictfp void main1(String[] args) {
		Chapter8 t = new Chapter8();

		System.out.println(t.sum());
	}

	interface BaseColors {
		int RED = 1, GREEN = 2, BLUE = 4;
	}

	interface RainbowColors extends BaseColors {
		int YELLOW = 3, ORANGE = 5, INDIGO = 6, VIOLET = 7;
	}

	interface PrintColors extends BaseColors {
		int YELLOW = 8, CYAN = 16, MAGENTA = 32;
	}

	interface LotsOfColors extends RainbowColors, PrintColors {
		int FUCHSIA = 17, VERMILION = 43, CHARTREUSE = RED + 90;
	}

	@Override
	public void implementorOne(String[] args) throws Exception {
		// logger.debug(LotsOfColors.YELLOW);
		logger.debug(LotsOfColors.CYAN);

	}

	public interface Sorter {

		public static <T extends Comparable<T>> void sort(T[] array) {

		};

		public default int getInt() {
			return 10;
		};

	}

	public class Foo {

		public boolean equals(Foo foo) {

			return true;

		}

	}

	@Override
	public void implementorTwo(String[] args) throws Exception {
		Object foo = new Foo();

		Object identicalFoo = new Foo();

		System.out.println(foo.equals(identicalFoo)); // false

	}

	@Override
	public void implementorThree(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorFive(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorSix(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
}
