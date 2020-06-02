package com.java8.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.java8.adv.abs.ExtendTemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Udemy extends ExtendTemplateMethod {

	public static void main(String[] args) {
		new Udemy().runTemplateMethod(args);

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);
		printOddNumbersinListStructure(numbers);

	}

	private static void printOddNumbersinListStructure(List<Integer> numbers) {
		numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		List<String> courses = Lists.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");
		printAllCoursesinListStructure(courses);

	}

	private static void printAllCoursesinListStructure(List<String> courses) {
		courses.stream().forEach(System.out::println);
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		List<String> courses = Lists.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");
		printAllCoursesinListStructure2(courses);

	}

	private static void printAllCoursesinListStructure2(List<String> courses) {
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		List<String> courses = Lists.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");
		printAllCoursesinListStructure3(courses);
	}

	private static void printAllCoursesinListStructure3(List<String> courses) {
		courses.stream().filter(course -> course.length() > 3).forEach(System.out::println);
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		List<Integer> numbers = Lists.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		printCubesofOddNumbersInListFunctional(numbers);
	}

	private static void printCubesofOddNumbersInListFunctional(List<Integer> numbers) {

		numbers.stream().filter(number -> number % 2 != 0)
				// Use of Lambda Expression
				.map(x -> x * x * x)
				// Use of map for mapping x -> x*x
				.forEach(System.out::println);

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {

		List<String> courses = Lists.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");
		printNoOfCharactersinEachCoursesinListStructure(courses);
	}

	private static void printNoOfCharactersinEachCoursesinListStructure(List<String> courses) {
		courses.stream().map(course -> course + "-" + course.length()).forEach(System.out::println);

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// Using IDE
		List<Integer> numbers = Lists.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		System.out.println(numbers.stream().map(x -> x * x).reduce(0, (x, y) -> x + y));
		System.out.println(numbers.stream().map(x -> x * x).reduce(0, Integer::sum));

		// Using JShell
		// jshell> numbers.stream().map(x -> x*x).reduce(0, (a,b) -> a+b)
		// $3 ==> 835

		// jshell> numbers.stream().map(x -> x*x).reduce(0, Integer::sum)
		// $3 ==> 835

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// Using IDE
		List<Integer> numbers = Lists.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		System.out.println(numbers.stream().filter(x -> x % 2 != 0).reduce(0, (a, b) -> a + b));
		System.out.println(numbers.stream().filter(x -> x % 2 != 0).reduce(0, Integer::sum));

		// Using JShell
		// jshell> numbers.stream().filter(x -> x%2 !=0).reduce(0, (a,b) -> a+b)
		// $5 ==> 37

		// jshell> numbers.stream().filter(x -> x%2 !=0).reduce(0, Integer::sum)
		// $4 ==> 37
	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		List<Integer> numbers = Lists.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<Integer> evenNumbers = evenList(numbers);
		System.out.println(evenNumbers);
		List<Integer> evenNumbers1 = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
	}

	private static List<Integer> evenList(List<Integer> numbers) {
		return numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
	}

	@Override
	public void implementionEleven(String[] args) throws Exception {
		List<String> courses = Lists.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");
		List<Integer> courselen = courseLenList(courses);
		System.out.println(courselen);
	}

	private static List<Integer> courseLenList(List<String> courses) {
		return courses.stream().map(str -> str.length()).collect(Collectors.toList());
	}
	// jshell>courses.stream().map(str ->
	// str.length()).collect(Collectors.toList());
	// $19 ==> [6, 11, 3, 13, 3, 3, 5, 6, 10]

	@Override
	public void implementionTwelve(String[] args) throws Exception {
		// Given, int sum = numbers.stream() .reduce(0, Integer::sum);

		List<Integer> numbers = Lists.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		// Scenario 1
		int sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum);

		// Scenario 2
		BinaryOperator<Integer> accumulator = Integer::sum;
		int sum1 = numbers.stream().reduce(0, accumulator);
		System.out.println(sum1);

		// Scenario 3
		BinaryOperator<Integer> accumulator2 = new BinaryOperator<Integer>() {
			public Integer apply(Integer x, Integer y) {
				return x + y;
			}
		};

		int sum2 = numbers.stream().reduce(0, accumulator2);
		System.out.println(sum2);

	}

	@Override
	public void implementionThirteen(String[] args) throws Exception {
		// Given, List squaredNumbers = numbers.stream().map(x ->
		// x*x).collect(Collectors.toList());
		List<Integer> numbers = Lists.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List squaredNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());

		// Using Behvaior Parameterisation
		List squaredNumbers2 = mapAndCreateNewList(numbers, x -> x * x);
		List cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);
		List doubledNumbers = mapAndCreateNewList(numbers, x -> 2 * x);
		System.out.println(squaredNumbers2);
		System.out.println(cubedNumbers);
		System.out.println(doubledNumbers);
	}

	private static List<? extends Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<Integer, Integer> mappingFunction) {
		return numbers.stream().map(mappingFunction).collect(Collectors.toList());
	}

	@Override
	public void implementionFourteen(String[] args) throws Exception {
		Runnable runnable2 = () -> { // Lambda Expression
			IntStream.range(0, 10).forEach(i -> System.out.println(Thread.currentThread().getId() + ":" + i));
		};

		Thread thread = new Thread(runnable2);
		thread.start();

		Thread thread1 = new Thread(runnable2);
		thread1.start();

		Thread thread2 = new Thread(runnable2);
		thread2.start();

	}

	@Override
	public void implementionFifteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEighteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNineteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTwenty(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}
