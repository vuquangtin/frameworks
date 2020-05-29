package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class CovertToArrayList extends TemplateMethod {
	public static void main(String[] args) {
		new CovertToArrayList().runTemplateMethod(args);
	}

	/***
	 * Converting array to ArrayList using Arrays.asList() method
	 * 
	 * 
	 * Arrays class contains various methods for manipulating arrays (such as
	 * sorting and searching). This class also contains a static factory that
	 * allows arrays to be viewed as lists. The method to convert Array to
	 * ArrayList is asList() whose general form is
	 */
	@Override
	public void implementionOne(String[] args) {
		String cityArray[] = { "Delhi", "Mumbai", "Bangalore", "Hyderabad",
				"Chennai" };
		// Converting array to List
		List<String> cityList = Arrays.asList(cityArray);
		for (String name : cityList) {
			System.out.println("City : " + name);
		}
	}

	/**
	 * There are few points to note about Arrays.asList() method
	 * 
	 * 
	 * This method returns a List that is a view onto the array. You can say it
	 * is more of a wrapper around an array. That makes it more efficient than
	 * any other option as array elements are not actually copied to the List.
	 * 
	 * The list returned by this method is a fixed-size list.
	 * 
	 * Since list returned is just a view onto the array, if you change any
	 * element in the list that change is reflected in the array too.
	 * 
	 * The ArrayList class used to create the list while using this method
	 * Arrays.asList is actually a static class within the Arrays class and many
	 * of the methods of the original ArrayList are not supported by this
	 * ArrayList. As example add() method is not there in this ArrayList so any
	 * attempt to add new element to the returned list will throw
	 * UnsupportedOperationException. Following example shows the same.
	 * 
	 */
	@Override
	public void implementionTwo(String[] args) {
		String cityArray[] = { "Delhi", "Mumbai", "Bangalore", "Hyderabad",
				"Chennai" };
		// Converting array to List
		List<String> cityList = Arrays.asList(cityArray);
		// Attempt to add new element in the list
		// This will throw exception
		cityList.add("Pune");
		for (String name : cityList) {
			System.out.println("City : " + name);
		}

	}

	/***
	 * Wrapping the list returned by Arrays.asList to a new ArrayList
	 */
	@Override
	public void implementionThree(String[] args) {
		String cityArray[] = { "Delhi", "Mumbai", "Bangalore", "Hyderabad",
				"Chennai" };
		// Converting array to List
		ArrayList<String> cityList = new ArrayList<String>(
				Arrays.asList(cityArray));

		cityList.add("Pune");
		for (String name : cityList) {
			System.out.println("City : " + name);
		}

	}

	/***
	 * Converting Array to ArrayList in Java using Collections.addAll method
	 * 
	 * 
	 * In this option to convert array to ArrayList using Collections.addAll
	 * method both array and ArrayList are passed as parameters to this method
	 * and the elements of array are added to the passed ArrayList. ArrayList
	 * you get from this method is independent from the array and can be
	 * modified without the change reflecting onto array and with out throwing
	 * any exception.
	 */
	@Override
	public void implementionFour(String[] args) {
		String cityArray[] = { "Delhi", "Mumbai", "Bangalore", "Hyderabad",
				"Chennai" };
		List<String> cityList = new ArrayList<String>();
		Collections.addAll(cityList, cityArray);
		cityList.add("Pune");
		for (String name : cityList) {
			System.out.println("City : " + name);
		}

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