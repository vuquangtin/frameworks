package com.java8.functionalprogramming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.java8.adv.abs.TemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class FunctionalProgramming09 extends TemplateMethod {

	public static void main(String[] args) {
		new FunctionalProgramming09().runTemplateMethod(args);

	}

	public static double timeIt(final Runnable block) {
		final long start = System.nanoTime();
		block.run();
		final long end = System.nanoTime();
		return (end - start) / 1.0e9;
	}

	// BobK I find it interesting that he didn't call ch06.PrimeFinder here
	public static boolean isPrime(final long number) {
		for (long i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return number > 1;
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		final int limit = 100_000;
		final int iterations = 100;
		final String format = "%g seconds";

		List<Long> numbers = Stream.iterate(1L, number -> number + 1).limit(limit).collect(Collectors.<Long> toList());

		{
			System.out.println("//" + "START:HABITUAL_OUTPUT");
			double time = 0;

			for (int i = 0; i < iterations; i++) {
				time += timeIt(() -> {
					long primesCount = 0;
					for (long number : numbers) {
						if (isPrime(number)) {
							primesCount += 1;
						}
					}
					System.out.println(primesCount);
				});
			}
			System.out.println(String.format(format, time / iterations));
			System.out.println("//" + "END:HABITUAL_OUTPUT");
		}

		{
			System.out.println("//" + "START:LAMBDA_OUTPUT");
			double time = 0;
			for (int i = 0; i < iterations; i++) {
				time += timeIt(() -> {
					final long primesCount = numbers.stream().filter(number -> isPrime(number)).count();
					System.out.println(primesCount);
				});
			}

			System.out.println(String.format(format, time / iterations));
			System.out.println("//" + "END:LAMBDA_OUTPUT");
		}

		{
			System.out.println("//" + "START:PARALLEL_OUTPUT");
			double time = 0;
			for (int i = 0; i < iterations; i++) {
				time += timeIt(() -> {
					final long primesCount = numbers.parallelStream().filter(number -> isPrime(number)).count();
					System.out.println(primesCount);
				});
			}

			System.out.println(String.format(format, time / iterations));
			System.out.println("//" + "END:PARALLEL_OUTPUT");
		}

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		List<Integer> prices = Arrays.asList(10, 20, 30, 40, 50, 60);

		{
			int max = 0;
			for (int price : prices) {
				if (max < price) {
					max = price;
				}
			}

			System.out.println(max);
		}

		final int max = prices.stream().reduce(0, Math::max);
		System.out.println(max);

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		final JFrame frame = new JFrame();
		final JButton button = new JButton("click me");
		frame.getContentPane().add(button);

		frame.setSize(400, 300);
		frame.setVisible(true);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(frame, "you clicked!");
			}
		});

		button.addActionListener(event -> JOptionPane.showMessageDialog(frame, "you clicked!"));

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
