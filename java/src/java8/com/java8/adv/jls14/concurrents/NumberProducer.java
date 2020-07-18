package com.java8.adv.jls14.concurrents;

import java.util.Random;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class NumberProducer extends Thread {
	private int maxNumsInQueue;
	private NumberQueue numsQueue;

	public NumberProducer(int maxNumsInQueue, NumberQueue numsQueue) {
		this.maxNumsInQueue = maxNumsInQueue;
		this.numsQueue = numsQueue;
	}

	@Override
	public void run() {
		System.out.println(getName() + " starting to produce ...");
		Random rand = new Random();
		// continuously produce numbers for queue
		while (true) {
			if (numsQueue.size() < maxNumsInQueue) {
				// random numbers 1-100
				int evenNums = rand.nextInt(99) + 1;
				numsQueue.pushNumber(evenNums);
				System.out.println(getName() + " adding " + evenNums);
			}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}