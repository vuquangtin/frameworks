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
public class WriteReadMain {
	static int j;
	volatile static int i;
	final static int MAX = 100;

	public static void main(String[] args) {
		Thread t = new WriteThread();
		t.start();
		new ReadThread().start();
		System.out.println(i);

	}

	static class WriteThread extends Thread {
		@Override
		public void run() {
			while (i < MAX) {
				System.out.println("increase j " + (++j));
				System.out.println("increase i " + (++i));
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class ReadThread extends Thread {
		@Override
		public void run() {
			int localValue = i;
			int localJValue = j;
			while (localValue < MAX) {
				if (localValue != i) {
					System.out.println(localJValue = j);
					System.out.println(localValue = i);
				}
			}
		}
	}
}