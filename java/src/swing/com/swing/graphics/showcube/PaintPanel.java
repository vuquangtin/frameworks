package com.swing.graphics.showcube;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class PaintPanel extends JPanel {

	private Color c0 = new Color(0, 0, 0);
	private Color c1 = new Color(0, 0, 255);
	private Color c2 = new Color(0, 255, 0);
	private Color c3 = new Color(0, 255, 255);
	private Color c4 = new Color(255, 0, 0);
	private Color c5 = new Color(255, 0, 255);
	private Color c6 = new Color(255, 255, 0);
	// ------ 1-2 5-6
	// ------ | | | |
	// ------ 3-4 7-8
	int half = 50; // radius = 50 * sqrt(2)
	private Point p1 = new Point(270, 270, -50, 1);
	private Point p2 = new Point(370, 270, -50, 2);
	private Point p3 = new Point(270, 370, -50, 3);
	private Point p4 = new Point(370, 370, -50, 4);
	private Point p5 = new Point(270, 270, 50, 5);
	private Point p6 = new Point(370, 270, 50, 6);
	private Point p7 = new Point(270, 370, 50, 7);
	private Point p8 = new Point(370, 370, 50, 8);
	private Point tmp; // record max-z node

	private double max_z = -9999;
	private int x0 = -1, y0 = -1, x1 = -1, y1 = -1, N;

	private boolean drawing = false;
	private int finish = 0;

	private BufferedImage image;
	private Image image_buffer;
	private Graphics ig;
	private Graphics ig_buffer;
	private Graphics2D ig2d;
	private Graphics2D ig2d_buffer;

	public PaintPanel() { // initial a cube
		image = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
		ig = image.getGraphics();
		ig2d = (Graphics2D) ig;
		clear();
		draw();
	}

	private void find_max_z() { // found the max_z. That point should not be
								// showed.
		max_z = p1.zt;
		tmp = p1;
		if (max_z < p2.zt) {
			max_z = p2.zt;
			tmp = p2;
		}
		if (max_z < p3.zt) {
			max_z = p3.zt;
			tmp = p3;
		}
		if (max_z < p4.zt) {
			max_z = p4.zt;
			tmp = p4;
		}
		if (max_z < p5.zt) {
			max_z = p5.zt;
			tmp = p5;
		}
		if (max_z < p6.zt) {
			max_z = p6.zt;
			tmp = p6;
		}
		if (max_z < p7.zt) {
			max_z = p7.zt;
			tmp = p7;
		}
		if (max_z < p8.zt) {
			max_z = p8.zt;
			tmp = p8;
		}
		// System.out.printf("max_from %d:%f\n",tmp.node,max_z);
	}

	public synchronized void CubeRotate(char v, int angle) {
		if (v == 'x')
			CubeRotateX(angle);
		else if (v == 'y')
			CubeRotateY(angle);
		else if (v == 'z')
			CubeRotateZ(angle);
		draw();
		// repaint();
	}

	public synchronized void draw() { // draw edges
		find_max_z();
		finish = 0;
		clear();
		if (tmp.node != 1 && tmp.node != 2)
			drawLine(p1, p2, c0);
		if (tmp.node != 2 && tmp.node != 4)
			drawLine(p2, p4, c0);
		if (tmp.node != 4 && tmp.node != 3)
			drawLine(p4, p3, c0);
		if (tmp.node != 3 && tmp.node != 1)
			drawLine(p3, p1, c0);
		if (tmp.node != 5 && tmp.node != 6)
			drawLine(p5, p6, c0);
		if (tmp.node != 6 && tmp.node != 8)
			drawLine(p6, p8, c0);
		if (tmp.node != 8 && tmp.node != 7)
			drawLine(p8, p7, c0);
		if (tmp.node != 7 && tmp.node != 5)
			drawLine(p7, p5, c0);
		if (tmp.node != 1 && tmp.node != 5)
			drawLine(p1, p5, c0);
		if (tmp.node != 2 && tmp.node != 6)
			drawLine(p2, p6, c0);
		if (tmp.node != 3 && tmp.node != 7)
			drawLine(p3, p7, c0);
		if (tmp.node != 4 && tmp.node != 8)
			drawLine(p4, p8, c0);
		// draw surface

		if (tmp.node != 1 && tmp.node != 2 && tmp.node != 4 && tmp.node != 3) {
			fill_square(p1, p2, p4, p3, c1);
		}
		if (tmp.node != 1 && tmp.node != 5 && tmp.node != 7 && tmp.node != 3) {
			fill_square(p1, p5, p7, p3, c2);
		}
		if (tmp.node != 1 && tmp.node != 5 && tmp.node != 6 && tmp.node != 2) {
			fill_square(p1, p5, p6, p2, c3);
		}
		if (tmp.node != 2 && tmp.node != 6 && tmp.node != 8 && tmp.node != 4) {
			fill_square(p2, p6, p8, p4, c4);
		}
		if (tmp.node != 3 && tmp.node != 7 && tmp.node != 8 && tmp.node != 4) {
			fill_square(p3, p7, p8, p4, c5);
		}
		if (tmp.node != 5 && tmp.node != 6 && tmp.node != 8 && tmp.node != 7) {
			fill_square(p5, p6, p8, p7, c6);
		}

		finish = 1;
		// ig = ig_buffer;
		// paint(ig_buffer);
	}

	public void fill_square(Point pp1, Point pp2, Point pp3, Point pp4, Color c) { // fill
																					// color
																					// for
																					// one
																					// surface
		int[] x, y;
		x = new int[Cons.polySize];
		y = new int[Cons.polySize];
		x[0] = pp1.x;
		y[0] = pp1.y;
		x[1] = pp2.x;
		y[1] = pp2.y;
		x[2] = pp3.x;
		y[2] = pp3.y;
		x[3] = pp4.x;
		y[3] = pp4.y;
		fillPolygon(x, y, c);
	}

	public void CubeRotateX(int angle) {
		p1.Rotate('x', angle);
		p2.Rotate('x', angle);
		p3.Rotate('x', angle);
		p4.Rotate('x', angle);
		p5.Rotate('x', angle);
		p6.Rotate('x', angle);
		p7.Rotate('x', angle);
		p8.Rotate('x', angle);
	}

	public void CubeRotateY(int angle) {
		p1.Rotate('y', angle);
		p2.Rotate('y', angle);
		p3.Rotate('y', angle);
		p4.Rotate('y', angle);
		p5.Rotate('y', angle);
		p6.Rotate('y', angle);
		p7.Rotate('y', angle);
		p8.Rotate('y', angle);
	}

	public void CubeRotateZ(int angle) {
		p1.Rotate('z', angle);
		p2.Rotate('z', angle);
		p3.Rotate('z', angle);
		p4.Rotate('z', angle);
		p5.Rotate('z', angle);
		p6.Rotate('z', angle);
		p7.Rotate('z', angle);
		p8.Rotate('z', angle);
	}

	private void drawPixel(Point p, Color c) {
		drawPixel(p.x, p.y, c);
	}

	private void drawPixel(int x, int y, Color c) {
		ig.setColor(c);
		ig.fillRect(x, y, 1, 1);
	}

	private void drawLine(Point p1, Point p2, Color c) {
		drawLine(p1.x, p1.y, p2.x, p2.y, c);
	}

	private void drawLine(int x0, int y0, int x1, int y1, Color c) {
		if (x0 > x1) {
			int temp;
			temp = x0;
			x0 = x1;
			x1 = temp;
			temp = y0;
			y0 = y1;
			y1 = temp;
		}
		double k = Math.abs(y1 - y0) * 1.0 / Math.abs(x1 - x0);
		if (Math.abs(y1 - y0) < Math.abs(x1 - x0)) {
			// 0 < k < 1
			if (y0 < y1) {
				int a = y0 - y1, b = x1 - x0;
				int d = 2 * a + b, d1 = 2 * a, d2 = 2 * (a + b);
				int x = x0, y = y0;
				drawPixel(x, y, c);
				while (x < x1) {
					if (d < 0) {
						x++;
						y++;
						d += d2;
					} else {
						x++;
						d += d1;
					}
					drawPixel(x, y, c);
				}
			} else {
				int a = y1 - y0, b = x1 - x0;
				int d = 2 * a + b, d1 = 2 * a, d2 = 2 * (a + b);
				int x = x0, y = y0;
				drawPixel(x, y, c);
				while (x < x1) {
					if (d < 0) {
						x++;
						y--;
						d += d2;
					} else {
						x++;
						d += d1;
					}
					drawPixel(x, y, c);
				}
			}
		} else {
			// k>=1
			if (y0 < y1) {
				int a = y0 - y1, b = x1 - x0;
				int d = a + 2 * b, d1 = 2 * b, d2 = 2 * (a + b);
				int x = x0, y = y0;
				drawPixel(x, y, c);
				while (y < y1) {
					if (d < 0) {
						y++;
						d += d1;
					} else {
						x++;
						y++;
						d += d2;
					}
					drawPixel(x, y, c);
				}
			} else {
				int a = y1 - y0, b = x1 - x0;
				int d = a + 2 * b, d1 = 2 * b, d2 = 2 * (a + b);
				int x = x0, y = y0;
				drawPixel(x, y, c);
				while (y > y1) {
					if (d < 0) {
						y--;
						d += d1;
					} else {
						x++;
						y--;
						d += d2;
					}
					drawPixel(x, y, c);
				}
			}
		}
	}

	public synchronized void paint(Graphics g) {
		// super.paint(g);
		// ig2d = (Graphics2D) ig_buffer;
		Graphics2D g2d = (Graphics2D) g;
		ig2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if (finish == 1)
			g.drawImage(image, 0, 0, this);
		// super.paint(g);
	}

	public void fillPolygon(int[] x, int[] y, Color c) {
		N = 4;// 4 points
		Edge[] newEdge = new Edge[Cons.polySize];
		int ymin = -1, ymax = -1;
		for (int i = 0; i < N; i++) {
			if (ymin == -1 || y[i] < ymin)
				ymin = y[i];
			if (ymax == -1 || y[i] > ymax)
				ymax = y[i];
			if (i == 0)
				newEdge[i] = new Edge(x[N - 1], y[N - 1], x[0], y[0]);
			else
				newEdge[i] = new Edge(x[i - 1], y[i - 1], x[i], y[i]);
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (newEdge[i].y0 > newEdge[j].y0) {
					newEdge[i].swap(newEdge[j]);
				}
			}
		}

		ActiveEdge[] activeEdge = new ActiveEdge[Cons.polySize];
		int M = 0;
		for (int y_tmp = ymin, i = 0; y_tmp < ymax; y_tmp++) {
			int j, k;
			for (; i < N && newEdge[i].y0 == y_tmp; i++) {
				if (activeEdge[M] == null)
					activeEdge[M] = new ActiveEdge(newEdge[i]);
				else
					activeEdge[M].copy(newEdge[i]);
				M++;
			}

			for (int l = 0; l < M; l++) {
				for (int r = l + 1; r < M; r++) {
					if (activeEdge[l].x > activeEdge[r].x) {
						activeEdge[l].swap(activeEdge[r]);
					}
				}
			}

			boolean flag = false;
			for (j = 0; j + 1 < M; j++) {
				flag = !flag;
				if (Math.abs(activeEdge[j].x - activeEdge[j + 1].x) < Cons.eps) {
					if (activeEdge[j].y1 == y_tmp
							&& activeEdge[j + 1].y1 == y_tmp) {
						// 0
					} else if (activeEdge[j].y1 > y_tmp
							&& activeEdge[j + 1].y1 > y_tmp) {
						// 2
						int lx = (int) activeEdge[j].x;
						drawLine(lx, y_tmp, lx, y_tmp, c);
						repaint();
					} else {
						// 1
						int lx = (int) activeEdge[j].x;
						drawLine(lx, y_tmp, lx, y_tmp, c);
						repaint();
						flag = !flag;
					}
				} else {
					if (flag) {
						int lx = (int) (activeEdge[j].x + 0.5);
						int rx = (int) (activeEdge[j + 1].x - 0.5);
						if (lx <= rx)
							drawLine(lx, y_tmp, rx, y_tmp, c);
						repaint();
					}
				}
			}

			for (j = 0; j < M;) {
				if (activeEdge[j].y1 > y_tmp) {
					activeEdge[j].x += activeEdge[j].delta;
					j++;
				} else if (activeEdge[j].y1 == y_tmp) {
					// delete
					activeEdge[j].swap(activeEdge[M - 1]);
					M--;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (i == 0) {
				drawLine(x[N - 1], y[N - 1], x[0], y[0], c0);
				repaint();
			} else {
				drawLine(x[i - 1], y[i - 1], x[i], y[i], c0);
				repaint();
			}
		}
	}

	public void clear() {
		ig.setColor(Color.white);
		ig.fillRect(0, 0, 640, 640);
		// drawing = false;
		repaint();
	}
}