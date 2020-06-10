package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.List;

import com.java.frameworks.base.TemplateMethod;

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
public class ConvertArray extends TemplateMethod {
	public static void main(String[] args) {
		new ConvertArray().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) {
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

	@Override
	public void implementionTwo(String[] args) {
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