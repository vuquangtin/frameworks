package com.java8.lambda.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class Main {
	interface NumericTest {
		boolean computeTest(int n);
	}

	public static void main(String[] a) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		System.out.print("Print all numbers: ");
		evaluate(list, (n) -> true);// test(n) luôn return true

		System.out.print("Print no numbers: ");
		evaluate(list, (n) -> false);// test(n) luôn return false

		System.out.print("Print even numbers: ");
		evaluate(list, (n) -> n % 2 == 0);// test(n) return true nếu n chẵn

		System.out.print("Print odd numbers: ");
		evaluate(list, (n) -> n % 2 == 1);// test(n) return true nếu n lẻ

		System.out.print("Print numbers greater than 5: ");
		evaluate(list, (n) -> n > 5);// test(n) return true nếu n > 5

		Arrays.asList("apple", "mango", "orange").forEach(
				(String value) -> System.out.println(value));
		NumericTest isEven = (n) -> (n % 2) == 0;
		NumericTest isNegative = (n) -> (n < 0);

		// Output: false
		System.out.println(isEven.computeTest(5));

		// Output: true
		System.out.println(isNegative.computeTest(-5));
		
		
		MyGreeting morningGreeting = (str) -> "Chao buoi sang " + str + "!";
		MyGreeting eveningGreeting = (str) -> "Chao buoi toi " + str + "!";
	  
	  	// Output: Chao buoi sang Dat! 
		System.out.println(morningGreeting.processName("Dat"));
		
		// Output: Chao buoi toi Minh!
		System.out.println(eveningGreeting.processName("Minh"));	

		// Khối Lambda dùng để đảo ngược chuỗi
		MyString reverseStr = (str) -> {
			String result = "";
			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			
			return result;
		};

		// Output: gg51 ousaY
		System.out.println(reverseStr.myStringFunction("Yasuo 15gg")); 
		
		// Phiên bản dành cho kiểu String của interface MyGereric
		MyGeneric<String> reverse = (str) -> {
			String result = "";
			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			
			return result;
		};

		// Phiên bản dành cho kiểu Integer của interface MyGereric
		MyGeneric<Integer> factorial = (Integer n) -> {
			int result = 1;
			
			for(int i=1; i <= n; i++)
				result = i * result;
			
			return result;
		};

		// Output: !!iiigasaH
		System.out.println(reverse.compute("Hasagiii!!")); 

		// Output: 120
		System.out.println(factorial.compute(5)); 
	}
	interface MyGeneric<T> {
		T compute(T t);
	}
	interface MyString {
		String myStringFunction(String str);
	}

	interface MyGreeting {
		String processName(String str);
	}
	public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.print(n + " ");
			}
		}
		System.out.println();
	}
}