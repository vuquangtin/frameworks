package com.java8.adv.hashs;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
public class HashMapSorting extends TemplateMethod {
	public static void main(String[] args) {
		new HashMapSorting().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) {
		// creating HashMap
		Map<String, String> langMap = new HashMap<String, String>();
		// Storing (key, value) pair to HashMap
		langMap.put("ENG", "English");
		langMap.put("NLD", "Dutch");
		langMap.put("ZHO", "Chinese");
		langMap.put("BEN", "Bengali");
		langMap.put("ZUL", "Zulu");
		// retrieving value using key
		String language = langMap.get("BEN");
		System.out.println("Language- " + language);

		System.out.println("-- Map Elements --");
		for (Map.Entry<String, String> lang : langMap.entrySet()) {
			System.out.println("Key- " + lang.getKey() + " Value- "
					+ lang.getValue());
		}

	}

	@Override
	public void implementionTwo(String[] args) {
		// creating HashMap
		Map<String, String> langMap = new HashMap<String, String>();
		// Storing (key, value) pair to HashMap
		langMap.put("ENG", "English");
		langMap.put("NLD", null);
		langMap.put("ZHO", null);
		langMap.put("BEN", "Bengali");
		langMap.put("ZUL", "Zulu");
		langMap.put(null, "French");
		langMap.put(null, "Hindi");

		System.out.println("-- Map Elements --");
		for (Map.Entry<String, String> lang : langMap.entrySet()) {
			System.out.println("Key- " + lang.getKey() + " Value- "
					+ lang.getValue());
		}

	}

	@Override
	public void implementionThree(String[] args) {
		// creating HashMap
		Map<String, String> langMap = new HashMap<String, String>();
		// Storing (key, value) pair to HashMap
		langMap.put("ENG", "English");
		langMap.put("NLD", "Dutch");
		langMap.put("ZHO", "Chinese");
		langMap.put("BEN", "Bengali");
		langMap.put("ZUL", "Zulu");
		langMap.put("FRE", "French");

		Set<Map.Entry<String, String>> langSet = langMap.entrySet();
		Iterator<Map.Entry<String, String>> itr = langSet.iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			System.out.println("Key is " + entry.getKey() + " Value is "
					+ entry.getValue());
			// removing value using HashMap's remove method
			if (entry.getKey().equals("NLD")) {
				langMap.remove(entry.getKey());
			}
		}

	}

	private HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		List<Map.Entry<String, Integer>> hmList = new LinkedList<Map.Entry<String, Integer>>(
				hm.entrySet());
		Collections.sort(hmList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> stringIntegerEntry,
					Map.Entry<String, Integer> t1) {
				return stringIntegerEntry.getValue().compareTo(t1.getValue());
			}
		});

		HashMap<String, Integer> hmOutput = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : hmList) {
			hmOutput.put(aa.getKey(), aa.getValue());

		}
		return hmOutput;

	}

	@Override
	public void implementionFour(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Maths", 99);
		hm.put("English", 84);
		hm.put("Hindi", 75);
		hm.put("Science", 93);
		hm.put("Gujarati", 80);
		hm.put("english", 90);
		hm.forEach((k, v) -> System.out
				.println("Key : " + k + ", Value : " + v));
		HashMapSorting hmSort = new HashMapSorting();
		HashMap sortedhm = hmSort.sortByValue(hm);
		System.out.println("****Sorted****");
		sortedhm.forEach((k, v) -> System.out.println("Key : " + k
				+ ", Value : " + v));

	}

	@Override
	public void implementionFive(String[] args) {
		Map<Key, String> cityMap = new HashMap<Key, String>();
		cityMap.put(new Key(1, "NY"), "New York City");
		cityMap.put(new Key(2, "ND"), "New Delhi");
		cityMap.put(new Key(3, "NW"), "Newark");
		cityMap.put(new Key(4, "NP"), "Newport");

		System.out.println("size before iteration " + cityMap.size());
		Iterator<Key> itr = cityMap.keySet().iterator();
		while (itr.hasNext()) {
			System.out.println(cityMap.get(itr.next()));
		}
		System.out.println("size after iteration " + cityMap.size());

	}

	/***
	 * <h1>Example code using entrySet() to get Map.Entry elements</h1>
	 * 
	 * 
	 * 
	 * Here is a Java example where we’ll get the “Collection view” of the map
	 * using the entrySet() method which returns a set view of the Map.Entry
	 * elements contained in this map.
	 */
	@Override
	public void implementionSix(String[] args) {

		Map<String, String> langMap = new HashMap<String, String>();

		langMap.put("ENG", "English");
		langMap.put("NLD", "Dutch");
		langMap.put("ZHO", "Chinese");
		langMap.put("BEN", "Bengali");
		langMap.put("ZUL", "Zulu");
		langMap.put("FRE", "French");

		// Getting Map.Entry elements using entrySet()
		Set<Map.Entry<String, String>> langSet = langMap.entrySet();
		// Looping the set of Map.Entry values
		for (Map.Entry<String, String> entry : langSet) {
			System.out.println("Key is " + entry.getKey() + " Value is "
					+ entry.getValue());
		}

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

	// This class' object is used as key
	// in the HashMap
	class Key {
		int index;
		String Name;

		Key(int index, String Name) {
			this.index = index;
			this.Name = Name;
		}

		@Override
		// A very bad implementation of hashcode
		// done here for illustrative purpose only
		public int hashCode() {
			return 5;
		}

		@Override
		// A very bad implementation of equals
		// done here for illustrative purpose only
		public boolean equals(Object obj) {
			return true;
		}
	}
}
