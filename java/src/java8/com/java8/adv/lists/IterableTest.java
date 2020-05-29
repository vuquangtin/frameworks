package com.java8.adv.lists;

import java.util.Iterator;

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
public class IterableTest extends TemplateMethod {
	public static void main(String[] args) {
		new IterableTest().runTemplateMethod(args);

	}

	public static class IterableApp implements Iterable<Integer> {
		@Override
		public Iterator<Integer> iterator() {
			return new IteratorApp();
		}

		private class IteratorApp implements Iterator<Integer> {
			private int size = 3;
			private int cursor = 0;

			@Override
			public boolean hasNext() {
				return cursor < size;
			}

			@Override
			public Integer next() {
				return cursor++;
			}
		}
	}

	@Override
	public void implementionOne(String[] args) {
		IterableApp iterableApp = new IterableApp();
		for (Integer i : iterableApp) {
			System.out.println(i);
		}

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
