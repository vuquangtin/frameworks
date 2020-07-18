package com.java8.adv.jls14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.java.frameworks.base.ExtendTemplateMethod;
import com.java8.adv.jls14.Chapter15.T;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Chapter15MethodReferences extends ExtendTemplateMethod {
	public static void main(String[] args) {
		new Chapter15MethodReferences().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		//Not allowed to include parameters, should give syntactic error
				Object f = String::charAt(a, b);
		
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		boolean b;
		// Must include parantheses, should give syntactic error
		Object f = b ? new ArrayList<Integer>() : new List<Integer>(
				String::iterator);

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// Conflict with: methodCall(Runnable < Integer, Double, String,
		// Double);
		Object f = methodCall(Runnable<Integer, Double, String, Double>::run);

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// /Testing if it can handle the >>> operator to match a methodreference
		Object f = methodCall(
				a,
				3,
				Runnable<ArrayList<Integer>, Callable<Map<Integer, String>>>::run);
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		//one > is missing, should give syntactic error
				Object f = methodCall(a, Runnable<ArrayList<Integer>, Callable<Integer>::run, 3);

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		Object f = System::getProperty;

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		Object f = String::length;

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		Object f = int[]::clone;

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		Object f = T::tvarMember;

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		Consumer<String> c = s -> System.out.println(s);
		Consumer<String> c2 = System.out::println;
	}

	public static boolean isMoreThanFifty(int n1, int n2) {
		return (n1 + n2) > 50;
	}

	public static List<Integer> findNumbers(List<Integer> l,
			BiPredicate<Integer, Integer> p) {
		List<Integer> newList = new ArrayList<>();
		for (Integer i : l) {
			if (p.test(i, i + 10)) {
				newList.add(i);
			}
		}
		return newList;
	}

	@Override
	public void implementionEleven(String[] args) throws Exception {
		List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

		// Using an anonymous class
		logger.debug(findNumbers(list, new BiPredicate<Integer, Integer>() {
			public boolean test(Integer i1, Integer i2) {
				return isMoreThanFifty(i1, i2);
			}
		}));

		// Using a lambda expression
		logger.debug(findNumbers(list, (i1, i2) -> isMoreThanFifty(i1, i2)));

		// Using a method reference
		logger.debug(findNumbers(list,
				Chapter15MethodReferences::isMoreThanFifty));

	}

	class Shipment {
		public double calculateWeight() {
			double weight = 0;
			// Calculate weight
			return weight;
		}
	}

	public List<Double> calculateOnShipments(List<Shipment> l,
			Function<Shipment, Double> f) {
		List<Double> results = new ArrayList<>();
		for (Shipment s : l) {
			results.add(f.apply(s));
		}
		return results;
	}

	@Override
	public void implementionTwelve(String[] args) throws Exception {
		List<Shipment> l = new ArrayList<Shipment>();

		// Using an anonymous class
		logger.debug(calculateOnShipments(l, new Function<Shipment, Double>() {
			public Double apply(Shipment s) { // The object
				return s.calculateWeight(); // The method
			}
		}));

		// Using a lambda expression
		logger.debug(calculateOnShipments(l, s -> s.calculateWeight()));

		// Using a method reference
		logger.debug(calculateOnShipments(l, Shipment::calculateWeight));

	}

	@Override
	public void implementionThirteen(String[] args) throws Exception {
		// Using an anonymous class
		Supplier<List<String>> s = new Supplier() {
			public List<String> get() {
				return new ArrayList<String>();
			}
		};
		List<String> l = s.get();

		// Using a lambda expression
		Supplier<List<String>> s2 = () -> new ArrayList<String>();
		List<String> l2 = s2.get();

		// Using a method reference
		Supplier<List> ls = ArrayList::new;
		List<String> ls2 = s.get();

	}

	@Override
	public void implementionFourteen(String[] args) throws Exception {
		// Using an anonymous class
		Function<String, Integer> f = new Function<String, Integer>() {
			public Integer apply(String s) {
				return new Integer(s);
			}
		};
		Integer i = f.apply("100");
		logger.debug(i);
		// Using a lambda expression
		Function<String, Integer> f2 = s -> new Integer(s);
		Integer i2 = f2.apply("100");
		logger.debug(i2);
		// Using a method reference
		Function<String, Integer> f3 = Integer::new;
		Integer i3 = f3.apply("100");
		logger.debug(i3);
	}

	@Override
	public void implementionFifteen(String[] args) throws Exception {
		// Using a anonymous class
		BiFunction<String, String, Locale> f = new BiFunction<String, String, Locale>() {
			public Locale apply(String lang, String country) {
				return new Locale(lang, country);
			}
		};
		Locale loc = f.apply("en", "UK");

		// Using a lambda expression
		BiFunction<String, String, Locale> f2 = (lang, country) -> new Locale(
				lang, country);
		Locale loc2 = f2.apply("en", "UK");

		// Using a method reference
		BiFunction<String, String, Locale> f3 = Locale::new;
		Locale loc3 = f3.apply("en", "UK");

	}

	public static void raiseToThePowerOfTwo(double num) {
		double result = Math.pow(num, 2);
		System.out.println(result);
	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		List<Double> integerList = new ArrayList<>();
		integerList.add(new Double(5));
		integerList.add(new Double(2));
		integerList.add(new Double(6));
		integerList.add(new Double(1));
		integerList.add(new Double(8));
		integerList.add(new Double(9));

		integerList.forEach(Chapter15MethodReferences::raiseToThePowerOfTwo);

	}

	/*
	 * Instance Methods of Arbitrary Objects
	 * 
	 * This example has already been shown in the beginning of the article when
	 * we've boiled down the imperative approach into a functional approach via
	 * Lambda Expressions.
	 * 
	 * Though, for good measure, since this approach is used really often, let's
	 * take a look at another example:
	 */
	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		List<Integer> integerList = new ArrayList<>();
		integerList.add(new Integer(5));
		integerList.add(new Integer(2));
		integerList.add(new Integer(6));
		integerList.add(new Integer(1));
		integerList.add(new Integer(8));
		integerList.add(new Integer(9));

		// Referencing the non-static compareTo method from the Integer class
		Collections.sort(integerList, Integer::compareTo);

		// Referencing static method
		integerList.forEach(System.out::print);

	}

	@Override
	public void implementionEighteen(String[] args) throws Exception {
		// Classic instantiation
		Employee employee = new Employee();

		// Constructor reference
		Supplier<Employee> employee2 = Employee::new;
		logger.debug(employee2.get());
		// Based on the context, if multiple constructors are present, the
		// adequate one will be used if referenced:

		// Making a list of employees
		List<String> employeeList = Arrays.asList("David", "Scott", "David",
				"Scott", "David", "Scott");

		// Mapping a list to Employee objects and returning them as an array
		Employee[] employeeArray = employeeList.stream().map(Employee::new)
				.toArray(Employee[]::new);
		Stream<Employee> stream = employeeList.stream().map(Employee::new);
		// Iterating through the array and printing information
		for (int i = 0; i < employeeArray.length; i++) {
			System.out.println(employeeArray[i].toString());
		}
	}

	interface ListFactory {
		<T> List<T> make();
	}

	@Override
	public void implementionNineteen(String[] args) throws Exception {
		ListFactory lf = ArrayList::new;
		List<String> ls = lf.make();
		List<Number> ln = lf.make();

	}

	@Override
	public void implementionTwenty(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}
