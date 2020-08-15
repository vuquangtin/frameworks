package com.java8.adv.classLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class LoaderTest {
	public static void main(String[] args) throws IOException {
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载");
		Enumeration<URL> em1 = systemLoader.getResources("");
		while (em1.hasMoreElements()) {
			System.out.println(em1.nextElement());
			// file:/...../target/classes/
		}
		ClassLoader extensionLader = systemLoader.getParent();
		System.out.println("拓展类加载器" + extensionLader);
		// 拓展类加载器sun.misc.Launcher$ExtClassLoader@57f530d8
		System.out.println("拓展类加载器的父" + extensionLader.getParent());// 拓展类加载器的父null
		// 为什么根类加载器为NULL?
		// 根类加载器并不是Java实现的，而且由于程序通常须访问根加载器，因此访问扩展类加载器的父类加载器时返回NULL
	}
}