package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <h1>How to Sort ArrayList of Custom Objects in Java</h1> In the post How to
 * sort ArrayList in Java you have already seen how to sort an ArrayList of
 * Strings, Integers or Dates. In this post we'll see how to sort an ArrayList
 * of custom objects in Java.
 * 
 * 
 * In order to sort an ArrayList of objects you can use sort() method provided
 * by the Collections class, which takes List as an argument. Note that there
 * are two overloaded variants of the sort() method.
 * 
 * <ul>
 * <li>sort(List<T> list)- If you are using this method to sort ArrayList of
 * objects, the class whose objects are stored in the List should implement
 * Comparable interface. If the class whose objects are stored in the List
 * doesn’t implement the Comparable interface and you pass that list as an
 * argument in sort(List<T> list) method that will result in compile time error.
 * See example.</li>
 * <li>sort(List<T> list, Comparator<? super T> c)- This is another overloaded
 * sort() method where you can pass your own Comparator along with the List that
 * has to be sorted. See example.</li>
 * <li>Let’s see examples using both Comparable and Comparator interfaces to
 * sort ArrayList of objects in Java.</li>
 * </ul>
 * Sorting arraylist containing custom objects using Comparable Let's say you
 * have an Employee class. Objects of this Employee class are stored in an
 * ArrayList and you want to sort it on first name and last name.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
class Employee implements Comparable<Employee> {
	private String lastName;
	private String firstName;
	private String empId;
	private int age;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getAge() + " " + getEmpId();
	}

	@Override
	public int compareTo(Employee o) {
		int firstCmp = this.getFirstName().compareTo(o.getFirstName());
		return firstCmp != 0 ? firstCmp : this.getLastName().compareTo(o.getLastName());
	}
}

public class SortObjectList {
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		// Storing elements in the arraylist
		empList.add(getData("E001", "Mishra", "Pyaremohan", 35));
		empList.add(getData("E002", "Smith", "John", 45));
		empList.add(getData("E003", "Sharma", "Ram", 23));
		empList.add(getData("E004", "Mishra", "Pyaremohan", 60));
		empList.add(getData("E005", "Caroll", "Eva", 32));
		empList.add(getData("E003", "Tiwari", "Ram", 23));

		System.out.println("Original List");
		for (Employee emp : empList) {
			System.out.println("" + emp);
		}
		// Sorting the list
		Collections.sort(empList);

		System.out.println("Sorted List");
		for (Employee emp : empList) {
			System.out.println("" + emp);
		}
	}

	// Stub method
	private static Employee getData(String empId, String lastName, String firstName, int age) {
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setAge(age);
		return employee;
	}

	public static void main2(String[] args) {
		// Using diamond operator (Right side no type specified)
		// Available from Java7 onwards
		List<String> cityList = new ArrayList<>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Mumbai");
		// sorting the list in descending order
		Collections.sort(cityList, Collections.reverseOrder());
		// Displaying the list
		for (String city : cityList) {
			System.out.println("Name " + city);
		}
	}

	public static void main3(String[] args) {
		// Using diamond operator (Right side no type specified)
		// Available from Java7 onwards
		List<String> cityList = new ArrayList<>();
		cityList.add("Delhi");
		cityList.add("Mumbai");
		cityList.add("Bangalore");
		cityList.add("Chennai");
		cityList.add("Kolkata");
		cityList.add("Mumbai");
		// sorting the list in descending order
		Collections.sort(cityList, new MyComparator());
		// Displaying the list
		for (String city : cityList) {
			System.out.println("Name " + city);
		}
	}

	// Custom comparator class
	static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	}
}
