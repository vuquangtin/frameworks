package com.java.frameworks.utils;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin">https://github.com/vuquangtin
 *      </a>
 *
 */

public class Log4jUtils {
	public static final String LOGS_FILE = "logs";
	public static final String PRE_LANGUAGE = "LanguageFile_%s_%s_";
	public static final String PRE_LANGUAGE_FILE = LOGS_FILE + "/" + PRE_LANGUAGE;
	public static final String EXE_LANGUAGE_FILE = "temp";
	public static final int LOG_FETCH_INDEX = 10;

	public static Logger initLog4j() {
		return initLog4j(true);
	}

	public static Logger initLog4j(boolean facebookable) {
		try {
			long sizeLogs = FileUtils.folderSize(LOGS_FILE);
			if (sizeLogs > 0) {
				String fileSize = FileUtils.readableFileSize(sizeLogs);
				System.out.println("fileSize:" + fileSize);
				if (fileSize.contains("GB")) {
					// MB
					System.out.println("cleanDirectory:" + LOGS_FILE);
					org.apache.commons.io.FileUtils.cleanDirectory(new File(LOGS_FILE));
					// FileUtils.delete(LOGS_FILE);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Properties properties = new Properties();
		properties.setProperty("log4j.rootLogger", "TRACE,stdout,MyFile");
		properties.setProperty("log4j.rootCategory", "TRACE");

		properties.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
		properties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
		// properties.setProperty("log4j.appender.stdout.layout.ConversionPattern","%d{yyyy/MM/dd
		// HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");

		// properties.setProperty("log4j.appender.stdout","org.apache.log4j.ConsoleAppender");

		properties.setProperty("log4j.appender.MyFile", "org.apache.log4j.RollingFileAppender");
		if (facebookable) {
			properties.setProperty("log4j.appender.MyFile.File",
					LOGS_FILE + "/" + FfpojoUtils.getLogName(FfpojoUtils.PRE_FB_LOG, ".log", false));
		} else {
			properties.setProperty("log4j.appender.MyFile.File",
					LOGS_FILE + "/" + FfpojoUtils.getLogName(FfpojoUtils.PRE_IG_LOG, ".log", false));
		}
		String ip = IPUtils.getCurrentIP() + "";
		if (ip.equals(Common.LOCALHOST))
			properties.setProperty("log4j.appender.MyFile.MaxFileSize", "100mb");
		else
			properties.setProperty("log4j.appender.MyFile.MaxFileSize", "100mb");
		properties.setProperty("log4j.appender.MyFile.MaxBackupIndex", "1");
		properties.setProperty("log4j.appender.MyFile.layout", "org.apache.log4j.PatternLayout");
		// properties.setProperty("log4j.appender.MyFile.layout.ConversionPattern","%d{yyyy/MM/dd
		// HH:mm:ss.SSS} [%5p] %t (%F) - %m%n");
		properties.setProperty("log4j.appender.MyFile.layout.ConversionPattern", "%d %5p [%l] - %m%n");

		properties.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
		// properties.setProperty("log4j.appender.stdout.layout.ConversionPattern","%5p
		// | %d | %F | %L | %m%n");
		properties.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%d %5p %l - %m%n");
		properties.setProperty("log4j.category.com.restfb", "WARN,file");
		properties.setProperty("log4j.additivity.com.restfb", "false");
		properties.setProperty("log4j.category.com.mongodb", "WARN,file");
		properties.setProperty("log4j.additivity.com.mongodb", "false");
		// properties.setProperty("log4j.logger.org.apache.kafka.clients.consumer.ConsumerConfig",
		// "ERROR,INFO,WARN,file");
		// properties.setProperty("log4j.logger.org.apache.kafka.clients.producer.ProducerConfig",
		// "ERROR,INFO,WARN,file");
		// properties.setProperty("log4j.logger.org.apache.zookeeper","INFO");
		java.util.logging.Logger.getLogger("com.mongodb").setLevel(Level.OFF);
		// Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		// mongoLogger.setLevel(org.apache.log4j.Level.SEVERE);
		// java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.log‌​ging.Level.SEVERE);
		java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.OFF);
		// %d %5p [%l] - %m%n
		PropertyConfigurator.configure(properties);
		Logger logger = Logger.getLogger("log4j");

		// logger.fatal("This is a FATAL message.");
		// logger.error("This is an ERROR message.");
		// logger.warn("This is a WARN message.");
		logger.info("This is an INFO message.");
		// logger.debug("This is a DEBUG message.");
		// logger.trace("This is a TRACE message.");

		return logger;
	}
}
