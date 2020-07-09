package com.java8.adv.jls14;

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

public class Chapter12 extends TemplateMethod {
	public static void main(String[] args) {
		new Chapter12().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		One o = null;
		Two t = new Two();
		System.out.println((Object) o == (Object) t);
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// TODO Auto-generated method stub

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

class Super {
	static {
		System.out.print("Super ");
	}
}

class One {
	static {
		System.out.print("One ");
	}
}

class Two extends Super {
	static {
		System.out.print("Two ");
	}
}