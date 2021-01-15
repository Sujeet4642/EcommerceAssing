package com.visionit.automation.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.visionit.automation.core.WebDriverFactory;
import com.visionit.automation.pageObjects.ColourChangeObjects;
import com.visionit.automation.pageObjects.LogInPageObjects;
import com.visionit.automation.pageObjects.SignUpPageObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {

	WebDriver driver;
	String baseUrl = "http://automationpractice.com";
	int implicitWaitTimeOutInSec = 20;
	Scenario scn;
	
	SignUpPageObjects signUpPageObj;
	LogInPageObjects logInPageObj;
	ColourChangeObjects colourChangeObj;
	
	@Before
	public void Setup(Scenario scn) throws Exception{
		this.scn = scn;
		String browser_name = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browser_name);
		
		signUpPageObj = new SignUpPageObjects(driver);
		logInPageObj = new LogInPageObjects(driver);
		colourChangeObj = new ColourChangeObjects(driver);
	}
	
	@After(order=1)
	public void cleanUp() {
		WebDriverFactory.quitDriver();
	}
	
	@After(order=2)
	public void takeSreenShot(Scenario s) {
		if(s.isFailed()) {
			TakesScreenshot srnshot = (TakesScreenshot)driver;
			byte[] data = srnshot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "failed step name: " + s.getName());
		}
		else {
			scn.log("Test case is passed, no screen shot captured");
		}
	}
	
	
	//signUp steps...................
	

@Given("User navigated to the home application url")
public void user_navigated_to_the_home_application_url() {
   WebDriverFactory.navigateToUrl(baseUrl);
}

@When("User clicks on sign up link of the application")
public void user_clicks_on_sign_up_link_of_the_application() {
    signUpPageObj.clickOnSignInBtn();
}

@When("User enters email address as {string} and clicks on Create an account button")
public void user_enters_email_address_as_and_clicks_on_create_an_account_button(String string) {
    signUpPageObj.emailId(string);
    signUpPageObj.clickOncreateAnAccBtn();
}

@When("User is able to fill the details in the form and clicks on Register button")
public void user_is_able_to_fill_the_details_in_the_form_and_clicks_on_register_button() {
  signUpPageObj.validateFormFillingTitle();
  signUpPageObj.fillDetails();
  signUpPageObj.clickOnRegisterbtn();
}

@Then("User account is created")
public void user_account_is_created() {
   signUpPageObj.validateAccCreatedTitle();
}

//login steps..........................


@When("User enters email address as {string} and password as {string} and clicks on Signin button")
public void user_enters_email_address_as_and_password_as_and_clicks_on_signin_button(String email, String pass) {
    logInPageObj.clickOnSignLink();
    logInPageObj.SetloginIdAndPass(email, pass);
    logInPageObj.clickOnSignInBtn();
}


@Then("User is login in the account")
public void user_is_login_in_the_account() {
    logInPageObj.ValidateUserIsLoggedIn();
}

	
//Colour change steps...................



@When("User click on Tshirt link of the application")
public void user_click_on_tshirt_link_of_the_application() {
   colourChangeObj.clickOnTshirtLink();
   colourChangeObj.validateTshirtPage();
}

@When("User clicks on the product as Faded short sleeves Tshirt")
public void user_clicks_on_the_product_as_faded_short_sleeves_tshirt() {
    colourChangeObj.selectFadedTshirt();
    colourChangeObj.validateFadedTshirtResult();
}

@When("User clicks on colour blue link")
public void user_clicks_on_colour_blue_link() {
   colourChangeObj.selectcolour();
}

@Then("User is displayed Tshirt with blue colour")
public void user_is_displayed_tshirt_with_blue_colour() {
	colourChangeObj.validateBlueColourTshirtResult();
   }

//send to friend.................
@Then("User is able to see result")
public void user_is_able_to_see_result() {
  
}

@When("User clicks on Send to a friend link of the application and clicks on send button")
public void user_clicks_on_send_to_a_friend_link_of_the_application_and_clicks_on_send_button() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("User is displayed with the message as {string}")
public void user_is_displayed_with_the_message_as(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}
