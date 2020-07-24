package com.java8.adv.happen_before;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Main3 {
	static int a = 0;
	volatile static int b = 0;

	public static void main(String[] args) {
		new Thread() {
			@Override
			public void run() {
				int r1 = a;
				b = 2;
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				int r2 = a;
				a = 1;
			}
		}.start();
	}
}