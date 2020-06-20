package com.java8.adv.jls14;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class ColoredPoint extends Point {
	static final int WHITE = 0, BLACK = 1;
	int color;

	ColoredPoint() {
	}

	ColoredPoint(int x, int y) {
		super(x, y);
		this.color = BLACK;
	}

	ColoredPoint(int x, int y, int color) {
		super(x, y);
		this.color = color;
	}

	public void getColor() throws IllegalArgumentException {

	}

	public void setColor(int color) {
		this.color = color;
	}
}