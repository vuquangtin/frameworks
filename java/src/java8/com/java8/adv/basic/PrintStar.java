package com.java8.adv.basic;

import java.util.Scanner;

import com.java.frameworks.base.ExtendTemplateMethod;
import com.java.frameworks.base.ITemplateMethod;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class PrintStar extends ExtendTemplateMethod implements ITemplateMethod {

	public static void main(String[] args) {
		new PrintStar().runTemplateMethod(args);

	}

	public static void pyramidPattern(int n) {
		for (int i = 0; i < n; i++)
		// outer loop for number of rows(n)
		{
			for (int j = n - i; j > 1; j--) // inner
			// loop for spaces
			{
				System.out.print(" "); // print space
			}
			for (int j = 0; j <= i; j++) // inner loop for number of columns
			{
				System.out.print("* "); // print star
			}

			System.out.println(); // ending line after each row

		}
	}

	@Override
	public void implementionEleven(String[] args) throws Exception {
		int n = 5;
		pyramidPattern(n);

	}

	@Override
	public void implementionTwelve(String[] args) throws Exception {
		int n = 5;
		rightTriangle(n);

	}

	public static void rightTriangle(int n) {
		int i, j;
		for (i = 0; i < n; i++) // outer loop for number of rows(n)
		{
			// for (j = 2 * (n - i); j >= 0; j--) // inner loop for spaces
			{
				System.out.print(" "); // printing space
			}
			for (j = 0; j <= i; j++) // inner loop for columns
			{
				System.out.print("* "); // print star
			}
			System.out.println(); // ending line after each row
		}
	}

	public static void printStars(int n) {
		int i, j;
		for (i = 0; i < n; i++) // outer loop for number of rows(n)
		{
			for (j = 2 * (n - i); j >= 0; j--) // inner loop for spaces
			{
				System.out.print(" "); // printing space
			}
			for (j = 0; j <= i; j++) // inner loop for columns
			{
				System.out.print("* "); // print star
			}
			System.out.println(); // ending line after each row
		}
	}

	@Override
	public void implementionThirteen(String[] args) throws Exception {
		int n = 5;
		printStars(n);

	}

	@Override
	public void implementionFourteen(String[] args) throws Exception {
		int n, i, j, space = 1;

		System.out.print("Enter the number of rows: ");

		// Scanner s = new Scanner(System.in);
		// n = s.nextInt();
		System.out.println("");
		n = 5;
		space = n - 1;
		for (j = 1; j <= n; j++) {
			for (i = 1; i <= space; i++) {
				System.out.print(" ");
			}
			space--;
			for (i = 1; i <= 2 * j - 1; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		space = 1;
		for (j = 1; j <= n - 1; j++) {
			for (i = 1; i <= space; i++) {
				System.out.print(" ");
			}
			space++;
			for (i = 1; i <= 2 * (n - j) - 1; i++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

	@Override
	public void implementionFifteen(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows: "); // takes input from
															// user

		int rows = 5;// sc.nextInt();

		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
		// sc.close();
		// }

	}

	@Override
	public void implementionSixteen(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of rows: "); // takes input from user

		int rows = 5;// sc.nextInt();

		for (int i = 0; i <= rows; i++) {
			for (int j = 1; j <= rows - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// sc.close();

	}

	@Override
	public void implementionSeventeen(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");

		int rows = 5;// sc.nextInt();
		for (int i = 0; i <= rows - 1; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k <= rows - 1 - i; k++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}
		// sc.close();

	}

	@Override
	public void implementionEighteen(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in); // takes input
		System.out.println("Enter number of rows: ");
		int rows = 5;// sc.nextInt();
		for (int i = rows; i >= 1; i--) {
			for (int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// sc.close();
		// }

	}

	@Override
	public void implementionNineteen(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");

		int rows = 5;// sc.nextInt();
		for (int i = 0; i <= rows - 1; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println("");
		}
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				System.out.print("*" + " ");
			}
			System.out.println("");
		}
		// sc.close();

	}

	@Override
	public void implementionTwenty(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");

		int rows = 5;// sc.nextInt();
		for (int i = 1; i <= rows; i++) {
			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = rows; i >= 1; i--) {
			for (int j = i; j <= rows; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k < i; k++) {
				System.out.print("*");
			}
			System.out.println("");

		}
		// sc.close();

	}

	@Override
	public void implementionOne(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");

		int rows = 5;// sc.nextInt();
		for (int i = 0; i <= rows - 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k <= rows - 1; k++) {
				System.out.print("*" + " ");
			}
			System.out.println("");
		}
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k <= rows - 1; k++) {
				System.out.print("*" + " ");
			}
			System.out.println("");
		}
		// sc.close();
	}

	// Java program to print alphabet A pattern
	static void display(int n) {
		// Outer for loop for number of lines
		for (int i = 0; i <= n; i++) {
			// Inner for loop for logic execution
			for (int j = 0; j <= n / 2; j++) {
				// prints two column lines
				if ((j == 0 || j == n / 2) && i != 0 ||
				// print first line of alphabet
						i == 0 && j != n / 2 ||
						// prints middle line
						i == n / 2)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

	@Override
	public void implementionTwo(String[] args) throws Exception {
		display(7);

	}

	@Override
	public void implementionThree(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");

		int rows = 7;// sc.nextInt();

		for (int i = 1; i <= rows; i++) {
			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				if (k == 1 || i == rows || k == (2 * i - 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		// sc.close();

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");

		int rows = 7;// sc.nextInt();
		for (int i = rows; i >= 1; i--) {
			for (int j = i; j < rows; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				if (k == 1 || i == rows || k == (2 * i - 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		// sc.close();

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");

		int rows = 7;// sc.nextInt();
		for (int i = 1; i <= rows; i++) {
			for (int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int k = 1; k < 2 * (i - 1); k++) {
				System.out.print(" ");
			}
			if (i == 1) {
				System.out.println("");
			} else {
				System.out.println("*");
			}
		}
		for (int i = rows - 1; i >= 1; i--) {
			for (int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int k = 1; k < 2 * (i - 1); k++) {
				System.out.print(" ");
			}
			if (i == 1)
				System.out.println("");
			else
				System.out.println("*");
		}
		// sc.close();

	}

	public static void printNums(int n) {
		int i, j, num;

		for (i = 0; i < n; i++) // outer loop for rows
		{
			num = 1;
			for (j = 0; j <= i; j++) // inner loop for rows
			{
				// printing num with a space
				System.out.print(num + " ");

				// incrementing value of num
				num++;
			}

			// ending line after each row
			System.out.println();
		}
	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		int n = 5;
		printNums(n);

	}

	@Override
	public void implementionSeven(String[] args) throws Exception {
		int i, j, k = 1;
		for (i = 1; i <= 5; i++) {
			for (j = 1; j < i + 1; j++) {
				System.out.print(k++ + " ");
			}

			System.out.println();
		}

	}

	@Override
	public void implementionEight(String[] args) throws Exception {
		int n = 5;

		for (int i = 0; i < n; i++) {
			int number = 1;
			System.out.printf("%" + (n - i) * 2 + "s", "");
			for (int j = 0; j <= i; j++) {
				System.out.printf("%4d", number);
				number = number * (i - j) / (j + 1);
			}
			System.out.println();
		}

	}

	@Override
	public void implementionNine(String[] args) throws Exception {
		for (int i = 1; i <= 4; i++) {
			int n = 4;

			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k >= 1; k--) {
				System.out.print(k);
			}
			for (int l = 2; l <= i; l++) {
				System.out.print(l);
			}
			System.out.println();
		}
		for (int i = 3; i >= 1; i--) {
			int n = 3;

			for (int j = 0; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k >= 1; k--) {
				System.out.print(k);
			}
			for (int l = 2; l <= i; l++) {
				System.out.print(l);
			}

			System.out.println();
		}

	}

	@Override
	public void implementionTen(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in); // Taking rows value from the
		// user
		System.out.println("Enter the number of rows: ");
		int rows = 7;// sc.nextInt();
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}

			System.out.println();
		}
		// sc.close();

	}

	@Override
	public void implementorOne(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");

		int rows = 7;// sc.nextInt();

		for (int i = 1; i <= rows; i++) {
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
		// sc.close();

	}

	@Override
	public void implementorTwo(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		// Taking rows value from the user

		System.out.println("Enter the number of rows: ");

		int rows = 7;// sc.nextInt();
		for (int i = rows; i >= 1; i--) {
			for (int j = rows; j >= i; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
		// sc.close();

	}

	@Override
	public void implementorThree(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");

		int rows = 7;// sc.nextInt();

		for (int i = 1; i <= rows; i++) {
			int num;

			if (i % 2 == 0) {
				num = 0;

				for (int j = 1; j <= rows; j++) {
					System.out.print(num);

					num = (num == 0) ? 1 : 0;
				}
			} else {
				num = 1;

				for (int j = 1; j <= rows; j++) {
					System.out.print(num);

					num = (num == 0) ? 1 : 0;
				}
			}

			System.out.println();
		}

		// sc.close();

	}

	@Override
	public void implementorFour(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of rows: ");

		int rows = 8;// sc.nextInt();
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				if (j % 2 == 0) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
			}

			System.out.println();
		}

		// sc.close();

	}

	@Override
	public void implementorFive(String[] args) throws Exception {
		int n = 5;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			for (int k = i; k <= n; k++) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
		for (int i = n - 1; i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = i; k <= n; k++) {
				System.out.print(k + " ");
			}

			System.out.println();
		}
	}

	@Override
	public void implementorSix(String[] args) throws Exception {
		int alphabet = 65;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((char) (alphabet + j) + " ");
			}
			System.out.println();
		}

	}

	@Override
	public void implementorSeven(String[] args) throws Exception {
		int alphabet = 65;
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((char) alphabet + " ");
			}
			alphabet++;
			System.out.println();
		}

	}

	@Override
	public void implementorEight(String[] args) throws Exception {
		for (int i = 5; i >= 0; i--) {
			int alphabet = 65;
			for (int j = 0; j <= i; j++) {
				System.out.print((char) (alphabet + j) + " ");
			}
			System.out.println();
		}
		for (int i = 0; i <= 5; i++) {
			int alphabet = 65;
			for (int j = 0; j <= i; j++) {
				System.out.print((char) (alphabet + j) + " ");
			}
			System.out.println();
		}

	}

	@Override
	public void implementorNine(String[] args) throws Exception {
		for (int i = 0; i <= 5; i++) {
			int alphabet = 65;
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print((char) (alphabet + k) + " ");
			}
			System.out.println();
		}

	}

	@Override
	public void implementorTen(String[] args) throws Exception {
		char[] letter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		int letter_number = 0;
		String[] diamond = new String[26]; // array of strings
		System.out.print("Enter a Character between A to Z : ");

		Scanner reader = new Scanner(System.in);
		try {
			char user_letter = reader.next("[A-Z]").charAt(0);
			// search for letter number in the array letter
			for (int i = 0; i < letter.length; i++) {
				if (letter[i] == user_letter) {
					letter_number = i;
					break;
				}
			}

			// construct diamond
			for (int i = 0; i <= letter_number; i++) {
				diamond[i] = "";
				// add initial spaces
				for (int j = 0; j < letter_number - i; j++) {
					diamond[i] += " ";
				}

				// add letter
				diamond[i] += letter[i];

				// add space between letters
				if (letter[i] != 'A') {
					for (int j = 0; j < 2 * i - 1; j++) {
						diamond[i] += " ";
					} // add letter
					diamond[i] += letter[i];
				} // Draw the first part of the diamond
				System.out.println(diamond[i]);
			}
			for (int i = letter_number - 1; i >= 0; i--) {
				// Draw the second part of the diamond
				// Writing the diamondArray in reverse order
				System.out.println(diamond[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}

	}

}
