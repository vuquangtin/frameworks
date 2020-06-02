package com.java8.lambda.main;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class UserBuilder {

    public static void main(String[] args) {
        User user = User.builder()
                .setId(42)
                .setName("Guest")
                .setAge(23)
                .build();

        System.out.println(user);
    }
}