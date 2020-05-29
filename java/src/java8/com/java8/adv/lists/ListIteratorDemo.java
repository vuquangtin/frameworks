package com.java8.adv.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import com.java8.adv.abs.ExtendTemplateMethod;

/**
 * <h1>Points to note</h1> <br/>
 * ListIterator in Java provides an add(E e) method which is not there in
 * Iterator. add(E e) inserts the specified element into the list (optional
 * operation). The element is inserted immediately before the element that would
 * be returned by next(), if any, and after the element that would be returned
 * by previous(), if any. <br/>
 * <br/>
 * ListItearator also provides set method. void set(E e) replaces the last
 * element returned by next() or previous() with the specified element (optional
 * operation). This call can be made only if neither remove() nor add(E) have
 * been called after the last call to next or previous. <br/>
 * <br/>
 * ListIterator is fail-fast and throws a ConcurrentModificationException if the
 * underlying collection is structurally modified in any way except through the
 * iterator's own remove or add methods.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ListIteratorDemo extends ExtendTemplateMethod {
	public static void main(String[] args) {
		new ListIteratorDemo().runTemplateMethod(args);
	}

	private ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2,
			3, 4, 5));
	private int size = arrayList.size();
	{
		System.out.println(arrayList);
	}

	public void implementionOne(String[] args) {
		List<Integer> numberList = new ArrayList<Integer>();
		ListIterator<Integer> ltr = null;
		numberList.add(25);
		numberList.add(17);
		numberList.add(108);
		numberList.add(76);
		numberList.add(2);
		numberList.add(36);
		ltr = numberList.listIterator();
		// forward iteration
		System.out.println("Iterating list in forward direction");
		while (ltr.hasNext()) {
			System.out.println(ltr.next());
		}
		// backward iteration
		System.out.println("Iterating list in backward direction");
		while (ltr.hasPrevious()) {
			System.out.println(ltr.previous());
		}
	}

	/***
	 * hasNextTest
	 */
	@Override
	public void implementionTwo(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		System.out.println(listIterator.hasNext());

		ListIterator<Integer> listIterator2 = arrayList.listIterator(size - 1);
		System.out.println(listIterator2.hasNext());

		ListIterator<Integer> listIterator3 = arrayList.listIterator(size);
		System.out.println(listIterator3.hasNext());

	}

	/***
	 * hasPreviousTest
	 */
	@Override
	public void implementionThree(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		System.out.println(listIterator.hasPrevious());

		ListIterator<Integer> listIterator2 = arrayList.listIterator(1);
		System.out.println(listIterator2.hasPrevious());

		ListIterator<Integer> listIterator3 = arrayList.listIterator(size);
		System.out.println(listIterator3.hasPrevious());

	}

	@Override
	public void implementionFour(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		System.out.println(listIterator.next());

	}

	@Override
	public void implementionFive(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator(1);
		System.out.println(listIterator.previous());

		ListIterator<Integer> listIterator2 = arrayList.listIterator(size);
		System.out.println(listIterator2.previous());

	}

	@Override
	public void implementionSix(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		System.out.println(listIterator.nextIndex());

	}

	@Override
	public void implementionSeven(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator(1);
		System.out.println(listIterator.previousIndex());

		ListIterator<Integer> listIterator2 = arrayList.listIterator(size);
		System.out.println(listIterator2.previousIndex());

	}

	@Override
	public void implementionEight(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		System.out.println(listIterator.next());
		listIterator.remove();
		System.out.println(arrayList);

	}

	@Override
	public void implementionNine(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator(1);
		System.out.println(listIterator.previous());
		listIterator.remove();
		System.out.println(arrayList);

	}

	@Override
	public void implementionTen(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		System.out.println(listIterator.next());
		listIterator.set(6);
		System.out.println(arrayList);

	}

	@Override
	public void implementionEleven(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator(1);
		System.out.println(listIterator.previous());
		listIterator.set(6);
		System.out.println(arrayList);

	}

	@Override
	public void implementionTwelve(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		listIterator.add(6);
		System.out.println(arrayList);
		System.out.println(listIterator.next());
		listIterator.add(7);
		listIterator.add(8);
		System.out.println(arrayList);
		System.out.println(listIterator.next());
		listIterator.add(9);
		listIterator.add(10);
		System.out.println(arrayList);
		System.out.println(listIterator.previous());
		listIterator.add(11);
		listIterator.add(12);
		System.out.println(arrayList);

	}

	@Override
	public void implementionThirteen(String[] args) {
		ListIterator<Integer> listIterator = arrayList.listIterator();
		System.out.println(listIterator.next());
		System.out.println(listIterator.previous());
		System.out.println(listIterator.next());

	}

	@Override
	public void implementionFourteen(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionFifteen(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSixteen(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionSeventeen(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionEighteen(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionNineteen(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionTwenty(String[] args) {
		// TODO Auto-generated method stub

	}
}
