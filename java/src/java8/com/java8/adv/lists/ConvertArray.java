package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Better approach for converting ArrayList to Array in Java</h1> There is
 * another option provided by Collection interface itself. Within Collection
 * interface there are two versions of toArray() method which can be used to
 * convert ArrayList to array.
 * <ul>
 * <li>Object[] toArray()</li>
 * <li><T> T[] toArray(T array[])</li>
 * </ul>
 * The first version returns an array of Object. The second version returns an
 * array containing the elements of the same type as list. Normally we go with
 * the second version because it returns the array of the same type as List.
 * 
 * Let's see the same example as above with the second version of toArray() to
 * convert an ArrayList to array in Java.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class ConvertArray {
	public static void main(String[] args) {
		List<String> cityList = new ArrayList<String>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Hyderabad");
		cityList.add("Chennai");

		// Create an array of the same size as list
		String cityArray[] = new String[cityList.size()];

		cityArray = cityList.toArray(cityArray);

		// Displaying Array values
		for (String name : cityArray) {
			System.out.println("City : " + name);
		}
	}

	public static void main1(String[] args) {
		List<String> cityList = new ArrayList<String>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Hyderabad");
		cityList.add("Chennai");

		// Create an array of the same size as list
		String cityArray[] = new String[cityList.size()];

		// Loop through the list and assign values to array
		for (int i = 0; i < cityList.size(); i++) {
			cityArray[i] = cityList.get(i);
		}

		// Displaying Array values
		for (String name : cityArray) {
			System.out.println("City : " + name);
		}
	}
}