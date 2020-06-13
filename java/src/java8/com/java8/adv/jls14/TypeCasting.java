package com.java8.adv.jls14;

import com.java.frameworks.base.TemplateMethod;

/**
 * 
 * <h1>Ép kiểu trong Java là gì? (Type casting)</h1>
 * 
 * Ép kiểu là việc gán giá trị của một biến có kiểu dữ liệu này sang biến khác
 * có kiểu dữ liệu khác.
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class TypeCasting extends TemplateMethod {
	/***
	 * @see https://kynangso.net/courses/bai-3-ep-kieu-du-lieu-trong-java.html
	 * @param args
	 */
	public static void main(String[] args) {
		new TypeCasting().runTemplateMethod(args);

	}

	/***
	 * 
	 <h1>Ép kiểu Nới rộng (Widening)</h1>
	 * 
	 * 
	 * Ép kiểu Nới rộng (Widening) Là quá trình làm tròn số từ kiểu dữ liệu có
	 * kích thước nhỏ hơn sang kiểu có kích thước lớn hơn. Kiểu biến đổi này
	 * không làm mất thông tin. Ví dụ chuyển từ int sang float. Chuyển kiểu loại
	 * này có thế được thực hiện ngầm định bởi trình biên dịch.
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		int myInt = 9;
		double myDouble = myInt; // Automatic casting: int to double

		System.out.println(myInt);
		System.out.println(myDouble);
	}

	/***
	 * 
	 * <h1>Ép kiểu Thu hẹp (Narrowwing)</h1>
	 * 
	 * 
	 * Ép kiểu Thu hẹp (Narrowwing) Là quá trình làm tròn số từ kiểu dữ liệu có
	 * kích thước lớn hơn sang kiểu có kích thước nhỏ hơn. Kiểu biến đổi này có
	 * thể làm mất thông tin như ví dụ ở trên. Chuyển kiểu loại này không thể
	 * thực hiện ngầm định bởi trình biên dịch, người dùng phải thực hiện chuyển
	 * kiểu tường minh.
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		double myDouble = 9.78;
		int myInt = (int) myDouble; // Explicit casting: double to int

		System.out.println(myDouble);
		System.out.println(myInt);

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
