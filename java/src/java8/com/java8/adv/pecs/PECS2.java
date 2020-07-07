package com.java8.adv.pecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class PECS2 {

	public static <T> T copy01(Collection<T> from, Collection<T> to) {
		for (T t : from) {
			to.add(t);
		}

		// ignore NPEs :P
		return from.iterator().next();
	}

	/**
	 * Use extends when getting from a producer
	 */
	public static <T> T copy02(Collection<? extends T> from, Collection<T> to) {
		for (T t : from) {
			to.add(t);
		}

		return from.iterator().next();
	}

	/**
	 * Use super when putting into a consumer
	 */
	public static <T> T copy03(Collection<T> from, Collection<? super T> to) {
		for (T t : from) {
			to.add(t);
		}

		return from.iterator().next();
	}

	public static void main(String[] args) {
		List<String> from = Arrays.asList("foo", "bar", "baz");
		List<CharSequence> to = new ArrayList<CharSequence>();

		// copy String elements to CharSequence elements
		copy01(from, to); // doesn't type check

		CharSequence a = copy02(from, to); // returns CharSequence because of
											// extends
		String b = copy03(from, to); // returns String because of super

		// Or, Collections.sort(List<T>, Comparator<? super T>);

		// sort by length, ascending
		Comparator<CharSequence> charSequenceComparator = new Comparator<CharSequence>() {
			@Override
			public int compare(CharSequence a, CharSequence b) {
				return a.length() - b.length();
			}
		};

		// The above can sort Strings
		List<String> stringsToSort = Arrays.asList("ccc", "bb", "a");
		Collections.sort(stringsToSort, charSequenceComparator);
		System.out.println(stringsToSort);

		// Or StringBuilders
		List<StringBuilder> buildersToSort = Arrays.asList(new StringBuilder(
				"ccc"), new StringBuilder("bb"), new StringBuilder("a"));
		Collections.sort(buildersToSort, charSequenceComparator);

		System.out.println(buildersToSort);
	}

	public void example() {
		// numberList is a producer of subtypes of numbers. Hence is generified
		// with ? extends Number. Producer->Extends
		final List<? extends Number> numberList = DoubleStream
				.of(-99, 1, 2, 3, 4, 5, 6).boxed().collect(Collectors.toList());
		// numberList.add(new Integer(1)); //Cannot add integer to this list,
		// even though integer is a subtype of number.
		numberList.add(null);// Cannot add anything to numberList other than
								// null
		final Number number = numberList.get(0);// Can only get values as Number
												// type
		System.out.println(number.doubleValue());

		// integerList is a consumer of supertypes of integers. Hence is
		// generified with ? super Integer. Consumer->Super
		final List<Object> doubleList = IntStream.of(99, 1, 2, 3, 4, 5, 6)
				.boxed().collect(Collectors.toList());
		final List<? super Integer> integerList = doubleList; // List<Object>
																// can be
																// assigned
		// integerList.add(new Object()); //Cannot add Object to the list, even
		// though Object is a super type of Integer
		integerList.add(1);// Integers can be added
		// final Integer integer = integerList.get(0); //Cannot get values as
		// Integer or Number
		final Object integer = integerList.get(0); // Can only get value in an
													// Object reference
		System.out.println(integer.toString());
	}
}