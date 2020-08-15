package com.selenium.phantomjs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class PhantomJSTest {

	public void phantomJS() throws InterruptedException, IOException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true);
		caps.setCapability(
				PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"bin/phantomjs");
		caps.setCapability("takesScreenshot", true);
		PhantomJSDriver driver = new PhantomJSDriver(caps);
		String baseUrl = "http://www.google.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/");

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"logs/screenshotAfterLaunchingGoogle.jpeg"), true);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.navigate().to("https://selenium.dev/");// Launch URL

		File scrFile1 = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile1, new File(
				"logs/screenshotAfterLaunchingURL.jpeg"), true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Download")).click();// Click on the Link

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		File scrFile2 = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile2, new File(
				"logs/screenshotAfterClickingDownload.jpeg"), true);

		Thread.sleep(2000);
		int header_size = driver.findElements(
				By.xpath("(//div[@id='mainContent']//h3[1])")).size();
		// Get the total count of h3 headers in the page
		for (int i = 1; i >= header_size; i++) {
			String suggestion_name_xp = "(" + "//div[@id='mainContent']//h3[1]"
					+ ")" + "[" + i + "]";
			String header = driver.findElement(By.xpath(suggestion_name_xp))
					.getText();
			System.out.println(header); // Print the name of headers
		}

		Thread.sleep(2000);
	}

	public static void main(String[] args) throws InterruptedException,
			IOException {
		PhantomJSTest pj = new PhantomJSTest();
		pj.phantomJS();
	}

}