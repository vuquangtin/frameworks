package com.java8.annotations;

/**
 * Một Annotation có phần tử tên là value có một số đặc biệt:
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public @interface AnnWithValue {

	// Một phần tử có tên là 'value', của Annotation.
	// Có một chút đặc biệt khi sử dụng phần tử này.
	public int value();

	// Phần tử 'name'
	public String name() default "";

}