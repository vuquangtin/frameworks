package com.java8.methodreferences.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class SortPerson1 {
	protected List<Person> persons;
	protected List<Person> personsOrig;

	public static List<Person> createPersons() {
		List<Person> myPersons = new ArrayList<Person>();
		Person p;
		for (String name : SortCollection1.STUDENTS_ARRAY) {
			p = new Person(name);
			myPersons.add(p);
		}

		return myPersons;
	}

	/**
	 * @param n
	 *            number of times to add p into returned list
	 * @param p
	 *            optional instance to populate the returned list with. If null,
	 *            new Person("",0) is used
	 * @return List<Person> created and filled with p, n times
	 */
	public static List<Person> createPersons(int n, Person p) {
		p = p != null ? p : new Person("", 0);
		List<Person> myPersons = new ArrayList<Person>(n); // NOTE this is still
															// an empty List
															// with initial
															// capacity of
															// personsOrig size
		// unfortunately there isn't a clone or factory method in Collections.
		// So have to create "target" collection with some garbage
		for (int i = 0; i < n; i++) {
			p = new Person("", 0);
			myPersons.add(p);
		}
		return myPersons;
	}

	public SortPerson1() {
		// personsOrig = SortPerson1.createPersons();
		personsOrig = createPersons(); // NOTE this line is equivalent to above
										// one. Although above one is
										// recommended, this line is OK in the
										// same class.
		persons = personsOrig;
	}

	public List<Person> sortPerson1() {
		System.out.println("BEFORE sorting:" + persons);

		Collections.sort(persons);
		System.out.println("AFTER sorting:" + persons);

		return null;
	}

	public List<Person> sortPersonInReverseOfNaturalOrder() {
		// persons = personsOrig; // WRONG to do shallow copy, instead do deep
		// copy like below
		persons = new ArrayList<Person>(personsOrig);
		System.out.println("BEFORE sorting:" + persons);

		Comparator reverseOfNaturalOrderComparator = Collections.reverseOrder();
		Collections.sort(persons, reverseOfNaturalOrderComparator);
		System.out.println("AFTER sorting:" + persons);

		return null;
	}

	public List<Person> sortPersonBasedOnAge() {
		// persons = personsOrig; // WRONG to do shallow copy, instead do deep
		// copy like below
		persons = new ArrayList<Person>(personsOrig);
		System.out.println("BEFORE sorting:" + persons);

		Person.PersonAgeComparator personAgeComparator = new Person.PersonAgeComparator();
		Collections.sort(persons, personAgeComparator);
		System.out.println("AFTER sorting:" + persons);

		return null;
	}

	public List<Person> sortPersonBasedOnReverseAge() {
		persons = personsOrig;
		System.out.println("BEFORE sorting:" + persons);

		Person.PersonAgeComparator personAgeComparator = new Person.PersonAgeComparator();
		Comparator reverseAgeComparator = Collections
				.reverseOrder(personAgeComparator);
		Collections.sort(persons, reverseAgeComparator);
		System.out.println("AFTER sorting:" + persons);

		return null;
	}

}