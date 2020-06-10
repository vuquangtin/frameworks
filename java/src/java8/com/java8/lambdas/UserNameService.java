package com.java8.lambdas;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
@FunctionalInterface
public interface UserNameService {
	void printName();

	boolean equals(Object obj);

	// default int add(int a,int b){
	// return a+b;
	// }
}