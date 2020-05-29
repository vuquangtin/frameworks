package com.java8.adv.abs;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 */
public abstract class TemplateMethod {
	public void runTemplateMethod(String[] args) {
		printDot("implementionOne");
		try {
			implementionOne(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionTwo");
		try {
			implementionTwo(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionThree");
		try {
			implementionThree(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionFour");
		try {
			implementionFour(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionFive");
		try {
			implementionFive(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionSix");
		try {
			implementionSix(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionSeven");
		try {
			implementionSeven(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionEight");
		try {
			implementionEight(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionNine");
		try {
			implementionNine(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionTen");
		try {
			implementionTen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void printDot(String methodName) {
		printDot(100, methodName);
	}

	private void printDot(int dot, String methodName) {
		int part = dot / 2;
		for (int i = 0; i < dot; i++) {
			System.out.print("-");
			if (i == part)
				System.out.print(methodName);
		}
		System.out.println();
	}

	public abstract void implementionOne(String[] args);

	public abstract void implementionTwo(String[] args);

	public abstract void implementionThree(String[] args);

	public abstract void implementionFour(String[] args);

	public abstract void implementionFive(String[] args);

	public abstract void implementionSix(String[] args);

	public abstract void implementionSeven(String[] args);

	public abstract void implementionEight(String[] args);

	public abstract void implementionNine(String[] args);

	public abstract void implementionTen(String[] args);
}
