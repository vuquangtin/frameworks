package com.java8.function.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class ExecuteAroundWithLambda {
	// accept the behaviour
	public static String processFile(BufferedReaderProcessor brp) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("src/com/java8/training/data.txt"))) {
			return brp.process(br); // execute the behaviour
		}
	}

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		            // pass the lambdas
		String s = processFile((BufferedReader br) -> br.readLine());
		System.out.println(s);
		s = processFile((BufferedReader br) -> {
			String s2 = br.readLine() + "  " + br.readLine();
			return s2;
		});
		//s = processFile((BufferedReader br) -> br.readLine() + "  " + br.readLine());
		System.out.println(s);
	}

}