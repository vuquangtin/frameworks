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
public class Chapter02 extends TemplateMethod {
	public static void main(String[] args) {
		new Chapter02().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		System.out.println("Decimal long literals:");
		System.out.print(0L);
		System.out.print(" ");
		System.out.print(12L);
		System.out.print(" ");
		System.out.print(12345678900l);
		System.out.print(" ");
		System.out.println(12345678900L);
		System.out.print("Long not overflow, 2002001001L + 2002001001L = ");
		System.out.println((2002001001L + 2002001001L));
		System.out.print("long extremes: ");
		System.out.print(-9223372036854775808L);
		System.out.print(" ");
		System.out.println(9223372036854775807L);
		System.out.println("Done!");

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		System.out.println("Hexa int literals:");
		System.out.print(0x0);
		System.out.print(" ");
		System.out.print(0x5f);
		System.out.print(" ");
		System.out.print(0X5F);
		System.out.print(" ");
		System.out.println(0xFFFFFFF0);
		System.out.print("Hexa int overflow, 0x70000000 + 0x70000000 = ");
		System.out.println((0x70000000 + 0x70000000));
		System.out.print("int extremes: ");
		System.out.print(0x80000000);
		System.out.print(" ");
		System.out.println(0x7fffffff);
		System.out.println("Hexa long literals:");
		System.out.print(0x0L);
		System.out.print(" ");
		System.out.print(0x123456789abL);
		System.out.print(" ");
		System.out.print(0x123456789ABl);
		System.out.print(" ");
		System.out.print(0xFFFFFFF0L);
		System.out.print(" ");
		System.out.println(0xFFFFFFFF00000000L);
		System.out
				.print("Hexa long not overflow, 0x70000000L + 0x70000000L = ");
		System.out.println((0x70000000L + 0x70000000L));
		System.out.print("long extremes: ");
		System.out.print(0x8000000000000000L);
		System.out.print(" ");
		System.out.println(0x7fffffffffffffffL);
		System.out.println("Done!");

	}

	// Octal integer literals
	@Override
	public void implementionThree(String[] args) throws Exception {
		System.out.println("Octa int literals:");
		System.out.print(00);
		System.out.print(" ");
		System.out.print(077);
		System.out.print(" ");
		System.out.println(037777777777);
		System.out.print("Octa int overflow, 017777777777 + 017777777777 = ");
		System.out.println((017777777777 + 017777777777));
		System.out.print("int extremes: ");
		System.out.print(020000000000);
		System.out.print(" ");
		System.out.println(017777777777);
		System.out.println("Octa long literals:");
		System.out.print(00L);
		System.out.print(" ");
		System.out.print(037777777777l);
		System.out.print(" ");
		System.out.println(01777777777777777777777L);
		System.out
				.print("Octa long not overflow, 017777777777L + 017777777777L = ");
		System.out.println((017777777777L + 017777777777L));
		System.out.print("long extremes: ");
		System.out.print(01000000000000000000000L);
		System.out.print(" ");
		System.out.println(0777777777777777777777L);
		System.out.println("Done!");

	}

