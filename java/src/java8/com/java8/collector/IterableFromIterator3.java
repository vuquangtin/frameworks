package com.java8.collector;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class IterableFromIterator3 {

	// Function to get the Spliterator
	public static <T> Iterable<T> getIterableFromIterator(Iterator<T> iterator) {
		return StreamSupport

		// Convert the iterator into a Spliterator
		// and then into a sequential stream
				.stream(Spliterators.spliteratorUnknownSize(iterator, 0), false)

				// Convert the stream to an iterable
				.collect(Collectors.toList());
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