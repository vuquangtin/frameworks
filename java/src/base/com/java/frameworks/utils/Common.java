package com.java.frameworks.utils;

import org.apache.log4j.Logger;
/**
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin">https://github.com/vuquangtin
 *      </a>
 *
 */

public class Common {
	static Logger logger = Logger.getLogger(Common.class.getName());
	public static final String LOCALHOST = "127001";
	public static final String DB_NAME = "FBGrapher.sqlite";
	public static final int MILLISECONDS_TO_MINUTES = 60000;
	public static final int MILLISECONDS_TO_SECONDS = 1000;
	public static final String EXCEPTION_MESSAGE = "exception:";
	public static final int MAX_EXCEPTION = 500;

	public static void sleep(int minutes) {
		sleep(minutes, "", "");
	}

	public static void sleep(int minutes, String message, String getMessage) {
		try {
			if (logger.isDebugEnabled())
				logger.debug(message + ":" + "(pleep " + minutes
						+ "p)\nMessage:" + getMessage);
			Thread.sleep(minutes * MILLISECONDS_TO_MINUTES);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void pause(String pauseMessage) {
		try {
			int minutes = 30;
			if (logger.isDebugEnabled())
				logger.debug(pauseMessage + ":" + "(pleep " + minutes + "m)");
			Thread.sleep(minutes * MILLISECONDS_TO_MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void sleepSeconds(int seconds, String message) {
		try {
			if (logger.isDebugEnabled())
				logger.debug(message + ":" + "(pleep " + seconds + " seconds)");

			Thread.sleep(seconds * MILLISECONDS_TO_SECONDS);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds * MILLISECONDS_TO_SECONDS);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void sleepMilliseconds(long millseconds, String message) {
		try {
			if (logger.isDebugEnabled())
				logger.debug(message + ":" + "(pleep " + millseconds
						+ " millseconds)");

			Thread.sleep(millseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
