package com.java.frameworks.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

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

public class FileUtils {

	static Logger logger = Logger.getLogger(FileUtils.class.getName());
	public final static String JAR_FILE = "fbcrawler-1.0-jar-with-dependencies.jar";
	public final static String JAR_FILE_OF_KAFKA = "fbcrawler-1.0-for-kafka-jar-with-dependencies.jar";
	public final static String JAR_FILE_SEVICE_OF_KAFKA = "fbcrawler-1.0-sevice-jar-with-dependencies.jar";
	public final static String JAR_FILE_OF_REDIS = "fbcrawler-1.0-for-redis-jar-with-dependencies.jar";
	// "FBGraphAPI-2.0.0-SNAPSHOT-jar-with-dependencies.jar";
	public final static String LIZARD_FS_CLOUD = "/lizardfs_cloud/fb_socials/";
	public static final String NAME_FILE = "pg";
	public static final String ENTER_ROW = "\t\t\t";
	// kich thuoc theo MB
	public static final int FILE_SIZE_MAX_MB = 25;
	public static final int FILE_SIZE_MIN_MB = 5;
	public static String FOLDER_SAVE = null;
	public static String FILE_NAME = null;
	public static String FILE_NAME_NEW = null;

	public static void main(String[] args) {
		logger = Log4jUtils.initLog4j();
		if (logger.isDebugEnabled())
			logger.debug(FileUtils.checkHsErrPidFile() + "");
		List<String> list = readLineToken("conf/FB_App_AccessToken.txt", true);
		for (String string : list) {
			if (logger.isDebugEnabled())
				logger.debug(string);
		}
		if (logger.isDebugEnabled())
			logger.debug("current:" + readingFile());
		// writeFile(10);
		if (logger.isDebugEnabled())
			logger.debug("current:" + readingFile());
	}

	public static long folderSize(String directory) {
		return folderSize(new File(directory));
	}

	public static long folderSize(File directory) {
		long length = 0;
		if (directory.listFiles() != null) {
			for (File file : directory.listFiles()) {
				if (file.isFile())
					length += file.length();
				else
					length += folderSize(file);
			}
		}
		return length;
	}

	public static String readableFileSize(long size) {
		if (size <= 0)
			return "0";
		final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
		int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
		return new DecimalFormat("#,##0.#").format(size
				/ Math.pow(1024, digitGroups))
				+ " " + units[digitGroups];
	}

	public static void writeDataOnlyEmailsSavedToFile(String folder,
			String fileName, String txt) {
		if (!new File(folder).exists())
			new File(folder).mkdir();
		writeLine(folder + "/" + fileName, txt);
	}

	public static void writeLine(String txtFile, String line) {
		writeLine(txtFile, line, true);
	}

	public static boolean mkdirs(String folder) {
		return mkdirs(folder, false);
	}

	public static boolean mkdirs(String folder, boolean mkdirs) {
		if (mkdirs == false)
			return false;
		try {
			if (!new File(folder).exists())
				new File(folder).mkdirs();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}
		return true;
	}

