package com.java8.functionalprogramming;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java.frameworks.base.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class FunctionalProgramming03 extends TemplateMethod {
	public static void main(String[] args) {
		new FunctionalProgramming03().runTemplateMethod(args);
	}

	/**
	 * Bob just can't quit his procedural ways!?! Am I functional? Is this a
	 * higher order function? Probably not as it does something rather than
	 * return a function that does something.
	 * 
	 * @param list
	 *            of Person to be sorted.
	 * @param c
	 *            Comparator function
	 * @return
	 */
	static List<Person> sortORama(List<Person> list, Comparator<Person> c) {
		return list.stream().sorted(c).collect(Collectors.toList());
	}

	// BobK doesn't think the compareByAge method belongs on Person.
	static int compareByAge(Person p1, Person p2) {
		return p1.age - p2.age;
	}

	public static void printPeople(final String message, final List<Person> people) {
		System.out.println(message);
		people.forEach(System.out::println);
	}

	/***
	 * compare
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		final List<Person> people = Arrays.asList(new Person("Robert", 49), new Person("John", 20),
				new Person("Sara", 21), new Person("Chloe", 18), new Person("Jane", 21), new Person("Greg", 35));

		printPeople("ascendingByAge", sortORama(people, (p1, p2) -> p1.age - p2.age));
		printPeople("ascendingByAgeAlt", sortORama(people, FunctionalProgramming03::compareByAge));

		Comparator<Person> compareAscending = (p1, p2) -> p1.age - p2.age;
		Comparator<Person> compareDescending = compareAscending.reversed();
		Comparator<Person> bobsDescending = (p1, p2) -> -compareAscending.compare(p1, p2);

		printPeople("compareAscending", sortORama(people, compareAscending));
		printPeople("compareDescending", sortORama(people, compareDescending));
		printPeople("bobsDescending", sortORama(people, bobsDescending));

		printPeople("ascendingByName", sortORama(people, (p1, p2) -> p1.name.compareTo(p2.name)));

		// Argh. Too bad we don't get partially applied functions then I could
		// all System.out.printf this
		people.stream().min(compareAscending).ifPresent(p -> System.out.printf("youngest %s\n", p));
		people.stream().max(compareAscending).ifPresent(p -> System.out.printf("oldest %s\n", p));

		final Function<Person, String> byName = person -> person.name;
		final Function<Person, Integer> byAge = person -> person.age;
		printPeople("ascendingByAgeThenName", sortORama(people, Comparator.comparing(byAge).thenComparing(byName)));

	}

	static void lambdaStringIterate_ctoi(final String s) {
		System.out.println("lambdaStringIteration( s: " + s + " )");
		s.chars().forEach(ch -> System.out.println(ch));
	}

	static void methodRefStringIterate_ctoi(final String s) {
		System.out.println("methodReferenceIteration( s: " + s + " )");
		s.chars().forEach(System.out::println);
	}

	private static void printChar(int i) {
		System.out.println((char) i);
	}

	private static void myMethodRefStringIterage(String s) {
		System.out.println("myMethodRefStringIterage( s: " + s + " )");
		s.chars().forEach(FunctionalProgramming03::printChar);
	}

	private static void mapToObjStringIterate(String s) {
		System.out.println("mapToObjStringIterate( s: " + s + " )");
		s.chars().mapToObj(ch -> (char) ch).forEach(System.out::println);
	}

	private static void filterDigitsStringIterate(String s) {
		System.out.println("filterDigitsStringIterate( s: " + s + " )");
		s.chars().filter(ch -> Character.isDigit(ch)).forEach(i -> printChar(i));
	}

	private static void methodRefFilterDigitsStringIterate(String s) {
		System.out.println("methodRefFilterDigitsStringIterate( s: " + s + " )");
		s.chars().filter(ch -> Character.isDigit(ch)).forEach(FunctionalProgramming03::printChar);
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		final String str = "w00t";
		lambdaStringIterate_ctoi(str);
		methodRefStringIterate_ctoi(str);
		myMethodRefStringIterage(str);
		mapToObjStringIterate(str);
		filterDigitsStringIterate(str);
		methodRefFilterDigitsStringIterate(str);

	}

	/***
	 * OlderThan20
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		final List<Person> people = Arrays.asList(new Person("Robert", 49), new Person("John", 20),
				new Person("Sara", 21), new Person("Chloe", 18), new Person("Jane", 21), new Person("Greg", 35));

		List<Person> olderThan20_a = new ArrayList<>();
		people.stream().filter(person -> person.age > 20).forEach(person -> olderThan20_a.add(person));
		printPeople("don't trust olderThan20_a", olderThan20_a);

		List<Person> olderThan20_b = people.stream().filter(person -> person.age > 20).collect(ArrayList::new,
				ArrayList::add, ArrayList::addAll);
		printPeople("don't trust olderThan20_b", olderThan20_b);

		List<Person> olderThan20_c = people.stream().filter(person -> person.age > 20).collect(Collectors.toList());
		printPeople("don't trust olderThan20_c", olderThan20_c);

		Map<Integer, List<Person>> peopleByAge = people.stream().collect(Collectors.groupingBy(person -> person.age));
		System.out.println("Grouped by age: " + peopleByAge);

		Map<Integer, List<String>> nameOfPeopleByAge = people.stream().collect(Collectors
				.groupingBy(person -> person.age, Collectors.mapping(person -> person.name, Collectors.toList())));
		System.out.println("People grouped by age: " + nameOfPeopleByAge);

		// Group the names by their first char and then get the oldest person in
		// each group
		Comparator<Person> byAge = Comparator.comparing(person -> person.age);
		Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream().collect(Collectors
				.groupingBy(person -> person.name.charAt(0), Collectors.reducing(BinaryOperator.maxBy(byAge))));
		System.out.println("Oldest person of each letter:");
		System.out.println(oldestPersonOfEachLetter);
	}

	/***
	 * WatchFileChange
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		System.out.println("begin");
		new Thread(() -> watchFileChange()).start();
		final File file = new File("sample.txt");
		try {
			file.createNewFile();
			Thread.sleep(2000);
			System.out.println(file.getName() + " lastModified " + new Date(file.lastModified()));
			file.setLastModified(System.currentTimeMillis());
			System.out.println(file.getName() + " lastModified " + new Date(file.lastModified()));
			Thread.sleep(2000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

	public static void watchFileChange() {
		try {
			// We're not watching the file, we're watching the directory
			final Path path = Paths.get(".");
			final WatchService watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

			System.out.println("Report any file changed within next 1 minute...");

			final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

			if (watchKey != null) {
				watchKey.pollEvents().stream().forEach(event -> {
					System.out.println(event.context());
				});
			}
		} catch (InterruptedException | IOException ex) {
			System.out.println(ex);
		}
	}

	/***
	 * ListFiles
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		try {
			listFiles();
			listSelectFiles();
			listHiddenFiles();
			listImmediateSubDirs();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void listFiles() throws IOException {
		System.out.println("all files");
		Files.list(Paths.get(".")).forEach(System.out::println);

		System.out.println("only directories");
		Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

		System.out.println("only directories");
		Files.list(Paths.get(".")).filter(f -> f.toFile().isDirectory()).forEach(System.out::println);
	}

	private static void listSelectFiles() throws IOException {
		final String[] oldSchoolFiles = new File("./src/ch03").list(new java.io.FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		});
		System.out.println("oldSchoolFiles " + Arrays.toString(oldSchoolFiles));

		// What?! No collect() method on DirectoryStream?
		Files.newDirectoryStream(Paths.get("./src/ch03"), path -> path.toString().endsWith(".java"))
				.forEach(System.out::println);
	}

	private static void listHiddenFiles() throws IOException {
		final File[] files = new File(".").listFiles(file -> file.isHidden());
		System.out.println("oldSchoolFiles " + Arrays.toString(files));
	}

	private static void listImmediateSubDirs() {
		theHardWay();
		theFlatMapWay();
	}

	private static void theFlatMapWay() {
		List<File> files = Stream.of(new File(".").listFiles())
				.flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
				.collect(Collectors.toList());
		System.out.println("theFlatMapWay():  Count: " + files.size());
	}

	/**
	 * List all the files in current directory and one-level-down subdirs.
	 */
	private static void theHardWay() {
		List<File> files = new ArrayList<>();
		File[] filesInCurrentDir = new File(".").listFiles();
		for (File file : filesInCurrentDir) {
			File[] filesInSubDir = file.listFiles();
			if (filesInSubDir != null) {
				files.addAll(Arrays.asList(filesInSubDir));
			} else {
				files.add(file);
			}
		}
		System.out.println("theHardWay():  Count: " + files.size());
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		final String str = "w00t";

		str.chars().forEach(System.out::println);

		System.out.println("--------------------------");

		str.chars().filter(Character::isDigit).forEach(FunctionalProgramming03::printChar);

		System.out.println("--------------------------");

		str.chars().mapToObj(ch -> ((char) ch)).forEach(System.out::println);
	}

	

	@Override
	public void implementionSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
}
