package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * Sorting ArrayList of strings using sort() method of List
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class SortListDemo {
	public static void main(String[] args) {
		List<String> cityList = new ArrayList<>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Mumbai");
		// Passing null so natural ordering is used
		cityList.sort(null);
		System.out.println("List sorted using natural ordering" + cityList);

		// Using naturalOrder method to sort in natural order
		cityList.sort(Comparator.naturalOrder());
		System.out.println("List sorted using natural ordering" + cityList);

		// Using reverseOrder method to impose reverse of natural ordering
		cityList.sort(Comparator.reverseOrder());
		System.out.println("List sorted in reverse" + cityList);
	}

	/***
	 * Using Collections.sort() method to sort ArrayList
	 * 
	 * 
	 * To sort an ArrayList of strings according to the natural ordering of its
	 * elements we can use the first of the two sort methods.
	 * 
	 * 
	 * 
	 * Collections.sort(List<T> list)
	 * 
	 * @param args
	 */
	public static void main1(String[] args) {
		List<String> cityList = Arrays.asList("Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata", "Mumbai");
		// sorting the list
		Collections.sort(cityList);
		System.out.println("List sorted using natural ordering" + cityList);
	}

	/***
	 * Sorting ArrayList in descending order using reverseOrder method
	 * 
	 * @param args
	 */
	public static void main2(String[] args) {
		List<String> cityList = Arrays.asList("Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata", "Mumbai");
		// sorting the list in descending order
		Collections.sort(cityList, Collections.reverseOrder());
		System.out.println("List sorted in reverses order- " + cityList);
	}

	/***
	 * Sorting ArrayList in descending order using custom Comparator
	 * 
	 * 
	 * Internally reverseOrder method calls a Comparator class to sort the list
	 * in reverse order. We can do it ourselves too by writing our own
	 * comparator class.
	 * 
	 * @param args
	 */
	public static void main3(String[] args) {
		List<String> cityList = Arrays.asList("Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata", "Mumbai");
		// sorting the list in descending order
		Collections.sort(cityList, (String a, String b) -> b.compareTo(a));
		System.out.println("List sorted in reverses order- " + cityList);
	}

	/***
	 * Sorting Java ArrayList using sorted method of the Java Stream
	 * 
	 * @param args
	 */
	public static void main4(String[] args) {
		List<String> cityList = Arrays.asList("Delhi", "Mumbai", "Bangalore", "Chennai", "Kolkata", "Mumbai");
		List<String> tempList = cityList.stream().sorted().collect(Collectors.toList());
		System.out.println("List sorted in natural order- " + tempList);
		tempList = cityList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("List sorted in reverse order- " + tempList);
	}

}