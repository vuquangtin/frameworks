package com.java8.adv.jls14;

import com.java.frameworks.base.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Chapter17 extends TemplateMethod {

	public static void main(String[] args) {
		new Chapter17().runTemplateMethod(args);

	}

	public class FirstThread extends Thread {
		@Override
		public void run() {
			System.out.println("Heellooo!");
		}
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// Creating Thread
		Thread thread = new FirstThread();
		thread.start();

	}

	public class FirstRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("Heellooo from Runnable :)");
		}
	}

	/***
	 * Implementation of the Runnable interface
	 * 
	 * The second way is to create a thread using the Thread’s constructor,
	 * which accepts the object implementing the Runnable interface:
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		// Creating Thread
		Thread thread = new Thread(new FirstRunnable());
		thread.start();

	}

	/*
	 * This time the body of the thread is the implementation of the run()
	 * interface method (the thread will run this method and will work until it
	 * is done). Note that you can create a thread using anonymous classes:
	 */

	@Override
	public void implementionThree(String[] args) throws Exception {

		Thread newThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello from the thread!");
			}
		});
		newThread.start();

	}

	/****
	 * Additionally, the Runnable interface is a function interface. Therefore,
	 * this can be simplified by using lambda expressions:
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {

		Thread newThread = new Thread(
				() -> System.out.println("Hello from the thread!"));
		newThread.start();

	}

	/****
	 * Synchronization in Java
	 * 
	 * Race Condition
	 * 
	 * You already know that threads share the address space. I’ve described it
	 * in the subsection #concurrent-data-processing. It has very important
	 * consequences. See the example below:
	 * 
	 * @see https
	 *      ://www.devdiaries.net/blog/Java-Interview-Questions-Multithreading/
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		Counter counter = new Counter();
		Runnable r = () -> {
			for (int i = 0; i < 50000; i++) {
				counter.increment();
			}
		};

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println(counter.getValue());
	}

	class Counter {
		private int value;

		public void increment() {
			value++;
		}

		public int getValue() {
			return value;
		}
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}

final class ProcessStep implements Runnable {
	private static final Object lock = new Object();
	private static int time = 0;
	private final int step; // Do Perform operations when field time
							// reaches this value

	public ProcessStep(int step) {
		this.step = step;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				while (time != step) {
					lock.wait();
				}

				// Perform operations

				time++;
				lock.notify();
			}
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt(); // Reset interrupted status
		}
	}

	public static void main(String[] args) {
		for (int i = 4; i >= 0; i--) {
			new Thread(new ProcessStep(i)).start();
		}
	}
}
