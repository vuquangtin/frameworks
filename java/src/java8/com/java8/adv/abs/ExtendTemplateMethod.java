package com.java8.adv.abs;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public abstract class ExtendTemplateMethod extends TemplateMethod {
	@Override
	public void runTemplateMethod(String[] args) {
		// TODO Auto-generated method stub
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

	public abstract void implementionEleven(String[] args);

	public abstract void implementionTwelve(String[] args);

	public abstract void implementionThirteen(String[] args);

	public abstract void implementionFourteen(String[] args);

	public abstract void implementionFifteen(String[] args);

	public abstract void implementionSixteen(String[] args);

	public abstract void implementionSeventeen(String[] args);

	public abstract void implementionEighteen(String[] args);

	public abstract void implementionNineteen(String[] args);

	public abstract void implementionTwenty(String[] args);

}
