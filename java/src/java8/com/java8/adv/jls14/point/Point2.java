package com.java8.adv.jls14.point;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */

public class Point2 {

	protected int x, y;


	void warp(com.java8.adv.jls14.point2.Point3d a) {
		if (a.z > 0)						// compile-time error: cannot access a.z
			a.delta(this);
	}

}