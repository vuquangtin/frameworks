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
class Test1 {
	static int x;

	static int i;
	public static void main(String[] args) {
		Test1.x = 10;
		int x = x;
		int i = 0;
		for (int i = 0; i < args.length; i++) {

		}
		class Local {
			{
				for (int i = 0; i < 10; i++)
					System.out.println(i);
			}
		}
	}
}

class Test2 {
	static int x;

	public static void main(String[] args) {
		Test2.x = 10;
		int x = (x = 2) * 2;
		System.out.println(x);
	}
}