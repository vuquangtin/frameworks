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
public class ExecuteAround {

	public static String processFile() throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("src/com/java8/training/data.txt"))) {
			return br.readLine();
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println(processFile());
	}

}