package com.java8.adv.jls14;

import com.java.frameworks.base.ExtendTemplateMethod;
import com.java.frameworks.base.ITemplateMethod;
import com.java8.generics.Test;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Chapter14 extends ExtendTemplateMethod implements ITemplateMethod {
	@FunctionalInterface
	interface IF {
		void print(String s);
	}

	public static void main(String[] args) {
		new Chapter14().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			IF im = (String s) -> {
				logger.debug(s);
			};
			im.print("print " + i);
		}

	}

	class test {
		test() {
			logger.debug("test.test()");
			f();
		}

		void f() {
			logger.debug("f()");
		}
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		new test();
		logger.debug("Done!");

	}

	class test2 {
		test2() {
			logger.debug("test.test()");
			f();
		}

		void f() {
			logger.debug("f()");
			return;
		}
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		new test2();
		logger.debug("Done!");

	}

	class test3 {
		test3() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			logger.debug("inside f()");
			return 80;
		}
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		new test3();
		logger.debug("Done!");

	}

	class test4 {
		test4() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			logger.debug("inside f()");
			return 3 + 4;
		}
	}

	class test5 {
		test5() {
			System.out.print("f(true) = ");
			logger.debug(f(true));
			System.out.print("f(false) = ");
			logger.debug(f(false));
		}

		int f(boolean b) {
			if (b) {
				return 3;
			} else {
				return 4;
			}
		}
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		new test4();
		logger.debug("Done!");

	}

	class test6 {
		test6() {
			System.out.print("isPrime(10) = ");
			logger.debug(isPrime(10));
			System.out.print("isPrime(9) = ");
			logger.debug(isPrime(9));
			System.out.print("isPrime(7) = ");
			logger.debug(isPrime(7));
		}

		// JBook semantics don't support operator String + boolean, that's why
		// we need String here
		String isPrime(int n) {
			int i = 2;
			while (i < n) {
				if (n % i == 0) {
					return "false";
				}
				i++;
			}
			return "true";
		}
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		new test6();
		logger.debug("Done!");

	}

	class test7 {
		test7() {
			System.out.print("isPrime(10) = ");
			logger.debug(isPrime(10));
			System.out.print("isPrime(9) = ");
			logger.debug(isPrime(9));
			System.out.print("isPrime(7) = ");
			logger.debug(isPrime(7));
		}

		// JBook semantics don't support operator String + boolean, that's why
		// we need String here
		String isPrime(int n) {
			int i = 2;
			do {
				if (n % i == 0) {
					return "false";
				}
				i++;
			} while (i < n);
			return "true";
		}
	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		new test7();
		logger.debug("Done!");

	}

	class test8 {
		test8() {
			System.out.print("isPrime(10) = ");
			logger.debug(isPrime(10));
			System.out.print("isPrime(9) = ");
			logger.debug(isPrime(9));
			System.out.print("isPrime(7) = ");
			logger.debug(isPrime(7));
		}

		// JBook semantics don't support operator String + boolean, that's why
		// we need String here
		String isPrime(int n) {
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					return "false";
				}
			}
			return "true";
		}
	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		new test8();
		logger.debug("Done!");

	}

	class test9 {
		test9() {
			System.out.print("isPrime(10) = ");
			logger.debug(isPrime(10));
			System.out.print("isPrime(9) = ");
			logger.debug(isPrime(9));
			System.out.print("isPrime(7) = ");
			logger.debug(isPrime(7));
		}

		// JBook semantics don't support operator String + boolean, that's why
		// we need String here
		String isPrime(int n) {
			switch (n) {
			case 2:
			case 3:
			case 5:
			case 7:
				return "true";
			default:
				return "false";
			}
		}
	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		new test9();
		logger.debug("Done!");

	}

	class test10 {
		test10() {
			System.out.print("isPrime(10) = ");
			logger.debug(isPrime(10));
			System.out.print("isPrime(9) = ");
			logger.debug(isPrime(9));
			System.out.print("isPrime(7) = ");
			logger.debug(isPrime(7));
		}

		// JBook semantics don't support operator String + boolean, that's why
		// we need String here
		String isPrime(int n) {
			int i = 2;
			label_1: while (i < n) {
				if (n % i == 0) {
					return "false";
				}
				i++;
			}
			return "true";
		}
	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		new test10();
		logger.debug("Done!");

	}

	class test11 {
		test11() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			try {
				if (true)
					return 1;
				logger.debug("unreachable");
			} catch (RuntimeException e) {
				logger.debug(e.toString());
				throw e;
			} finally {
				logger.debug("finally");
			}
			logger.debug("unreachable");
			return 4;
		}
	}

	@Override
	public void implementionEleven(String[] args) throws Exception {
		new test11();
		logger.debug("Done!");

	}

	class test12 {
		test12() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			try {
				// JBook semantics don't support constructor with arg for
				// exceptions
				// if (true) throw new RuntimeException("re");
				if (true)
					throw new RuntimeException();
				logger.debug("unreachable");
			} catch (RuntimeException e) {
				logger.debug(e.toString());
				return 2;
			} finally {
				logger.debug("finally");
			}
			logger.debug("unreachable");
			return 4;
		}
	}

	@Override
	public void implementionTwelve(String[] args) throws Exception {
		new test12();
		logger.debug("Done!");

	}

	class test13 {
		test13() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			try {
				logger.debug("try");
			} catch (RuntimeException e) {
				logger.debug(e.toString());
				return 2;
			} finally {
				logger.debug("finally");
				if (true)
					return 3;
			}
			logger.debug("unreachable");
			return 4;
		}
	}

	@Override
	public void implementionThirteen(String[] args) throws Exception {
		new test13();
		logger.debug("Done!");

	}

	class test14 {
		test14() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			try {
				logger.debug("try");
				return 1;
			} finally {
				logger.debug("finally");
				if (true)
					return 3;
			}
		}
	}

	@Override
	public void implementionFourteen(String[] args) throws Exception {
		new test14();
		logger.debug("Done!");

	}

	class test15 {
		test15() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			try {
				logger.debug("try");
				// JBook semantics don't support constructor with arg for
				// exceptions
				// throw new RuntimeException("abc");
				throw new RuntimeException();
			} finally {
				logger.debug("finally");
				if (true)
					return 3;
			}
		}
	}

	@Override
	public void implementionFifteen(String[] args) throws Exception {
		new test15();
		logger.debug("Done!");

	}

	class test16 {
		test16() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		int f() {
			try {
				logger.debug("try");
				// JBook semantics don't support constructor with arg for
				// exceptions
				// throw new RuntimeException("abc");
				throw new RuntimeException();
			} catch (RuntimeException e) {
				logger.debug(e.toString());
				return 2;
			} finally {
				logger.debug("finally");
				if (true)
					return 3;
			}
		}
	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		new test16();
		logger.debug("Done!");

	}

	class test17 {
		test17() {
			System.out.print("f() = ");
			logger.debug(f());
		}

		String f() {
			return "abc";
		}
	}

	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		new test17();
		logger.debug("Done!");

	}

	class test18 {
		test18() {
			System.out.print("f() = ");
			logger.debug(f().toString());
		}

		RuntimeException f() {
			return new RuntimeException();
			// JBook semantics don't support constructor with arg for exceptions
			// return new RuntimeException("abc");
		}
	}

	@Override
	public void implementionEighteen(String[] args) throws Exception {
		new test18();
		logger.debug("Done!");

	}

	class test19 {
		test19() {
			System.out.print("f() = ");
			logger.debug(f().toString());
		}

		RuntimeException f() {
			return new Ex();
		}
	}

	class Ex extends RuntimeException {
		Ex() {
			super();
		}
	}

	@Override
	public void implementionNineteen(String[] args) throws Exception {
		new test19();
		logger.debug("Done!");
	}

	class main {

		int b = 10;

		main() {
			try {
				int b = 2;
				System.out.print("try: b = ");
				logger.debug(b);
				return;
			} finally {
				System.out.print("finally: b = ");
				logger.debug(b);
			}
		}
	}

	@Override
	public void implementionTwenty(String[] args) throws Exception {
		new main();
		logger.debug("Done!");

	}

	@Override
	public void implementorOne(String[] args) throws Exception {
		Test t = new Test();

		synchronized (t) {
			synchronized (t) {
				logger.debug("made it!");
			}
		}
		t = null;
		synchronized (t) {
			synchronized (t) {
				logger.debug("made it!");
			}
		}

	}

	static class BlewIt extends Exception {
		BlewIt() {
		}

		BlewIt(String s) {
			super(s);
		}
	}

	static void blowUp() throws BlewIt {
		throw new BlewIt();
	}

	@Override
	public void implementorTwo(String[] args) throws Exception {
		try {
			blowUp();
		} catch (RuntimeException r) {
			logger.debug("RuntimeException:" + r);
		} catch (BlewIt b) {
			logger.debug("BlewIt");
		}

	}

	static void blowUpNull() throws BlewIt {
		throw new NullPointerException();
	}

	@Override
	public void implementorThree(String[] args) throws Exception {
		try {
			blowUpNull();
		} catch (BlewIt b) {
			logger.debug("Caught BlewIt");
		} finally {
			logger.debug("Uncaught Exception");
		}

	}

	@Override
	public void implementorFour(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorFive(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorSix(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorSeven(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorEight(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorNine(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
}
