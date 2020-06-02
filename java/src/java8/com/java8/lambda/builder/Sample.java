package com.java8.lambda.builder;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Sample {

	public static void main(String[] args) {
		User user = User.builder().setId(1).setName("guest").setAge(18).addRole("GUEST").addRole("LOGIN").build();

		System.out.println(user);
	}
}