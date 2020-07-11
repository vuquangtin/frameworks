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
public class Chapter06 extends TemplateMethod {

	public static void main(String[] args) {
		new Chapter06().runTemplateMethod(args);
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

	/***
	 * 06_string_plus-str_conv_011_String_plus_str/
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		System.out.println(("ab" + "cde"));
		System.out.println("Done!");

	}

	/***
	 * 06_string_plus-str_conv_012_String_plus_int/
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		System.out.println(("ab" + -12));
		System.out.println((-12 + "cde"));
		System.out.println("Done!");
	}

	/***
	 * 06_string_plus-str_conv_013_String_plus_bool
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		System.out.println(("" + true));
		System.out.println("Done!");

	}

	class Ex extends RuntimeException {
		Ex(String message) {
			super(message);
		}
	}

	/***
	 * 06_string_plus-str_conv_014_String_plus_obj
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		System.out.println(("" + new RuntimeException("re")));
		System.out.println(("" + new AssertionError("ae")));
		System.out.println(("" + new Ex("ex")));
		System.out.println("Done!");

	}

	/***
	 * 06_string_plus-str_conv_016_String_plus_null
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		System.out.println(("" + null));
		System.out.println("Done!");
	}

	/***
	 * 06_string_plus-str_conv_015_String_plus_int_types/
	 */
	@Override
	public void implementionSix(String[] args) throws Exception {
		System.out.println(("" + (byte) 100 + "_" + (short) 1000 + "_"
				+ (int) 1000000 + "_" + (long) 9000000000L + "_" + 'z'));
		System.out.println("Done!");

	}

	/***
	 * 06_string_plus-str_conv_02_String_assign_plus/
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		String s = "ab";
		System.out.println((s += "cde"));
		System.out.println((s += 12));
		String[] vs = new String[1];
		vs[0] = s;
		System.out.println((vs[0] += "cde"));
		System.out.println("Done!");

	}

	/***
	 * 06_string_plus-str_conv_03_Object_assign_plus
	 */
	@Override
	public void implementionEight(String[] args) throws Exception {
		Object o = new RuntimeException("re-");
		Object o2 = o;
		System.out.println(("" + (o2 += "zz")));

		Object[] vo = new Object[1];
		vo[0] = o;
		System.out.println((vo[0] += "cde"));
		System.out.println("Done!");

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
