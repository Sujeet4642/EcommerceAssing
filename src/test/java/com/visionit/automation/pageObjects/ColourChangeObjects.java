package com.visionit.automation.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColourChangeObjects {
	private static final Logger logger = LogManager.getLogger(ColourChangeObjects.class);

	
	private WebDriver driver;
	
	//ul[@class='submenu-container clearfix first-in-line-xs']//a[@title='T-shirts']
	private By TshirtLink = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");
    private By FadedTshirt=By.xpath("//a[@title='Faded Short Sleeve T-shirts' and @ class='product-name']");
    private By BlueColour=By.id("color_14");
    private By ValidateBlueTshirt = By.xpath("//img[contains(@src,  'img/p/3/3-large_default.jpg')]");
    
    public ColourChangeObjects(WebDriver driver) {
    	this.driver = driver;
    }
    
    public void clickOnTshirtLink() {
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.elementToBeClickable(TshirtLink));
    	driver.findElement(TshirtLink).click();
    	logger.info("clicked on Tshirt link");
    }
    
    public void validateTshirtPage() {
    	String  expectedTitle  = "T-shirts - My Store";
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
    	Assert.assertEquals("Title match", true, b);
    	logger.info("Tshirt page title match as : " + expectedTitle);
    }
    
    public void selectFadedTshirt() {
    	driver.findElement(FadedTshirt).click();
    	logger.info("clicked on faded Tshirt category");
    }
    
    public void validateFadedTshirtResult() {
    	String expectedTitle = "Faded Short Sleeve T-shirts - My Store";
    	WebDriverWait wait = new WebDriverWait(driver,20);
    	boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
    	Assert.assertEquals("title match", true, b);
    	logger.info("Faded Tshirt page tile match as : " +expectedTitle);
    }
    
    public void selectcolour() {
    	driver.findElement(BlueColour).click();
    	logger.info("clicked on blue colour box for selectection of blue colour tshirt");
    }
    
    public void validateBlueColourTshirtResult() {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.elementToBeClickable(BlueColour));
    	boolean b = driver.findElement(ValidateBlueTshirt).isDisplayed();
    	Assert.assertEquals("Validate It Shows blue tshirt", true, b);
    	logger.info("Displayed Tshirt with blue colour");
    }
}
