package com.java8.adv.reflector;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ReflectException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReflectException() {
		super();
	}

	public ReflectException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public ReflectException(String detailMessage) {
		super(detailMessage);
	}

	public ReflectException(Throwable throwable) {
		super(throwable);
	}

}