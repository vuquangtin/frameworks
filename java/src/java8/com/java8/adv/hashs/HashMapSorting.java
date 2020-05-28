package com.java8.adv.hashs;

import java.util.HashMap;
import java.util.Iterator;
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
	public void main1(String[] args) {
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
			System.out.println("Key- " + lang.getKey() + " Value- " + lang.getValue());
		}

	}

	@Override
	public void main2(String[] args) {
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
			System.out.println("Key- " + lang.getKey() + " Value- " + lang.getValue());
		}

	}

	@Override
	public void main3(String[] args) {
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
			System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());
			// removing value using HashMap's remove method
			if (entry.getKey().equals("NLD")) {
				langMap.remove(entry.getKey());
			}
		}

	}

	@Override
	public void main4(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void main5(String[] args) {
		// TODO Auto-generated method stub

	}
}
