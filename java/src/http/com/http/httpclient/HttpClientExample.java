package com.http.httpclient;

import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class HttpClientExample {
	public static void main(String args[]) throws Exception {
		String url = "https://trithucvn.net/trung-quoc/vien-cung-di-cac-dang-vien-dcstq-deu-muon-o-lai-nuoc-ngoai.html";
		// Creating a HttpClient object
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// Creating a HttpGet object
		HttpGet httpget = new HttpGet(url);
		// Executing the Get request
		HttpResponse httpresponse = httpclient.execute(httpget);
		Scanner sc = new Scanner(httpresponse.getEntity().getContent());
		// Instantiating the StringBuffer class to hold the result
		StringBuffer sb = new StringBuffer();
		while (sc.hasNext()) {
			sb.append(sc.next());
			// System.out.println(sc.next());
		}
		// Retrieving the String from the String Buffer object
		String result = sb.toString();
		System.out.println(result);
		// Removing the HTML tags
		result = result.replaceAll("<[^>]*>", "");
		System.out.println("Contents of the web page: " + result);
	}
}