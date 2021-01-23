package com.visionit.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class SendToFriendObjects {
	private static final Logger logger = LogManager.getLogger(SendToFriendObjects.class);

	private WebDriver driver;
	
	private By fadedTshirtShows = By.xpath("//img[contains(@src, 'img/p/1/1-large_default.jpg') ]");
	private By sendTofrndLink = By.xpath("//a[@id='send_friend_button']");
	private By nameOfFrnd = By.xpath("//input[@id='friend_name']");
	private By emailOfFrnd = By.xpath("//input[@id='friend_email']");
	private By sendBtn = By.xpath("//button[@id='sendEmail']");
	private By emailSentfrndMsg = By.xpath("//*[text()=\"Your e-mail has been sent successfully\"]");
	
	public SendToFriendObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void ValidateTshirtResult() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(fadedTshirtShows));
		boolean b = driver.findElement(fadedTshirtShows).isDisplayed();
		Assert.assertEquals(true, b);
		logger.info("shown result of faded T-shirts");
	}
	
	public void clickOnsendToAFrndlink() {
		driver.findElement(sendTofrndLink).click();
		logger.info("clicked on send to a friend link");
	}
	
	public void setSendToFrndNameAndEmail(String name, String email) {
		driver.findElement(nameOfFrnd).sendKeys(name);
		logger.info("entered name of friend as : " + name);
		driver.findElement(emailOfFrnd).sendKeys(email);
		logger.info("entered email as : " + email);
	}
	
	public void clickOnSendBtn() {
		driver.findElement(sendBtn).click();
		logger.info("clicked on send button");
	}
	
	public void validateWithMsg(String msg) {
		String b = driver.findElement(emailSentfrndMsg).getText();
		String expected = "Your e-mail has been sent successfully";
		Assert.assertEquals("validate with message", expected, b);
		logger.info("message dispaled as : " + expected);
	}
	
}
