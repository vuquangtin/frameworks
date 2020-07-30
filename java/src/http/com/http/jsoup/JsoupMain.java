package com.http.jsoup;

import java.io.IOException;

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
public class JsoupMain {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		String url = "https://trithucvn.net/trung-quoc/vien-cung-di-cac-dang-vien-dcstq-deu-muon-o-lai-nuoc-ngoai.html";
		new JsoupMain(url).fetch();

	}

	String url;
	int timeOut = 30;

	public JsoupMain(String url) {
		this.url = url;
	}

	private void fetch() throws IOException, InterruptedException {
		Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:79.0) Gecko/20100101 Firefox/79.0")
				.ignoreHttpErrors(true).timeout(timeOut * 1000).get(); // s
		System.out.println(document.title());
		System.out.println(document.html());

	}

}
