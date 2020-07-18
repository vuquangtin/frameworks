package com.java8.adv.jls14.concurrents;

import java.util.LinkedList;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class NumberQueue {
	private LinkedList<Integer> numQueue = new LinkedList<>();

	public synchronized void pushNumber(int num) {
		numQueue.addLast(num);
		notifyAll();
	}

	public synchronized int pullNumber() {
		while (numQueue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return numQueue.removeFirst();
	}

	public synchronized int size() {
		return numQueue.size();
	}
}