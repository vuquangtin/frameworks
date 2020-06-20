package com.java8.adv.jls14.point2;

import com.java8.adv.jls14.point.Point2;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Point3d extends Point2 {

	protected int z;


	public void delta(Point2 p) {
		p.x += this.x;						// compile-time error: cannot access p.x
		p.y += this.y;						// compile-time error: cannot access p.y
	}


	public void delta3d(Point3d q) {
		q.x += this.x;
		q.y += this.y;
		q.z += this.z;
	}

}