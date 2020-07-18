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
		logger.debug("Decimal long literals:");
		logger.debug(0L);
		logger.debug(" ");
		logger.debug(12L);
		logger.debug(" ");
		logger.debug(12345678900l);
		logger.debug(" ");
		logger.debug(12345678900L);
		logger.debug("Long not overflow, 2002001001L + 2002001001L = ");
		logger.debug((2002001001L + 2002001001L));
		logger.debug("long extremes: ");
		logger.debug(-9223372036854775808L);
		logger.debug(" ");
		logger.debug(9223372036854775807L);
		logger.debug("Done!");

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		logger.debug("Hexa int literals:");
		logger.debug(0x0);
		logger.debug(" ");
		logger.debug(0x5f);
		logger.debug(" ");
		logger.debug(0X5F);
		logger.debug(" ");
		logger.debug(0xFFFFFFF0);
		logger.debug("Hexa int overflow, 0x70000000 + 0x70000000 = ");
		logger.debug((0x70000000 + 0x70000000));
		logger.debug("int extremes: ");
		logger.debug(0x80000000);
		logger.debug(" ");
		logger.debug(0x7fffffff);
		logger.debug("Hexa long literals:");
		logger.debug(0x0L);
		logger.debug(" ");
		logger.debug(0x123456789abL);
		logger.debug(" ");
		logger.debug(0x123456789ABl);
		logger.debug(" ");
		logger.debug(0xFFFFFFF0L);
		logger.debug(" ");
		logger.debug(0xFFFFFFFF00000000L);
		System.out
				.print("Hexa long not overflow, 0x70000000L + 0x70000000L = ");
		logger.debug((0x70000000L + 0x70000000L));
		logger.debug("long extremes: ");
		logger.debug(0x8000000000000000L);
		logger.debug(" ");
		logger.debug(0x7fffffffffffffffL);
		logger.debug("Done!");

	}

	// Octal integer literals
	@Override
	public void implementionThree(String[] args) throws Exception {
		logger.debug("Octa int literals:");
		logger.debug(00);
		logger.debug(" ");
		logger.debug(077);
		logger.debug(" ");
		logger.debug(037777777777);
		logger.debug("Octa int overflow, 017777777777 + 017777777777 = ");
		logger.debug((017777777777 + 017777777777));
		logger.debug("int extremes: ");
		logger.debug(020000000000);
		logger.debug(" ");
		logger.debug(017777777777);
		logger.debug("Octa long literals:");
		logger.debug(00L);
		logger.debug(" ");
		logger.debug(037777777777l);
		logger.debug(" ");
		logger.debug(01777777777777777777777L);
		System.out
				.print("Octa long not overflow, 017777777777L + 017777777777L = ");
		logger.debug((017777777777L + 017777777777L));
		logger.debug("long extremes: ");
		logger.debug(01000000000000000000000L);
		logger.debug(" ");
		logger.debug(0777777777777777777777L);
		logger.debug("Done!");

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
		logger.debug(t);
		logger.debug(f);
		logger.debug("Done!");

	}

	/***
	 * main character literals - the part supported by maude
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		logger.debug("Standart single char literals:");
		logger.debug("");
		logger.debug('a');
		logger.debug('A');
		logger.debug('0');
		logger.debug(' ');
		logger.debug('#');// aA0 #
		logger.debug("Single chars, same as in named escapes:");
		logger.debug("");
		logger.debug('b');
		logger.debug('t');
		logger.debug('n');
		logger.debug('f');
		logger.debug('r');
		logger.debug("Done!");

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
		logger.debug("Named escape:");
		logger.debug("");
		logger.debug('\b');
		logger.debug('\t');
		logger.debug('\n');
		logger.debug('\f');
		logger.debug('\r');
		logger.debug('\"');
		logger.debug('\'' + '\\');
		logger.debug("Octal escape of simple chars:");
		logger.debug("");
		logger.debug('\141');
		logger.debug('\101');
		logger.debug('\60');
		logger.debug('\40');
		logger.debug('\43');// aA0 #
		logger.debug("Unicode escape of simple chars:");
		logger.debug("");
		logger.debug('\u0061');
		logger.debug('\u0041');
		logger.debug('\u0030');
		logger.debug('\u0020');
		logger.debug('\u0023');// aA0 #

		logger.debug("Octal escape:");
		logger.debug("");
		logger.debug('\0');
		logger.debug('\7');
		logger.debug('\00');
		logger.debug('\07');
		logger.debug('\37');
		logger.debug('\77');
		logger.debug('\000');
		logger.debug('\007');
		logger.debug('\077');
		logger.debug('\177');
		logger.debug("Octal escape 0, 127, again: ");
		logger.debug('\0');
		logger.debug('\177');
		logger.debug("Unicode escape:");
		logger.debug("");
		logger.debug('\u0000');
		logger.debug('\u0001');
		logger.debug('\uu0007');
		logger.debug('\u0010');
		logger.debug('\uuu007f');
		logger.debug("Done!");

	}

	/***
	 * main string literals
	 * 
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		logger.debug("Empty string:");
		logger.debug("");
		logger.debug("Simple chars string:");
		logger.debug("aA0 #");
		logger.debug("Names escape only:");
		logger.debug("\\");
		logger.debug("two named escapes:");
		logger.debug("\"\\");
		logger.debug("Chars and escapes together:");
		logger.debug("_\\\'_<>");
		logger.debug("Done!");

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
		logger.debug("Named escape:");
		logger.debug("");
		logger.debug("_\b_");
		logger.debug("_\t_");
		logger.debug("_\n_");
		logger.debug("_\f_");
		logger.debug("_\r_");
		logger.debug("_\"_" + "_\'_" + "_\\_");
		logger.debug("Octal escape of simple chars:");
		logger.debug("");
		logger.debug("_\141_");
		logger.debug("_\101_");
		logger.debug("_\60_");
		logger.debug("_\40_");
		logger.debug("_\43_");// aA0 #
		logger.debug("Unicode escape of simple chars:");
		logger.debug("");
		logger.debug("_\u0061_");
		logger.debug("_\u0041_");
		logger.debug("_\u0030_");
		logger.debug("_\u0020_");
		logger.debug("_\u0023_");// aA0 #

		logger.debug("Octal escape:");
		logger.debug("");
		logger.debug("_\0_");
		logger.debug("_\7_");
		logger.debug("_\00_");
		logger.debug("_\07_");
		logger.debug("_\37_");
		logger.debug("_\77_");
		logger.debug("_\000_");
		logger.debug("_\007_");
		logger.debug("_\077_");
		logger.debug("_\177_");
		logger.debug("Unicode escape:");
		logger.debug("");
		logger.debug("_\u0000_");
		logger.debug("_\u0001_");
		logger.debug("_\uu0007_");
		logger.debug("_\u0010_");
		logger.debug("_\uuu007f_");
		logger.debug("Done!");

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
		logger.debug("");
		logger.debug(a);
		logger.debug("Done!");

	}

	class A {
	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}
}
