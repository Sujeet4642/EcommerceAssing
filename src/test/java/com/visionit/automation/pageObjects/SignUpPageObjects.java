package com.visionit.automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class SignUpPageObjects {
	private static final Logger logger = LogManager.getLogger(SignUpPageObjects.class);
	
	private WebDriver driver;
	
	private By signIn = By.xpath("//a[@class='login']");
	private By emailBox = By.id("email_create");
	private By createAnAcc = By.id("SubmitCreate");
	//private By gender = By.id("id_gender");
	private By firstName = By.id("customer_firstname");
	private By lastName = By.id("customer_lastname");
	private By password = By.id("passwd");
	private By AddrFirstName = By.id("firstname");
	private By AddrLastName = By.id("lastname");
	private By address = By.id("address1");
	private By city = By.id("city");
	private By zipcode = By.id("postcode");
	private By country = By.id("id_country");
	private By mobile = By.id("phone_mobile");
	private By alias = By.id("alias");
	private By registerButn = By.id("submitAccount");
	
	public SignUpPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSignInBtn() {
		driver.findElement(signIn).click();
		logger.info("clicked on signIn");
	}
	
	public void emailId(String email) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(emailBox));
		driver.findElement(emailBox).sendKeys(email);
		logger.info("Email for registration : " + email);
	}
	
	public void clickOncreateAnAccBtn() {
		driver.findElement(createAnAcc).click();
		logger.info("clicked on create an account button");
	}
	
	public void validateFormFillingTitle() {
		String expectedTitle = "Login - My Store";
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		boolean b = wait1.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("title", true, b);
		logger.info("Match Title of Registration page as : " + expectedTitle );
	}
	
	
	public void fillDetails() {
		//driver.findElement(gender).click();
		driver.findElement(firstName).sendKeys("sujeet");
		logger.info("Entered first name");
		driver.findElement(lastName).sendKeys("rajput");
		logger.info("Entered last name");
		driver.findElement(password).sendKeys("suj123");
		logger.info("Entered password");
		driver.findElement(AddrFirstName).clear();
		driver.findElement(AddrFirstName).sendKeys("sujeet");
		logger.info("Entered first name");
		driver.findElement(AddrLastName).clear();
		driver.findElement(AddrLastName).sendKeys("rajput");
		logger.info("Entered last name");
		driver.findElement(address).sendKeys("boston appartements");
		logger.info("Entered address");
		driver.findElement(city).sendKeys("newyork");
		logger.info("Entered city");
		
		
		WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
		Select sel = new Select(state);
		sel.selectByValue("32");
		logger.info("State is selected");
		
		driver.findElement(zipcode).sendKeys("12345");
		logger.info("Entered zipcode");
		driver.findElement(country);
		logger.info("Entered country");
		driver.findElement(mobile).sendKeys("8871304642");
		logger.info("Entered mobile no.");
		driver.findElement(alias).clear();
		driver.findElement(alias).sendKeys("boston");
	}
	
	public void clickOnRegisterbtn() {
		driver.findElement(registerButn).click();
		logger.info("clicked on register button");
	}
	
	public void validateAccCreatedTitle() {
		String expectedTitle= "My account - My Store";
		WebDriverWait wait = new WebDriverWait(driver,20);
		boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals("title", true, b);
		logger.info("Match Title of Created Account page as : " + expectedTitle );
	}
}
