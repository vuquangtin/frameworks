package com.java8.adv.jls14;

import java.util.Scanner;

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
public class Chapter01 extends TemplateMethod {

	public static void main(String[] args) {
		new Chapter01().runTemplateMethod(args);

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		int[] v = new int[1];
		v[0] = 1;
		v[0] = v[0] + 1;
		logger.debug("v[0]=");
		logger.debug(v[0]);
		logger.debug("Done!");
		// v[0]=2
		// Done!

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		logger.debug("Insert 3 numbers: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int max;
		if (a > b) {
			if (a > c) {
				max = a;
			} else {
				max = c;
			}
		} else {
			if (b > c) {
				max = b;
			} else {
				max = c;
			}
		}
		logger.debug("max = ");
		logger.debug(max);
		logger.debug("Done!");
		// (for input 6 12 8)

		// Insert 3 numbers: max = 12
		// Done!
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		logger.debug("Insert two numbers: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		logger.debug("You inserted: ");
		logger.debug(a);
		logger.debug(" ");
		logger.debug(b);
		logger.debug("Done!");
		// (for input 12 85)

		// Insert a number: You inserted: 12 85
		// Done!
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		int n = 4;
		int s, i;

		int[] v = new int[n + 1];
		for (i = 0; i <= n; i++) {
			v[i] = i;
		}

		s = 0;
		for (i = 0; i <= n; i++) {
			s = s + v[i];
		}
		logger.debug("sum 1..");
		logger.debug(n);
		logger.debug("=");
		logger.debug(s);
		logger.debug("Done!");
		// sum 1..4=10
		// Done!
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		int n, s, i;
		n = 4;
		s = 0;
		i = 1;
		while (i <= n) {
			s = s + i;
			i = i + 1;
		}
		logger.debug("sum 1..");
		logger.debug(n);
		logger.debug("=");
		logger.debug(s);
		logger.debug("Done!");
		// sum 1..4=10
		// Done!
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
