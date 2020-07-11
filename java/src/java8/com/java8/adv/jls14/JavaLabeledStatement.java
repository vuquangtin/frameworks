package com.java8.adv.jls14;

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
public class JavaLabeledStatement extends TemplateMethod {

	public static void main(String[] args) {
		new JavaLabeledStatement().runTemplateMethod(args);

	}

	/***
	 * <h1>The break Statement, Without a Label</h1>
	 * 
	 * The common usage of break statements is that we generally use them to
	 * terminate a switch statement in execution. It exits from the block to
	 * execute the next statement after the block.
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		String emote = "happy";
		String emoticon = "/-s";
		switch (emote) {
		case "happy":
			emoticon = ":-)";
			break;
		case "sad":
			emoticon = ":-(";
			break;
		case "playful":
			emoticon = ";)";
			break;
		case "angry":
			emoticon = ">:(";
			break;
		case "embarassed":
			emoticon = ":-/";
			break;
		case "shocked":
			emoticon = ":-o";
			break;
		default:
			emoticon = ":-?";
			break;
		}
		System.out.println(emoticon);
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		int i = 0;

		for (i = 9999; i <= 99999; i++) {
			if (i % 397 == 0)
				break;
		}
		System.out.println("First number " + "divisible by 397 between "
				+ "9999 and 99999 is = " + i);

	}

	/***
	 * The break Statement, with a Label
	 * 
	 * Sometimes, it is a requirement of the program logic to exit from the
	 * entire nested control statement with just one statement rather than wait
	 * for it to complete the entire execution. This type of situation is
	 * particularly suitable for a labeled break statement. This statement
	 * enables one to break from the entire labeled block in one go. The program
	 * execution resumes from the first statement encountered after the
	 * enclosing labeled break statement. Let's write a couple of simple
	 * programs, one with labeled break and one with a simple break, and observe
	 * the difference in output.
	 * 
	 * Here is a program with a simple break statement:
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		int counter = 0;
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (i == 5)
					break;
			}
			counter++;
		}
		System.out.println(counter);

	}

	/***
	 * Here is a program with a labeled break statement:
	 */
	@Override
	public void implementionFour(String[] args) throws Exception {
		int counter = 0;
		start: {
			for (int i = 0; i <= 10; i++) {
				for (int j = 0; j <= 10; j++) {
					if (i == 5)
						break start;
				}
				counter++;
			}
		}
		System.out.println(counter);

	}

	/***
	 * The continue Statement, Without a Label
	 * 
	 * The continue statement, when used in association with loops in Java,
	 * skips the remaining statements in the loop body and proceeds to the next
	 * iteration of the loop. This is in contrast to the break statements, where
	 * it escapes from the immediate loop. The continue statement simple resumes
	 * the loop beginning with the next iteration.
	 */
	@Override
	public void implementionFive(String[] args) throws Exception {
		String[] listOfNames = { "Ravi", "Soma", "null", "Colin", "Harry",
				"null", "Smith" };

		for (int i = 0; i < listOfNames.length; i++) {
			if (listOfNames[i].equals("null"))
				continue;
			System.out.println(listOfNames[i]);
		}

	}

	/***
	 * The continue Statement, with a Label
	 * 
	 * The labeled continue statement is similar to the unlabelled continue
	 * statement in the sense that both resume the iteration. The difference
	 * with the labeled continue statement is that it resumes operation from the
	 * target label defined in the code. As soon as the labeled continue is
	 * encountered, it skips the remaining statements from the statement's body
	 * and any number of enclosing loops and jumps to the nest iteration of the
	 * enclosing labeled loop statements. Here is an example to illustrate the
	 * labeled continue statement.
	 */
	@Override
	public void implementionSix(String[] args) throws Exception {
		start: for (int i = 0; i < 5; i++) {
			System.out.println();
			for (int j = 0; j < 10; j++) {
				System.out.print("#");
				if (j >= i)
					continue start;
			}
			System.out.println("This will never" + " be printed");
		}

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
