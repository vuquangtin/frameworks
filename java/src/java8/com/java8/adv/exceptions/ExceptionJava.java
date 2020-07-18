package com.java8.adv.exceptions;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

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
public class ExceptionJava extends TemplateMethod {

	public static void main(String[] args) {
		new ExceptionJava().runTemplateMethod(args);

	}

	/***
	 * The try-with-resources statement
	 * 
	 * In Java, the try-with-resources statement is a try statement that
	 * declares one or more resources. The resource is as an object that must be
	 * closed after finishing the program. The try-with-resources statement
	 * ensures that each resource is closed at the end of the statement
	 * execution.
	 * 
	 * You can pass any object that implements java.lang.AutoCloseable, which
	 * includes all objects which implement java.io.Closeable.
	 * 
	 * The following example writes a string into a file. It uses an instance of
	 * FileOutputStream to write data into the file. FileOutputStream is a
	 * resource that must be closed after the program is finished with it. So,
	 * in this example, closing of resource is done by itself try.
	 */
	@Override
	public void implementionOne(String[] args) throws Exception {
		// Using try-with-resources
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				"/java7-new-features/src/abc.txt")) {
			String msg = "Welcome to javaTpoint!";
			byte byteArray[] = msg.getBytes(); // converting string into byte
												// array
			fileOutputStream.write(byteArray);
			logger.debug("Message written to file successfuly!");
		} catch (Exception exception) {
			logger.debug(exception);
		}

	}

	/***
	 * Try-with-resources Example : Using Multiple Resources
	 */

	@Override
	public void implementionTwo(String[] args) throws Exception {
		// Using try-with-resources
		try ( // Using multiple resources
		FileOutputStream fileOutputStream = new FileOutputStream(
				"/java7-new-features/src/abc.txt");
				InputStream input = new FileInputStream(
						"/java7-new-features/src/abc.txt")) {
			// -----------------------------Code to write data into
			// file--------------------------------------------//
			String msg = "Welcome to javaTpoint!";
			byte byteArray[] = msg.getBytes(); // Converting string into byte
												// array
			fileOutputStream.write(byteArray); // Writing data into file
			logger.debug("------------Data written into file--------------");
			logger.debug(msg);
			// -----------------------------Code to read data from
			// file---------------------------------------------//
			// Creating input stream instance
			DataInputStream inst = new DataInputStream(input);
			int data = input.available();
			// Returns an estimate of the number of bytes that can be read from
			// this input stream.
			byte[] byteArray2 = new byte[data]; //
			inst.read(byteArray2);
			String str = new String(byteArray2); // passing byte array into
													// String constructor
			logger.debug("------------Data read from file--------------");
			logger.debug(str); // display file data
		} catch (Exception exception) {
			logger.debug(exception);
		} finally {
			logger.debug("DONE");
		}

	}

	/***
	 * Try-with-resources Example: using finally block
	 */
	@Override
	public void implementionThree(String[] args) throws Exception {
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				"/home/irfan/scala-workspace/java7-new-features/src/abc.txt")) {
			// -----------------------------Code to write data into
			// file--------------------------------------------//
			String msg = "Welcome to javaTpoint!";
			byte byteArray[] = msg.getBytes(); // Converting string into byte
												// array
			fileOutputStream.write(byteArray); // Writing data into file
			logger.debug("Data written successfully!");
		} catch (Exception exception) {
			logger.debug(exception);
		} finally {
			System.out
					.println("Finally executes after closing of declared resources.");
		}

	}

	@Override
	public void implementionFour(String[] args) throws Exception {
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
			while ((line = br.readLine()) != null) {
				logger.debug("Line =>" + line);
			}
		} catch (IOException e) {
			logger.debug("IOException in try block =>" + e.getMessage());
		}

	}

	@Override
	public void implementionFive(String[] args) throws Exception {
		BufferedReader br = null;
		String line;

		try {
			logger.debug("Entering try block");
			br = new BufferedReader(new FileReader("test.txt"));
			while ((line = br.readLine()) != null) {
				logger.debug("Line =>" + line);
			}
		} catch (IOException e) {
			logger.debug("IOException in try block =>" + e.getMessage());
		} finally {
			logger.debug("Entering finally block");
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				logger.debug("IOException in finally block =>" + e.getMessage());
			}

		}

	}

	@Override
	public void implementionSix(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(new File("testRead.txt"));
				PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
			while (scanner.hasNext()) {
				writer.print(scanner.nextLine());
			}
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