	public static void writeLine(String txtFile, String line, boolean append) {
		if (line == null)
			return;
		try {
			String enter = "";// SymbolsKeyboard.ENTER_KEY_SYMBOLS;
			File fout = new File(txtFile);
			if (!fout.exists() || append == false) {
				fout.createNewFile();
				append = false;
			} else {
				if (append)
					enter = SymbolsKeyboard.ENTER_KEY_SYMBOLS;
			}
			FileOutputStream fos = new FileOutputStream(fout, append);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			bw.write(enter + line);

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static Set<String> getRowsOfString(String content) {
		Set<String> list = new HashSet<String>();
		String idInCSV = null;
		boolean isOneLine = true;
		if (content.contains(SymbolsKeyboard.NEW_LINE_SEPARATOR)) {
			isOneLine = false;
			for (String url : content.split(SymbolsKeyboard.NEW_LINE_SEPARATOR)) {

				// url.contains("\",\"") ||
				if (url.contains(",")) {
					idInCSV = url.substring(0, url.indexOf(",") - 1).replace(
							"\"", "");

					if (idInCSV.matches("[0-9]*")) {
						list.add(idInCSV);
					}
				} else {
					list.add(url);
				}

			}
		}
		if (content.contains(SymbolsKeyboard.CRLF)) {
			isOneLine = false;
			String[] arrCRLF = content.split(SymbolsKeyboard.CRLF);
			if (arrCRLF != null && arrCRLF.length > 0) {
				for (String url : arrCRLF) {
					if (logger.isDebugEnabled()) {
						logger.debug("CRLF  url::" + url);
					}
					if (url.contains(",")) {
						idInCSV = url.substring(0, url.indexOf(",") - 1)
								.replace("\"", "");

						if (idInCSV.matches("[0-9]*")) {
							list.add(idInCSV);
						}
					} else {
						list.add(url);
					}
				}
			}
		}
		if (isOneLine) {
			if (content != null && !content.isEmpty()) {
				list.add(content);
			}
		}
		return list;

	}

	public static String readAllText(File file, Charset encoding) {
		return readAllText(file.toPath(), encoding);
	}

	public static String readAllText(String path, Charset encoding) {
		return readAllText(Paths.get(path), encoding);
	}

	private static String readAllText(Path path, Charset encoding) {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(path);
			return new String(encoded, encoding);
		} catch (IOException e) {
			logger.error(Common.EXCEPTION_MESSAGE + e);
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isFilenameValid(String file) {
		File f = new File(file);
		try {
			f.getCanonicalPath();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public static long getLastModifiedOfFacebookGraphAPIJar(boolean kafka,
			boolean sevice) {
		String jarFileString = getJarFile(kafka, sevice);
		File file = new File(LIZARD_FS_CLOUD + jarFileString);
		if (file.exists()) {
			if (logger.isDebugEnabled())
				logger.debug("lastModified: " + file.lastModified());
			return file.lastModified();
		}
		if (logger.isDebugEnabled())
			logger.debug(jarFileString + " no exists in " + LIZARD_FS_CLOUD);
		return 0;

	}

	public static long getcurrentLastModifiedOfFacebookGraphAPIJar(
			boolean kafka, boolean sevice) {

		try {
			File file = new File(FileUtils.class.getProtectionDomain()
					.getCodeSource().getLocation().toURI().getPath());
			if (file.exists()) {
				if (logger.isDebugEnabled())
					logger.debug("lastModified: " + file.lastModified());
				return file.lastModified();
			}
		} catch (Exception ex) {
		}
		if (logger.isDebugEnabled())
			logger.debug(getJarFile(kafka, sevice) + " no exists in "
					+ LIZARD_FS_CLOUD);
		return 0;

	}

	public static String getJarFile(boolean kafka, boolean sevice) {
		String jarFileString = JAR_FILE_OF_KAFKA;
		if (kafka) {
			if (sevice == true) {
				jarFileString = JAR_FILE_SEVICE_OF_KAFKA;
			} else {
				jarFileString = JAR_FILE_OF_KAFKA;
			}
		} else {
			jarFileString = JAR_FILE_OF_KAFKA;// JAR_FILE_OF_REDIS;
		}
		return jarFileString;
	}

	public static void copyFacebookGraphAPIJar(int exitCode, boolean kafka,
			boolean sevice) {
		// File source = new File("/adscloud/graph_api/" + JAR_FILE);
		String jarFileString = getJarFile(kafka, sevice);
		File source = new File(LIZARD_FS_CLOUD + jarFileString);
		if (source.exists()) {
			if (logger.isDebugEnabled())
				logger.debug("Copy : " + jarFileString);
			try {

				String currentFolder = FileUtils.class.getProtectionDomain()
						.getCodeSource().getLocation().toURI().getPath()
						.replace(jarFileString, "");
				if (logger.isDebugEnabled())
					logger.debug("current folder:" + currentFolder);
				org.apache.commons.io.FileUtils.copyFileToDirectory(source,
						new File(currentFolder));
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
				if (logger.isDebugEnabled())
					logger.debug("-------------------exit copy "
							+ jarFileString
							+ " function while copy jar file----------------");
				System.exit(exitCode);
			}

		}

	}

	public static boolean checkHsErrPidFile() {

		return checkAllFiles("hs_err_pid.*\\.log");

	}

	public static boolean deleteLangFilesWithSamePrefix(String dir, String pre) {
		return deleteFilesWithSamePrefix(dir, pre, Log4jUtils.EXE_LANGUAGE_FILE);
	}

	public static boolean deleteFilesWithSamePrefix(String dir, String pre) {
		return deleteFilesWithSamePrefix(dir, pre, null);
	}

	public static boolean deleteFilesWithSamePrefix(String dir, String pre,
			final String extension) {
		final File folder = new File(dir);
		final File[] files = folder.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(final File dir, final String name) {
				if (extension != null)
					return name.matches(pre + ".*\\." + extension);
				else
					return name.matches(pre + ".*");
			}
		});
		boolean r = true;
		for (final File file : files) {
			if (!file.delete()) {
				System.err.println("Can't remove " + file.getAbsolutePath());
				r = false;
			}
		}
		return r;
	}

	private static boolean checkAllFiles(String regex) {
		File curDir = new File(".");
		File[] filesList = curDir.listFiles();
		boolean isReturn = false;
		for (File f : filesList) {
			if (f.isFile()) {
				if (f.getName().matches(regex)) {
					f.delete();
					if (isReturn == false) {
						isReturn = true;
						// Logs.infoOutOfMenmory(conf, Logs.LIST_HYPHEN +
						// Logs.LIST_HYPHEN + "------\n");
					}
					if (logger.isDebugEnabled())
						logger.debug("delete:" + f.getName());
					// Logs.infoOutOfMenmory(conf, f.getName());
					// Logs.info(conf, FileUtils.class, "delete file
					// (hs_err_pid.*.log):" + f.getName());

				}
			}
		}
		return isReturn;

	}

	public static boolean checkFileIsMaxSize(String fileName) {
		return checkFileIsMaxSize(new File(fileName), FILE_SIZE_MAX_MB);
	}

	public static boolean checkFileIsMaxSize(File file, int Max) {

		// Get length of file in bytes
		long fileSizeInBytes = file.length();
		// Convert the bytes to Kilobytes (1 KB = 1024 Bytes)
		long fileSizeInKB = fileSizeInBytes / 1024;
		// Convert the KB to MegaBytes (1 MB = 1024 KBytes)
		long fileSizeInMB = fileSizeInKB / 1024;

		if (fileSizeInMB > Max) {
			return true;
		}
		return false;
	}

	private static boolean mkdirs() {
		File file = new File(FOLDER_SAVE + "/" + TimeUtils.getNowForFile());
		if (!file.exists()) {
			file.mkdirs();
			return true;
		}
		return false;
	}

	public static String getFileName() {
		mkdirs();
		return FOLDER_SAVE + "/" + TimeUtils.getNowForFile() + "/" + NAME_FILE
				+ "-" + TimeUtils.getLongCurrentDate();
	}

	public static boolean checkProfileIsLoaded(String fileName) {

		File processCheck = new File(fileName);
		if (processCheck.exists()) {
			return false;
		} else {
			try {
				processCheck.createNewFile();
				return true;
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
		return false;

	}

	public static boolean delete(String fileName) throws Exception {
		File file = new File(fileName);
		logger.debug("delete:" + fileName);
		if (file.exists()) {
			if (logger.isDebugEnabled())
				logger.debug("delete profile temp: " + fileName);
			file.delete();
			return true;
		} else {
			logger.debug("khong ton tai:" + fileName);
		}
		return false;
	}

	public static void copyFolder(File src, File dest) throws IOException {

		if (src.isDirectory()) {

			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
				// Logs.info("Directory copied from " + src + " to "
				// + dest);
			}

			// list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}

		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}

			in.close();
			out.close();
			// Logs.info("File copied from " + src + " to " + dest);
		}
	}

	public static int readIntLine(String txtFile, boolean createFileIsNotFound,
			int defaultInt) {
		String line = readLine(txtFile, createFileIsNotFound, defaultInt + "");
		try {
			return Integer.parseInt(line);
		} catch (Exception ex) {
			return 0;
		}
	}

	/***
	 * @see <a href=
	 *      "https://stackoverflow.com/questions/453018/number-of-lines-in-a-file-in-java">
	 *      https://stackoverflow.com/questions/453018/number-of-lines-in-a-file

	 *      -in-java</a>
	 * @param txtFile
	 * @param defaultInt
	 * @return total line
	 * @throws IOException
	 */
	public static int countLine(String txtFile, int defaultInt)
			throws IOException {
		File file = new File(txtFile);
		if (!file.exists()) {
			return defaultInt;
		}
		InputStream is = new BufferedInputStream(new FileInputStream(txtFile));
		try {
			byte[] c = new byte[1024];

			int readChars = is.read(c);
			if (readChars == -1) {
				// bail out if nothing to read
				return 0;
			}

			// make it easy for the optimizer to tune this loop
			int count = 1;
			while (readChars == 1024) {
				for (int i = 0; i < 1024;) {
					if (c[i++] == '\n') {
						++count;
					}
				}
				readChars = is.read(c);
			}

			// count remaining characters
			while (readChars != -1) {
				// System.out.println(readChars);
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
				readChars = is.read(c);
			}

			return count == 0 ? 1 : count;
		} finally {
			is.close();
		}
	}

	public static int countLinesOld(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 1;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	public static int getIndex(String pathData, String emailFolder) {
		int i = 0;
		while (true) {
			i++;
			File file = new File(pathData + emailFolder + i);
			if (file.exists())
				continue;
			return i;

		}
	}

	public static int writeIntLine(String txtFile, int value) {
		File file = new File(txtFile);
		if (file.exists())
			file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(txtFile, false);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(value + "");
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;
	}

	public static String readLine(String txtFile, boolean createFileIsNotFound,
			String defaultStr) {
		if (createFileIsNotFound) {
			File file = new File(txtFile);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					logger.error(Common.EXCEPTION_MESSAGE + e);
					e.printStackTrace();
				}
				FileUtils.writeLine(txtFile, defaultStr + "", false);
				return defaultStr;
			}
		}

		BufferedReader br = null;
		String line = null;

		try {

			br = new BufferedReader(new FileReader(txtFile));
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty() && !line.equals(""))
					return line;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return line;
	}

	public static List<String> readLineToken(String txtFile) {
		return readLineToken(txtFile, false);
	}

	public static List<String> readLineToken(String txtFile, boolean isApp) {
		List<String> list = readLine(txtFile);
		List<String> listTokenEnable = new ArrayList<String>();
		try {
			if (list != null) {
				int countLine = 1;
				for (Iterator<String> iterator = list.iterator(); iterator
						.hasNext();) {
					String line = iterator.next();
					if (!line.isEmpty() && !line.equals("")
							&& !line.startsWith("#")) {
						if (isApp) {
							if (line.matches("[0-9]*|.*"))
								listTokenEnable.add(line);
						} else {
							// if (logger.isDebugEnabled())
							// logger.debug("line:"+line);
							listTokenEnable.add(line);
						}
					} else {
						if (logger.isDebugEnabled())
							logger.debug("line[" + (countLine)
									+ "] is invalidate:" + line + "___");
					}
					countLine++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listTokenEnable;
	}

	public static List<String> readLine(String txtFile) {
		return readLine(txtFile, true);
	}

	public static List<String> readLine(String txtFile, boolean acceptEmpty) {
		BufferedReader br = null;
		String line = "";
		List<String> list = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(txtFile));
			while ((line = br.readLine()) != null) {
				if (acceptEmpty) {
					list.add(line);
				} else {
					if (!line.isEmpty())
						list.add(line);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public static void writeLine(String txtFile, List<String> list) {
		if (list == null)
			return;
		try {
			File fout = new File(txtFile);
			FileOutputStream fos = new FileOutputStream(fout);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			int n = list.size();
			for (int i = 0; i < n; i++) {
				bw.write(list.get(i));
				if (i != n - 1)
					bw.newLine();
			}

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static final String FOLDER = "conf";
	public static final String FILE = "file";

	public static boolean checkFile(String fileName) {

		File folder = new File(FOLDER);
		if (!folder.exists()) {
			folder.mkdir();
		}
		// String pathFile = fileName;
		// if(logger.isDebugEnabled())
		logger.debug("pathFile:" + fileName);
		File fileRequest = new File(fileName);
		if (!fileRequest.exists()) {

			// FileWriter fileWriter = new FileWriter(fileName);
			// BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// if(logger.isDebugEnabled())
			logger.debug("write:" + 0);
			// bufferedWriter.write("0");
			// bufferedWriter.close();
			writeFile(0);
			// RandomAccessFile file = new RandomAccessFile(pathFile, "rw");
			// file.writeBytes("0");
			return true;

		}
		return true;
	}

	public static int readingFile() {
		return readingFile(FOLDER + "/" + FILE);
	}

	public static int readingFile(String fileName) {
		BufferedReader bufferedReader = null;
		FileReader reader = null;
		if (checkFile(fileName)) {
			try {
				reader = new FileReader(fileName);
				bufferedReader = new BufferedReader(reader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					if (logger.isDebugEnabled())
						logger.debug("line:" + line);
					bufferedReader.close();
					return Integer.parseInt(line);
				}
				bufferedReader.close();
				reader.close();
				return 0;
			} catch (IOException e) {
				if (bufferedReader != null)
					try {
						bufferedReader.close();
					} catch (IOException e1) {

						e1.printStackTrace();
						logger.error(Common.EXCEPTION_MESSAGE + e1);
					}
				e.printStackTrace();
				logger.error(Common.EXCEPTION_MESSAGE + e);
				return 0;
			}
		} else {
			return 0;
		}
	}

	public static void writeFile(int current) {
		writeFile(FOLDER + "/" + FILE, current);
	}

	public static void writeFile(String fileName, int current) {
		try {
			FileWriter writer = new FileWriter(fileName, false);
			if (logger.isDebugEnabled())
				logger.debug("current:" + current);
			writer.write(current + "");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(Common.EXCEPTION_MESSAGE + e);
		}
	}

	public static void writeToTxtFile(String fileJson, String json,
			String fileName, String content, boolean created) {
		writeToFile(fileJson, json, created);
		writeToFile(fileName, content, created);

	}

	public static void writeToTxtFile(String fileName, String content,
			boolean created) {
		if (fileName != null) {
			writeToFile(fileName, content, created);
		}

	}

	public static void appendToTxtFile(String fileName, String content,
			boolean appended, boolean terminatesTheLine) {
		synchronized (FileUtils.class) {

			// boolean isCreateNewFile = false;
			if (new File(fileName).exists() == false) {
				try {
					new File(fileName).createNewFile();
					// isCreateNewFile = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			PrintWriter writer = null;
			try {
				writer = new PrintWriter(new FileOutputStream(fileName,
						appended));
				if (terminatesTheLine) {
					writer.println(content);
				} else {
					writer.print(content);
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (writer != null)
					writer.close();
			}
		}
	}

	private static void writeToFile(String fileName, String content,
			boolean created) {
		writeToFile(fileName, content, created, true);
	}

	private static void writeToFile(String fileName, String content,
			boolean created, boolean overwrite) {
		if (overwrite == false) {
			if (new File(fileName).exists() == true)
				return;
		}
		if (created) {
			if (new File(fileName).exists() == false) {
				try {
					new File(fileName).createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		PrintWriter writer = null;
		try {
			// writer = new PrintWriter(fileName, "UTF-8");
			writer = new PrintWriter(new FileOutputStream(fileName, false));
			writer.println(content);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				writer.close();
		}

	}

	public static void writeToFileInModeThread(String fileName,
			String textToAppend, boolean created) {
		synchronized (FileUtils.class) {
			if (created) {
				if (new File(fileName).exists() == false) {
					try {
						new File(fileName).createNewFile();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
			}

			try {
				Path path = Paths.get(fileName);
				// Append mode
				Files.write(path, textToAppend.getBytes(),
						StandardOpenOption.APPEND);

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public static List<String> listFilesForFolder(final String pathname) {
		return listFilesForFolder(new File(pathname));
	}

	public static List<String> listFilesForFolder(final File folder) {
		List<String> list = new ArrayList<>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				logger.debug("getName:" + fileEntry.getName());
				logger.debug("getPath:" + fileEntry.getPath());
				list.add(fileEntry.getPath());
			}
		}
		return list;
	}
}
