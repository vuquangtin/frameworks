package com.java8.adv.basic;

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
public class NestedLoop extends TemplateMethod {
	public static void main(String[] args) {
		new NestedLoop().runTemplateMethod(args);
	}

	/***
	 * Like other answerers, I'd definitely prefer to put the loops in a
	 * different method, at which point you can just return to stop iterating
	 * completely. This answer just shows how the requirements in the question
	 * can be met.
	 * 
	 * You can use break with a label for the outer loop. For example:
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		OUTER_LOOP: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i * j > 6) {
					System.out.println("Breaking");
					break OUTER_LOOP;
				}
				System.out.println(i + " " + j);
			}
		}
		System.out.println("Done");

	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		boolean earlyExit = false;
		for (int i = 0; i < 10 && !earlyExit; i++) {
			for (int j = 0; i < 10 && !earlyExit; j++) {
				earlyExit = true;
			}
		}

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		boolean condition1 = false, condition2 = false;
		int index = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					if (condition1) {
						System.out.println("Breaking from Loop K and J");
						k = 9;
						j = 9;
					}
					if (condition2) {
						System.out.println("Breaking from Loop K, J and I");
						k = 9;
						j = 9;
						i = 9;
					}
					index++;
					if (index == 20)
						condition1 = true;
				}
			}
		}
		System.out.println("End of I , J , K");

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		loop3: for (int i = 0; i < 6; i++) {
			loop2: for (int k = 0; k < 6; k++) {
				loop1: for (int j = 0; j < 5; j++) {
					if (i == 3)
						break loop3;
				}
			}
		}

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		outerloop: for (int i = 0; i < 10; i++) {
			// here we can break Outer loop by
			if (i == 10)
				break outerloop;

			innerloop: for (int j = 0; j < 10; j++) {
				// here we can break innerloop by
				if (j == 10)
					break innerloop;
			}
		}

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		INNER: for (int j = 0; j < args.length; j++) {
			System.out.println("Even number: " + j
					+ ", break  from INNER label");
			break INNER;
		}
	}

	private static class BreakLoopException extends Exception {
		private static final long serialVersionUID = 1L;

		@Override
		public StackTraceElement[] getStackTrace() {
			return new StackTraceElement[0];
		}
	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		try {
			int index = 0;
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					if (index > 50) {
						// Do something and break the loop.
						throw new BreakLoopException();
					}
					index++;
				}
			}
		} catch (BreakLoopException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		boolean exitloops = false;
		for (int i = 0; i < 5 && !exitloops; i++) {
			// here should exitloops as a Conditional Statement to get out from
			// the loops if exitloops become true.
			for (int j = 0; j < 5 && !exitloops; j++) {
				// here should also use exitloops as a Conditional Statement.
				if (i * j > 6) {
					exitloops = true;
					System.out
							.println("Inner loop still Continues For i * j is => "
									+ i * j);
					break;
				}
				System.out.println(i * j);
			}
		}
	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		outerloop: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i * j > 6) {
					System.out.println("Breaking");
					break outerloop;
				}
				System.out.println(i + " " + j);
			}
		}
		System.out.println("Done");

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		boolean condition1 = false, condition2 = false;
		int index = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					if (condition1) {
						return;
					}
					if (condition2) {
						return;
					}
					index++;
					if (index == 20)
						condition1 = true;
				}
			}
		}
		System.out.println("End of I , J , K");

	}
}
