package com.java8.adv.jls14;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
interface I {
	int i = 1, ii = TestC12.out("ii", 2);
}

interface J extends I {
	int j = TestC12.out("j", 100), l = TestC12.out("l", 3), jj = TestC12.out("jj", 4);
}

interface K extends J {
	int k = TestC12.out("k", 5);
}

class TestC12 {
	public static void main(String[] args) {
		System.out.println(J.i);
		System.out.println(K.j);
	}

	static int out(String s, int i) {
		System.out.println(s + "=" + i);
		return i;
	}
}