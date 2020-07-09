package com.java8.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Wildcard Arguments With An Unknown Type:
 * 
 * The syntax for declaring this type of wildcard arguments is,
 * 
 * GenericType<?>
 * 
 * The arguments which are declared like this can hold any type of objects. For
 * example, Collection<?> or ArrayList<?> can hold any type of objects like
 * String, Integer, Double etc.
 * 
 * Wildcard Arguments With An Unknown Type
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class WildCardSimpleExample {
	public static void printCollection(Collection<?> c) {
		for (Object e : c) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<>();
		collection.add("ArrayList Collection");
		printCollection(collection);
		Collection<String> collection2 = new LinkedList<>();
		collection2.add("LinkedList Collection");
		printCollection(collection2);
		Collection<String> collection3 = new HashSet<>();
		collection3.add("HashSet Collection");
		printCollection(collection3);

	}
}