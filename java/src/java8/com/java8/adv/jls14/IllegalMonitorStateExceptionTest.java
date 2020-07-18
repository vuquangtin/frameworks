package com.java8.adv.jls14;

/**
 * You can't wait() on an object unless the current thread owns that object's
 * monitor. To do that, you must synchronize on it:
 * 
 * class Runner implements Runnable { public void run() { try {
 * synchronized(Main.main) { Main.main.wait(); } } catch (InterruptedException
 * e) {} System.out.println("Runner away!"); } }
 * 
 * The same rule applies to notify()/notifyAll() as well.
 * 
 * The Javadocs for wait() mention this:
 * 
 * This method should only be called by a thread that is the owner of this
 * object's monitor. See the notify method for a description of the ways in
 * which a thread can become the owner of a monitor. Throws:
 * 
 * IllegalMonitorStateException – if the current thread is not the owner of this
 * object's monitor.
 * 
 * And from notify():
 * 
 * A thread becomes the owner of the object's monitor in one of three ways:
 * 
 * By executing a synchronized instance method of that object. By executing the
 * body of a synchronized statement that synchronizes on the object. For objects
 * of type Class, by executing a synchronized static method of that class.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class IllegalMonitorStateExceptionTest {

	interface SAM {
		void foo(int i);
	}

	static void print(int i) {
		System.out.println(i);
	}

	/*
	 * 
	 * 
	 * You can't wait() on an object unless the current thread owns that
	 * object's monitor. To do that, you must synchronize on it:
	 * 
	 * class Runner implements Runnable { public void run() { try {
	 * synchronized(Main.main) { Main.main.wait(); } } catch
	 * (InterruptedException e) {} System.out.println("Runner away!"); } }
	 * 
	 * The same rule applies to notify()/notifyAll() as well.
	 * 
	 * The Javadocs for wait() mention this:
	 * 
	 * This method should only be called by a thread that is the owner of this
	 * object's monitor. See the notify method for a description of the ways in
	 * which a thread can become the owner of a monitor. Throws:
	 * 
	 * IllegalMonitorStateException – if the current thread is not the owner of
	 * this object's monitor.
	 * 
	 * And from notify():
	 * 
	 * A thread becomes the owner of the object's monitor in one of three ways:
	 * 
	 * By executing a synchronized instance method of that object. By executing
	 * the body of a synchronized statement that synchronizes on the object. For
	 * objects of type Class, by executing a synchronized static method of that
	 * class.
	 */
	public static void main(String[] args) {
		try {
			test(IllegalMonitorStateExceptionTest::print);
			test(i -> {
				System.out.println(i);
			});

		} catch (Throwable t) {
			t.printStackTrace();
			throw new AssertionError("An error occurred");
		}
		Object o = new Object();
		try {
			o.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.notify();
	}

	void noti() {
		Object o = new Object();
		try {
			o.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		o.notify();
	}

	static void test(SAM s) throws Throwable {
		s.hashCode();
		s.equals(null);
		s.toString();
		try {
			s.notify(); // will throw IllegalMonitorStateException
		} catch (final IllegalMonitorStateException e) {
			e.printStackTrace();
		}
		try {
			s.notifyAll(); // will throw IllegalMonitorStateException
		} catch (final IllegalMonitorStateException e) {
			e.printStackTrace();
		}
		try {
			s.wait(1); // will throw IllegalMonitorStateException
		} catch (final IllegalMonitorStateException | InterruptedException e) {
			e.printStackTrace();
		}
		try {
			s.wait(1, 1); // will throw IllegalMonitorStateException
		} catch (final IllegalMonitorStateException | InterruptedException e) {
			e.printStackTrace();
		}
		try {
			s.wait(); // will throw IllegalMonitorStateException
		} catch (final IllegalMonitorStateException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}