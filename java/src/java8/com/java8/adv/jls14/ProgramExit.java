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
public class ProgramExit extends TemplateMethod {

	public static void main(String[] args) {
		new ProgramExit().runTemplateMethod(args);

	}

	/***
	 * What is System.exit() Method?
	 * 
	 * 
	 * System.exit() method calls the exit method in class Runtime. It exits the
	 * current program by terminating Java Virtual Machine. As the method name
	 * defines, exit() method never returns anything.
	 * 
	 * The call System.exit(n) is effectively equivalent to the call:
	 * 
	 * Runtime.getRuntime().exit(n)
	 * 
	 * System.exit function has status code, which tells about the termination,
	 * such as:
	 * 
	 * exit(0) : Indicates successful termination. exit(1) or exit(-1) or any
	 * non-zero value – indicates unsuccessful termination.
	 * 
	 * Now, let’s see the parameters and the exception throws in System.exit()
	 * method.
	 * 
	 * Parameters: Exit status.
	 * 
	 * Exception: It throws a SecurityException.
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		Runtime.getRuntime().exit(0);

	}

	/***
	 * Moving ahead with System.exit method(), let’s see some of its practical
	 * implementation.
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 4) {
				System.out.println("Exit from the loop");
				System.exit(0); // Terminates JVM
			} else
				System.out.println("arr[" + i + "] = " + arr[i]);
		}
		System.out.println("End of the Program");
		// Output: arr[0] = 1
		// arr[1] = 2
		// arr[2] = 3
		// Exit from the loop

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < a.length; i++) {
			if (a[i] <= 4) {
				System.out.println("array[" + i + "]=" + a[i]);
			} else {
				System.out.println("Exit from the loop");
				System.exit(0); // Terminates jvm
			}
		}
		// Output: array[0]=1
		// array[1]=2
		// array[2]=3
		// array[3]=4
		// Exit from the loop
	}

	public class DaemonThread extends Thread {
		public DaemonThread(String name) {
			super(name);
		}

		public void run() {
			// Checking whether the thread is Daemon or not
			if (Thread.currentThread().isDaemon()) {
				System.out.println(getName() + " is Daemon thread");
			}

			else {
				System.out.println(getName() + " is User thread");
			}
		}

	}

	/***
	 * All the threads that are not daemon threads terminate.
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {

		DaemonThread t1 = new DaemonThread("t1");
		DaemonThread t2 = new DaemonThread("t2");
		DaemonThread t3 = new DaemonThread("t3");

		// Setting user thread t1 to Daemon
		t1.setDaemon(true);

		// starting first 2 threads
		t1.start();
		t2.start();

		// Setting user thread t3 to Daemon
		t3.setDaemon(true);
		t3.start();

	}

	public class DaemonThread2 extends Thread {
		public void run() {
			System.out.println("Thread name: "
					+ Thread.currentThread().getName());
			System.out.println("Check if its DaemonThread: "
					+ Thread.currentThread().isDaemon());
		}

	}

	/***
	 * If you call the setDaemon() method after starting the thread, it would
	 * throw IllegalThreadStateException.
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		DaemonThread2 t1 = new DaemonThread2();
		DaemonThread2 t2 = new DaemonThread2();
		t1.start();

		// Exception as the thread is already started
		t1.setDaemon(true);

		t2.start();

	}

	/***
	 * What is the purpose of Runtime and System class?
	 * 
	 * The purpose of the Runtime class is to provide access to the Java runtime
	 * system. The runtime information like memory availability, invoking the
	 * garbage collector, etc.
	 * 
	 * The purpose of the System class is to provide access to system resources.
	 * It contains accessibility to standard input, standart output, error
	 * output streams, current time in millis, terminating the application, etc.
	 */
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
