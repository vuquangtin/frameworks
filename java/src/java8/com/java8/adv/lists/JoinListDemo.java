package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>better options to join lists in Java.</h1> <br/>
 * Using addAll() method provided by List interface. <br/>
 * Using ListUtils.union() method provided by Apache Commons Collections.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 * @see https://www.netjstech.com/2015/05/java-advanced-topics.html
 */
public class JoinListDemo {
	public static void main(String[] args) {
		List<String> cityList = new ArrayList<String>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Kolkata");
		List<String> anotherCityList = new ArrayList<String>();
		anotherCityList.add("Hyderabad");
		anotherCityList.add("Bangalore");
		anotherCityList.add("Mumbai");

		// Using addAll method, here adding with in the first list
		// we can create a new list and use addAll method to
		// add both lists to the new List
		cityList.addAll(anotherCityList);
		System.out.println("--Merged List--");
		for (String cityName : cityList) {
			System.out.println("City Name " + cityName);
		}
	}
}