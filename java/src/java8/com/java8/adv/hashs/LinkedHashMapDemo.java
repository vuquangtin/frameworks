package com.java8.adv.hashs;

import java.util.LinkedHashMap;
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
public class LinkedHashMapDemo extends TemplateMethod {
	public static void main(String[] args) {
		new LinkedHashMapDemo().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) {
		// Creating LinkedHashMap
		Map<String, String> cityTemperatureMap = new LinkedHashMap<String, String>();

		// Storing elements
		cityTemperatureMap.put("Delhi", "24");
		cityTemperatureMap.put("Mumbai", "32");
		cityTemperatureMap.put(null, "26");
		cityTemperatureMap.put("Chennai", "35");
		cityTemperatureMap.put("Bangalore", "22");
		cityTemperatureMap.put(null, "34");
		cityTemperatureMap.put("Kolkata", "28");
		cityTemperatureMap.put("Chennai", "36");

		// iterating the map
		for (Map.Entry<String, String> me : cityTemperatureMap.entrySet()) {
			System.out.println(me.getKey() + " " + me.getValue());
		}

	}

	@Override
	public void implementionTwo(String[] args) {
		Map<String, String> cityMap = new LinkedHashMap<String, String>(16,
				0.75f, true);
		cityMap.put("1", "New York City");
		cityMap.put("2", "New Delhi");
		cityMap.put("3", "Newark");
		cityMap.put("4", "Newport");
		System.out.println("" + cityMap.get("1"));
		System.out.println("" + cityMap.get("4"));
		for (Map.Entry<String, String> me : cityMap.entrySet()) {
			System.out.println(me.getKey() + " " + me.getValue());
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
