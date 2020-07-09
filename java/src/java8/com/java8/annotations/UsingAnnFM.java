package com.java8.annotations;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class UsingAnnFM {

	// AnnFM chỉ được phép chú thích (annotate) trên FIELD hoặc METHOD.
	@AnnFM
	protected int someField = 100;

	// AnnFM chỉ được phép chú thích (annotate)trên FIELD hoặc METHOD.
	@AnnFM2
	public void someMethod() {

	}

}