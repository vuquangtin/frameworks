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
		System.out.print("v[0]=");
		System.out.println(v[0]);
		System.out.println("Done!");
		// v[0]=2
		// Done!

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		System.out.print("Insert 3 numbers: ");
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
		System.out.print("max = ");
		System.out.println(max);
		System.out.println("Done!");
		// (for input 6 12 8)

		// Insert 3 numbers: max = 12
		// Done!
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		System.out.print("Insert two numbers: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.print("You inserted: ");
		System.out.print(a);
		System.out.print(" ");
		System.out.println(b);
		System.out.println("Done!");
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
		System.out.print("sum 1..");
		System.out.print(n);
		System.out.print("=");
		System.out.println(s);
		System.out.println("Done!");
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
		System.out.print("sum 1..");
		System.out.print(n);
		System.out.print("=");
		System.out.println(s);
		System.out.println("Done!");
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
