package com.visionit.automation.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static WebDriver driver=null;
	
	public static WebDriver getWebDriverForBrowser(String browser) throws Exception {
		switch(browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			default:
				throw new Exception("No such browser is implemented.Browser name sent: " + browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void navigateToUrl(String url) {
		driver.get(url);
	}
	
	public static void quitDriver() {
		driver.quit();
	}
	
	public static String getBrowserName() {
		String browserDefault = "chrome";
		String browserSentFromCommand = System.getProperty("browser");
		
		if(browserSentFromCommand==null) {
			return browserDefault;
		}
		else {
			return browserSentFromCommand;
		}
	}
	
		
}
