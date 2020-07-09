package com.java8.adv.jls14;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
public class Chapter10 extends TemplateMethod {
	public static void main(String[] args) {
		new Chapter10().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		int[] ia = new int[101];
		for (int i = 0; i < ia.length; i++)
			ia[i] = i;
		int sum = 0;
		for (int e : ia)
			sum += e;
		System.out.println(sum);
		// short , byte , or char values may also be
		// used as index values
		byte s = 5;
		int index = 5;
		System.out.println(ia[s]);
	}

	class Point {
		int x, y;
	}

	class ColoredPoint extends Point {
		int color;
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		ColoredPoint[] cpa = new ColoredPoint[10];
		Point[] pa = cpa;
		System.out.println(pa[1] == null);
		try {
			// cpa[0] = new Point();
			pa[0] = new Point();
			pa[0] = new ColoredPoint();
		} catch (ArrayStoreException e) {
			System.out.println(e);
		}
		// ColoredPoint cp=new Point();
		Point p = new ColoredPoint();
	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		int ia[][] = { { 1, 2 }, null };
		for (int[] ea : ia) {
			for (int e : ea) {
				System.out.println(e);
			}
		}

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		List<? extends Number> list = Arrays.asList(182, 834939f, 21423.545d);
		list.forEach((item) -> {
			logger.debug(item);
		});
	}

	class A<T> implements Cloneable, java.io.Serializable {
		public final int length = 10;

		public T[] clone() {
			try {
				return (T[]) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new InternalError(e.getMessage());
			}
		}
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		int ia1[] = { 1, 2 };
		int ia2[] = ia1.clone();
		System.out.print((ia1 == ia2) + " ");
		ia1[1]++;
		System.out.println(ia2[1]);

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		int ia[][] = { { 1, 2 }, null };
		int ja[][] = ia.clone();
		System.out.print((ia == ja) + " ");
		System.out.println(ia[0] == ja[0] && ia[1] == ja[1]);

	}

	/***
	 * Although an array type is not a class, the Class object of every array
	 * acts as if:
	 * 
	 * 
	 * • The direct superclass of every array type is Object .
	 * 
	 * • Every array type implements the interfaces Cloneable and
	 * java.io.Serializable .
	 */
	@Override
	public void implementionSeven(String[] args) throws Exception {
		int[] ia = new int[3];
		System.out.println(ia.getClass());
		System.out.println(ia.getClass().getSuperclass());
		for (Class<?> c : ia.getClass().getInterfaces())
			System.out.println("Superinterface: " + c);

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		int[] ia = new int[3];
		int[] ib = new int[6];
		System.out.println(ia == ib);
		System.out.println((ia.getClass() == ib.getClass()) + ":"
				+ ib.getClass());

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		String s = "public void implementionNine(String[] args) throws Exception {";

		for (char strTemp : s.toCharArray()) {

			System.out.println(strTemp);

		}

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		try {
			throw new FileNotFoundException();
		} catch (IOException ioe) {
			// "catch IOException" catches IOException
			// and any subtype.
			ioe.printStackTrace();
		}
		try {
			throw new FileNotFoundException();
			// Statement "can throw" FileNotFoundException.
			// It is not the case that statement "can throw"
			// a subtype or supertype of FileNotFoundException.
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			// ... Handle exception ...
		} catch (IOException ioe) {
			// Legal, but compilers are encouraged to give
			// warnings as of Java SE 7, because all subtypes of
			// IOException that the try block "can throw" have
			// already been caught by the prior catch clause.
		}
		try {
			m();
			// m's declaration says "throws IOException", so
			// m "can throw" IOException. It is not the case
			// that m "can throw" a subtype or supertype of
			// IOException (e.g. Exception).
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			// Legal, because the dynamic type of the exception
			// might be FileNotFoundException.
		} catch (IOException ioe) {
			// Legal, because the dynamic type of the exception
			// might be a different subtype of IOException.
		} catch (Throwable t) {
			// Can always catch Throwable.
		}

	}

	static void m() throws IOException {
		throw new FileNotFoundException();
	}

}
