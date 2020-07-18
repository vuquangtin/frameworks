package com.java8.adv.jls14;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import com.java.frameworks.base.ExtendTemplateMethod;
import com.java.frameworks.base.IExtendTemplateMethod;
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
public class Chapter15 extends ExtendTemplateMethod implements
		IExtendTemplateMethod {

	public static void main(String[] args) {
		new Chapter15().runTemplateMethod(args);

	}

	/****
	 * Evaluate Left-Hand Operand First
	 */

	@Override
	public void implementionOne(String[] args) throws Exception {
		int i = 2;
		int j = (i = 3) * i;
		logger.debug(j);
		/*
		 * This program produces the output: 9
		 */

	}

	/****
	 * Implicit Left-Hand Operand In Operator Of Compound Assigment
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		int a = 9;
		a += (a = 3); // first example
		logger.debug(a);
		int b = 9;
		b = b + (b = 3); // second example
		logger.debug(b);
		/*
		 * This program produces the output:
		 * 
		 * 12
		 * 
		 * 12
		 */

	}

	/****
	 * Abrupt Completion of Evaluation of the Left-Hand Operand
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		int j = 1;
		try {
			int i = forgetIt() / (j = 2);
		} catch (Exception e) {
			logger.debug(e);
			logger.debug("Now j = " + j);
		}

	}

	static int forgetIt() throws Exception {
		throw new Exception("I'm outta here!");
	}

	/****
	 * Evaluation of Operands Before Operation
	 * 
	 * since no part of the division operation, including signaling of a
	 * divide-by-zero exception, may appear to occur before the invocation of
	 * loseBig completes, even though the implementation may be able to detect
	 * or infer that the division operation would certainly result in a
	 * divide-by-zero exception
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		int divisor = 0;
		try {
			int i = 1 / (divisor * loseBig());
		} catch (Exception e) {
			logger.debug(e);
		}
		/*
		 * This program produces the output:
		 * 
		 * java.lang.Exception: Shuffle off to Buffalo!
		 * 
		 * and not:
		 * 
		 * java.lang.ArithmeticException: / by zero
		 */
	}

	static int loseBig() throws Exception {
		throw new Exception("Shuffle off to Buffalo!");
	}

	@Override
	public strictfp void implementionFive(String[] args) throws Exception {
		double d = 8e+307;
		logger.debug(4.0 * d * 0.5);
		logger.debug(2.0 * d);
		/*
		 * prints:
		 * 
		 * Infinity
		 * 
		 * 1.6e+308
		 * 
		 * because the first expression overflows and the second does not.
		 */

	}

	/****
	 * Argument Lists are Evaluated Left-to-Right
	 */
	static void print3(String a, String b, String c) {
		logger.debug(a + b + c);
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		String s = "going, ";
		print3(s, s, s = "gone");
		/*
		 * This program produces the output:
		 * 
		 * going, going, gone
		 * 
		 * because the assignment of the string " gone " to s occurs after the
		 * first two arguments to print3 have been evaluated.
		 */

	}

	/****
	 * Abrupt Completion of Argument Expression
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		try {
			test(id = 1, oops(), id = 3);
		} catch (Exception e) {
			logger.debug(e + ", id=" + id);
		}
		/*
		 * This program produces the output:
		 * 
		 * java.lang.Exception: oops, id=1
		 * 
		 * because the assignment of 3 to id is not executed.
		 */
	}

	static int id;

	static int test(int a, int b, int c) {
		return a + b + c;
	}

	static int oops() throws Exception {
		throw new Exception("oops");
	}

	static class List {
		int value;
		List next;
		static List head = new List(0);

		List(int n) {
			value = n;
			next = head;
			head = this;
		}
	}

	/****
	 * prints:
	 * 
	 * class java.lang.OutOfMemoryError, false
	 * 
	 * 
	 * because the out-of-memory condition is detected before the argument
	 * expression oldid = id is evaluated
	 */
	@Override
	public void implementionEight(String[] args) throws Exception {
		// int id = 0, oldid = 0;
		// try {
		// for (;;) {
		// ++id;
		// new List(oldid = id);
		// }
		// } catch (Error e) {
		// e.printStackTrace();
		// List.head = null;
		// logger.debug(e.getClass() + ", " + (oldid == id));
		// }

	}

	private static double[] mList;
	private static int mStart = 0;
	private static int mListSize = 9000000;
	private static int mThreshold = 10000;
	private static long mTime;
	private static Random mRandom;

	// this method is used to assign random values to the array called mList
	public static void sequentialArrayFilling(double[] mList) {
		// creating a Random object that generates a random double number when
		// invoked with .nextDouble() and assign
		// the random value to each element of the mList
		mRandom = new Random();
		for (int i = 0; i < mList.length; i++) {
			mList[i] = mRandom.nextDouble();
		}
	}

	// this method is used to assign random values to the array using the
	// fork/join framework by making
	// a new task and send the mList, 0 as the start, the list's size as an end
	// and a threshold defined above
	public static void parallelArrayFilling(double[] mList) {
		// creating a task object that extends the RecursiveAction class
		Task task = new Task(mList, mStart, mListSize, mThreshold);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		// assigning the task to the ForkJoinPool object
		forkJoinPool.invoke(task);
	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		mList = new double[mListSize];

		// gets the system's current time in milliseconds
		mTime = System.currentTimeMillis();
		// calling the sequential method with the mList as an argument
		sequentialArrayFilling(mList);
		// calculating the sequential elapsed time by subtracting the current
		// time - starting time
		logger.debug("Sequential Processing Time: "
				+ (System.currentTimeMillis() - mTime));
		mTime = System.currentTimeMillis();
		// calling the parallel method with the mList as an argument
		parallelArrayFilling(mList);
		// calculating the parallel elapsed time
		logger.debug("Parallel Processing Time: "
				+ (System.currentTimeMillis() - mTime));

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		Integer[] integerArray = { 5, 7, 8, 0 };

		// "Integer" is a wrapper class
		ArrayList<Integer> integerList = new ArrayList<>(
				Arrays.asList(integerArray));

	}

	@Override
	public void implementionEleven(String[] args) throws Exception {
		int[] arrayTask1 = { 1, 1, 0, 0, 1, 1, 0, 1 };
		reverseInt(arrayTask1);
		logger.debug("Заменить 0 на 1 и 1 на 0 в массиве. Результат: "
				+ Arrays.toString(arrayTask1));

		int[] arrayTask2 = new int[8];
		fillArray(arrayTask2);
		logger.debug("Заполнить массив. Результат: "
				+ Arrays.toString(arrayTask2));

		int[] arrayTask3 = { 1, 5, 3, 0, 11, 4, 5, 2, -4, 8, 9, 1 };
		updateArray(arrayTask3);
		logger.debug("Увеличить в 2 раза значения меньше 6. Результат: "
				+ Arrays.toString(arrayTask3));

		int arraySize = 9;
		int[][] arrayTask4 = createSquareArray(arraySize);
		System.out
				.println("Создать квадратный двумерный массив с 1 по диагонали. Размер массива = "
						+ arraySize);
		for (int i = 0; i < arraySize; i++) {
			logger.debug(Arrays.toString(arrayTask4[i]));
		}

		int[] arrayTask5 = { 1, 3, -66, 7, 10, 66, 5, 0, 3, 8, 66, 1 };
		logger.debug("Найти мин и макс в массиве. Результат: "
				+ getMaxAndMinValue(arrayTask5));

		int[] arrayTask6 = { 1, 0, -1, 1, 1, 2, -1, 1 };
		logger.debug("Есть точка баланса в массиве? "
				+ checkBalance(arrayTask6));

		int[] arrayTask7 = { 1, 5, 3, 7, 0, 44, -2, 11, -4 };
		int step = -2;
		shiftElements(arrayTask7, step);
		logger.debug("Сместить позицию элементов массива на " + step
				+ ". Результат: " + Arrays.toString(arrayTask7));

	}

	private static void reverseInt(int[] arrayInitial) {
		for (int i = 0; i < arrayInitial.length; i++) {
			if (arrayInitial[i] == 0) {
				arrayInitial[i] = 1;
			} else {
				arrayInitial[i] = 0;
			}
		}
	}

	private static void fillArray(int[] arrayInitial) {
		for (int i = 0; i < arrayInitial.length; i++) {
			arrayInitial[i] = i * 3;
		}
	}

	private static void updateArray(int[] arrayInitial) {
		for (int i = 0; i < arrayInitial.length; i++) {
			if (arrayInitial[i] < 6) {
				arrayInitial[i] *= 2;
			}
		}
	}

	private static int[][] createSquareArray(int size) {
		if (size < 0)
			return new int[0][0];
		int[][] arrayCreated = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j || (i + j == (size - 1))) {
					arrayCreated[i][j] = 1;
				}
			}
		}
		return arrayCreated;
	}

	private static String getMaxAndMinValue(int[] arrayInitial) {
		if (arrayInitial.length < 1)
			return "Массив пустой";
		int maxValue = arrayInitial[0];
		int minValue = arrayInitial[0];
		for (int i : arrayInitial) {
			if (i > maxValue) {
				maxValue = i;
			}
			if (i < minValue) {
				minValue = i;
			}
		}
		return "Max = " + maxValue + " Min = " + minValue;
	}

	private static boolean checkBalance(int[] arrayInitial) {
		int size = arrayInitial.length;
		if (size < 2)
			return false;
		for (int i = 0; i < (size - 1); i++) {
			int sumLeft = 0;
			int sumRight = 0;
			for (int j = 0; j <= i; j++) {
				sumLeft += arrayInitial[j];
			}
			for (int k = size - 1; k > i; k--) {
				sumRight += arrayInitial[k];
			}
			if (sumLeft == sumRight) {
				return true;
			}
		}
		return false;
	}

	private static void shiftElements(int[] arrayInitial, int step) {
		int size = arrayInitial.length;
		if (step < 0) {
			for (int i = 0; i < size; i++) {
				if (i - step < size) {
					arrayInitial[i] = arrayInitial[i - step];
				} else {
					arrayInitial[i] = 0;
				}
			}
		} else {
			for (int j = size - 1; j >= 0; j--) {
				if (j - step >= 0) {
					arrayInitial[j] = arrayInitial[j - step];
				} else {
					arrayInitial[j] = 0;
				}
			}
		}
	}

	@Override
	public void implementionTwelve(String[] args) throws Exception {
		testSingleInt();
		testSingleChar();
		testSingleShort();
		testSingleLong();
		testSingle();
		testMultiInt();
		testMulti();
		testAbstract();

		logger.debug("ReflectArrayTest passed");

	}

	static void testSingleInt() {
		Object intArray;

		intArray = Array.newInstance(Integer.TYPE, 2);

		int[] array = (int[]) intArray;
		array[0] = 5;
		Array.setInt(intArray, 1, 6);

		if (Array.getInt(intArray, 0) != 5)
			throw new RuntimeException();
		if (array[1] != 6)
			throw new RuntimeException();
		try {
			array[2] = 27;
			throw new RuntimeException("store should have failed");
		} catch (ArrayIndexOutOfBoundsException abe) {
		}
		try {
			Array.setInt(intArray, 2, 27);
			throw new RuntimeException("store should have failed");
		} catch (ArrayIndexOutOfBoundsException abe) {
		}
		if (array.length != Array.getLength(intArray) || array.length != 2) {
			throw new RuntimeException("bad len");
		}

		Integer x123 = Integer.valueOf(123);
		Integer x456 = Integer.valueOf(456);

		Array.set(intArray, 0, x123);
		Array.set(intArray, 1, x456);
		if (!Array.get(intArray, 0).equals(x123)
				|| !Array.get(intArray, 1).equals(x456)) {
			throw new RuntimeException("bad 123 or 456");
		}

		int[][] wrongArray;
		try {
			wrongArray = (int[][]) intArray;
			throw new RuntimeException("cast should have failed");
		} catch (ClassCastException cce) {
		}

		intArray = Array.newInstance(Integer.TYPE, 0);
		if (Array.getLength(intArray) != 0)
			throw new RuntimeException();
		logger.debug("ReflectArrayTest.testSingleInt passed");
	}

	static void testSingleChar() {
		Object charArray = Array.newInstance(Character.TYPE, 7);

		char[] array = (char[]) charArray;
		array[0] = '0';
		array[1] = 'W';
		array[2] = '2';
		array[3] = '3';
		array[4] = 'X';
		array[5] = '5';
		array[6] = '6';
		Array.setChar(charArray, 1, '1');
		Array.setChar(charArray, 4, '4');
		try {
			Array.setShort(charArray, 3, (short) 'Y');
			throw new RuntimeException("shouldn't allow short in char array");
		} catch (IllegalArgumentException iae) {
		}
		try {
			Array.setInt(charArray, 5, 'Z');
			throw new RuntimeException("shouldn't allow int in char array");
		} catch (IllegalArgumentException iae) {
		}

		try {
			for (int i = 0; i < array.length; i++) {
				if (Array.getInt(charArray, i) - '0' != i) {
					throw new RuntimeException("mismatch: " + i + " is "
							+ array[i]);
				}
			}

			if (Array.getInt(charArray, 4) != '4') {
				throw new RuntimeException("load should have worked");
			}
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}
		try {
			Array.getByte(charArray, 2);
			throw new RuntimeException("shouldn't allow read of char as byte");
		} catch (IllegalArgumentException iae) {
		}

		Array.setChar(charArray, 3, (char) 0xffff);
		try {
			if (Array.getInt(charArray, 3) != 0xffff) {
				throw new RuntimeException("char got sign-extended? "
						+ Array.getInt(charArray, 3));
			}
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		}

		logger.debug("ReflectArrayTest.testSingleChar passed");
	}

	static void testSingleShort() {
		Object shortArray = Array.newInstance(Short.TYPE, 1);
		Array.setShort(shortArray, 0, (short) -1);
		if (Array.getInt(shortArray, 0) != -1) {
			throw new RuntimeException("short didn't get sign-extended");
		}

		Short box = (Short) Array.get(shortArray, 0);

		logger.debug("ReflectArrayTest.testSingleShort passed");
	}

	static void testSingleLong() {
		Object longArray = Array.newInstance(Long.TYPE, 2);
		Array.setInt(longArray, 0, 123);
		Array.setLong(longArray, 1, 0x1122334455667788L);
		try {
			Array.getInt(longArray, 0);
			throw new RuntimeException("shouldn't allow read of long as int");
		} catch (IllegalArgumentException iae) {
		}

		long[] array = (long[]) longArray;
		if (array[0] != 123 || array[1] != 0x1122334455667788L) {
			throw new RuntimeException();
		}

		float f = Array.getFloat(longArray, 0);
		if (f < 122.9 || f > 123.1) {
			throw new RuntimeException("long-as-float failed - " + f);
		}
		if (Array.getLong(longArray, 1) != 0x1122334455667788L) {
			throw new RuntimeException("long1 failed");
		}

		logger.debug("ReflectArrayTest.testSingleLong passed");
	}

	static void testSingle() {
		Object strArray;

		strArray = Array.newInstance(String.class, 2);

		String[] array = (String[]) strArray;
		array[0] = "entry zero";
		Array.set(strArray, 1, "entry one");
		try {
			Array.set(strArray, 2, "entry two");
			throw new RuntimeException("store should have failed");
		} catch (ArrayIndexOutOfBoundsException abe) {
		}

		// logger.debug("array: " + array);

		if (!"entry zero".equals(Array.get(strArray, 0)))
			throw new RuntimeException();
		if (!"entry one".equals(array[1]))
			throw new RuntimeException();

		if (array.length != Array.getLength(strArray) || array.length != 2) {
			throw new RuntimeException("bad len");
		}

		try {
			Array.set(strArray, 0, new Integer(5));
			throw new RuntimeException("store of Integer should have failed");
		} catch (IllegalArgumentException iae) {
		}
		logger.debug("ReflectArrayTest.testSingle passed");
	}

	static void testMultiInt() {
		Object intIntIntArray;
		int[] dimensions = { 3, 2, 1 };

		intIntIntArray = Array.newInstance(Integer.TYPE, dimensions);
		int[][][] array3 = (int[][][]) intIntIntArray;

		array3[0][0][0] = 123; // trouble
		array3[2][1][0] = 456;

		try {
			array3[2][1][1] = 768;
			throw new RuntimeException("store should have failed");
		} catch (ArrayIndexOutOfBoundsException abe) {
		}
		logger.debug("ReflectArrayTest.testMultiInt passed");
	}

	static void testMulti() {
		Object strStrStrArray;
		int[] dimensions = { 1, 2, 3 };

		strStrStrArray = Array.newInstance(String.class, dimensions);
		String[][][] array3 = (String[][][]) strStrStrArray;

		array3[0][0][0] = "zero zero zero";
		array3[0][1][2] = "zero one two";

		try {
			array3[1][0][0] = "bad store";
			throw new RuntimeException("store should have failed");
		} catch (ArrayIndexOutOfBoundsException abe) {
		}

		try {
			String[][] array2 = (String[][]) strStrStrArray;
			throw new RuntimeException("expecting bad cast");
		} catch (ClassCastException cce) {
		}

		String[] strar = new String[4];
		strar[2] = "zero one two ++";
		array3[0][1] = strar;
		logger.debug(array3[0][1][2]);
		// logger.debug("array3: " + array3);

		int[] dimensions2 = { 1, 2 };
		strStrStrArray = Array.newInstance(String[].class, dimensions2);
		array3 = (String[][][]) strStrStrArray;

		array3[0][1] = new String[3];
		array3[0][1][2] = "zero one two";
		try {
			array3[1][0][0] = "bad store";
			throw new RuntimeException("store should have failed");
		} catch (ArrayIndexOutOfBoundsException abe) {
		}
		logger.debug("ReflectArrayTest.testMulti passed");
	}

	static void testAbstract() {
		Object arrayOfAbstractClasses = Array.newInstance(Number.class, 1);
		logger.debug(arrayOfAbstractClasses.getClass().toString()
				+ " modifiers: "
				+ arrayOfAbstractClasses.getClass().getModifiers());
		arrayOfAbstractClasses = Array.newInstance(Cloneable.class, 1);
		logger.debug(arrayOfAbstractClasses.getClass().toString()
				+ " modifiers: "
				+ arrayOfAbstractClasses.getClass().getModifiers());
		logger.debug("ReflectArrayTest.testAbstract passed");
	}

	@Override
	public void implementionThirteen(String[] args) throws Exception {
		int i = 4;
		int ia[][] = new int[i][i = 3];
		logger.debug("[" + ia.length + "," + ia[0].length + "]");

	}

	@Override
	public void implementionFourteen(String[] args) throws Exception {
		int[][] a = { { 00, 01 }, { 10, 11 } };
		int i = 99;
		try {
			a[val()][i = 1]++;
		} catch (Exception e) {
			logger.debug(e + ", i=" + i);
		}
		/*
		 * prints:
		 * 
		 * java.lang.Exception: unimplemented, i=99
		 * 
		 * because the embedded assignment that sets i to 1 is never executed.
		 */
		try {
			int m = a[1][i = 1]++;
			logger.info(m);
		} catch (Exception e) {
			logger.debug(e + ", i=" + i);
		}
	}

	static int val() throws Exception {
		throw new Exception("unimplemented");
	}

	@Override
	public void implementionFifteen(String[] args) throws Exception {
		float[][] matrix = new float[3][3];
		// is equivalent in behavior to:
		// float[][]
		matrix = new float[3][];
		for (int d = 0; d < matrix.length; d++)
			matrix[d] = new float[3];
		// and
		Age[][][][][] Aquarius = new Age[6][10][8][12][];
		// is equivalent to:
		// Age[][][][][]
		Aquarius = new Age[6][][][][];
		for (int d1 = 0; d1 < Aquarius.length; d1++) {
			Aquarius[d1] = new Age[10][][][];
			for (int d2 = 0; d2 < Aquarius[d1].length; d2++) {
				Aquarius[d1][d2] = new Age[8][][];
				for (int d3 = 0; d3 < Aquarius[d1][d2].length; d3++) {
					Aquarius[d1][d2][d3] = new Age[12][];
				}
			}
		}
	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		Age[][][][][] Aquarius = new Age[6][10][8][12][];
		Age[] Hair = { new Age("quartz"), new Age("topaz") };
		Aquarius[1][9][6][9] = Hair;

	}

	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		float triang[][] = new float[100][];
		for (int i = 0; i < triang.length; i++)
			triang[i] = new float[i + 1];

	}

	/****
	 * Example 15.10.2-3. OutOfMemoryError and Dimension Expression Evaluation
	 */
	@Override
	public void implementionEighteen(String[] args) throws Exception {
		int len = 0, oldlen = 0;
		Object[] a = new Object[0];
		try {
			for (;;) {
				++len;
				Object[] temp = new Object[oldlen = len];
				temp[0] = a;
				a = temp;
			}
		} catch (Error e) {
			logger.debug(e + ", " + (oldlen == len) + "--->" + oldlen);
		}

	}

	@Override
	public void implementionNineteen(String[] args) throws Exception {
		final Object[] a = new Object[10];

	}

	/****
	 * In an array access, the expression to the left of the brackets appears to
	 * be fully evaluated before any part of the expression within the brackets
	 * is evaluated. For example, in the (admittedly monstrous) expression
	 * a[(a=b)[3]] , the expression a is fully evaluated before the expression
	 * (a=b)[3] ; this means that the original value of a is fetched and
	 * remembered while the expression (a=b)[3] is evaluated. This array
	 * referenced by the original value of a is then subscripted by a value that
	 * is element 3 of another array (possibly the same array) that was
	 * referenced by b and is now also referenced by a .
	 */
	@Override
	public void implementionTwenty(String[] args) throws Exception {
		int[] a = { 11, 12, 13, 14 };
		int[] b = { 0, 1, 2, 3 };
		/****
		 * Mảng này được tham chiếu bởi giá trị ban đầu của a sau đó được đăng
		 * ký bởi một giá trị là phần tử 3 của một mảng khác (có thể là cùng một
		 * mảng) được tham chiếu bởi b và bây giờ cũng được tham chiếu bởi a.
		 */
		logger.debug(a[(a = b)[3]]);

		printArray(a);
		printArray(b);

	}

	void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}

	@Override
	public void implementorOne(String[] args) throws Exception {
		int[] a = { 11, 12, 13, 14 };
		int[] b = { 0, 1, 2, 3 };
		logger.debug(a[(a = b)[3]]);
		/*
		 * prints:
		 * 
		 * 14
		 * 
		 * because the monstrous expression's value is equivalent to a[b[3]] or
		 * a[3] or 14 .
		 */

	}

	@Override
	public void implementorTwo(String[] args) throws Exception {
		int index = 1;
		try {
			skedaddle()[index = 2]++;
		} catch (Exception e) {
			System.out.println(e + ", index=" + index);
		}

		/*
		 * prints:
		 * 
		 * java.lang.Exception: Ciao, index=1
		 * 
		 * because the embedded assignment of 2 to index never occurs.
		 */
	}

	static int[] skedaddle() throws Exception {
		throw new Exception("Ciao");
	}

	/***
	 * Example 15.10.4-3. null Array Reference
	 * 
	 * 
	 * If the array reference expression produces null instead of a reference to
	 * an array, then a NullPointerException is thrown at run time, but only
	 * after all parts of the array access expression have been evaluated and
	 * only if these evaluations completed normally. Thus, the program:
	 */
	@Override
	public void implementorThree(String[] args) throws Exception {
		int index = 1;
		try {
			nada()[index = 2]++;
		} catch (Exception e) {
			System.out.println(e + ", index=" + index);
		}
		/*
		 * prints:
		 * 
		 * java.lang.NullPointerException, index=2
		 * 
		 * because the embedded assignment of 2 to index occurs before the check
		 * for a null array reference expression
		 */
	}

	static int[] nada() {
		return null;
	}

	/*
	 * As a related example, the program:
	 */
	@Override
	public void implementorFour(String[] args) throws Exception {
		int[] a = null;
		try {
			int i = a[vamoose()];
			System.out.println(i);
		} catch (Exception e) {
			System.out.println(e);
		}
		// exit();
		/*
		 * always prints:
		 * 
		 * java.lang.Exception: Twenty-three skidoo!
		 * 
		 * A NullPointerException never occurs, because the index expression
		 * must be completely evaluated before any further part of the array
		 * access occurs, and that includes the check as to whether the value of
		 * the array reference expression is null .
		 */
	}

	static int vamoose() throws Exception {
		throw new Exception("Twenty-three skidoo!");
	}

	class S {
		int x = 0;
	}

	class T extends S {
		int x = 1;
	}

	@Override
	public void implementorFive(String[] args) throws Exception {
		T t = new T();
		System.out.println("t.x=" + t.x + when("t", t));
		S s = new S();
		System.out.println("s.x=" + s.x + when("s", s));
		s = t;
		System.out.println("s.x=" + s.x + when("s", s));
		// exit();
		/*
		 * This program produces the output:
		 * 
		 * t.x=1 when t holds a class T at run time.
		 * 
		 * s.x=0 when s holds a class S at run time.
		 * 
		 * s.x=0 when s holds a class T at run time.
		 */

	}

	static String when(String name, Object t) {
		return " when " + name + " holds a " + t.getClass() + " at run time.";
	}

	class SB {
		int x = 0;

		int z() {
			return x;
		}
	}

	class TB extends SB {
		int x = 1;

		int z() {
			return x;
		}
	}

	/***
	 * This lack of dynamic lookup for field accesses allows programs to be run
	 * efficiently with straightforward implementations. The power of late
	 * binding and overriding is available, but only when instance methods are
	 * used. Consider the same example using instance methods to access the
	 * fields:
	 */
	@Override
	public void implementorSix(String[] args) throws Exception {
		TB t = new TB();
		System.out.println("t.z()=" + t.z() + whenB("t", t));
		SB s = new SB();
		System.out.println("s.z()=" + s.z() + whenB("s", s));
		s = t;
		System.out.println("s.z()=" + s.z() + whenB("s", s));
		/*
		 * The last line shows that, indeed, the method that is accessed does
		 * depend on the run- time class of the referenced object; when s holds
		 * a reference to an object of class T , the expression s.z() refers to
		 * the z method of class T , despite the fact that the type of the
		 * expression s is S . Method z of class T overrides method z of class S
		 * .
		 */
		// exit();
		/*
		 * Now the output is:
		 * 
		 * t.z()=1 when t holds a class T at run time.
		 * 
		 * s.z()=0 when s holds a class S at run time.
		 * 
		 * s.z()=1 when s holds a class T at run time.
		 */
	}

	static String whenB(String name, Object t) {
		return " when " + name + " holds a " + t.getClass() + " at run time.";
	}

	/***
	 * Example 15.11.1-2. Receiver Variable Is Irrelevant For static Field
	 * Access
	 * 
	 * The following program demonstrates that a null reference may be used to
	 * access a class ( static ) variable without causing an exception:
	 */
	@Override
	public void implementorSeven(String[] args) throws Exception {
		System.out.println(favorite().mountain);
		/*
		 * It compiles, executes, and prints:
		 * 
		 * Mount Chocorua
		 */
		// exit();
	}

	static String mountain = "Chocorua";

	/****
	 * Even though the result of favorite() is null , a NullPointerException is
	 * not thrown. That " Mount " is printed demonstrates that the Primary
	 * expression is indeed fully evaluated at run time, despite the fact that
	 * only its type, not its value, is used to determine which field to access
	 * (because the field mountain is static ).
	 */
	static Chapter15 favorite() {
		System.out.print("Mount ");
		return null;
	}

	interface I {
		int x = 0;
	}

	class T1 implements I {
		int x = 1;
	}

	class T2 extends T1 {
		int x = 2;
	}

	class T3 extends T2 {
		int x = 3;

		void test() {
			System.out.println("x=\t\t" + x);
			System.out.println("super.x=\t\t" + super.x);
			System.out.println("((T2)this).x=\t" + ((T2) this).x);
			System.out.println("((T1)this).x=\t" + ((T1) this).x);
			System.out.println("((I)this).x=\t" + ((I) this).x);

		}
	}

	@Override
	public void implementorEight(String[] args) throws Exception {
		new T3().test();
		/*
		 * This program produces the output:
		 * 
		 * x=3
		 * 
		 * super.x=2
		 * 
		 * ((T2)this).x=2
		 * 
		 * ((T1)this).x=1
		 * 
		 * ((I)this).x=0
		 * 
		 * Within class T3 , the expression super.x has the same effect as
		 * ((T2)this).x when x has package access. Note that super.x is not
		 * specified in terms of a cast, due to difficulties around access to
		 * protected members of the superclass.
		 */
		// exit();

	}

	class Superclass {
		void foo() {
			System.out.println("Hi");
		}
	}

	class Subclass1 extends Superclass {
		void foo() {
			throw new UnsupportedOperationException();
		}

		Runnable tweak = new Runnable() {
			public void run() {
				Subclass1.super.foo(); // Gets the 'println' behavior
			}
		};
	}

	interface Superinterface {
		default void foo() {
			System.out.println("Hi");
		}
	}

	class Subclass2 implements Superinterface {
		public void foo() {
			throw new UnsupportedOperationException();
		}

		void tweak() {
			Superinterface.super.foo();
		}
		// Gets the 'println' behavior
	}

	class Subclass3 implements Superinterface {
		public void foo() {
			throw new UnsupportedOperationException();
		}

		Runnable tweak = new Runnable() {
			public void run() {
				Subclass3.Superinterface.super.foo();// Illegal
			}
		};
		/*
		 * A workaround is to introduce a private method in the lexically
		 * enclosing type declaration, that performs the interface super call
		 */
	}

	static long two(long j) {
		return j + j;
	}

	@Override
	public void implementorNine(String[] args) throws Exception {
		System.out.println(two(3));
		System.out.println(Doubler.two(3));
		// compile-time error
		exit();

	}

	/****
	 * Here, a compile-time error occurs for the second invocation of setColor ,
	 * because no applicable method can be found at compile time. The type of
	 * the literal 37 is int , and int cannot be converted to byte by invocation
	 * conversion. Assignment conversion, which is used in the initialization of
	 * the variable color , performs an implicit conversion of the constant from
	 * type int to byte , which is permitted because the value 37 is small
	 * enough to be represented in type byte ; but such a conversion is not
	 * allowed for invocation conversion.
	 */
	@Override
	public void implementorTen(String[] args) throws Exception {
		ColoredPoint cp = new ColoredPoint();
		byte color = 37;
		cp.setColor(color);
		cp.setColor(37); // compile-time error

	}

	class ColoredPoint extends Point {
		int x, y;
		byte color;

		void setColor(byte color) {
			this.color = color;
		}
	}

	class Point {
		int x, y;
	}

	// class ColoredPoint extends Point {
	// int color;
	// }
	static void test(ColoredPoint p, Point q) {
		System.out.println("(ColoredPoint, Point)");
	}

	static void test(Point p, ColoredPoint q) {
		System.out.println("(Point, ColoredPoint)");
	}

	/*
	 * If a third definition of test were added:
	 */
	// static void test(ColoredPoint p, ColoredPoint q) {
	// System.out.println("(ColoredPoint, ColoredPoint)");
	// }
	/*
	 * then it would be more specific than the other two, and the method
	 * invocation would no longer be ambiguous.
	 */

	@Override
	public void implementorEleven(String[] args) throws Exception {
		ColoredPoint cp = new ColoredPoint();
		test(cp, cp); // compile-time error
		/*
		 * This example produces an error at compile time. The problem is that
		 * there are two declarations of test that are applicable and
		 * accessible, and neither is more specific than the other. Therefore,
		 * the method invocation is ambiguous.
		 */

	}

	/*
	 * Example 15.12.2-2. Return Type Not Considered During Method Selection
	 */
	static int test(ColoredPoint p) {
		return p.color;
	}

	static String test(Point p) {
		return "Point";
	}

	/*
	 * Here, the most specific declaration of method test is the one taking a
	 * parameter of type ColoredPoint . Because the result type of the method is
	 * int , a compile-time error occurs because an int cannot be converted to a
	 * String by assignment conversion. This example shows that the result types
	 * of methods do not participate in resolving overloaded methods, so that
	 * the second test method, which returns a String , is not chosen, even
	 * though it has a result type that would allow the example program to
	 * compile without error.
	 */
	@Override
	public void implementorTwelve(String[] args) throws Exception {
		ColoredPoint cp = new ColoredPoint();
		String s = test(cp); // compile-time error

	}

	/*
	 * Example 15.12.2-3. Choosing The Most Specific Method The most specific
	 * method is chosen at compile time; its descriptor determines what method
	 * is actually executed at run time. If a new method is added to a class,
	 * then source code that was compiled with the old definition of the class
	 * might not use the new method, even if a recompilation would cause this
	 * method to be chosen. So, for example, consider two compilation units, one
	 * for class Point :
	 */
	public class Point3 {
		public int x, y;

		public Point3(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return toString("");
		}

		public String toString(String s) {
			return "(" + x + "," + y + s + ")";
		}
	}

	// and one for class ColoredPoint :
	public class ColoredPoint3 extends Point3 {
		public static final int RED = 0, GREEN = 1, BLUE = 2;
		public String[] COLORS = { "red", "green", "blue" };
		public byte color;

		public ColoredPoint3(int x, int y, int color) {
			super(x, y);
			this.color = (byte) color;
		}

		/**
		 * Copy all relevant fields of the argument into this ColoredPoint
		 * object.
		 */
		public void adopt(Point3 p) {
			x = p.x;
			y = p.y;
		}

		public String toString() {
			String s = "," + COLORS[color];
			return super.toString(s);
		}
	}

	/*
	 * Now consider a third compilation unit that uses ColoredPoint :
	 */
	@Override
	public void implementorThirteen(String[] args) throws Exception {
		ColoredPoint3 cp = new ColoredPoint3(6, 6, ColoredPoint3.RED);
		ColoredPoint3 cp2 = new ColoredPoint3(3, 3, ColoredPoint3.GREEN);
		cp.adopt(cp2);
		System.out.println("cp: " + cp);
		// The output is:
		// cp: (3,3,red)
		// exit();
		/*
		 * The programmer who coded class Test has expected to see the word
		 * green , because the actual argument, a ColoredPoint , has a color
		 * field, and color would seem to be a "relevant field". (Of course, the
		 * documentation for the package points ought to have been much more
		 * precise!)
		 */
	}

	/****
	 * the occurrence of s before " .startsWith " is evaluated first, before the
	 * argument expression s = "two" . Therefore, a reference to the string
	 * "one" is remembered as the target reference before the local variable s
	 * is changed to refer to the string "two" . As a result, the startsWith
	 * method is invoked for target object "one" with argument "two" , so the
	 * result of the invocation is false , as the string "one" does not start
	 * with "two" . It follows that the test program does not print " oops ".
	 */
	@Override
	public void implementorFourteen(String[] args) throws Exception {
		String s = "one";
		if (s.startsWith(s = "two"))
			System.out.println("oops");
		// exit();
	}

	/****
	 * However, this fact is essentially never useful. For example, a==b==c
	 * parses as (a==b)==c . The result type of a==b is always boolean , and c
	 * must therefore be of type boolean or a compile-time error occurs. Thus,
	 * a==b==c does not test to see whether a , b , and c are all equal.
	 */
	@Override
	public void implementorFifteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	/****
	 * If the result is not NaN, the sign of the result equals the sign of the
	 * dividend.
	 */
	@Override
	public void implementorSixteen(String[] args) throws Exception {
		int a = 5 % 3; // 2
		int b = 5 / 3; // 1
		System.out.println("5%3 produces " + a + " (note that 5/3 produces "
				+ b + ")");
		int c = 5 % (-3); // 2
		int d = 5 / (-3); // -1
		System.out.println("5%(-3) produces " + c
				+ " (note that 5/(-3) produces " + d + ")");
		int e = (-5) % 3; // -2
		int f = (-5) / 3; // -1
		System.out.println("(-5)%3 produces " + e
				+ " (note that (-5)/3 produces " + f + ")");
		int g = (-5) % (-3); // -2
		int h = (-5) / (-3); // 1
		System.out.println("(-5)%(-3) produces " + g
				+ " (note that (-5)/(-3) produces " + h + ")");
		// exit();
	}

	/****
	 * Example 15.17.3-2. Floating-Point Remainder Operator
	 */
	@Override
	public void implementorSeventeen(String[] args) throws Exception {
		double a = 5.0 % 3.0; // 2.0
		System.out.println("5.0%3.0 produces " + a);
		double b = 5.0 % (-3.0); // 2.0
		System.out.println("5.0%(-3.0) produces " + b);
		double c = (-5.0) % 3.0; // -2.0
		System.out.println("(-5.0)%3.0 produces " + c);
		double d = (-5.0) % (-3.0); // -2.0
		System.out.println("(-5.0)%(-3.0) produces " + d);
		// exit();
	}

	/****
	 * Example 15.18.1-1. String Concatenation
	 */
	@Override
	public void implementorEighteen(String[] args) throws Exception {
		// The example expression:
		String str = "The square root of 2 is " + Math.sqrt(2);
		// produces the result:
		// "The square root of 2 is 1.4142135623730952"
		logger.debug(str);

		// The + operator is syntactically left-associative, no matter whether
		// it is determined by
		// type analysis to represent string concatenation or numeric addition.
		// In some cases care is
		// required to get the desired result. For example, the expression:
		// a + b + c
		// is always regarded as meaning:
		// (a + b) + c
		// Therefore the result of the expression:

		str = 1 + 2 + " fiddlers";
		// is:
		// "3 fiddlers"
		logger.debug(str);
		// but the result of:
		str = "fiddlers " + 1 + 2;
		// is:
		// "fiddlers 12"
		logger.debug(str);
		logger.debug(str);
		logger.debug(str);

		// exit();
	}

	static class Bottles {
		static void printSong(Object stuff, int n) {
			String plural = (n == 1) ? "" : "s";
			loop: while (true) {
				System.out.println(n + " bottle" + plural + " of " + stuff
						+ " on the wall,");
				System.out.println(n + " bottle" + plural + " of " + stuff
						+ ";");
				System.out
						.println("You take one down " + "and pass it around:");
				--n;
				plural = (n == 1) ? "" : "s";
				if (n == 0)
					break loop;
				System.out.println(n + " bottle" + plural + " of " + stuff
						+ " on the wall!");
				System.out.println();
			}
			System.out.println("No bottles of " + stuff + " on the wall!");
		}

	}

	@Override
	public void implementorNineteen(String[] args) throws Exception {
		Bottles.printSong("slime", 3);
		// the method printSong will print a version of a children's song.
		// Popular values for stuff
		// include " pop " and " beer "; the most popular value for n is 100 .
		// Here is the output that
		// results from running the program:
		// 3 bottles of
		// 3 bottles of
		// You take one
		// 2 bottles of
		// slime on the wall,
		// slime;
		// down and pass it around:
		// slime on the wall!
		// 2 bottles of slime on the wall,
		// 2 bottles of slime;
		// You take one down and pass it around:
		// 1 bottle of slime on the wall!
		// 1 bottle of slime on the wall,
		// 1 bottle of slime;
		// You take one down and pass it around:
		// No bottles of slime on the wall!
		// exit();
	}

	// class Point5 {
	// int x, y;
	// }

	class Element5 {
		int atomicNumber;
	}

	class Point5 extends Element5 {
		int x, y;
	}

	/****
	 * Example 15.20.2-1. The instanceof Operator
	 */
	@Override
	public void implementorTwenty(String[] args) throws Exception {
		Point5 p = new Point5();
		Element5 e = new Element5();
		if (e instanceof Point5) { // compile-time error
			System.out.println("I get your point!");
			p = (Point5) e; // compile-time error
		}
		/*
		 * This program results in two compile-time errors. The cast (Point)e is
		 * incorrect because no instance of Element or any of its possible
		 * subclasses (none are shown here) could possibly be an instance of any
		 * subclass of Point . The instanceof expression is incorrect for
		 * exactly the same reason. If, on the other hand, the class Point were
		 * a subclass of Element (an admittedly strange notion in this example):
		 */
	}
}

class Doubler {
	static int two() {
		return two(1);
	}

	private static int two(int i) {
		return 2 * i;
	}
}