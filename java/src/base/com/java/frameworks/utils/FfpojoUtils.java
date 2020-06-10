package com.java.frameworks.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin">https://github.com/vuquangtin
 *      </a>
 *
 */
public class FfpojoUtils {
	static Logger logger = Logger.getLogger(FfpojoUtils.class.getName());
	public static final String CSV_NAME = ".csv";
	public static final String TXT_NAME = ".txt";
	public static final String INFO_NAME = ".info";
	public static final String TS_NAME = ".ts";
	public static final String CONTENT_NAME = ".content";
	public static final String FROM_NAME = ".from";
	public static final String URL_NAME = ".url";
	public static final String COMMENT_NAME = ".comment";
	public static final String MP4_NAME = ".mp4";
	public static final String JPG_NAME = ".jpg";
	public static final String JSON_NAME = ".json";
	public static final String SUBSCRIBERS_NAME = "_subscribers" + TXT_NAME;
	public static final String SUBSCRIBED_TO_NAME = "_subscribedto" + TXT_NAME;
	public static final String THUMBNAIL = "_thumbnail";
	public static final String FRIENDS_NAME = "_friends" + TXT_NAME;
	public static final String MEMBERS_NAME = "" + TXT_NAME;
	public static final String SEPARATOR_ENTER = "\n";
	public static final String SEPARATOR_CSV = ",";

	public static final String PATH_DATA_PROFILE_LOG = "logs/";
	public static final String PATH_REST_DATA = "conf/";
	public static final int MAX_FOLDER = 10000;

	public static final String PRE_FB_LOG = "fblog";
	public static final String PRE_IG_LOG = "iglog";

	public static final String REGEX_NUMBER = "[0-9]*";

	public static int countOfLine(String filename) {
		int lines = 0;
		try {
			if (!filename.endsWith(TXT_NAME))
				filename = filename + TXT_NAME;
			if (new File(filename).exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				while (reader.readLine() != null)
					lines++;
				reader.close();
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return lines;
	}

	public static Set<String> getLines(String filename, int totalLine) {

		int lines = 0;
		Set<String> hashSet = new HashSet<>();
		try {
			if (!filename.endsWith(TXT_NAME))
				filename = filename + TXT_NAME;
			if (new File(filename).exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(filename));
				String thisLine = null;
				while ((thisLine = reader.readLine()) != null) {
					if (thisLine.startsWith("#")) {
						if (logger.isDebugEnabled())
							logger.debug("break id[" + lines + "] " + thisLine);
						continue;
					}
					hashSet.add(thisLine);
					if (logger.isDebugEnabled())
						logger.debug("getLines profile id[" + lines + "] from file :" + thisLine);

					if (lines > totalLine)
						break;
					lines++;
				}
				reader.close();
				if (hashSet.size() > 0) {
					return hashSet;
				}
			}

		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public static Set<String> getAllID(String filename) {
		Set<String> hashSetProfileId = new HashSet<String>();
		try {
			String thisLine = null;
			BufferedReader reader = new BufferedReader(new FileReader(filename + TXT_NAME));
			while ((thisLine = reader.readLine()) != null) {
				hashSetProfileId.add(thisLine);
			}
			reader.close();
		} catch (Exception e) {
			logger.error(e);
		}
		return hashSetProfileId;
	}

	public static String getLogName(String preLog, String extension) {
		return getLogName(preLog, extension, true);
	}

	public static String getLogName(String preLog, String extension, boolean isDatetime) {
		if (extension.contains(".") == false)
			extension = "." + extension;
		if (isDatetime) {
			return preLog + "_" + IPUtils.getCurrentIP() + "_" + TimeUtils.getFullNowForFile() + extension;
		} else {
			return preLog + "_" + IPUtils.getCurrentIP() + "_" + TimeUtils.getNowForFile() + extension;
		}
	}
}
