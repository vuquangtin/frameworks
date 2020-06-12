package com.java8.generics;
import com.java.frameworks.base.TemplateMethod;

/**
 * <h1>Autoboxing và unboxing</h1>
 * 
 * Việc chuyển đổi tự động các kiểu dữ liệu nguyên thủy thành kiểu Wrapper tương
 * đương của nó được gọi là hoạt động autoboxing (hay boxing) và ngược lại được
 * gọi là unboxing. Đây là tính năng mới của Java 5. Vì vậy, lập trình java
 * không cần phải viết mã chuyển đổi.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class AutoboxingAndUnboxing extends TemplateMethod {

	public static void main(String[] args) {
		new AutoboxingAndUnboxing().runTemplateMethod(args);

	}

	/***
	 * Ví dụ đơn giản về Autoboxing trong java
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		int a = 50;
		Integer a2 = new Integer(a);// Boxing
		Integer a3 = 5; // Boxing
		System.out.println(a2 + " " + a3);

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		Integer i = new Integer(50);
		int a = i; // unboxing
		System.out.println(a);

	}

	/***
	 * Autoboxing và Unboxing với toán tử so sánh
	 * 
	 * Unboxing có thể được thực hiện với các toán tử so sánh. Chúng ta hãy xem
	 * ví dụ về boxing với toán tử so sánh:
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		Integer i = new Integer(50);
		if (i < 100) { // unboxing
			System.out.println(i);
		}

	}

	static void m(int i) {
		System.out.println("int");
	}

	static void m(Integer i) {
		System.out.println("Integer");
	}

	/***
	 * Autoboxing và Unboxing với nạp chồng phương thức
	 * 
	 * Ví dụ 1: widening (ép kiểu thu hẹp) và boxing, widening thắng boxing.
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		short s = 30;
		m(s);

	}

	/***
	 * widening và varargs, widening thắng varargs.
	 */
	static void m(int... i) {
		System.out.println("int int");
	}

	static void m(Integer i1, Integer i2) {
		System.out.println("Integer...");
	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		short s1 = 30;
		short s2 = 40;
		m(s1, s2);

	}

	/***
	 * boxing thắng varargs
	 */
	static void m1(Integer i) {
		System.out.println("Integer");
	}

	static void m1(Integer... i) {
		System.out.println("Integer...");
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		int a = 30;
		m1(a);

	}

	/***
	 * widening và boxing không được thực hiện:
	 */
	static void m5(Integer l) {
		System.out.println("Integer");
	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		short a = 30;
		// Compile Time Error
		// m5(a);

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
