package com.java8.adv.jls14.concurrents;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class EvenNumberQueueRunner {

	public static void main(String[] args) {
		final int MAX_QUEUE_SIZE = 5;

		NumberQueue queue = new NumberQueue();
		System.out
				.println("    NumberProducer thread         NumberConsumer threads");
		System.out
				.println("============================= =============================");

		NumberProducer producer = new NumberProducer(MAX_QUEUE_SIZE, queue);
		producer.start();

		// give producer a head start
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		NumberConsumer consumer1 = new NumberConsumer(queue);
		consumer1.start();

		NumberConsumer consumer2 = new NumberConsumer(queue);
		consumer2.start();
	}
}