package com.swing.graphics.showcube;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class ActiveEdge {

	double x, delta;
	int y1;

	public ActiveEdge(double x, double delta, int y1) {
		this.x = x;
		this.delta = delta;
		this.y1 = y1;
	}

	public ActiveEdge(ActiveEdge e) {
		x = e.x;
		delta = e.delta;
		y1 = e.y1;
	}

	public ActiveEdge(Edge e) {
		x = e.x0;
		delta = e.delta;
		y1 = e.y1;
	}

	public void copy(Edge e) {
		x = e.x0;
		delta = e.delta;
		y1 = e.y1;
	}

	public void copy(ActiveEdge e) {
		x = e.x;
		delta = e.delta;
		y1 = e.y1;
	}

	public void swap(ActiveEdge e) {
		int temp;
		temp = y1;
		y1 = e.y1;
		e.y1 = temp;
		double d;
		d = x;
		x = e.x;
		e.x = d;
		d = delta;
		delta = e.delta;
		e.delta = d;
	}
}