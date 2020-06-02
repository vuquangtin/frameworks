package com.java8.lambda.main;

import java.util.StringJoiner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class User {

	private Long id;
	private String name;
	private int age;

	private User(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public static UserBuilderId builder() {
		return id -> name -> age -> () -> new User(id, name, age);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public interface UserBuilderId {
		UserBuilderName setId(long id);
	}

	public interface UserBuilderName {
		UserBuilderAge setName(String name);
	}

	public interface UserBuilderAge {
		UserBuilder setAge(int age);
	}

	public interface UserBuilder {
		User build();
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", User.class.getSimpleName() + "[", "]").add("id=" + id).add("name='" + name + "'")
				.add("age=" + age).toString();
	}
}