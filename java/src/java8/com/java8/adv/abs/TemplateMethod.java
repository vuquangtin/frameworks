package com.java8.adv.abs;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 */
public abstract class TemplateMethod {
	public void runTemplateMethod(String[] args) {
		try {
			main1(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			main2(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			main3(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			main4(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			main5(args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public abstract void main1(String[] args);

	public abstract void main2(String[] args);

	public abstract void main3(String[] args);

	public abstract void main4(String[] args);

	public abstract void main5(String[] args);
}
