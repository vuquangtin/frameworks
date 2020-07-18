package com.java8.adv.jls14;

import java.util.ArrayList;
import java.util.List;

import com.java.frameworks.base.IExtendTemplateMethod;
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
public class Chapter05 extends TemplateMethod implements IExtendTemplateMethod
// Chapter 5, conversions
{
	public static void main(String[] args) {
		new Chapter05().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// Casting conversion (5.4) of a float literal to
		// type int. Without the cast operator, this would
		// be a compile-time error, because this is a
		// narrowing conversion (5.1.3):
		int i = (int) 12.5f;

		// String conversion (5.4) of i's int value:
		logger.debug("(int)12.5f==" + i);

		// Assignment conversion (5.2) of i's value to type
		// float. This is a widening conversion (5.1.2):
		float f = i;

		// String conversion of f's float value:
		logger.debug("after float widening: " + f);

		// Numeric promotion (5.6) of i's value to type
		// float. This is a binary numeric promotion.
		// After promotion, the operation is float*float:
		logger.debug(f);
		f = f * i;

		// Two string conversions of i and f:
		logger.debug("*" + i + "==" + f);

		// Invocation conversion (5.3) of f's value
		// to type double, needed because the method Math.sin
		// accepts only a double argument:
		double d = Math.sin(f);

		// Two string conversions of f and d:
		logger.debug("Math.sin(" + f + ")==" + d);

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		narrowingAndWidening();
	}

	public static void narrowingAndWidening() {
		int big = 1234567890;
		float approx = big;
		logger.debug(big - (int) approx);
		float fmin = Float.NEGATIVE_INFINITY;
		float fmax = Float.POSITIVE_INFINITY;
		logger.debug("long: " + (long) fmin + ".." + (long) fmax);
		logger.debug("int: " + (int) fmin + ".." + (int) fmax);
		logger.debug("short: " + (short) fmin + ".." + (short) fmax);
		logger.debug("char: " + (int) (char) fmin + ".."
				+ (int) (char) fmax);
		logger.debug("byte: " + (byte) fmin + ".." + (byte) fmax);
		// A narrowing of int to short loses high bits:
		logger.debug("(short)0x12345678==0x"
				+ Integer.toHexString((short) 0x12345678));
		// An int value too big for byte changes sign and magnitude:
		logger.debug("(byte)255==" + (byte) 255);
		// A float value too big to fit gives largest int value:
		logger.debug("(int)1e20f==" + (int) 1e20f);
		// A NaN converted to int yields zero:
		logger.debug("(int)NaN==" + (int) Float.NaN);
		// A double value too large for float yields infinity:
		logger.debug("(float)-1e100==" + (float) -1e100);
		// A double value too small for float underflows to zero:
		logger.debug("(float)1e-50==" + (float) 1e-50);
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		assignmentConversions();

	}

	public static void assignmentConversions() {
		short s = 12; // narrow 12 to short
		float f = s; // widen short to float
		logger.debug("f=" + f);
		char c = '\u0123';
		long l = c; // widen char to long
		logger.debug("l=0x" + Long.toString(l, 16));
		f = 1.23f;
		double d = f; // widen float to double
		logger.debug("d=" + d);
	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		referenceTypeConversions();

	}

	public static void referenceTypeConversions() {
		// Assignments to variables of class type:
		Point p = new Point();
		p = new Point3D();
		// OK because Point3D is a subclass of Point
		// ERROR
		// Point3D p3d = p;
		// Error: will require a cast because a Point
		// might not be a Point3D (even though it is,
		// dynamically, in this example.)

		// Assignments to variables of type Object:
		Object o = p; // OK: any object to Object
		int[] a = new int[3];
		Object o2 = a; // OK: an array to Object

		// Assignments to variables of interface type:
		ColoredPoint cp = new ColoredPoint();
		// ERROR
		// Colorable c = cp;
		// OK: ColoredPoint implements Colorable

		// Assignments to variables of array type:
		byte[] b = new byte[4];
		// ERROR
		// a = b;
		// Error: these are not arrays of the same primitive type
		Point3D[] p3da = new Point3D[3];
		Point[] pa = p3da;
		// OK: since we can assign a Point3D to a Point
		// ERROR
		// p3da = pa;
		// Error: (cast needed) since a Point
		// can't be assigned to a Point3D
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		ArrayConversions();

	}

	public static void ArrayConversions() {
		long[] veclong = new long[100];
		Object o = veclong; // okay
		// ERROR
		// Long l = veclong; // compile-time error
		// ERROR
		// short[] vecshort = veclong; // compile-time error
		Point[] pvec = new Point[100];
		ColoredPoint[] cpvec = new ColoredPoint[100];
		pvec = cpvec; // okay
		pvec[0] = new Point(); // okay at compile time,
								// but would throw an
								// exception at run time
		// ERROR
		// cpvec = pvec; // compile-time error
	}

	public static void castingConversions() {
		Point p = new Point();
		ColoredPoint cp = new ColoredPoint();
		Colorable c;
		// The following may cause errors at run time because
		// we cannot be sure they will succeed; this possibility
		// is suggested by the casts:
		cp = (ColoredPoint) p; // p might not reference an
								// object which is a ColoredPoint
								// or a subclass of ColoredPoint
		c = (Colorable) p; // p might not be Colorable
		// The following are incorrect at compile time because
		// they can never succeed as explained in the text:
		// ERROR
		// Long l = (Long) p; // compile-time error #1
		EndPoint e = new EndPoint();
		c = (Colorable) e; // compile-time error #2
	}

	public static void castingConversionsForArrays() {
		Point[] pa = new ColoredPoint[4];
		pa[0] = new ColoredPoint(2, 2, 12);
		pa[1] = new ColoredPoint(4, 5, 24);
		ColoredPoint[] cpa = (ColoredPoint[]) pa;
		logger.debug("cpa: {");
		for (int i = 0; i < cpa.length; i++)
			logger.debug((i == 0 ? " " : ", ") + cpa[i]);
		logger.debug(" }");
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		castingConversionsForArrays();

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		castingConversions();

	}

	public static void unaryNumericPromotions() {
		byte b = 2;
		int a[] = new int[b]; // dimension expression promotion
		char c = '\u0001';
		a[c] = 1; // index expression promotion
		a[0] = -c; // unary - promotion
		logger.debug("a: " + a[0] + "," + a[1]);
		b = -1;
		int i = ~b; // bitwise complement promotion
		logger.debug("~0x" + Integer.toHexString(b) + "==0x"
				+ Integer.toHexString(i));
		i = b << 4L; // shift promotion (left operand)
		logger.debug("0x" + Integer.toHexString(b) + "<<4L==0x"
				+ Integer.toHexString(i));
	}

	public static void binaryNumericPromotions() {
		int i = 0;
		float f = 1.0f;
		double d = 2.0;
		// First int*float is promoted to float*float, then
		// float==double is promoted to double==double:
		if (i * f == d)
			logger.debug("oops");

		// A char&byte is promoted to int&int:
		byte b = 0x1f;
		char c = 'G';
		int control = c & b;
		logger.debug(Integer.toHexString(control));

		// Here int:float is promoted to float:float:
		f = (b == 0) ? i : 4.0f;
		logger.debug(1.0 / f);
	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		binaryNumericPromotions();

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		unaryNumericPromotions();

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		Point[] pa = new Point[100];

		// The following line will throw a ClassCastException:
		ColoredPoint[] cpa = (ColoredPoint[]) pa;
		logger.debug(cpa[0]);

		int[] shortvec = new int[2];
		Object o = shortvec;

		// The following line will throw a ClassCastException:
		Colorable c = (Colorable) o;
		c.setColor(0);

	}

	public static void reverse(List<?> list) {
		rev(list);
	}

	private static <T> void rev(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(list.size() - i - 1));
		}
	}

	@Override
	public void implementorOne(String[] args) throws Exception {
		byte b = 1;
		int rm = b;
		b = b * 2;

		int m = 100;
		m = m * 100l;
		m = (int) (m * 100f);
	}

	/***
	 * 05_prim_conversions-exp_conv_01_primitive_cast
	 */
	@Override
	public void implementorTwo(String[] args) throws Exception {
		logger.debug("");
		logger.debug((byte) (byte) 100);
		logger.debug(" ");
		logger.debug((byte) (short) 1000);
		logger.debug(" ");
		logger.debug((byte) (int) 1000000);
		logger.debug(" ");
		logger.debug((byte) (long) 9000000000L);
		logger.debug(" ");
		logger.debug((byte) (char) 50000);
		logger.debug("");
		logger.debug((short) (byte) 100);
		logger.debug(" ");
		logger.debug((short) (short) 1000);
		logger.debug(" ");
		logger.debug((short) (int) 1000000);
		logger.debug(" ");
		logger.debug((short) (long) 9000000000L);
		logger.debug(" ");
		logger.debug((short) (char) 50000);
		logger.debug("");
		logger.debug((int) (byte) 100);
		logger.debug(" ");
		logger.debug((int) (short) 1000);
		logger.debug(" ");
		logger.debug((int) (int) 1000000);
		logger.debug(" ");
		logger.debug((int) (long) 9000000000L);
		logger.debug(" ");
		logger.debug((int) (char) 50000);
		logger.debug("");
		logger.debug((long) (byte) 100);
		logger.debug(" ");
		logger.debug((long) (short) 1000);
		logger.debug(" ");
		logger.debug((long) (int) 1000000);
		logger.debug(" ");
		logger.debug((long) (long) 9000000000L);
		logger.debug(" ");
		logger.debug((long) (char) 50000);
		logger.debug("");
		logger.debug((int) (char) (byte) 100);
		logger.debug(" ");
		logger.debug((int) (char) (short) 1000);
		logger.debug(" ");
		logger.debug((int) (char) (int) 1000000);
		logger.debug(" ");
		logger.debug((int) (char) (long) 9000000000L);
		logger.debug(" ");
		logger.debug((int) (char) (char) 50000);
		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-exp_conv_02_primitive_var_init_cast
	 */
	@Override
	public void implementorThree(String[] args) throws Exception {
		byte bt = (byte) 100;
		short sh = (short) 1000;
		int i = (int) 1000000;
		long l = (long) 9000000000L;
		char ch = (char) 50000;
		logger.debug("");
		logger.debug(bt);
		logger.debug(" ");
		logger.debug(sh);
		logger.debug(" ");
		logger.debug(i);
		logger.debug(" ");
		logger.debug(l);
		logger.debug(" ");
		logger.debug((int) ch);
		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_03_primitive_var_init
	 */
	@Override
	public void implementorFour(String[] args) throws Exception {
		byte bt = 100;
		short sh = 1000;
		int i = 1000000;
		long l = 9000000000L;
		char ch1 = 50000;
		char ch2 = 'z';
		char ch3 = 100;
		logger.debug("");
		logger.debug(bt);
		logger.debug(" ");
		logger.debug(sh);
		logger.debug(" ");
		logger.debug(i);
		logger.debug(" ");
		logger.debug(l);
		logger.debug(" ");
		logger.debug((int) ch1);
		logger.debug(" ");
		logger.debug(ch2);
		logger.debug(" ");
		logger.debug(ch3);
		logger.debug("Done!");

	}

	class Impl {
		Impl() {
			byte sb;
			short ss;
			int si;
			long sl;
			char sc;
			sb = (byte) 100;
			ss = (short) -1100;
			si = (int) 1100200;
			sl = (long) 9876543210L;
			sc = (char) 'z';

			// byte to others
			logger.debug("");
			logger.debug(fb(sb));
			logger.debug(" ");
			logger.debug(fs(sb));
			logger.debug(" ");
			logger.debug(fi(sb));
			logger.debug(" ");
			logger.debug(fl(sb));

			// short to others
			logger.debug("");
			logger.debug(fs(ss));
			logger.debug(" ");
			logger.debug(fi(ss));
			logger.debug(" ");
			logger.debug(fl(ss));

			// int to others
			logger.debug("");
			logger.debug(fi(si));
			logger.debug(" ");
			logger.debug(fl(si));

			// long to others
			logger.debug("");
			logger.debug(fl(sl));

			// char to others
			logger.debug("");
			logger.debug(fi(sc));
			logger.debug(" ");
			logger.debug(fl(sc));
			logger.debug(" ");
			logger.debug(fc(sc));

			logger.debug("Done!");
		}

		byte fb(byte param) {
			return param;
		}

		short fs(short param) {
			return param;
		}

		int fi(int param) {
			return param;
		}

		long fl(long param) {
			return param;
		}

		int fc(char param) {
			return (int) param;
		}
	}

	/***
	 * 05_prim_conversions-imp_conv_04_mcall_widening
	 */
	@Override
	public void implementorFive(String[] args) throws Exception {
		new Impl();

	}

	/***
	 * 05_prim_conversions-imp_conv_05_unary_num_prom
	 */
	@Override
	public void implementorSix(String[] args) throws Exception {
		logger.debug("");
		logger.debug((+(short) 1000));
		logger.debug(" ");
		logger.debug((-(short) (-32768)));
		logger.debug(" ");
		logger.debug(((short) (-32768)));
		logger.debug("");
		logger.debug(((short) 10000 >> (short) 2));
		logger.debug(" ");
		logger.debug(((short) 10000 << (short) 2));
		logger.debug(" ");
		logger.debug(((short) -10000 >>> (short) 2));
		logger.debug("");
		logger.debug((10000L >> (short) 2));
		logger.debug(" ");
		logger.debug((10000L << (short) 24));
		logger.debug(" ");
		logger.debug((-10000L >>> (short) 2));
		logger.debug("");
		logger.debug(((short) 10000 >> 2L));
		logger.debug(" ");
		logger.debug(((short) 10001 << 24L));
		logger.debug(" ");
		logger.debug(((short) -10000 >>> 2L));
		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_06_unary_prom_array
	 */
	@Override
	public void implementorSeven(String[] args) throws Exception {
		byte n = 10;
		byte i = 5;
		int[] v = new int[n];
		v[i] = 200;
		logger.debug(v[i]);
		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_07_bin_prom_to_int_all_op
	 */
	@Override
	public void implementorEight(String[] args) throws Exception {
		logger.debug(((short) 1000) * (short) 1000);
		logger.debug(((short) 1000) / (short) 1);
		logger.debug(((short) 1000) % (short) 1000);
		logger.debug(((short) 30000) + (short) 30000);
		logger.debug(((short) -30000) - (short) -30000);
		logger.debug(((short) 1000) < (short) 1000);
		logger.debug(((short) 1000) <= (short) 1000);
		logger.debug(((short) 1000) > (short) 1000);
		logger.debug(((short) 1000) >= (short) 1000);
		logger.debug(((short) 1000) == (short) 1000);
		logger.debug(((short) 1000) != (short) 1000);
		logger.debug(((short) -32768) & (short) -16384);
		logger.debug(((short) -32768) ^ (short) -16384);
		logger.debug(((short) 1000) | (short) 1000);
		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_08_bin_prom_selections/
	 */
	@Override
	public void implementorNine(String[] args) throws Exception {
		logger.debug(((byte) 127) * ((byte) 127));
		logger.debug(((short) 1000) * ((short) 1000));
		logger.debug(((char) 50000) * ((char) 50000));
		logger.debug(((byte) 127) * ((short) 1000));
		logger.debug(((short) 1000) * ((byte) 127));
		logger.debug(((short) 1000) * 1234567);
		logger.debug(1234567 * ((short) 1000));
		logger.debug(((short) 1000) * 123456789L);
		logger.debug(123456789L * ((short) 1000));
		logger.debug(1000 * 123456789L);
		logger.debug(1000 * 123456789L);
		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_09_bin_prom_cond_op
	 */
	@Override
	public void implementorTen(String[] args) throws Exception {
		/*
		 * Binary promotion: ?: operator: case 1: byte+byte->byte
		 * short_short->short int_int->int long_long->long char_char->char case
		 * 2: byte_short->short byte_int->int byte_long->long char_short->int
		 * short_byte->short case 3: byte_byteconst->byte
		 * short_shortconst->short int_intconst->int long_longconst->long
		 * char_charconst->char byteconst_byte->byte
		 */

		byte b = 100;
		short s = 1000;
		int i = 1000000;
		long l = 9876543210L;

		// case 1
		char c = 'v';
		byte br = true ? b : b;
		short sr = true ? s : s;
		int ir = true ? i : i;
		long lr = true ? l : l;
		char cr = true ? c : c;
		logger.debug("");
		logger.debug(br);
		logger.debug(" ");
		logger.debug(sr);
		logger.debug(" ");
		logger.debug(ir);
		logger.debug(" ");
		logger.debug(lr);
		logger.debug(" ");
		logger.debug(cr);

		// case 2
		sr = false ? b : s;
		ir = false ? b : i;
		lr = false ? b : l;
		int ir2 = false ? c : s;
		short sr2 = false ? s : b;
		logger.debug("");
		logger.debug(sr);
		logger.debug(" ");
		logger.debug(ir);
		logger.debug(" ");
		logger.debug(lr);
		logger.debug(" ");
		logger.debug(ir2);
		logger.debug(" ");
		logger.debug(sr2);

		// case 3
		br = true ? b : 101;
		sr = true ? s : 101;
		ir = true ? i : 101;
		lr = true ? l : 101;
		cr = true ? c : 101;
		byte br2 = true ? 101 : b;
		logger.debug("");
		logger.debug(br);
		logger.debug(" ");
		logger.debug(sr);
		logger.debug(" ");
		logger.debug(ir);
		logger.debug(" ");
		logger.debug(lr);
		logger.debug(" ");
		logger.debug(cr);
		logger.debug(" ");
		logger.debug(br2);

		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_10_short_inc_dec/
	 */
	@Override
	public void implementorEleven(String[] args) throws Exception {
		short s1 = 0, s2 = 0, s3 = 0, s4 = 0;
		byte b = 0;
		char c = 0;
		++s1;
		--s2;
		s3++;
		s4--;
		b--;
		c++;
		logger.debug("");
		logger.debug(s1);
		logger.debug(" ");
		logger.debug(s2);
		logger.debug(" ");
		logger.debug(s3);
		logger.debug(" ");
		logger.debug(s4);
		logger.debug(" ");
		logger.debug(b);
		logger.debug(" ");
		logger.debug((int) c);

		s1 = 32767;
		s2 = -32768;
		s3 = 32767;
		s4 = -32768;
		b = -128;
		c = 0;
		++s1;
		--s2;
		s3++;
		s4--;
		b--;
		c--;
		logger.debug("");
		logger.debug(s1);
		logger.debug(" ");
		logger.debug(s2);
		logger.debug(" ");
		logger.debug(s3);
		logger.debug(" ");
		logger.debug(s4);
		logger.debug(" ");
		logger.debug(b);
		logger.debug(" ");
		logger.debug((int) c);

		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_11_compound_assign
	 */
	@Override
	public void implementorTwelve(String[] args) throws Exception {
		short s = 32767;
		logger.debug((s += 32767));
		s = 32767;
		logger.debug(s -= 1000000);
		s = 32767;
		logger.debug(s *= 200);
		s = 32767;
		logger.debug(s /= 4);
		s = -32768;
		logger.debug(s &= 32768);
		s = 32767;
		logger.debug(s |= 100000);
		s = 32767;
		logger.debug(s ^= 65537);
		s = 32767;
		logger.debug(s %= 1);
		s = 32767;
		logger.debug(s <<= 2);
		s = 32767;
		logger.debug(s >>= 2);
		s = 32767;
		logger.debug(s >>>= 2);

		logger.debug("Done!");

	}

	/***
	 * 05_prim_conversions-imp_conv_12_compound_assign_se
	 */
	@Override
	public void implementorThirteen(String[] args) throws Exception {
		byte b = 127;
		logger.debug((b += 100));
		short s = 30000;
		logger.debug((s += 10000));
		int i = 2000000000;
		logger.debug((i += 2000000000));
		long l = 2000000000;
		logger.debug((l += 2000000000));
		char c = 50000;
		logger.debug((int) (c += 50000));

		logger.debug("Done!");

	}

	@Override
	public void implementorFourteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorFifteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorSixteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorSeventeen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorEighteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorNineteen(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void implementorTwenty(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

	// interface Colorable {
	//
	// void setColor(int color);
	// }
	//
	// class Point {
	//
	// int x, y;
	// }
	//
	// class ColoredPoint extends Point implements Colorable {
	//
	// int color;
	//
	// public void setColor(int color) {
	// this.color = color;
	// }
	// }
}
