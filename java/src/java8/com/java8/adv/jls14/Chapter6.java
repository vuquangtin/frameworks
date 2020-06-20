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
public class Chapter6 extends TemplateMethod {

	public static void main(String[] args) {
		new Chapter6().runTemplateMethod(args);
	}

	class Super {
		void f2(String s) {
		}

		void f3(String s) {
		}

		void f3(int i1, int i2) {
		}
	}

	class Test {
		void f1(int i) {
		}

		void f2(int i) {
		}

		void f3(int i) {
		}

		void m() {
			new Super() {
				{
					f1(0);
					f2(0);
					f3(0);
				}
			};
		}
		// OK, resolves to Test.f1(int)
		// compile-time error
		// compile-time error
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
