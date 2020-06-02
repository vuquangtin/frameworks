package com.java8.adv.abs;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 * 
 *      vuquangtin/frameworks</a>
 *
 */
public abstract class ExtendTemplateMethod extends TemplateMethod {
	@Override
	public void runTemplateMethod(String[] args) {

		super.runTemplateMethod(args);
		printDot("implementionEleven");
		try {
			implementionEleven(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionTwelve");
		try {
			implementionTwelve(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionThirteen");
		try {
			implementionThirteen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionFourteen");
		try {
			implementionFourteen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionFifteen");
		try {
			implementionFifteen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionSixteen");
		try {
			implementionSixteen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionSeventeen");
		try {
			implementionSeventeen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionEighteen");
		try {
			implementionEighteen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionNineteen");
		try {
			implementionNineteen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionTwenty");
		try {
			implementionTwenty(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public abstract void implementionEleven(String[] args) throws Exception;

	public abstract void implementionTwelve(String[] args) throws Exception;

	public abstract void implementionThirteen(String[] args) throws Exception;

	public abstract void implementionFourteen(String[] args) throws Exception;

	public abstract void implementionFifteen(String[] args) throws Exception;

	public abstract void implementionSixteen(String[] args) throws Exception;

	public abstract void implementionSeventeen(String[] args) throws Exception;

	public abstract void implementionEighteen(String[] args) throws Exception;

	public abstract void implementionNineteen(String[] args) throws Exception;

	public abstract void implementionTwenty(String[] args) throws Exception;

}
