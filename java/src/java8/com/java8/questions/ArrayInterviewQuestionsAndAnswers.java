package com.java8.questions;

import java.util.Arrays;
import java.util.BitSet;

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
public class ArrayInterviewQuestionsAndAnswers extends ExtendTemplateMethod {

	public static void main(String[] args) {
		new ArrayInterviewQuestionsAndAnswers().runTemplateMethod(args);

	}

	/*
	 * Q1 What is an Array?
	 * 
	 * Array is a collection of similar data types. It can not have different
	 * data type. It can hold both primitive types (int, float, double) and
	 * object references.
	 * 
	 * It is fixed in length i.e static in nature.
	 * 
	 * Arrays are created on the heap memory not on the stack.
	 * 
	 * Accessing an invalid index of an Array will cause exception.
	 */

	/*
	 * Q2 How do you declare an Array in java?
	 * 
	 * You can declare an Array in java by the following way :
	 * 
	 * dataType[] arrayVariableName = new dataType[arraySize];
	 * 
	 * for example for int data type, you can declare an int array as :
	 * 
	 * int[] temp = new int[256]
	 */
	/**
	 * Q3 What is the default value of Array for different data types?
	 * 
	 * 
	 * Data Type Default value
	 * 
	 * byte, short, int, long 0
	 * 
	 * float, double 0.0
	 * 
	 * boolean false
	 * 
	 * Any object null
	 */

	/**
	 * Q4 Can you change size of Array in java after creation?
	 * 
	 * You can not change the size of Array after creation. Although there are
	 * other data-structures which can change size after creation
	 */
	/**
	 * Q5 Can you pass the negative number in Array size?
	 * 
	 * No, you can not pass the negative number as Array size. If you pass a
	 * negative number in Array size then you will not get the compiler error.
	 * Instead, you will get the NegativeArraySizeException at run time.
	 */
	/**
	 * Q6 Can you declare an Array without Array size?
	 * 
	 * No, you can not declare Array without Array size. You will get compile
	 * time error.
	 * 
	 * Q7 Where does Array stored in JVM memory ?
	 * 
	 * Array is an object in java. So, Array is stored in heap memory in JVM.
	 * 
	 * Q8 Given a primitive Array in java, where does in JVM it is stored?
	 * 
	 * This is a follow-up question of Q7. An Array will always be an object on
	 * heap memory, even if the Array is declared to hold primitive elements.
	 */
	/*
	 * Q9 What is ArrayStoreException ? When this exception is thrown ?
	 * 
	 * According to Oracle docs,
	 * 
	 * ArrayStoreException is a runtime exception. Array must contain the same
	 * data type elements.
	 * 
	 * This exception is thrown to indicate that an attempt has been made to
	 * store the wrong type of object into an array of objects. In other words,
	 * if you want to store the integer Object in an Array of String you will
	 * get ArrayStoreException.
	 * 
	 * The following code throws ArrayStoreException :
	 */
	@Override
	public void implementionEleven(String[] args) throws Exception {
		Object x[] = new String[3];
		x[0] = new Integer(0);

	}

	/**
	 * Q10 What is the difference between ArrayStoreException and
	 * ArrayOutOfBoundsException ?
	 * 
	 * ArrayStoreException is thrown if you are trying to add incompatible data
	 * type. For example, if you try to add an integer object to String Array,
	 * then ArrayStoreException is thrown.
	 * 
	 * ArrayOutOfBoundsException is thrown when an attempt is made to access the
	 * Array with illegal index. For example, illegal index means if the index
	 * is either negative or greater than or equal to the size of the Array.
	 * 
	 * Q11 What are the advantages of Array ?
	 * 
	 * a. We can sort multiple elements of Array at the same time.
	 * 
	 * b. Using index, we can access the element of the Array in O(1) time.
	 * 
	 * Q12 What are the disadvantages of Array?
	 * 
	 * a. To create an Array, contiguous memory is required. It is possible in
	 * JVM that the memory is available to accommodate Array but memory
	 * available is not contiguous.
	 * 
	 * b. The Array is static data structure. It is of fixed size. We can not
	 * increase or decrease the size of the Array after creation.
	 * 
	 * Q13 Can we use Generics with an Array?
	 * 
	 * No, we can not use generics with an Array.
	 * 
	 * Q14 What is an Anonymous Array in Java ? Give example?
	 * 
	 * An array without any name (or reference) is called an Anonymous Array.
	 * They are useful for the scenarios where we need one time usage of Array.
	 * For example,
	 * 
	 * Anonymous int array :
	 */
	@Override
	public void implementionTwelve(String[] args) throws Exception {
		int[] a = new int[] { 2, 3, 4, 5, 6, 7 };
		// Anonymous String array :
		String[] b = new String[] { "Java", "Hungry" };

	}

