package com.java8.properties.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 3. Đọc properties file từ classpath
 * 
 * Giả sử file "config.properties" nằm trong thư mục gốc của classpath (ví dụ
 * nằm trong thư mục /src với cấu hình trong file .classpath như sau
 * <classpathentry kind="src" path="src"/>)
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class LoadPropertiesFromClasspath {

	public static void main(String[] args) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			String filename = "config.properties";
			input = LoadPropertiesFromClasspath.class.getClassLoader()
					.getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			prop.entrySet().forEach(
					e -> System.out.println(e.getKey() + " : " + e.getValue()));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}