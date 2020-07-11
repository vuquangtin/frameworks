package com.startup.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class Configuration extends Properties {
	private static final String CONF_ENV = "app.conf";
	private static final String DEFAULT_NAME = "config.properties";
	private static final Properties defaultProps = new Properties();
	private static String defaultResPath = System.getProperty("app.conf");

	public static void setSystemPropertiesFromConfig(Properties props,
			String... propertyKeys) {
		String[] var2 = propertyKeys;
		int var3 = propertyKeys.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			String key = var2[var4];
			if (System.getProperty(key) == null) {
				System.setProperty(key, props.getProperty(key));
			}
		}

	}

	public static void setDefaultResourcePath(String path) {
		defaultResPath = path;
	}

	public Configuration() {
		this(defaultResPath);
	}

	public Configuration(String path) {
		try {
			this.addResource(path);
		} catch (IOException var3) {
			throw new ConfigurationException(var3);
		}
	}

	public Configuration(InputStream is) {
		try {
			this.addResource(is);
		} catch (IOException var3) {
			throw new ConfigurationException(var3);
		}
	}

	public void addResource(InputStream is) throws IOException {
		this.addResource(is, false);
	}

	public void addResource(InputStream is, boolean closeAfterLoad)
			throws IOException {
		try {
			this.load(is);
		} finally {
			if (closeAfterLoad) {
				is.close();
			}

		}

	}

	public void addResource(String path) throws IOException {
		if (path != null) {
			this.addResource(new FileInputStream(path), true);
		}

	}

	public String getProperty(String key) {
		String value = super.getProperty(key);
		return value != null ? value : defaultProps.getProperty(key);
	}

	public synchronized String toString() {
		Set<Object> keySet = new LinkedHashSet<Object>();
		keySet.addAll(this.keySet());
		keySet.addAll(defaultProps.keySet());
		List<Object> list = new ArrayList<Object>(keySet);
		list.sort(Comparator.comparing(Object::toString));
		StringBuilder sb = new StringBuilder("Configuration properties:\n");
		list.forEach((key) -> {
			sb.append(String.format(Locale.US, "\t%s = %s\n", key.toString(),
					this.getProperty(key.toString(), "")));
		});
		return sb.toString();
	}

	static {
		try {
			defaultProps.load(Configuration.class.getClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (IOException var2) {
			Throwable t = new IOException(
					"Cannot find config.properties in classpath");
			t.printStackTrace(new PrintStream(System.out));
		}

	}
}