	/**
	 * Q15 Write a program to print elements of Array ?
	 */
	@Override
	public void implementionThirteen(String[] args) throws Exception {
		int[] rollNumber = { 23, 17, 20, 29, 30 };
		for (int temp : rollNumber) {
			System.out.print(temp + " ");
		}
		/**
		 * Output : 23 17 20 29 30
		 */
	}

	/**
	 * Q16 Write a program to sort an Array in Java ?
	 * 
	 * You do not need to write quick sort or merge sort algorithm in order to
	 * sort an Array. You can sort an Array by using Arrays.sort() method. Check
	 * out the program below :
	 */
	@Override
	public void implementionFourteen(String[] args) throws Exception {

		int[] rollNumber = { 23, 17, 20, 29, 30 };
		Arrays.sort(rollNumber);
		for (int temp : rollNumber)
			System.out.print(temp + " ");
		/*
		 * Output :
		 * 
		 * 17 20 23 29 30
		 */
	}

	/**
	 * Q17 Write a program to check whether two given Arrays are equal, given
	 * both contains same data type and same length ?
	 * 
	 * To check whether two given arrays are equal or not , we can use
	 * Arrays.equals() method. Check the program below :
	 */
	@Override
	public void implementionFifteen(String[] args) throws Exception {
		int[] arr1 = { 2, 3, 4 };
		int[] arr2 = { 1, 2, 3 };

		System.out.println(Arrays.equals(arr1, arr2));

		int[] arr3 = { 2, 3, 4 };

		System.out.println(Arrays.equals(arr1, arr3));
		/**
		 * Output :
		 * 
		 * false
		 * 
		 * true
		 */
	}

	/**
	 * A general method to find missing values from an integer array in Java.
	 * This method will work even if array has more than one missing element.
	 */
	private static void printMissingNumber(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);

		for (int number : numbers) {
			bitSet.set(number - 1);
		}

		System.out
				.printf("Missing numbers in integer array %s, with total number %d is %n",
						Arrays.toString(numbers), count);
		int lastMissingIndex = 0;

		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.println(++lastMissingIndex);
		}

	}

	/**
	 * Java method to find missing number in array of size n containing
	 * 
	 * numbers from 1 to n only. can be used to find missing elements on integer
	 * array of
	 * 
	 * numbers from 1 to 100 or 1 - 1000
	 */
	private static int getMissingNumber(int[] numbers, int totalCount) {
		int expectedSum = totalCount * ((totalCount + 1) / 2);
		int actualSum = 0;
		for (int i : numbers) {
			actualSum += i;
		}

		return expectedSum - actualSum;
	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		// one missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 6 }, 6);

		// two missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 6, 7, 9, 8, 10 }, 10);

		// three missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 6, 9, 8 }, 10);

		// four missing number
		printMissingNumber(new int[] { 1, 2, 3, 4, 9, 8 }, 10);

		// Only one missing number in array
		int[] iArray = new int[] { 1, 2, 3, 5 };
		int missing = getMissingNumber(iArray, 5);
		System.out.printf("Missing number in array %s is %d %n",

		Arrays.toString(iArray), missing);
		// exit();

	}

	class T1 {
		String s() {
			return "1";
		}
	}

	class T2 extends T1 {
		String s() {
			return "2";
		}
	}

	class T3 extends T2 {
		String s() {
			return "3";
		}

		void test() {
			System.out.println("s()=\t\t" + s());
			System.out.println("super.s()=\t" +

			super.s());
			System.out.println("((T2)this).s()=\t" +

			((T2) this).s());
			System.out.println("((T1)this).s()=\t" + ((T1) this).s());

		}
	}

	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		T3 t3 = new T3();
		t3.test();
		//exit();
		/*
		 * s()= 3
		 * 
		 * super.s()= 2
		 * 
		 * ((T2)this).s()= 3
		 * 
		 * ((T1)this).s()= 3
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

	@Override
	public void implementionOne(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
