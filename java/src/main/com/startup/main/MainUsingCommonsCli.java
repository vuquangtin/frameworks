package com.startup.main;

import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.startup.utils.CLIArgumentParser;
import com.startup.utils.Configuration;

/**
 * 
 * Main class cho tất cả các service trong hệ thống. Được sử dụng bởi script
 * run-class.sh làm điểm khởi đầu để start các class khác
 *
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class MainUsingCommonsCli {

	public static void main(String[] args) throws Exception {
		CLIArgumentParser parser = new CLIArgumentParser.Builder()
				.addOpt(null, "logging.level", true, "Log level", false)
				.addOpt(null, "logging.path", true, "Log path", false)
				.addOpt(null, "app.conf", true, "App config path", false)
				.addOpt(null, "class", true, "Main class", true).build();

		try {
			CLIArgumentParser.Result cmd = parser.parse(args);
			initSystemProperties(cmd.getOptions());
			initLogger();
			invokeMainClass(cmd.getOptionValue("class"), cmd.getAppArgs());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			parser.printHelpUsage();
			System.exit(1);
		}
	}

	private static void initSystemProperties(Map<String, String> options) {
		options.remove("class");
		for (Map.Entry<String, String> e : options.entrySet()) {
			if (e.getValue() == null)
				continue;
			System.setProperty(e.getKey(), e.getValue());
		}
	}

	private static void initLogger() {
		Configuration config = new Configuration();
		Configuration.setSystemPropertiesFromConfig(config, "logging.level",
				"logging.path");
		Logger logger = LoggerFactory.getLogger(Configuration.class);
		logger.info(config.toString());
	}

	private static void invokeMainClass(String className, String[] args)
			throws Exception {
		Class<?> clazz = MainUsingCommonsCli.class.getClassLoader().loadClass(
				className);
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, (Object) args);
	}
}