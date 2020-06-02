package com.java8.functionalprogramming;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.adv.abs.TemplateMethod;

/**
 * "Functional Programming in Java, Harnessing the Power of Java 8 Lambda Expressions"
 * by Venkat Subramaniam
 * 
 * Requires Java 8
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class FunctionalProgramming01 extends TemplateMethod {

	public static void main(String[] args) {
		new FunctionalProgramming01().runTemplateMethod(args);

	}

	public static void findChicagoImperative(final List<String> cities) {
		boolean found = false;
		for (String city : cities) {
			if (city.equals("Chicago")) {
				found = true;
				break;
			}
		}
		System.out.println("Found chicago?:" + found);
	}

	public static void findChicagoDeclarative(final List<String> cities) {
		System.out.println("Found chicago?:" + cities.contains("Chicago"));
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		List<String> cities = Arrays.asList("Albany", "Boulder", "Chicago", "Denver", "Eugene");
		findChicagoImperative(cities);
		findChicagoDeclarative(cities);

	}

	public BigDecimal imperativeDiscounter(List<BigDecimal> prices) {
		BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
		for (BigDecimal price : prices) {
			if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
				totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
			}
		}
		return totalOfDiscountedPrices;
	}

	public BigDecimal functionalDiscounter(List<BigDecimal> prices) {
		final BigDecimal totalOfDiscountedPrices = prices.stream()
				.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
				.map(price -> price.multiply(BigDecimal.valueOf(0.9))).reduce(BigDecimal.ZERO, BigDecimal::add);
		return totalOfDiscountedPrices;
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		/*
		 * What was that about API and Copyright? Arrays.asList is a Guava
		 * thing!
		 */
		final List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
				new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"),
				new BigDecimal("12"));

		System.out.println("imperativeDiscounter() => " + imperativeDiscounter(prices));
		System.out.println("functionalDiscounter() => " + functionalDiscounter(prices));

	}

	public static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

	public static final List<String> editors = Arrays.asList("Brian", "Jackie", "John", "Mike");

	public static final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

	/***
	 * Iteration
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		// self-inflicted wound pattern...
		System.out.print("for i gets 0....");
		for (int i = 0; i < friends.size(); i++) {
			System.out.print(" " + friends.get(i));
		}

		System.out.print("\nfor x in y....");
		for (String name : friends) {
			System.out.print(" " + name);
		}

		System.out.print("\nIterable.forEach old-school anonymous inner class...");
		friends.forEach(new Consumer<String>() {
			public void accept(final String name) {
				System.out.print(" " + name);
			}
		});

		System.out.print("\nIterable.forEach full lambda expression...");
		friends.forEach((final String name) -> System.out.print(" " + name));

		System.out.print("\nIterable.forEach lambda expression, type inference...");
		friends.forEach((name) -> System.out.print(" " + name));

		System.out.print("\nIterable.forEach lambda expression, type inference on single parameter...");
		friends.forEach(name -> System.out.print(" " + name));

		System.out.print("\nIterable.forEach method-reference...");
		friends.forEach(System.out::print);

	}

	/***
	 * PickALongest
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		// mapToInt() maps, sum() reduces...
		{
			System.out.println("Total number of characters in all names: "
					+ friends.stream().mapToInt(name -> name.length()).sum());
		}

		// reduce carries forward its result...
		final Optional<String> aLongName = friends.stream()
				.reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));

		// You can set a default or base value for the reduce and get rid of the
		// Optional...
		final String steveOrLonger = friends.stream().reduce("Steve",
				(name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
		System.out.println(steveOrLonger);

	}

	public static void uglyPickName(final List<String> names, final String startingLetter) {
		String foundName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				foundName = name;
				break;
			}
		}
		System.out.print(String.format("A name starting with %s: ", startingLetter));

		if (foundName != null) {
			System.out.println(foundName);
		} else {
			System.out.println("No name found");
		}
	}

	public static void functionalPickName(final List<String> names, final String startingLetter) {
		// BobK. Hmmm. We have to walk the whole collection and then
		// .findFirst()!? P35 says "NO!"
		final Optional<String> foundName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		System.out.println(
				String.format("A name starting with %s: %s", startingLetter, foundName.orElse("No name found")));
		foundName.ifPresent(name -> System.out.println("Hello " + name));
	}

	/***
	 * PickAnElement
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		uglyPickName(friends, "N");
		uglyPickName(friends, "Z");

		functionalPickName(friends, "N");
		functionalPickName(friends, "Z");

	}

	// Note how this doesn't return boolean, it returns a Predicate.
	public static Predicate<String> checkIfStartsWith(final String letter) {
		return name -> name.startsWith(letter);
	}

	/***
	 * PickDifferentNames
	 */
	@Override
	public void implementionSix(String[] args) throws Exception {
		{
			// There is obvious room for improvement here...
			final Predicate<String> startsWithN = name -> name.startsWith("N");
			final Predicate<String> startsWithB = name -> name.startsWith("B");

			final long countFriendsStartN = friends.stream().filter(startsWithN).count();
			final long countFriendsStartB = friends.stream().filter(startsWithB).count();

			System.out.println("countFriendsStartN: " + countFriendsStartN);
			System.out.println("countFriendsStartB: " + countFriendsStartB);
		}

		{ // BobK says "remove duplication like you already know how to"...
			final Predicate<String> startsWithNorB = name -> (name.startsWith("N") || name.startsWith("B"));

			final long countFriendsStartNorB = friends.stream().filter(startsWithNorB).count();

			System.out.println("countFriendsStartNorB: " + countFriendsStartNorB);
		}
		{ // BobK says "lookie at that .or thing on Predicate"...
			final Predicate<String> startsWithN = name -> name.startsWith("N");
			final Predicate<String> startsWithB = name -> name.startsWith("B");

			final long countFriendsStartNorB = friends.stream().filter(startsWithN.or(startsWithB)).count();

			System.out.println("countFriendsStartNorB: " + countFriendsStartNorB);
		}
		{ // P31: Venkat says "Remove Duplication with Lexical Scoping"...
			final long countFriendsStartN = friends.stream().filter(checkIfStartsWith("N")).count();
			final long countFriendsStartB = friends.stream().filter(checkIfStartsWith("B")).count();

			System.out.println("countFriendsStartN: " + countFriendsStartN);
			System.out.println("countFriendsStartB: " + countFriendsStartB);
		}
		{ // Venkat says
			// "We don't want to pollute the class with static methods"...
			final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
				Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
				return checkStarts;
			};

			final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
			final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

			System.out.println("countFriendsStartN: " + countFriendsStartN);
			System.out.println("countFriendsStartB: " + countFriendsStartB);
		}
		{ // Venkat says
			// "Replace the explicit Predicate instance with a lambda
			// expression"...
			final Function<String, Predicate<String>> startsWithLetter = (
					String letter) -> (String name) -> name.startsWith(letter);

			final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
			final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

			System.out.println("countFriendsStartN: " + countFriendsStartN);
			System.out.println("countFriendsStartB: " + countFriendsStartB);
		}
		{ // Venkat says
			// "let the Java compiler infer the types based on the context"...
			final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);

			final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
			final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

			System.out.println("countFriendsStartN: " + countFriendsStartN);
			System.out.println("countFriendsStartB: " + countFriendsStartB);
		}
		{ // TODO: Bob wants a vararg Predicate. Where is George Smith when you
			// need him?
		}

	}

	/***
	 * PickElements
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		{
			// self-inflicted wound pattern...
			final List<String> startsWithN = new ArrayList<String>();
			for (String name : friends) {
				if (name.startsWith("N")) {
					startsWithN.add(name);
				}
			}
			System.out.println(String.format("for x in y...Found %d names", startsWithN.size()));
		}

		final List<String> startsWithN = friends.stream().filter(name -> name.startsWith("N"))
				.collect(Collectors.toList());
		System.out.println(String.format("Stream.filter.collect...Found %d names", startsWithN.size()));

	}

	/***
	 * PickElementsMultipleCollection
	 */
	@Override
	public void implementionEight(String[] args) throws Exception {
		{
			final long countFriendsStartN = friends.stream().filter(name -> name.startsWith("N")).count();
			// Yuk..
			final long countEditorsStartN = editors.stream().filter(name -> name.startsWith("N")).count();
			// Yuk.
			final long countComradesStartN = comrades.stream().filter(name -> name.startsWith("N")).count();

			System.out.println(countFriendsStartN);
			System.out.println(countComradesStartN);
			System.out.println(countEditorsStartN);
		}

		{
			// Thats better...
			final Predicate<String> startsWithN = name -> name.startsWith("N");

			final long countFriendsStartN = friends.stream().filter(startsWithN).count();
			final long countEditorsStartN = editors.stream().filter(startsWithN).count();
			final long countComradesStartN = comrades.stream().filter(startsWithN).count();

			System.out.println(countFriendsStartN);
			System.out.println(countComradesStartN);
			System.out.println(countEditorsStartN);
		}

	}

	/***
	 * PrintList
	 */
	@Override
	public void implementionNine(String[] args) throws Exception {
		// Dangling comma sucks...
		System.out.println("//" + "START:FOREACH_OUTPUT");
		for (String name : friends) {
			System.out.print(name + ", ");
		}
		System.out.println();
		System.out.println("//" + "END:FOREACH_OUTPUT");

		// Avoiding the dangling comma sucks too...
		System.out.println("//" + "START:FOR_OUTPUT");
		for (int i = 0; i < friends.size() - 1; i++) {
			System.out.print(friends.get(i) + ", ");
		}
		if (friends.size() > 0) {
			System.out.println(friends.get(friends.size() - 1));
		}
		System.out.println("//" + "END:FOR_OUTPUT");

		// Ahhh. That looks better...
		System.out.println("//" + "START:JOIN_OUTPUT");
		System.out.println(String.join(", ", friends));
		System.out.println("//" + "END:JOIN_OUTPUT");

		System.out.println("//" + "START:MAP_JOIN_OUTPUT");
		System.out.println(friends.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));
		System.out.println("//" + "END:MAP_JOIN_OUTPUT");

	}

	/***
	 * Transform
	 */
	@Override
	public void implementionTen(String[] args) throws Exception {
		{
			// self-inflicted wound pattern...
			final List<String> uppercaseNames = new ArrayList<String>();
			for (String name : friends) {
				uppercaseNames.add(name.toUpperCase());
			}
			System.out.println("for x in y...." + uppercaseNames);
		}
		{
			final List<String> uppercaseNames = new ArrayList<String>();
			friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
			System.out.println("Iterable.forEach lambda expression, type inference..." + uppercaseNames);
		}

		System.out.print("Stream.map over Iterable.forEach...");
		friends.stream().map(name -> name.toUpperCase()).forEach(name -> System.out.print(name + " "));

		System.out.print("\nStream.map over Iterable.forEach, different type...");
		friends.stream().map(name -> name.length())
				.forEach(count -> System.out.print(count.getClass().getSimpleName() + "( " + count + " ) "));

		System.out.print("\nStream.map with Method Reference over Iterable.forEach...");
		friends.stream().map(String::toUpperCase).forEach(name -> System.out.print(name + " "));

	}

}
