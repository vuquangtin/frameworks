package com.java8.adv.classLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class MyClassLoader {

	public static void main(String[] args) throws MalformedURLException,
			ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		URL url = new URL("target/classes/com/java8/adv/classLoader");
		ClassLoader myloader = new URLClassLoader(new URL[] { url });
		Class c = myloader.loadClass("com.java8.adv.classLoader.Test2");
		System.out.println("----------");
		Test2 t3 = (Test2) c.newInstance();
	}
}