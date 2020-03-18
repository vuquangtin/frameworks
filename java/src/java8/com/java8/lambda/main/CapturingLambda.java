package com.java8.lambda.main;

/**
 * 
 * Capturing bambdas Là Lamdas truy cập đến final effectively final field bên
 * ngoài nó (blog code)
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class CapturingLambda {
	public static void main(String[] args) {
		String effectivelyFinal = "effectivelyFinal";
		Runnable capturingLambda = () -> System.out.println("capturingLambda "
				+ effectivelyFinal);
		capturingLambda.run();
	}
}