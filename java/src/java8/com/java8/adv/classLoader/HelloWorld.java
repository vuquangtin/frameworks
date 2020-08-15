package com.java8.adv.classLoader;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class HelloWorld {
	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		Class c = hello.getClass();
		ClassLoader loader = c.getClassLoader();

		System.out.println(loader);// sun.misc.Launcher$AppClassLoader@4145f572
		System.out.println(loader.getParent());// sun.misc.Launcher$ExtClassLoader@57f530d8
		ClassLoader loaderParent = loader.getParent();
		System.out.println(loaderParent.getParent());// null
	}
}
