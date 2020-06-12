package com.java.frameworks.base;

import java.util.Objects;

import org.apache.log4j.Logger;

import com.java.frameworks.utils.Log4jUtils;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 */
public abstract class TemplateMethod {
	protected static Logger logger = Logger.getLogger(TemplateMethod.class
			.getName());

	protected void runTemplateMethod(String[] args,
			IExtendTemplateMethod iTemplateMethod) {
		runPrivateTemplateMethod(args);
		if (iTemplateMethod != null) {
			try {
				printDot("implementorOne");
				iTemplateMethod.implementorOne(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorTwo(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorThree(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorFour(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorFive(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorSix(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorSeven(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorEight(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorNine(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorTen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}

			try {
				iTemplateMethod.implementorEleven(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorTwelve(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorThirteen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorFourteen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorFifteen(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorSixteen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorSeventeen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorEighteen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorNineteen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorTwenty(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	protected void runTemplateMethod(String[] args,
			ITemplateMethod iTemplateMethod) {
		runPrivateTemplateMethod(args);
		if (iTemplateMethod != null) {
			try {
				printDot("implementorOne");
				iTemplateMethod.implementorOne(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorTwo(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorThree(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorFour(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorFive(args);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorSix(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorSeven(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorEight(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorNine(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				iTemplateMethod.implementorTen(args);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void runTemplateMethod(String[] args) {

		if (this instanceof IExtendTemplateMethod) {
			runTemplateMethod(args, (IExtendTemplateMethod) this);
		} else if (this instanceof ITemplateMethod) {
			runTemplateMethod(args, (ITemplateMethod) this);
		} else {
			runPrivateTemplateMethod(args);
		}

	}

	private void runPrivateTemplateMethod(String[] args) {
		logger = Log4jUtils.initLog4j();
		printDot("implementionOne");
		try {
			implementionOne(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionTwo");
		try {
			implementionTwo(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionThree");
		try {
			implementionThree(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionFour");
		try {
			implementionFour(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionFive");
		try {
			implementionFive(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionSix");
		try {
			implementionSix(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionSeven");
		try {
			implementionSeven(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionEight");
		try {
			implementionEight(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionNine");
		try {
			implementionNine(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		printDot("implementionTen");
		try {
			implementionTen(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void printDot(String methodName) {
		printDot(100, methodName);
	}

	private void printDot(int dot, String methodName) {
		int part = dot / 2;
		for (int i = 0; i < dot; i++) {
			System.out.print("-");
			if (i == part)
				System.out.print(methodName);
		}
		System.out.println();
	}

	protected void println(Object message) {
		System.out.println(Objects.toString(message));
	}

	protected void log(Object message) {
		System.out.println(Objects.toString(message));
	}

	public abstract void implementionOne(String[] args) throws Exception;

	public abstract void implementionTwo(String[] args) throws Exception;

	public abstract void implementionThree(String[] args) throws Exception;

	public abstract void implementionFour(String[] args) throws Exception;

	public abstract void implementionFive(String[] args) throws Exception;

	public abstract void implementionSix(String[] args) throws Exception;

	public abstract void implementionSeven(String[] args) throws Exception;

	public abstract void implementionEight(String[] args) throws Exception;

	public abstract void implementionNine(String[] args) throws Exception;

	public abstract void implementionTen(String[] args) throws Exception;
}
