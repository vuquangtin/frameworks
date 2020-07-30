package com.http.htmlunit;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * mvn -U clean install
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class HtmlUnitMain {

	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException,
			IOException {
		String url = "https://trithucvn.net/trung-quoc/vien-cung-di-cac-dang-vien-dcstq-deu-muon-o-lai-nuoc-ngoai.html";
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setJavaScriptEnabled(true);
		// enable javascript
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		// even if there is error in js continue
		webClient.waitForBackgroundJavaScript(5000);
		// important! wait when javascript finishes rendering
		HtmlPage page = webClient.getPage(url);
		System.out.println(page.asText());
		// page.getElementById("tournamentTable");
		System.out.println(page.getTitleText());

	}

}
