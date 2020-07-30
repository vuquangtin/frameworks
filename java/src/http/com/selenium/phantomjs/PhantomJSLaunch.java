package com.selenium.phantomjs;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class PhantomJSLaunch {

	public static void main(String[] args) {

		File path = new File("bin/phantomjs");
		System.setProperty("phantomjs.binary.path", path.getAbsolutePath());
		System.out.println(path.getAbsolutePath());
		WebDriver driver = new PhantomJSDriver();
		driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}