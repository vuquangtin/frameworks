package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.java.frameworks.base.TemplateMethod;

/**
 * <h1>Sorting arraylist containing custom objects using Comparator</h1>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class SortObjectList2 extends TemplateMethod {
	public static void main(String[] args) {
		new SortObjectList().runTemplateMethod(args);
	}

	public void implementionOne(String[] args) {
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
		Collections.sort(empList, new MyComparator());

		System.out.println("Sorted List");
		for (Employee emp : empList) {
			System.out.println("" + emp);
		}
	}

	// Stub method
	private static Employee getData(String empId, String lastName,
			String firstName, int age) {
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setLastName(lastName);
		employee.setFirstName(firstName);
		employee.setAge(age);
		return employee;
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

class MyComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		int firstCmp = o1.getFirstName().compareTo(o2.getFirstName());
		if (firstCmp == 0) {
			int lastCmp = o1.getLastName().compareTo(o2.getLastName());
			if (lastCmp == 0) {
				return (o2.getAge() < o1.getAge() ? -1 : (o2.getAge() == o1
						.getAge() ? 0 : 1));
			} else {
				return lastCmp;
			}

		} else {
			return firstCmp;
		}
	}
}