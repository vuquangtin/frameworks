package com.java8.collector;

import java.util.Arrays;
import java.util.Iterator;

/**
 * https://www.geeksforgeeks.org/convert-iterator-to-iterable-in-java/
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class IterableFromIterator {

	// Function to get the Spliterator
	public static <T> Iterable<T> getIterableFromIterator(Iterator<T> iterator) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return iterator;
			}
		};
	}

	// Driver code
	public static void main(String[] args) {

		// Get the Iterator
		Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();

		// Get the Iterable from the Iterator
		Iterable<Integer> iterable = getIterableFromIterator(iterator);

		// Print the elements of Iterable
		iterable.forEach(System.out::println);
	}
}