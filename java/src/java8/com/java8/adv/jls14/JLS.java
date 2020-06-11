package com.java8.adv.jls14;

import com.java.frameworks.base.TemplateMethod;

/**
 * <h1>In Short :</h1>
 * 
 * 
 * <ul>
 * <li>Carriage_return(\r or 0xD): To take control at starting of same line.</li>
 * <li>
 * Line_Feed(\n or 0xA): To Take control at starting of next line.</li>
 * <li>
 * form_feed(\f or 0xC): To take control at starting of next page.</li>
 * <ul>
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class JLS extends TemplateMethod {

	public static void main(String[] args) {
		new JLS().runTemplateMethod(args);
	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// WhiteSpace
		System.out.println("This is before\fNow new line");
		System.out.println("TEXTBEFORE\rOverlap");
		System.out.println("12\b3");
		for (int i = 0; i < 3; i++) {
			System.out.print("Progress: " + i + " %\r");
			Thread.sleep(100);
		}

	}

	/***
	 * Identifiers
	 */
	@Override
	public void implementionTwo(String[] args) throws Exception {
		/* this comment /* // /** ends here: */
		// A "Java letter" is a character for which the method
		// Character.isJavaIdentifierStart(int) returns true.
		logger.debug(Character.isJavaIdentifierStart(100));
		// A "Java letter-or-digit" is a character for which the method
		// Character.isJavaIdentifierPart(int) returns true.
		logger.debug(Character.isJavaIdentifierPart(900));

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
