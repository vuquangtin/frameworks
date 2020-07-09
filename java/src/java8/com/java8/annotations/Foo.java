package com.java8.annotations;

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
public interface Foo {
	int m();

	boolean equals(Object obj);
	// int compare(T o1, T o2);
	// public Object clone();
}

interface X {
	long m();
}

interface Y {
	int m();
}

interface Z extends X, Y {
}

interface FooG<T, N extends Number> {
	void m(T arg);

	void m(N arg);
}

// 2 abstract method
@FunctionalInterface
interface Bar extends FooG<String, Integer> {
}

// only 1 abstract method m(Integer arg)
@FunctionalInterface
interface Baz2 extends FooG<Integer, Integer> {
}
