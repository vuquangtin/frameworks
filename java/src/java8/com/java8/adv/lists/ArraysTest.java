package com.java8.adv.lists;

import java.util.Arrays;

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
public class ArraysTest extends TemplateMethod {
	public static void main(String[] args) {
		new ArraysTest().runTemplateMethod(args);
	}

	public static class Copy {
		public String string;
		public Integer integer;

		public Copy(String string, Integer integer) {
			super();
			this.string = string;
			this.integer = integer;
		}

		@Override
		public String toString() {
			return "Copy [string=" + string + ", integer=" + integer + "]";
		}

	}

	@Override
	public void implementionOne(String[] args) {
		Copy[] copies = new Copy[1];
		copies[0] = new Copy("EagleLi", 1);

		Copy[] copies2 = Arrays.copyOf(copies, copies.length);
		copies2[0] = new Copy("EagleLi1", 1);
		System.out.println(Arrays.asList(copies));
		System.out.println(Arrays.asList(copies2));

		System.out.println("\n--- 分割线 ---\n");

		Copy[] copies3 = Arrays.copyOf(copies, copies.length);
		copies3[0].string = "EagleLi1";
		System.out.println(Arrays.asList(copies));
		System.out.println(Arrays.asList(copies3));

		System.out.println("\n--- 分割线 ---\n");

		System.out.println(copies2[0] == copies[0]);
		System.out.println(copies2[0].string == copies[0].string);

	}

	@Override
	public void implementionTwo(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionThree(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFour(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFive(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSix(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeven(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEight(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNine(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTen(String[] args) {
		// TODO Auto-generated method stub

	}

}
