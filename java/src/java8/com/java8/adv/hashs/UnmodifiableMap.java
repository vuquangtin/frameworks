package com.java8.adv.hashs;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
public class UnmodifiableMap extends TemplateMethod {

	public static void main(String[] args) {
		new UnmodifiableMap().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) {
		Map<String, String> alphaMap = new HashMap<String, String>();
		alphaMap.put("1", "a");
		alphaMap.put("2", "b");
		alphaMap.put("3", "c");
		alphaMap.put("4", "d");
		Map<String, String> aMap = Collections.unmodifiableMap(alphaMap);
		// still mutable
		alphaMap.put("5", "e");
		System.out.println("alphaMap- " + alphaMap);
		// error as this Map is an unmodifiable view
		aMap.put("6", "f");

	}

	/***
	 * <h1>Map.of() method Java example</h1>
	 * 
	 * Map.of() static factory method is a convenient way to create unmodifiable
	 * maps Java 9 onward. This method is overloaded to have up to 10 elements
	 * and the form of the method is as follows.
	 */
	@Override
	public void implementionTwo(String[] args) {
		// Map<String, String> alphaMap = Map.of("1", "a", "2", "b", "3", "c",
		// "4", "d");
		// System.out.println("alphaMap- " + alphaMap);
		// // Error
		// alphaMap.put("5", "e");

	}

	@Override
	public void implementionThree(String[] args) {
//		Map<String, String> alphaMap = Map.ofEntries(entry("1", "a"),
//				entry("2", "b"), entry("3", "c"), entry("4", "d"));
//		System.out.println("alphaMap- " + alphaMap);

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
