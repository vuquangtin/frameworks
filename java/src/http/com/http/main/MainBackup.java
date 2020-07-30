package com.http.main;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class MainBackup {
	public static void main(String[] args) throws IOException {
		String url="https://trithucvn.net/the-gioi/ong-joe-biden-tung-ngan-can-nguoi-ti-nan-viet-nam-den-my-nam-1975.html";
		processCrawling_kompas(url);
	}

	public static void processCrawling_kompas(String URL) {
		try {
			Connection.Response response = Jsoup.connect(URL).timeout(0)
					.execute();
			int statusCode = response.statusCode();
			if (statusCode == 200) {
				Document dok = Jsoup.connect(URL).userAgent("Mozilla/5.0")
						.timeout(0).get();
				System.out.println("opened page: " + URL);

				Elements nextPages = dok.select("a");
				for (Element nextPage : nextPages) {
					if (nextPage != null) {
						if (nextPage.attr("href").contains("bola.kompas.com")) {
							processCrawling_kompas(nextPage.attr("abs:href"));
						}
					}
				}
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HttpStatusException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}