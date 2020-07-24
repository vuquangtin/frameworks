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
public class DoubleCheck {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
	}

	static class Singleton {
		private volatile static Singleton singleton = new Singleton();

		public Singleton() {
		}

		public static Singleton getInstance() {
			if (singleton == null) {
				synchronized (Singleton.class) {
					if (singleton == null) {
						singleton = new Singleton();
					}
				}
			}
			return new Singleton();
		}
	}
}