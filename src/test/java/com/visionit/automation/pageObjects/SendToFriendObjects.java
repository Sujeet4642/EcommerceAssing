package com.visionit.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;

public class SendToFriendObjects {

	private WebDriver driver;
	
	private By sendTofrndLink = By.xpath("//a[@id='send_friend_button']");
	private By fadedTshirtShown = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"); 	
	public SendToFriendObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ValidateTshirtResult() {
		boolean b = driver.findElement(fadedTshirtShown).isDisplayed();
		Assert.assertEquals(true, b);
	}
}
