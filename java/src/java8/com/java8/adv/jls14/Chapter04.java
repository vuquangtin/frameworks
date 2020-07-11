package com.java8.adv.jls14;

import com.java.frameworks.base.ExtendTemplateMethod;
import com.java.frameworks.base.ITemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Chapter04 extends ExtendTemplateMethod implements ITemplateMethod {

	public static void main(String[] args) {
		new Chapter04().runTemplateMethod(args);

	}

	/***
	 * 04_prim_operators-op_011_int_to_int_prefix/
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		int a = 10;
		System.out.print("a   = ");
		System.out.println(a);
		System.out.print("+a  = ");
		System.out.println((+a));
		System.out.print("-a  = ");
		System.out.println((-a));
		System.out.println("Done!");

	}

	/***
	 * 04_prim_operators-op_012_int_to_int_pre_inc_dec
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		int a = 10;
		System.out.print("a   = ");
		System.out.println(a);
		System.out.print("++a = ");
		System.out.println((++a));
		System.out.print("a   = ");
		System.out.println(a);
		System.out.print("--a = ");
		System.out.println((--a));
		System.out.print("a   = ");
		System.out.println(a);
		System.out.println("Done!");

	}

	/***
	 * 04_prim_operators-op_013_int_to_int_postfix
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		int a = 10;
		System.out.print("a   = ");
		System.out.println(a);
		System.out.print("a++ = ");
		System.out.println((a++));
		System.out.print("a   = ");
		System.out.println(a);
		System.out.print("a-- = ");
		System.out.println((a--));
		System.out.print("a   = ");
		System.out.println(a);
		System.out.println("Done!");

	}

	class main {

		void printAll(String[] vs, int[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 5;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = "9 + 3        ";
			vs[i++] = "9 - 3        ";
			vs[i++] = "9 * 3        ";
			vs[i++] = "9 / 3        ";
			vs[i++] = "9 % 3        ";

			nrOps = i;
			return vs;
		}

		main(String[] args) {
			int[] v = new int[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				v[i] = 9;
			}

			int i = 0;
			// Infix operators
			v[i++] = 9 + 3;
			v[i++] = 9 - 3;
			v[i++] = 9 * 3;
			v[i++] = 9 / 3;
			v[i++] = 9 % 3;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_014_int_to_int_bin_arith
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		new main(args);

	}

	class main5 {

		void printAll(String[] vs, int[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 10;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = "9 | 3        ";
			vs[i++] = "9 ^ 3        ";
			vs[i++] = "9 & 3        ";
			vs[i++] = "9 | -4       ";
			vs[i++] = "9 ^ -4       ";
			vs[i++] = "9 & -4       ";
			vs[i++] = "-10 | 3      ";
			vs[i++] = "-10 ^ 3      ";
			vs[i++] = "-10 & 3      ";

			// Prefix operators
			vs[i++] = "~ 9          ";

			nrOps = i;
			return vs;
		}

		main5(String[] args) {
			int[] v = new int[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				v[i] = 9;
			}

			int i = 0;
			// Infix operators
			v[i++] = 9 | 3;
			v[i++] = 9 ^ 3;
			v[i++] = 9 & 3;
			v[i++] = 9 | -4;
			v[i++] = 9 ^ -4;
			v[i++] = 9 & -4;
			v[i++] = -10 | 3;
			v[i++] = -10 ^ 3;
			v[i++] = -10 & 3;

			// Prefix operators
			v[i++] = ~9;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_015_int_to_int_bitwise
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		new main5(args);

	}

	class main6 {

		void printAll(String[] vs, int[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 1;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Ternary operator
			vs[i++] = "9 > 3 ? 9 : 3";

			nrOps = i;
			return vs;
		}

		main6(String[] args) {
			int[] v = new int[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				v[i] = 9;
			}

			int i = 0;

			// Ternary operator
			v[i++] = 9 > 3 ? 9 : 3;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_016_int_to_int_cond
	 */
	@Override
	public void implementionSix(String[] args) throws Exception {
		new main6(args);

	}

	class main7 {

		void printAllB(String[] vs, boolean[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 6;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = "9 == 3       ";
			vs[i++] = "9 != 3       ";
			vs[i++] = "9 < 3        ";
			vs[i++] = "9 > 3        ";
			vs[i++] = "9 <= 3       ";
			vs[i++] = "9 >= 3       ";

			nrOps = i;

			return vs;
		}

		main7(String[] args) {
			boolean[] vb = new boolean[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				vb[i] = false;
			}

			int i = 0;
			// Infix operators
			vb[i++] = 9 == 3;
			vb[i++] = 9 != 3;
			vb[i++] = 9 < 3;
			vb[i++] = 9 > 3;
			vb[i++] = 9 <= 3;
			vb[i++] = 9 >= 3;

			printAllB(vs, vb);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_02_int_to_bool
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		new main7(args);

	}

	class main8 {

		void printAll(String[] vs, int[] v) {
			for (int i = 0; i < v.length; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 12;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			vs[i++] = " 9 <<   2    ";
			vs[i++] = " 9 <<  -2    ";
			vs[i++] = "-9 <<   2    ";
			vs[i++] = "-9 <<  -2    ";
			vs[i++] = " 9  >>  2    ";
			vs[i++] = " 9  >> -2    ";
			vs[i++] = "-9  >>  2    ";
			vs[i++] = "-9  >> -2    ";
			vs[i++] = " 9 >>>  2    ";
			vs[i++] = " 9 >>> -2    ";
			vs[i++] = "-9 >>>  2    ";
			vs[i++] = "-9 >>> -2    ";

			return vs;
		}

		main8(String[] args) {
			int[] v = new int[nrOps];
			String[] vs = initVS();
			int i = 0;

			v[i++] = 9 << 2;
			v[i++] = 9 << -2;
			v[i++] = -9 << 2;
			v[i++] = -9 << -2;
			v[i++] = 9 >> 2;
			v[i++] = 9 >> -2;
			v[i++] = -9 >> 2;
			v[i++] = -9 >> -2;
			v[i++] = 9 >>> 2;
			v[i++] = 9 >>> -2;
			v[i++] = -9 >>> 2;
			v[i++] = -9 >>> -2;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_03_int_bit_shift
	 */
	@Override
	public void implementionEight(String[] args) throws Exception {
		new main8(args);

	}

	/***
	 * 04_prim_operators-op_041_int_assign_plus
	 */
	@Override
	public void implementionNine(String[] args) throws Exception {
		int a = 9;
		a += 3;
		System.out.print("9 += 3  =>  ");
		System.out.println(a);
		System.out.println("Done!");

	}

	class main9 {

		void printAll(String[] vs, int[] v) {
			for (int i = 0; i < v.length; i++) {
				System.out.print(vs[i]);
				System.out.print("  =>  ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 12;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			vs[i++] = "9 = 3   ";
			vs[i++] = "9 +=   3";
			vs[i++] = "9 -=   3";
			vs[i++] = "9 *=   3";
			vs[i++] = "9 /=   3";
			vs[i++] = "9 &=   3";
			vs[i++] = "9 |=   3";
			vs[i++] = "9 ^=   3";
			vs[i++] = "9 %=   3";
			vs[i++] = "9 <<=  3";
			vs[i++] = "9 >>=  3";
			vs[i++] = "9 >>>= 3";

			return vs;
		}

		main9(String[] args) {
			int[] v = new int[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				v[i] = 9;
			}
			int i = 0;

			v[i++] = 3;
			v[i++] += 3;
			v[i++] -= 3;
			v[i++] *= 3;
			v[i++] /= 3;
			v[i++] &= 3;
			v[i++] |= 3;
			v[i++] ^= 3;
			v[i++] %= 3;
			v[i++] <<= 3;
			v[i++] >>= 3;
			v[i++] >>>= 3;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_042_int_assign_all
	 */
	@Override
	public void implementionTen(String[] args) throws Exception {
		new main9(args);

	}

	class main10 {

		void printAll(String[] vs, int[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 30;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = " 2147483647 + 2147483647      ";
			vs[i++] = "-2147483647 - 2147483647      ";
			vs[i++] = " 2147483647 * 2147483647      ";
			vs[i++] = "- (-2147483648)               ";
			vs[i++] = "++2147483647                  ";
			vs[i++] = "2147483647++                  ";
			vs[i++] = "-- (-2147483648)              ";
			vs[i++] = "(-2147483648)--               ";
			vs[i++] = "~(-2147483648)                ";
			vs[i++] = "2147483647 | (-2147483648)    ";
			vs[i++] = "2147483647 ^ (-2147483648)    ";
			vs[i++] = "3 << 31                       ";

			nrOps = i;

			return vs;
		}

		main10(String[] args) {
			int[] v = new int[nrOps];
			String[] vs = initVS();

			int i = 0;
			// Infix operators
			v[i++] = 2147483647 + 2147483647;
			v[i++] = -2147483647 - 2147483647;
			v[i++] = 2147483647 * 2147483647;
			v[i++] = -(-2147483648);
			v[i] = 2147483647;
			++v[i++];
			v[i] = 2147483647;
			v[i++]++;
			v[i] = -2147483648;
			--v[i++];
			v[i] = -2147483648;
			v[i++]--;
			v[i++] = ~(-2147483648);
			v[i++] = 2147483647 | (-2147483648);
			v[i++] = 2147483647 ^ (-2147483648);
			v[i++] = 3 << 31;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_05_int_to_int_overflow
	 */
	@Override
	public void implementionEleven(String[] args) throws Exception {
		new main10(args);

	}

	class main11 {

		void printAll(String[] vs, long[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 30;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = "9L | 3L        ";
			vs[i++] = "9L ^ 3L        ";
			vs[i++] = "9L & 3L        ";
			vs[i++] = "9L | -4L       ";
			vs[i++] = "9L ^ -4L       ";
			vs[i++] = "9L & -4L       ";
			vs[i++] = "-10L | 3L      ";
			vs[i++] = "-10L ^ 3L      ";
			vs[i++] = "-10L & 3L      ";
			vs[i++] = "9L << 3L       ";
			vs[i++] = "9L >> 3L       ";
			vs[i++] = "9L >>> 3L      ";
			vs[i++] = "9L + 3L        ";
			vs[i++] = "9L - 3L        ";
			vs[i++] = "9L * 3L        ";
			vs[i++] = "9L / 3L        ";
			vs[i++] = "9L % 3L        ";

			// Prefix operators
			vs[i++] = "++9L          ";
			vs[i++] = "--9L          ";
			vs[i++] = "~ 9L          ";
			vs[i++] = "+ 9L          ";
			vs[i++] = "- 9L          ";

			// Postfix operators
			vs[i++] = "9L++          ";
			vs[i++] = "9L--          ";

			// Ternary operator
			vs[i++] = "9L > 3L ? 9L : 3L";

			nrOps = i;
			return vs;
		}

		main11(String[] args) {
			long[] v = new long[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				v[i] = 9L;
			}

			int i = 0;
			// Infix operators
			v[i++] = 9L | 3L;
			v[i++] = 9L ^ 3L;
			v[i++] = 9L & 3L;
			v[i++] = 9L | -4L;
			v[i++] = 9L ^ -4L;
			v[i++] = 9L & -4L;
			v[i++] = -10L | 3L;
			v[i++] = -10L ^ 3L;
			v[i++] = -10L & 3L;
			v[i++] = 9L << 3L;
			v[i++] = 9L >> 3L;
			v[i++] = 9L >>> 3L;
			v[i++] = 9L + 3L;
			v[i++] = 9L - 3L;
			v[i++] = 9L * 3L;
			v[i++] = 9L / 3L;
			v[i++] = 9L % 3L;

			// Prefix operators
			++v[i++];
			--v[i++];
			v[i++] = ~9L;
			v[i++] = +9L;
			v[i++] = -9L;

			// Postfix operators
			v[i] = v[i++]++;
			v[i] = v[i++]--;

			// Ternary operator
			v[i++] = 9L > 3L ? 9L : 3L;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_06_long_to_long
	 */
	@Override
	public void implementionTwelve(String[] args) throws Exception {
		new main11(args);

	}

	class main12 {

		void printAllB(String[] vs, boolean[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 14;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = "9L == 3L       ";
			vs[i++] = "9L != 3L       ";
			vs[i++] = "9L  < 3L       ";
			vs[i++] = "9L  > 3L       ";
			vs[i++] = "9L <= 3L       ";
			vs[i++] = "9L >= 3L       ";

			nrOps = i;

			return vs;
		}

		main12(String[] args) {
			boolean[] vb = new boolean[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				vb[i] = false;
			}

			int i = 0;
			// Infix operators
			vb[i++] = 9L == 3L;
			vb[i++] = 9L != 3L;
			vb[i++] = 9L < 3L;
			vb[i++] = 9L > 3L;
			vb[i++] = 9L <= 3L;
			vb[i++] = 9L >= 3L;

			printAllB(vs, vb);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_07_long_to_bool
	 */
	@Override
	public void implementionThirteen(String[] args) throws Exception {
		new main12(args);

	}

	class main13 {

		void printAll(String[] vs, long[] v) {
			for (int i = 0; i < v.length; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 12;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			vs[i++] = " 9L <<   2L    ";
			vs[i++] = " 9L <<  -2L    ";
			vs[i++] = "-9L <<   2L    ";
			vs[i++] = "-9L <<  -2L    ";
			vs[i++] = " 9L  >>  2L    ";
			vs[i++] = " 9L  >> -2L    ";
			vs[i++] = "-9L  >>  2L    ";
			vs[i++] = "-9L  >> -2L    ";
			vs[i++] = " 9L >>>  2L    ";
			vs[i++] = " 9L >>> -2L    ";
			vs[i++] = "-9L >>>  2L    ";
			vs[i++] = "-9L >>> -2L    ";

			return vs;
		}

		main13(String[] args) {
			long[] v = new long[nrOps];
			String[] vs = initVS();
			int i = 0;

			v[i++] = 9L << 2L;
			v[i++] = 9L << -2L;
			v[i++] = -9L << 2L;
			v[i++] = -9L << -2L;
			v[i++] = 9L >> 2L;
			v[i++] = 9L >> -2L;
			v[i++] = -9L >> 2L;
			v[i++] = -9L >> -2L;
			v[i++] = 9L >>> 2L;
			v[i++] = 9L >>> -2L;
			v[i++] = -9L >>> 2L;
			v[i++] = -9L >>> -2L;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_08_long_bit_shift
	 */
	@Override
	public void implementionFourteen(String[] args) throws Exception {
		new main13(args);

	}

	class main14 {

		void printAll(String[] vs, long[] v) {
			for (int i = 0; i < v.length; i++) {
				System.out.print(vs[i]);
				System.out.print("  =>  ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 12;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			vs[i++] = "9L  =   3L";
			vs[i++] = "9L +=   3L";
			vs[i++] = "9L -=   3L";
			vs[i++] = "9L *=   3L";
			vs[i++] = "9L /=   3L";
			vs[i++] = "9L &=   3L";
			vs[i++] = "9L |=   3L";
			vs[i++] = "9L ^=   3L";
			vs[i++] = "9L %=   3L";
			vs[i++] = "9L <<=  3L";
			vs[i++] = "9L >>=  3L";
			vs[i++] = "9L >>>= 3L";

			return vs;
		}

		main14(String[] args) {
			long[] v = new long[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				v[i] = 9L;
			}
			int i = 0;

			v[i++] = 3L;
			v[i++] += 3L;
			v[i++] -= 3L;
			v[i++] *= 3L;
			v[i++] /= 3L;
			v[i++] &= 3L;
			v[i++] |= 3L;
			v[i++] ^= 3L;
			v[i++] %= 3L;
			v[i++] <<= 3L;
			v[i++] >>= 3L;
			v[i++] >>>= 3L;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_09_long_assign
	 */
	@Override
	public void implementionFifteen(String[] args) throws Exception {
		new main14(args);

	}

	class main15 {

		void printAll(String[] vs, long[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 30;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = " 9223372036854775807L + 9223372036854775807L      ";
			vs[i++] = "-9223372036854775807L - 9223372036854775807L      ";
			vs[i++] = " 9223372036854775807L * 9223372036854775807L      ";
			vs[i++] = "- (-9223372036854775808L)                         ";
			vs[i++] = "++9223372036854775807L                            ";
			vs[i++] = "9223372036854775807L++                            ";
			vs[i++] = "-- (-9223372036854775808L)                        ";
			vs[i++] = "(-9223372036854775808L)--                         ";
			vs[i++] = "~(-9223372036854775808L)                          ";
			vs[i++] = "9223372036854775807L | (-9223372036854775808L)    ";
			vs[i++] = "9223372036854775807L ^ (-9223372036854775808L)    ";
			vs[i++] = "3L << 63L                                         ";

			nrOps = i;

			return vs;
		}

		main15(String[] args) {
			long[] v = new long[nrOps];
			String[] vs = initVS();

			int i = 0;
			// Infix operators
			v[i++] = 9223372036854775807L + 9223372036854775807L;
			v[i++] = -9223372036854775807L - 9223372036854775807L;
			v[i++] = 9223372036854775807L * 9223372036854775807L;
			v[i++] = -(-9223372036854775808L);
			v[i] = 9223372036854775807L;
			++v[i++];
			v[i] = 9223372036854775807L;
			v[i++]++;
			v[i] = -9223372036854775808L;
			--v[i++];
			v[i] = -9223372036854775808L;
			v[i++]--;
			v[i++] = ~(-9223372036854775808L);
			v[i++] = 9223372036854775807L | (-9223372036854775808L);
			v[i++] = 9223372036854775807L ^ (-9223372036854775808L);
			v[i++] = 3L << 63L;

			printAll(vs, v);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_10_long_to_long_overflow
	 */
	@Override
	public void implementionSixteen(String[] args) throws Exception {
		new main15(args);

	}

	class main16 {

		void printAllB(String[] vs, boolean[] v) {
			for (int i = 0; i < nrOps; i++) {
				System.out.print(vs[i]);
				System.out.print(" = ");
				System.out.println(v[i]);
			}
		}

		int nrOps = 6;

		String[] initVS() {
			String[] vs = new String[nrOps];
			int i = 0;

			// Infix operators
			vs[i++] = "true | false ";
			vs[i++] = "true ^ false ";
			vs[i++] = "true & false ";
			vs[i++] = "true == false";
			vs[i++] = "true != false";

			// Prefix operators
			vs[i++] = "! true       ";

			nrOps = i;

			return vs;
		}

		main16(String[] args) {
			boolean[] vb = new boolean[nrOps];
			String[] vs = initVS();

			for (int i = 0; i < nrOps; i++) {
				vb[i] = false;
			}

			int i = 0;
			// Infix operators
			vb[i++] = true | false;
			vb[i++] = true ^ false;
			vb[i++] = true & false;
			vb[i++] = true == false;
			vb[i++] = true != false;

			// Prefix operators
			vb[i++] = !true;

			printAllB(vs, vb);
			System.out.println("Done!");
		}
	}

	/***
	 * 04_prim_operators-op_111_bool_to_bool_not_lazy
	 */
	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		new main16(args);

	}

	class main17 {

		main17(String[] args) {
			System.out.print("false && true       = ");
			System.out.println((false && true));
			System.out.print("true && false       = ");
			System.out.println((true && false));
			System.out.print("fFalse() && fTrue() = ");
			System.out.println((fFalse() && fTrue()));
			System.out.print("fTrue() && fFalse() = ");
			System.out.println((fTrue() && fFalse()));
			System.out.println("Done!");
		}

		boolean fTrue() {
			System.out.println("fTrue()");
			return true;
		}

		boolean fFalse() {
			System.out.println("fFalse()");
			return false;
		}
	}

	/***
	 * 04_prim_operators-op_112_lazy_and
	 */
	@Override
	public void implementionEighteen(String[] args) throws Exception {
		new main17(args);

	}

	class main18 {

		main18(String[] args) {
			System.out.print("true || false       = ");
			System.out.println((true || false));
			System.out.print("false || true       = ");
			System.out.println((false || true));
			System.out.print("fTrue() || fFalse() = ");
			System.out.println((fTrue() || fFalse()));
			System.out.print("fFalse() || fTrue() = ");
			System.out.println((fFalse() || fTrue()));
			System.out.println("Done!");
		}

		boolean fTrue() {
			System.out.println("fTrue()");
			return true;
		}

		boolean fFalse() {
			System.out.println("fFalse()");
			return false;
		}
	}

	/***
	 * 04_prim_operators-op_113_lazy_or
	 */
	@Override
	public void implementionNineteen(String[] args) throws Exception {
		new main18(args);

	}

	/***
	 * 04_prim_operators-op_12_bool_compound_assign
	 */
	@Override
	public void implementionTwenty(String[] args) throws Exception {
		boolean b1 = false, b2 = false, b3 = false;
		System.out.print("");
		System.out.print((b1 &= true));
		System.out.print(" ");
		System.out.print((b2 |= true));
		System.out.print(" ");
		System.out.println((b3 ^= true));
		System.out.println("Done!");

	}

	class ArrayReferenceThrow extends RuntimeException {
		ArrayReferenceThrow() {
			super((String) null);
		}
	}

	class IndexThrow extends RuntimeException {
		IndexThrow() {
			super((String) null);
		}
	}

	class RightHandSideThrow extends RuntimeException {
		RightHandSideThrow() {
			super((String) null);
		}
	}

	class IllustrateCompoundArrayAssignment {
		String[] strings;

		IllustrateCompoundArrayAssignment() {
			strings = new String[2];
			strings[0] = "Simon";
			strings[1] = "Garfunkel";
		}

		String[] stringsThrow() {
			throw new ArrayReferenceThrow();
		}

		int indexThrow() {
			throw new IndexThrow();
		}

		String stringThrow() {
			throw new RightHandSideThrow();
		}

		void testEight(String[] x, int j) {
			String sx = (x == null) ? "null" : "Strings";
			System.out.println();
			try {
				System.out.print(sx);
				System.out.print("[throw]+=throw => ");
				x[indexThrow()] += stringThrow();
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}
			try {
				System.out.print(sx);
				System.out.print("[throw]+=\"heh\" => ");
				x[indexThrow()] += "heh";
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}
			try {
				System.out.print(sx);
				System.out.print("[");
				System.out.print(j);
				System.out.print("]+=throw => ");
				x[j] += stringThrow();
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}
			try {
				System.out.print(sx);
				System.out.print("[");
				System.out.print(j);
				System.out.print("]+=\"heh\" => ");
				x[j] += "heh";
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}
		}

		void main() {
			try {
				System.out.print("throw[throw]+=throw => ");
				stringsThrow()[indexThrow()] += stringThrow();
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}
			try {
				System.out.print("throw[throw]+=\"heh\" => ");
				stringsThrow()[indexThrow()] += "heh";
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}
			try {
				System.out.print("throw[1]+=throw => ");
				stringsThrow()[1] += stringThrow();
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}
			try {
				System.out.print("throw[1]+=\"heh\" => ");
				stringsThrow()[1] += "heh";
				System.out.println("Okay!");
			} catch (RuntimeException e) {
				System.out.println(e);
			}

			testEight(null, 1);
			testEight(null, 9);
			testEight(strings, 1);
			testEight(strings, 9);
		}
	}

	/***
	 * 04_prim_operators-op_13_compound_assign_jls
	 */
	@Override
	public void implementorOne(String[] args) throws Exception {
		new IllustrateCompoundArrayAssignment().main();

	}

	@Override
	public void implementorTwo(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorThree(String[] args) throws Exception {
		// TODO Auto-generated method stub

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
