package com.java8.function.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.DoublePredicate;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class LambdaExercize {

	@Test
	public void reverseCountryName() {

		List<Country> countries = Countries.getCountries();

		List<String> reverseCountries = countries.stream().map(c -> new StringBuilder(c.getName()).reverse().toString())
				.collect(Collectors.toList());

		System.out.println(reverseCountries);

	}

	@Test
	public void upperCaseCountryName() {

		List<Country> countries = Countries.getCountries();
		List<String> upperCaseCountries = countries.stream().map(c -> c.getName().toUpperCase()).collect(Collectors.toList());

		System.out.println(upperCaseCountries);

	}

	@Test
	public void countryStartWithC() {

		List<Country> countries = Countries.getCountries();
		List<String> upperCaseCountries = countries.stream().map(Country::getName).filter(s -> s.startsWith("C"))
				.collect(Collectors.toList());

		System.out.println(upperCaseCountries);

	}

	@Test
	public void sumOfAllNameLength() {

		List<Country> countries = Countries.getCountries();
		int sum = countries.stream().mapToInt(c -> c.getName().length()).sum();

		System.out.println(sum);

	}

	@Test
	public void longestCountryLength() {

		List<Country> countries = Countries.getCountries();
		Country c = countries.stream().reduce((c1, c2) -> c1.getName().length() > c2.getName().length() ? c1 : c2)
				.get();

		System.out.println(c);

	}

//	@Test
//	public void sortCountryByPoulation() {
//
//		List<Country> countries = Countries.getCountries();
//		countries.stream().parallel().sorted(comparing(Country::getPopulation)).forEach(System.out::println);
//		;
//
//	}

	@Test
	public void groupCountryByContient() {

		List<Country> countries = Countries.getCountries();
		countries.stream().collect(Collectors.groupingBy(Country::getContinent)).forEach((k, v) -> {
			System.out.println("Continent : " + k);
			System.out.println(v);
		});

	}

	@Test
	public void listAllFilesOrDirectoryOnly() throws IOException {

		Files.list(Paths.get(".")).forEach(System.out::println);

		Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

	}

	@Test
	public void biPrdicate() {
		BiPredicate<Integer, Integer> bp = (i, j) -> i > j;
		System.out.println(bp.test(10, 20));
		System.out.println(bp.test(40, 20));
	}

	@Test
	public void booleanSupplier() {
		BooleanSupplier bs = () -> {
			return 10 > 20;
		};
		System.out.println(bs.getAsBoolean());

	}

	@Test
	public void doublePredicate() {
		DoublePredicate dp = (x) -> {
			return x > 20;
		};
		System.out.println(dp.test(10.2));

	}

	@Test
	public void intSupplier() {
		IntSupplier is = () -> {
			return new Integer(10);
		};
		System.out.println(is.getAsInt());

	}

	@Test
	public void helloWorldLambda() {

//		FunctionalHello f = () -> {
//			System.out.println("hello world");
//		};
//		f.apply();
	}

}