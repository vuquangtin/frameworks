package com.java8.adv.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class NetworkClassLoader extends ClassLoader {

	String name;

	// 类存放的路径
	private String path = "target/classes/com/java8/adv/models/";

	@Override
	protected Class<?> findClass(String name) {
		byte[] b = new byte[0];
		try {
			b = loadClassData(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name) throws IOException {
		try {
			// name = name.replace(".", "//");
			FileInputStream is = new FileInputStream(new File(path + name
					+ ".class"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int b = 0;
			while ((b = is.read()) != -1) {
				baos.write(b);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public NetworkClassLoader(String name) {
		this.name = name;
	}
}