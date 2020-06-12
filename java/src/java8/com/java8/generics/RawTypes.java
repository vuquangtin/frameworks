package com.java8.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.java.frameworks.base.TemplateMethod;

/**
 * <h1>Raw Types</h1>
 * 
 * A raw type is a name for a generic interface or class without its type
 * argument:
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class RawTypes extends TemplateMethod {

	public static void main(String[] args) {
		new RawTypes().runTemplateMethod(args);

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		List list = new ArrayList(); // raw type
		// Instead of:

		List<Integer> listIntgrs = new ArrayList<>(); // parameterized type

	}

	public void methodB(List rawList) { // raw type!
		rawList.add(1);
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		List<String> parameterizedList = new ArrayList<>();
		parameterizedList.add("Hello Folks");
		methodB(parameterizedList);

	}

	void withRawType() {
		// Raw List doesn't self-document,
		// doesn't state explicitly what it can contain
		List stars = Arrays.asList("Arcturus", "Vega", "Altair");
		Iterator iter = stars.iterator();
		while (iter.hasNext()) {
			String star = (String) iter.next(); // cast needed
			log(star);
		}
	}

	void withParameterizedType() {
		List<String> stars = Arrays.asList("Spica", "Regulus", "Antares");
		for (String star : stars) {
			log(star);
		}
	}

	/***
	 * <h1>Avoid raw types</h1>
	 * 
	 * Raw types refer to using a generic type without specifying a type
	 * parameter. For example, List is a raw type, while List<String> is a
	 * parameterized type.
	 * 
	 * When generics were introduced in JDK 1.5, raw types were retained only to
	 * maintain backwards compatibility with older versions of Java. Although
	 * using raw types is still possible, they should be avoided:
	 * <ul>
	 * <li>
	 * they usually require casts</li>
	 * <li>they aren't type safe, and some important kinds of errors will only
	 * appear at runtime</li>
	 * <li>they are less expressive, and don't self-document in the same way as
	 * parameterized types</li>
	 * </ul>
	 */

	@Override
	public void implementionThree(String[] args) throws Exception {
		withRawType();
		withParameterizedType();

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
