package com.java8.adv.jls14;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java.frameworks.base.ExtendTemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Chapter10 extends ExtendTemplateMethod {
	public static void main(String[] args) {
		new Chapter10().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		int[] ia = new int[101];
		for (int i = 0; i < ia.length; i++)
			ia[i] = i;
		int sum = 0;
		for (int e : ia)
			sum += e;
		System.out.println(sum);
		// short , byte , or char values may also be
		// used as index values
		byte s = 5;
		int index = 5;
		System.out.println(ia[s]);
	}

	class Point {
		int x, y;
	}

	class ColoredPoint extends Point {
		int color;
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		ColoredPoint[] cpa = new ColoredPoint[10];
		Point[] pa = cpa;
		System.out.println(pa[1] == null);
		try {
			// cpa[0] = new Point();
			pa[0] = new Point();
			pa[0] = new ColoredPoint();
		} catch (ArrayStoreException e) {
			System.out.println(e);
		}
		// ColoredPoint cp=new Point();
		Point p = new ColoredPoint();
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		int ia[][] = { { 1, 2 }, null };
		for (int[] ea : ia) {
			for (int e : ea) {
				System.out.println(e);
			}
		}

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		List<? extends Number> list = Arrays.asList(182, 834939f, 21423.545d);
		list.forEach((item) -> {
			logger.debug(item);
		});
	}

	class A<T> implements Cloneable, java.io.Serializable {
		public final int length = 10;

		public T[] clone() {
			try {
				return (T[]) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new InternalError(e.getMessage());
			}
		}
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		int ia1[] = { 1, 2 };
		int ia2[] = ia1.clone();
		System.out.print((ia1 == ia2) + " ");
		ia1[1]++;
		System.out.println(ia2[1]);

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		int ia[][] = { { 1, 2 }, null };
		int ja[][] = ia.clone();
		System.out.print((ia == ja) + " ");
		System.out.println(ia[0] == ja[0] && ia[1] == ja[1]);

	}

	/***
	 * Although an array type is not a class, the Class object of every array
	 * acts as if:
	 * 
	 * 
	 * • The direct superclass of every array type is Object .
	 * 
	 * • Every array type implements the interfaces Cloneable and
	 * java.io.Serializable .
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		int[] ia = new int[3];
		System.out.println(ia.getClass());
		System.out.println(ia.getClass().getSuperclass());
		for (Class<?> c : ia.getClass().getInterfaces())
			System.out.println("Superinterface: " + c);

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		int[] ia = new int[3];
		int[] ib = new int[6];
		System.out.println(ia == ib);
		System.out.println((ia.getClass() == ib.getClass()) + ":"
				+ ib.getClass());

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		String s = "public void implementionNine(String[] args) throws Exception {";

		for (char strTemp : s.toCharArray()) {

			System.out.println(strTemp);

		}

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		try {
			throw new FileNotFoundException();
		} catch (IOException ioe) {
			// "catch IOException" catches IOException
			// and any subtype.
			ioe.printStackTrace();
		}
		try {
			throw new FileNotFoundException();
			// Statement "can throw" FileNotFoundException.
			// It is not the case that statement "can throw"
			// a subtype or supertype of FileNotFoundException.
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			// ... Handle exception ...
		} catch (IOException ioe) {
			// Legal, but compilers are encouraged to give
			// warnings as of Java SE 7, because all subtypes of
			// IOException that the try block "can throw" have
			// already been caught by the prior catch clause.
		}
		try {
			m();
			// m's declaration says "throws IOException", so
			// m "can throw" IOException. It is not the case
			// that m "can throw" a subtype or supertype of
			// IOException (e.g. Exception).
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			// Legal, because the dynamic type of the exception
			// might be FileNotFoundException.
		} catch (IOException ioe) {
			// Legal, because the dynamic type of the exception
			// might be a different subtype of IOException.
		} catch (Throwable t) {
			// Can always catch Throwable.
		}

	}

	static void m() throws IOException {
		throw new FileNotFoundException();
	}

	@Override
	public void implementionEleven(String[] args) throws Exception {
		Integer[][] a1 = { // Autoboxing
		{ 1, 2, 3, }, { 4, 5, 6, }, };
		Double[][][] a2 = { // Autoboxing
		{ { 1.1, 2.2 }, { 3.3, 4.4 } }, { { 5.5, 6.6 }, { 7.7, 8.8 } },
				{ { 9.9, 1.2 }, { 2.3, 3.4 } }, };
		String[][] a3 = { { "The", "Quick", "Sly", "Fox" },
				{ "Jumped", "Over" },
				{ "The", "Lazy", "Brown", "Dog", "and", "friend" }, };
		System.out.println("a1: " + Arrays.deepToString(a1));
		System.out.println("a2: " + Arrays.deepToString(a2));
		System.out.println("a3: " + Arrays.deepToString(a3));
		/*
		 * Output: a1: [[1, 2, 3], [4, 5, 6]] a2: [[[1.1, 2.2], [3.3, 4.4]],
		 * [[5.5, 6.6], [7.7, 8.8]], [[9.9, 1.2], [2.3, 3.4]]] a3: [[The, Quick,
		 * Sly, Fox], [Jumped, Over], [The, Lazy, Brown, Dog, and, friend]]
		 */// :~
	}

	public class ArrayOfGenericType<T> {
		T[] array; // OK

		@SuppressWarnings("unchecked")
		public ArrayOfGenericType(int size) {
			// ! array = new T[size]; // Illegal
			array = (T[]) new Object[size]; // "unchecked" Warning
		}
		// Illegal:
		// ! public <U> U[] makeArray() { return new U[10]; }
	} // /:~

	@Override
	public void implementionTwelve(String[] args) throws Exception {
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[]) la; // "Unchecked" warning
		ls[0] = new ArrayList<String>();
		// Compile-time checking produces an error:
		// ! ls[1] = new ArrayList<Integer>();

		// The problem: List<String> is a subtype of Object
		Object[] objects = ls; // So assignment is OK
		// Compiles and runs without complaint:
		objects[1] = new ArrayList<Integer>();

		// However, if your needs are straightforward it is
		// possible to create an array of generics, albeit
		// with an "unchecked" warning:
		List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
		for (int i = 0; i < spheres.length; i++)
			spheres[i] = new ArrayList<BerylliumSphere>();

	}

	static class BerylliumSphere {
		private static long counter;
		private final long id = counter++;

		public String toString() {
			return "Sphere " + id;
		}
	}

	@Override
	public void implementionThirteen(String[] args) throws Exception {
		// Arrays of objects:
		BerylliumSphere[] a; // Local uninitialized variable
		BerylliumSphere[] b = new BerylliumSphere[5];
		// The references inside the array are
		// automatically initialized to null:
		com.java8.adv.jls14.Print.print("b: " + Arrays.toString(b));
		BerylliumSphere[] c = new BerylliumSphere[4];
		for (int i = 0; i < c.length; i++)
			if (c[i] == null) // Can test for null reference
				c[i] = new BerylliumSphere();
		// Aggregate initialization:
		BerylliumSphere[] d = { new BerylliumSphere(), new BerylliumSphere(),
				new BerylliumSphere() };
		// Dynamic aggregate initialization:
		a = new BerylliumSphere[] { new BerylliumSphere(),
				new BerylliumSphere(), };
		// (Trailing comma is optional in both cases)
		com.java8.adv.jls14.Print.print("a.length = " + a.length);
		com.java8.adv.jls14.Print.print("b.length = " + b.length);
		com.java8.adv.jls14.Print.print("c.length = " + c.length);
		com.java8.adv.jls14.Print.print("d.length = " + d.length);
		a = d;
		com.java8.adv.jls14.Print.print("a.length = " + a.length);

		// Arrays of primitives:
		int[] e; // Null reference
		int[] f = new int[5];
		// The primitives inside the array are
		// automatically initialized to zero:
		com.java8.adv.jls14.Print.print("f: " + Arrays.toString(f));
		int[] g = new int[4];
		for (int i = 0; i < g.length; i++)
			g[i] = i * i;
		int[] h = { 11, 47, 93 };
		// Compile error: variable e not initialized:
		// !print("e.length = " + e.length);
		com.java8.adv.jls14.Print.print("f.length = " + f.length);
		com.java8.adv.jls14.Print.print("g.length = " + g.length);
		com.java8.adv.jls14.Print.print("h.length = " + h.length);
		e = h;
		com.java8.adv.jls14.Print.print("e.length = " + e.length);
		e = new int[] { 1, 2 };
		com.java8.adv.jls14.Print.print("e.length = " + e.length);

	}

	/*
	 * Output: b: [null, null, null, null, null] a.length = 2 b.length = 5
	 * c.length = 4 d.length = 3 a.length = 3 f: [0, 0, 0, 0, 0] f.length = 5
	 * g.length = 4 h.length = 3 e.length = 3 e.length = 2
	 */// :~
	class Array<E> {
		private final Object[] obj_array; // object array
		public final int length;

		// class constructor
		public Array(int length) {
			// instantiate a new Object array of specified length
			obj_array = new Object[length];
			this.length = length;
		}

		// get obj_array[i]
		E get(int i) {
			@SuppressWarnings("unchecked")
			final E e = (E) obj_array[i];
			return e;
		}

		// set e at obj_array[i]
		void set(int i, E e) {
			obj_array[i] = e;
		}

		@Override
		public String toString() {
			return Arrays.toString(obj_array);
		}
	}

	/***
	 * Using Object Array
	 * 
	 * This approach uses the array of type Objects as a member of the main
	 * array class. We also use get/set methods to read and set the array
	 * elements. Then, we instantiate the main array class that allows us to
	 * provide the data type as required.
	 * 
	 * This simulates the generic array.
	 * 
	 * The following program demonstrates the use of object array to create a
	 * Generic array-like structure.
	 */
	@Override
	public void implementionFourteen(String[] args) throws Exception {
		final int length = 5;
		// creating integer array
		Array<Integer> int_Array = new Array(length);
		System.out.print("Generic Array <Integer>:" + " ");
		for (int i = 0; i < length; i++)
			int_Array.set(i, i * 2);
		System.out.println(int_Array);
		// creating string array
		Array<String> str_Array = new Array(length);
		System.out.print("Generic Array <String>:" + " ");
		for (int i = 0; i < length; i++)
			str_Array.set(i, String.valueOf((char) (i + 97)));
		System.out.println(str_Array);

	}

	/***
	 * Using Reflection
	 * 
	 * In this approach, we use a reflection class to create a generic array
	 * whose type will be known only at runtime.
	 * 
	 * The approach is similar to the previous one with just one difference i.e.
	 * we use reflection class in the constructor itself to instantiate an
	 * object array by explicitly passing the data type information to the class
	 * constructor.
	 * 
	 * This type of information is passed to the Array.newInstance method of
	 * reflection.
	 * 
	 * The following program shows the usage of reflection to create a generic
	 * array. Note that the entire program structure is similar to the previous
	 * approach with just the difference in the usage of reflection features.
	 */
	@Override
	public void implementionFifteen(String[] args) throws Exception {
		final int length = 5;
		// create array with Integer as data type
		ArrayReflection<Integer> int_Array = new ArrayReflection(Integer.class,
				length);
		System.out.print("Generic Array<Integer>:" + " ");
		for (int i = 0; i < length; i++)
			int_Array.set(i, i + 10);
		System.out.println(int_Array);
		// create an array with String as data type
		ArrayReflection<String> str_Array = new ArrayReflection(String.class,
				length);
		System.out.print("Generic Array<String>:" + " ");
		for (int i = 0; i < length; i++)
			str_Array.set(i, String.valueOf((char) (i + 65)));
		System.out.println(str_Array);

	}

	class ArrayReflection<E> {
		private final E[] objArray;
		public final int length;

		// class constructor
		public ArrayReflection(Class<E> dataType, int length) {
			// create a new array with the specified data type and length at
			// runtime using reflection
			this.objArray = (E[]) java.lang.reflect.Array.newInstance(dataType,
					length);
			this.length = length;
		}

		// get element at objArray[i]
		E get(int i) {
			return objArray[i];
		}

		// assign e to objArray[i]
		void set(int i, E e) {
			objArray[i] = e;
		}

		@Override
		public String toString() {
			return Arrays.toString(objArray);
		}
	}

	// The following program shows a demonstration of using wildcards.
	// generic array class
	class Arr<T> {
		T tarray[];

		Arr(T myarray[]) {
			tarray = myarray;
		}

		@Override
		public String toString() {
			return Arrays.toString(tarray);
		}
	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		// Arr<Integer>tarray[] = new Arr<Integer>[5]; //error: generic array
		// creation

		// initialize new array objects
		Arr<Integer> arr1 = new Arr<Integer>(new Integer[] { 2, 4, 6, 8, 10 });
		System.out.print("Array with Integer type:" + " ");
		System.out.println(arr1);

		Arr<String> arr2 = new Arr<String>(new String[] { "aa", "bb", "cc",
				"dd" });
		System.out.print("Array with String type:" + " ");
		System.out.println(arr2);

		// define array objects using wildcard
		Arr<?> arr3[] = new Arr<?>[5];

		arr3[0] = new Arr<Integer>(new Integer[] { 10, 20, 30, 40, 50 });
		System.out.println("Integer array: " + arr3[0]);

		arr3[1] = new Arr<Float>(new Float[] { 1.1f, 2.2f, 3.3f, 4.4f, 5.5f });
		System.out.println("Float array: " + arr3[1]);
	}

	/***
	 * Why is Generic Array Creation not Allowed in Java?
	 */
	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		// To understand this topic let us directly start with an example.
		List<Integer> arrayOfIntegerList[] = new ArrayList<>[10];
		// compile time error !!
		Object objectArray[] = new Integer[10];
		// it will work fine
		// Invariant: It means you cannot assign subclass type generic to its
		// super class generic reference because in generics any two distinct
		// types are neither a subtype nor a supertype. For instance,

		List<Object> objectList = new ArrayList<Integer>(); // won't compile

		// Let us consider the following example to understand that:-

		// 1)
		List<Integer> arrayOfIdList[] = new ArrayList<Integer>[10];
		// Suppose generic array creation is legal.
		// 2)
		List<String> nameList = new ArrayList<String>();
		// 3)
		Object objArray[] = arrayOfIdList;
		// that is allowed because arrays are covariant
		// 4)
		objArray[0] = nameList;
		// 5)
		Integer id = objArray[0].get(0);
		/*
		 * As we assumed generic array creation is legal, so line 1 is valid and
		 * creates an array of ID List.
		 * 
		 * In line 2, we have created a simple list of string.
		 * 
		 * In line 3, we passed an arrayOfIdList object to objArray reference,
		 * which is legal because arrays are covariant.
		 * 
		 * In line 4, we have assigned nameList (i.e. the list of string) into
		 * objArray that is pointing to the arrayOfIdList object. It is alright
		 * because of Type Erasure, means the runtime instance of List<String>
		 * is List and List<Integer> arrayOfIdList[] is list[], so this will not
		 * generate any exception. Here comes the biggest problem, we have
		 * assigned the list of string (i.e., List<String>) into an array that
		 * can only contain the list of integer.
		 * 
		 * In line 5, mistakenly, we are trying to get the first element of the
		 * 0th element of an array. As arrayOfIdList declared as an array of
		 * integer list, the compiler will cast that assignment to Integer which
		 * will generate ClassCastException at runtime.
		 * 
		 * Here one of the major purposes of generic is failed (i.e., compile
		 * time strict type checking.) Therefore, to address this problem
		 * compile time error gets generated at line 1.
		 */

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
