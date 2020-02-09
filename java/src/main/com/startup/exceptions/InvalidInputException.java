package com.startup.exceptions;

import com.startup.utils.CommandLineParser;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String msg) {
		super(msg);
	}

	/**
	 * @param parser
	 * @return boolean to see if process input was missing or invalid
	 */
	public boolean checkProcessInput(CommandLineParser parser) {
		return (parser.getNumberOfProcessors() <= 0);
	}

}
