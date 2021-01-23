package com.visionit.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;

public class UserJourneyObjects {
	
	private WebDriver driver;
	
	//private By quantity = By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']");
	private By Setquantity = By.id("quantity_wanted");
	private By addToCart = By.xpath("//p[@id='add_to_cart']");
	private By validateSize = By.xpath("//*[text()=\"Orange, L\" and @id='layer_cart_product_attributes']");
	private By validateQuantity = By.xpath("//*[@id='layer_cart_product_quantity']");
	private By validateTshirtsPrice = By.xpath("//span[@class='ajax_block_cart_total' and text()=\"$35.02\"]");
	private By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");
	//private By validateCheckout = By.xpath("//h1[@id='cart_title']");
	private By proceedToCheckoutAgain = By.xpath("//a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']");
	private By priceTotal = By.xpath("//span[@id='total_price']");
	private By finalProceedBtn = By.xpath("//button[@name='processAddress']");
	private By checkBox = By.id("cgv");
	private By payBankWire = By.xpath("//a[@title='Pay by bank wire']");
	private By orderConfirmBtn = By.xpath("//button[@class='button btn btn-default button-medium' and @type='submit']");
	private By logIn = By.id("email");
	private By pass = By.id("passwd");
	private By signInBtn = By.id("SubmitLogin");
	private By proceedBtnEnd = By.xpath("//button[@name='processCarrier']");
	private By orderCompleteText= By.xpath("//*[text()=\"Your order on My Store is complete.\"]");
	
	
	
	public UserJourneyObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectQuantityTwo() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(Setquantity));
		driver.findElement(Setquantity).clear();
		driver.findElement(Setquantity).sendKeys("2");
		driver.findElement(Setquantity).click();
	}
	
	
	public void selectTshirtSize() {
		WebElement sizeSelection = driver.findElement(By.id("group_1"));
		Select sel = new Select(sizeSelection);
		sel.selectByValue("3");
	}
	
    public void clickOnAddToCart() {
		driver.findElement(addToCart).click();
	}
    
    public void validateSizeOfTshirt() {
    	String b = driver.findElement(validateSize).getText();
    	String expected = "Orange, L";
    	Assert.assertEquals("validate size", expected, b);
    }
    
     public void validateQuantityOfTshirt() {
    	 String b = driver.findElement(validateQuantity).getText();
    	 String expected = "2"; 
    	Assert.assertEquals("validateQuantity", expected, b);
    }
     
     public void validateTwoTshirtsPrice() {
    	 String b = driver.findElement(validateTshirtsPrice).getText();
    	 String expected = "$35.02";
    	 Assert.assertEquals("Tshirts price match", expected, b);
     }
     
     public void clickOnProceedToCheckout() {
    	 driver.findElement(proceedToCheckout).click();
     }
     
     public void validateCheckOutPage() {
    	 String expected = "Order - My Store";
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
    	 boolean b = wait.until(ExpectedConditions.titleContains(expected));
    	 Assert.assertEquals(true, b);
     }
     
     public void matchPrice() {
    	 String b = driver.findElement(priceTotal).getText();
    	 String expected = "$35.02";
    	 Assert.assertEquals("Price check", expected, b);
     }
     
     public void clickOnProceedToCheckOutAgain() {
    	 driver.findElement(proceedToCheckoutAgain).click();
     }
     
     public void setLogInBox() {
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
    	 wait.until(ExpectedConditions.elementToBeClickable(logIn));
    	 driver.findElement(logIn).sendKeys("sujeet22s1990@gmail.com");
    	 driver.findElement(pass).sendKeys("suj123");
    	 driver.findElement(signInBtn).click();
     }
     
     public void clickLastProceedToCheckoutBtn() {
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
    	 wait.until(ExpectedConditions.elementToBeClickable(finalProceedBtn));
    	 driver.findElement(finalProceedBtn).click();
     }
     
     public void clickOnCheckBox() {
    	 driver.findElement(checkBox).click();
     }
     
     public void clickonCheckOutEnd() {
    	WebDriverWait wait = new WebDriverWait(driver, 20) ;
    	wait.until(ExpectedConditions.elementToBeClickable(proceedBtnEnd));
    	driver.findElement(proceedBtnEnd).click();
     }
     
    
     public void clickOnPayByBankWireLink() {
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
    	 wait.until(ExpectedConditions.elementToBeClickable(payBankWire));
    	 driver.findElement(payBankWire).click();
     }
     
     public void clickOnIconfirmOrderBtn() {
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
    	 wait.until(ExpectedConditions.elementToBeClickable(orderConfirmBtn));
    	 driver.findElement(orderConfirmBtn).click();
     }
     
     public void validateOrderConfirmationPage() {
    	 String expected = "Order confirmation - My Store";
    	 WebDriverWait wait = new WebDriverWait(driver, 20);
    	 boolean b = wait.until(ExpectedConditions.titleContains(expected));
    	 Assert.assertEquals("Title Match", true, b);
     }
     
     public void validateOrderConfirmationText() {
    	 String b = driver.findElement(orderCompleteText).getText();
    	 String expected = "Your order on My Store is complete.";
    	 Assert.assertEquals("text verification", expected, b);
     }

}
