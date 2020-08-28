package com.swing.download.images;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class EarthWallpapers {
	static int var = 0;
	static HashSet<String> hs;

	public static void main(String[] args) throws IOException,
			BadLocationException {
		String site = readLine();
		hs = new HashSet<String>();
		hs.add(site);
		start(site);
	}

	public static void start(String site) throws IOException,
			BadLocationException {
		// System.out.println(site);
		URL url = new URL(site);
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				httpcon.getInputStream()));
		HTMLEditorKit hek = new HTMLEditorKit();
		HTMLDocument hd = (HTMLDocument) hek.createDefaultDocument();
		hek.read(br, hd, 0);
		HTMLDocument.Iterator iterator = hd.getIterator(HTML.Tag.A);
		for (; iterator.isValid(); iterator.next()) {
			AttributeSet attributes = iterator.getAttributes();
			String imgSrc = (String) attributes
					.getAttribute(HTML.Attribute.HREF);
			// System.out.println(imgSrc);
			if (imgSrc != null) {
				String lower = imgSrc.toLowerCase();
				String goDeeper = "https://www.reddit.com/r/EarthPorn/comments/";
				// If we need to recurse further to get the pictures.
				if (imgSrc.contains(goDeeper)) {
					int size = hs.size();
					hs.add(imgSrc);
					// Don't want to revisit the same site multiple times.
					if (size != hs.size()) {
						start(imgSrc);
					}
				} else if (lower.contains("redd.it/")
						&& ((lower.contains(".jpg") || (lower.contains(".png"))
								|| (lower.contains(".jpeg"))
								|| (lower.contains(".bmp")) || (lower
									.contains(".ico"))))) {
					// only trying to get pictures from Reddit, not actually any
					// images from the comments.
					// Can remove the first part to grab all pictures (including
					// comments)
					try {
						downloadImage(site, imgSrc);
					} catch (IOException ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		}
	}

	public static void downloadImage(String site, String imageS)
			throws IOException {
		BufferedImage image = null;
		try {
			site = imageS.startsWith("http") ? imageS : site + imageS;
			imageS = imageS.substring(imageS.lastIndexOf("/") + 1);
			String imageFormat = null;
			imageFormat = imageS.substring(imageS.lastIndexOf(".") + 1);
			String imgPath = null;
			String home = System.getProperty("user.home");
			imgPath = home + File.separator + "Desktop" + File.separator
					+ "RedditPics";
			System.out.println(imgPath);
			URL imageUrl = new URL(site);
			image = ImageIO.read(imageUrl);
			if (image != null) {
				String x = "newim" + var + "." + imageFormat;
				File file = new File(imgPath + File.separator + x);
				if (!file.mkdir()) {
					file.mkdirs();
				}
				System.out.println(x);
				ImageIO.write(image, imageFormat, file);
				++var;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	final private static int BUFFER_SIZE = 1 << 16;
	private static DataInputStream din = new DataInputStream(System.in);
	private static byte[] buffer = new byte[BUFFER_SIZE];
	private static int bufferPointer = 0, bytesRead = 0;
	static PrintWriter pr = new PrintWriter(new BufferedWriter(
			new OutputStreamWriter(System.out)));

	public static String readLine() throws IOException {
		byte[] buf = new byte[1000000]; // line length
		int cnt = 0, c;
		while ((c = Read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public static String read() throws IOException {
		byte[] ret = new byte[1024];
		int idx = 0;
		byte c = Read();
		while (c <= ' ') {
			c = Read();
		}
		do {
			ret[idx++] = c;
			c = Read();
		} while (c != -1 && c != ' ' && c != '\n' && c != '\r');
		return new String(ret, 0, idx);
	}

	public static int readInt() throws IOException {
		int ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public static long readLong() throws IOException {
		long ret = 0;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public static double readDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = Read();
		while (c <= ' ')
			c = Read();
		boolean neg = (c == '-');
		if (neg)
			c = Read();

		do {
			ret = ret * 10 + c - '0';
		} while ((c = Read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = Read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private static void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private static byte Read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}

	static void print(Object o) {
		pr.print(o);
	}

	static void println(Object o) {
		pr.println(o);
	}

	static void flush() {
		pr.flush();
	}

	static void println() {
		pr.println();
	}

	static void exit() throws IOException {
		din.close();
		pr.close();
		System.exit(0);
	}
}