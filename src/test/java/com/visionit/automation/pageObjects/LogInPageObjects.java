package com.visionit.automation.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class LogInPageObjects {
	private static final Logger logger = LogManager.getLogger(LogInPageObjects.class);
	
	private WebDriver driver;
	
	private By signInlink = By.xpath("//a[@class='login']");
	private By logInEmail = By.id("email");
	private By logInpass = By.id("passwd");
	private By signInBtn = By.id("SubmitLogin"); 
	private By validateAcc = By.xpath("//a[@class='account']"); 
	
	
	public LogInPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnSignLink() {
		driver.findElement(signInlink).click();
		logger.info("clicked on signIn link");
	}
	
	public void SetloginIdAndPass(String email,String pass) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(logInEmail));
		driver.findElement(logInEmail).sendKeys(email);
		logger.info("entered email as : " + email);
		driver.findElement(logInpass).sendKeys(pass);
		logger.info("entered password");
	}
	
	
	public void clickOnSignInBtn() {
		driver.findElement(signInBtn).click();
		logger.info("clicked on signIn button");
	}
	
	public void ValidateUserIsLoggedIn() {
		//String expected = "My account - My Store";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(validateAcc));
        boolean b = driver.findElement(validateAcc).isDisplayed();
        Assert.assertEquals("log in to account successfully", true, b);
        logger.info("user loggedIn in their account");
		//boolean b = wait.until(ExpectedConditions.titleContains(expected));
		//Assert.assertEquals("My account title match" , true, b);
	}
	

}
