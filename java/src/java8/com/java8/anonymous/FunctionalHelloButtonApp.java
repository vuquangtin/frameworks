package com.java8.anonymous;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class FunctionalHelloButtonApp {
	private final Button button = new Button();

	public FunctionalHelloButtonApp() {
		button.addActionListener(event -> System.out.println("button clicked"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("button clicked");
			}
		});
	}
}