	/***
	 * literals_04_boolean
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		boolean t = true;
		boolean f = false;
		System.out.println(t);
		System.out.println(f);
		System.out.println("Done!");

	}

	/***
	 * main character literals - the part supported by maude
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		System.out.println("Standart single char literals:");
		System.out.print("");
		System.out.print('a');
		System.out.print('A');
		System.out.print('0');
		System.out.print(' ');
		System.out.println('#');// aA0 #
		System.out.println("Single chars, same as in named escapes:");
		System.out.print("");
		System.out.print('b');
		System.out.print('t');
		System.out.print('n');
		System.out.print('f');
		System.out.println('r');
		System.out.println("Done!");

	}

	/***
	 * Escape sequences for chars - named, octal and unicode. Only chars in the
	 * range of ascii codes 0-127. Those beyond 127 are not supported by maude.
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionSix(String[] args) throws Exception {
		System.out.println("Named escape:");
		System.out.print("");
		System.out.print('\b');
		System.out.print('\t');
		System.out.print('\n');
		System.out.print('\f');
		System.out.print('\r');
		System.out.print('\"');
		System.out.println('\'' + '\\');
		System.out.println("Octal escape of simple chars:");
		System.out.print("");
		System.out.print('\141');
		System.out.print('\101');
		System.out.print('\60');
		System.out.print('\40');
		System.out.println('\43');// aA0 #
		System.out.println("Unicode escape of simple chars:");
		System.out.print("");
		System.out.print('\u0061');
		System.out.print('\u0041');
		System.out.print('\u0030');
		System.out.print('\u0020');
		System.out.println('\u0023');// aA0 #

		System.out.println("Octal escape:");
		System.out.print("");
		System.out.print('\0');
		System.out.print('\7');
		System.out.print('\00');
		System.out.print('\07');
		System.out.print('\37');
		System.out.print('\77');
		System.out.print('\000');
		System.out.print('\007');
		System.out.print('\077');
		System.out.println('\177');
		System.out.print("Octal escape 0, 127, again: ");
		System.out.print('\0');
		System.out.println('\177');
		System.out.println("Unicode escape:");
		System.out.print("");
		System.out.print('\u0000');
		System.out.print('\u0001');
		System.out.print('\uu0007');
		System.out.print('\u0010');
		System.out.println('\uuu007f');
		System.out.println("Done!");

	}

	/***
	 * main string literals
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		System.out.println("Empty string:");
		System.out.println("");
		System.out.println("Simple chars string:");
		System.out.println("aA0 #");
		System.out.println("Names escape only:");
		System.out.println("\\");
		System.out.println("two named escapes:");
		System.out.println("\"\\");
		System.out.println("Chars and escapes together:");
		System.out.println("_\\\'_<>");
		System.out.println("Done!");

	}

	/***
	 * Named, octal and unicode escapes, all possible cases, part supported by
	 * maude.
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionEight(String[] args) throws Exception {
		System.out.println("Named escape:");
		System.out.print("");
		System.out.print("_\b_");
		System.out.print("_\t_");
		System.out.print("_\n_");
		System.out.print("_\f_");
		System.out.print("_\r_");
		System.out.println("_\"_" + "_\'_" + "_\\_");
		System.out.println("Octal escape of simple chars:");
		System.out.print("");
		System.out.print("_\141_");
		System.out.print("_\101_");
		System.out.print("_\60_");
		System.out.print("_\40_");
		System.out.println("_\43_");// aA0 #
		System.out.println("Unicode escape of simple chars:");
		System.out.print("");
		System.out.print("_\u0061_");
		System.out.print("_\u0041_");
		System.out.print("_\u0030_");
		System.out.print("_\u0020_");
		System.out.println("_\u0023_");// aA0 #

		System.out.println("Octal escape:");
		System.out.print("");
		System.out.print("_\0_");
		System.out.print("_\7_");
		System.out.print("_\00_");
		System.out.print("_\07_");
		System.out.print("_\37_");
		System.out.print("_\77_");
		System.out.print("_\000_");
		System.out.print("_\007_");
		System.out.print("_\077_");
		System.out.println("_\177_");
		System.out.println("Unicode escape:");
		System.out.print("");
		System.out.print("_\u0000_");
		System.out.print("_\u0001_");
		System.out.print("_\uu0007_");
		System.out.print("_\u0010_");
		System.out.println("_\uuu007f_");
		System.out.println("Done!");

	}

	/***
	 * literals_09_null
	 * 
	 * @param args
	 * @throws Exception
	 */

	@Override
	public void implementionNine(String[] args) throws Exception {
		A a = null;
		System.out.print("");
		System.out.println(a);
		System.out.println("Done!");

	}

	class A {
	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
}
