package com.java8.adv.hashs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.java8.adv.abs.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class HashMapLooping extends TemplateMethod {

	public static void main(String[] args) {
		new HashMapLooping().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) {
		// Setting up a HashMap
		Map<String, String> cityMap = new HashMap<String, String>();
		cityMap.put("1", "New York City");
		cityMap.put("2", "New Delhi");
		cityMap.put("3", "Newark");
		cityMap.put("4", "Newport");

		System.out.println("Looping with keySet");
		// Loop through HashMap using Key Set
		Set<String> citySet = cityMap.keySet();
		for (String key : citySet) {
			System.out.println("Key is " + key + " Value is "
					+ cityMap.get(key));
		}

		System.out.println("Looping HashMap using entrySet");
		// Second way with entrySet
		for (Map.Entry<String, String> entry : cityMap.entrySet()) {
			System.out.println("Key is " + entry.getKey() + " Value is "
					+ entry.getValue());
		}

		System.out.println("Looping with entrySet using Iterator");
		// Third way with iterator
		Iterator<Entry<String, String>> itr = cityMap.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			System.out.println("Key is " + entry.getKey() + " Value is "
					+ entry.getValue());
		}

		System.out.println("Looping HashMap using values method");
		for (String value : cityMap.values()) {
			System.out.println("Value is " + value);
		}

	}

	/**
	 * Iterating HashMap using forEach statement
	 * 
	 * Java 8 onward forEach statement is provided to be used along with Lambda
	 * expression in Java, which reduces the looping through a Map to a single
	 * statement. Another feature of Java 8, method reference makes it even
	 * shorter. With forEach statement you can even iterate a HashMap directly
	 * without getting a collection view of the Map.
	 */
	@Override
	public void implementionTwo(String[] args) {
		// Setting up a HashMap
		Map<String, String> cityMap = new HashMap<String, String>();
		cityMap.put("1", "New York City");
		cityMap.put("2", "New Delhi");
		cityMap.put("3", "Newark");
		cityMap.put("4", "Newport");

		System.out.println("Looping with Lambda expression forEach stmt");
		Set<Map.Entry<String, String>> valueSet = cityMap.entrySet();
		valueSet.forEach((a) -> System.out.println("Key is " + a.getKey()
				+ " Value is " + a.getValue()));

		System.out.println("Looping with method reference forEach");
		cityMap.entrySet().forEach(System.out::println);
		// Looping HashMap directly with forEach
		System.out.println("Looping HashMap with forEach statement");
		cityMap.forEach((K, V) -> System.out.println("Key is " + K
				+ " Value is " + V));
	}

	@Override
	public void implementionThree(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFour(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFive(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSix(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeven(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) {
		// TODO Auto-generated method stub

	}

}
