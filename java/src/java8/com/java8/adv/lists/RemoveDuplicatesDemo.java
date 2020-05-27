package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class RemoveDuplicatesDemo {

	public static void main(String[] args) {
		List<String> cityList = new ArrayList<>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Mumbai");

		List<String> newList = new ArrayList<>();
		for (String name : cityList) {
			if (!newList.contains(name)) {
				newList.add(name);
			}
		}

		for (String name : newList) {
			System.out.println("City Name - " + name);
		}
	}

	/***
	 * Using HashSet to remove duplicate elements from ArrayList
	 * 
	 * 
	 * You can create a new HashSet by passing the List as argument. Any
	 * duplicates in the ArrayList would be discarded as HashSet stores only
	 * unique elements. Then you can add the Set again to the List after
	 * clearing the List. That gives you the List without any duplicates.
	 */
	public static void main1() {
		List<String> cityList = new ArrayList<>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Mumbai");

		// creating a hashset using the list
		Set<String> citySet = new HashSet<String>(cityList);
		// remove all the elements from the list
		cityList.clear();
		// add all the elements of the set to create a
		// list with out duplicates
		cityList.addAll(citySet);

		// displaying the elements
		for (String name : cityList) {
			System.out.println("City Name - " + name);
		}
	}

	/***
	 * Using LinkedHashSet to remove duplicate elements from ArrayList
	 * 
	 * 
	 * Here is an example using LinkedHashSet to remove duplicate elements from
	 * an ArrayList, insertion order would be retained by using this option.
	 * 
	 * @param args
	 */
	public static void main2(String[] args) {
		List<String> cityList = new ArrayList<>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Mumbai");
		// creating a linkedhashset using the list
		Set<String> citySet = new LinkedHashSet<String>(cityList);
		// remove all the elements from the list
		cityList.clear();
		// add all the elements of the set to create a
		// list with out duplicates
		cityList.addAll(citySet);

		// displaying the elements
		for (String name : cityList) {
			System.out.println("City Name - " + name);
		}
	}

	/***
	 * Removing duplicates from ArrayList using Java Streams
	 * 
	 * 
	 * Stream API in Java provides a very simple way to remove duplicate
	 * elements from ArrayList using the distinct method. Note that this option
	 * is available Java 8 onward.
	 * 
	 * @param args
	 */
	public static void main3(String[] args) {
		List<String> cityList = new ArrayList<>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Mumbai");

		cityList = cityList.stream().distinct().collect(Collectors.toList());

		// displaying the elements
		for (String name : cityList) {
			System.out.println("City Name - " + name);
		}
	}
}