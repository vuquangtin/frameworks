package com.java8.adv.jls14.concurrents;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class NumberConsumer extends Thread {
	private NumberQueue numQueue;

	public NumberConsumer(NumberQueue numQueue) {
		this.numQueue = numQueue;
	}

	@Override
	public void run() {
		System.out.println(getName() + " starting to consume ...");
		Random rand = new Random();
		// consume forever
		while (true) {
			int num = numQueue.pullNumber();
			List<Integer> evens = new ArrayList();
			while (evens.size() < num) {
				int randInt = rand.nextInt(999) + 1;
				if (randInt % 2 == 0) {
					evens.add(randInt);
				}
			}
			String s = "                                 " + getName()
					+ " found " + num + " evens [";
			StringJoiner nums = new StringJoiner(",");
			for (int randInt : evens) {
				nums.add(Integer.toString(randInt));
			}
			s += nums.toString() + "]";
			System.out.println(s);
		}
	}
}