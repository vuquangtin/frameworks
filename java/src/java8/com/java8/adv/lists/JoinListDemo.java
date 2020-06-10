package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.List;

import com.java.frameworks.base.TemplateMethod;

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
public class JoinListDemo extends TemplateMethod {

	public static void main(String[] args) {
		new JoinListDemo().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) {
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

	@Override
	public void implementionTwo(String[] args) {
		// TODO Auto-generated method stub

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