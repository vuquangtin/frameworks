package com.java8.adv.exceptions;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class CatchAllTheExceptions {
	public static void main(String[] args) throws Throwable {
		try {
			// IO code
			Files.readAllLines(new File("").toPath());
		} catch (Throwable t) {
			if (t instanceof Exception) {
				if (t instanceof IOException) {
					// handle this exception type
				} else if (t instanceof AnotherExceptionType) {
					// handle this one
				} else {
					// We didn't expect this Exception. What could it be? Let's
					// log it, and let it bubble up the hierarchy.
				}
			} else if (t instanceof Error) {
				if (t instanceof IOError) {
					// handle this Error
				} else if (t instanceof AnotherError) {
					// handle different Error
				} else {
					// We didn't expect this Error. What could it be? Let's log
					// it, and let it bubble up the hierarchy.
				}
			} else {
				// This should never be reached, unless you have subclassed
				// Throwable for your own purposes.
				throw t;
			}
		}
	}
}

class AnotherExceptionType extends Exception {
	private static final long serialVersionUID = 1L;
	
}

class AnotherError extends Error {

	private static final long serialVersionUID = -8413273202168757826L;
}
