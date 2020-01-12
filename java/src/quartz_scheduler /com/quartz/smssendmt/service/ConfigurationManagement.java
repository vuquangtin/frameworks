package com.quartz.smssendmt.service;

import java.net.URL;

import javax.naming.ConfigurationException;

import org.hibernate.cfg.Configuration;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class ConfigurationManagement {

	/**
	 * log tool.
	 */
	// private static Logger log =
	// Logger.getLogger(ConfigurationManagement.class);
	private static transient PropertiesConfiguration configuration = null;
	private static final String CONFIG_FILE = "sms.conf";
	private static final String CONFIG_PATH = "conf/";

	private ConfigurationManagement() {
	}

	public static Configuration getInstance() {
		if (configuration == null) {
			try {
				final URL url = ConfigurationManagement.class.getClassLoader().getResource(CONFIG_PATH + CONFIG_FILE);
				// System.out.println(url);
				configuration = new PropertiesConfiguration(url);
				configuration.setAutoSave(true);
			} catch (ConfigurationException ex) {
				// log.error("error while loading configuration file" + ex);
			}
		}
		return configuration;
	}
}
