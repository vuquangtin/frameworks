package com.java8.methodreferences.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Person implements Comparable<Person> {
	public static List<Person> roster;
	static {
		roster = new ArrayList<>();

		for (int i = 0; i < 100; i++) {

			// Person person = new Person("Person " + i, i);
			Person person = new Person("Person " + i, i, i % 2 == 0 ? Sex.MALE
					: Sex.FEMALE, "gmail00" + i + "@gmail.com");
			roster.add(person);
		}

	}

	public static List<Person> getRoster() {
		return roster;
	}

	public static void setRoster(List<Person> roster) {
		Person.roster = roster;
	}

	public static class PersonAgeComparator implements Comparator<Person> {

		@Override
		public int compare(Person left, Person right) {
			return left.getAge().compareTo(right.getAge());
		}
	}

	public enum Sex {
		MALE, FEMALE
	}

	public Person(String name, int age, Sex gender, String emailAddress) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.emailAddress = emailAddress;
	}

	public Person(String _name) {
		name = _name;

		// generate a random int value and assign to age
		Random generator = new Random();
		age = generator.nextInt(10);
	}

	public Person(String _name, int _age) {
		name = _name;
		age = _age;
	}

	private String name;

	public String getName() {
		return name;
	}

	LocalDate birthday;
	Sex gender;
	String emailAddress;
	private Integer age;

	public Integer getAge() {
		return age;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append(name).append(",").append(age).append("}");
		return sb.toString();
	}

	@Override
	public int compareTo(Person p) {
		return name.compareTo(p.name);
	}
}
