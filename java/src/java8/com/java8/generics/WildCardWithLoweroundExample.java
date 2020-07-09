package com.java8.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Lower Bounded Wildcards
 * 
 * 
 * A lower bounded wildcard is expressed using the wildcard character ('?'),
 * following by the super keyword, followed by its lower bound: <? super A>.
 * 
 * GenericType<? super SubClass>
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class WildCardWithLoweroundExample {
	static void processElements(List<? super Integer> a) {
		for (Object element : a) {
			System.out.println(element);
		}
	}

	public static void main(String[] args) {
		// ArrayList Containing Integers

		List<Integer> a1 = new ArrayList<>();

		a1.add(10);

		a1.add(20);

		a1.add(30);

		processElements(a1);

		// ArrayList Containing Longs

		List<Long> a2 = new ArrayList<>();

		a2.add(100L);

		a2.add(200L);

		a2.add(300L);

		processElements(a2); // compiler error

	}
}
