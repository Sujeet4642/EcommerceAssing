package com.visionit.automation.stepdefs;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.visionit.automation.core.WebDriverFactory;
import com.visionit.automation.pageObjects.ColourChangeObjects;
import com.visionit.automation.pageObjects.LogInPageObjects;
import com.visionit.automation.pageObjects.SendToFriendObjects;
import com.visionit.automation.pageObjects.SignUpPageObjects;
import com.visionit.automation.pageObjects.UserJourneyObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs {
	private static final Logger logger = LogManager.getLogger(Stepdefs.class);

	WebDriver driver;
	String baseUrl = "http://automationpractice.com";
	int implicitWaitTimeOutInSec = 20;
	Scenario scn;
	
	SignUpPageObjects signUpPageObj;
	LogInPageObjects logInPageObj;
	ColourChangeObjects colourChangeObj;
	SendToFriendObjects sendToFriendObj;
	UserJourneyObjects userJourneyObj;
	
	@Before
	public void Setup(Scenario scn) throws Exception{
		this.scn = scn;
		String browser_name = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browser_name);
		logger.info("browser invoked");
		
		signUpPageObj = new SignUpPageObjects(driver);
		logInPageObj = new LogInPageObjects(driver);
		colourChangeObj = new ColourChangeObjects(driver);
		sendToFriendObj = new SendToFriendObjects(driver);
		userJourneyObj = new UserJourneyObjects(driver);
	}
	
	@After(order=1)
	public void cleanUp() {
		WebDriverFactory.quitDriver();
		logger.info("browser closed");
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
   logger.info("navigated to Url : " + baseUrl);
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
   sendToFriendObj.ValidateTshirtResult(); 
}

@When("User clicks on Send to a friend link of the application and User enters name as {string} and email address as {string} and clicks on send button")
public void user_clicks_on_send_to_a_friend_link_of_the_application_and_user_enters_name_as_and_email_address_as_and_clicks_on_send_button(String name, String email) {
	sendToFriendObj.clickOnsendToAFrndlink();
    sendToFriendObj.setSendToFrndNameAndEmail(name, email);
    sendToFriendObj.clickOnSendBtn();
}

@Then("User is displayed with the message as {string}")
public void user_is_displayed_with_the_message_as(String message) {
   sendToFriendObj.validateWithMsg(message);
}


//user journey...............

@When("User clicks on quantity and increase the quantity to two")
public void user_clicks_on_quantity_and_increase_the_quantity_to_two() {
    userJourneyObj.selectQuantityTwo();
}

@When("User clicks on dropdown and select size to L and clicks on Add to cart button")
public void user_clicks_on_dropdown_and_select_size_to_l_and_clicks_on_add_to_cart_button() {
   userJourneyObj.selectTshirtSize();
   userJourneyObj.clickOnAddToCart();
}

@Then("User is displayed Tshirt with twice the quantity and selected size")
public void user_is_displayed_tshirt_with_twice_the_quantity_and_selected_size() {
   userJourneyObj.validateSizeOfTshirt();
   userJourneyObj.validateQuantityOfTshirt(); 
}

@Then("User sees the Pop Up that Product Successfully Added to Cart")
public void user_user_sees_the_pop_up_that_product_successfully_added_to_cart() {
	userJourneyObj.AddedToCartIconIsDisplayed();
}

@Then("Check Total Price is twice the amount fetched earlier")
public void check_total_price_is_twice_the_amount_fetched_earlier() {
	userJourneyObj.validateTwoTshirtsPrice();
	
 
}

@When("User clicks on Proceed to Checkout")
public void user_clicks_on_proceed_to_checkout() {
	 userJourneyObj.clickOnProceedToCheckout();
	
}

@When("User Click on Proceed to Check out again and reach till payment and click on Terms and condition check box")
public void user_click_on_proceed_to_check_out_again_and_reach_till_payment_and_click_on_terms_and_condition_check_box() {
	userJourneyObj.validateCheckOutPage();
	userJourneyObj.matchPrice();
    userJourneyObj.clickOnProceedToCheckOutAgain();
    userJourneyObj.setLogInBox();
    userJourneyObj.clickLastProceedToCheckoutBtn();
    userJourneyObj.clickOnCheckBox();
    userJourneyObj.clickonCheckOutEnd();
}

@When("User On Payment Page click on Pay by bank wire and Click on I confirm my Order")
public void user_on_payment_page_click_on_pay_by_bank_wire_and_click_on_i_confirm_my_order() {
   userJourneyObj.clickOnPayByBankWireLink();
   userJourneyObj.clickOnIconfirmOrderBtn();
}

@Then("User displayed with message {string}")
public void user_displayed_with_message(String string) {
   userJourneyObj.validateOrderConfirmationPage();
   userJourneyObj.validateOrderConfirmationText();
}


/*@When("User clicks on {string}")
public void user_clicks_on(String string) {
   userJourneyObj.clickOnProceedToCheckout();
   userJourneyObj.validateCheckOutPage();
   userJourneyObj.matchPrice();
   userJourneyObj.clickOnProceedToCheckOutAgain();
   userJourneyObj.setLogInBox();
   userJourneyObj.clickLastProceedToCheckoutBtn();
   userJourneyObj.clickOnCheckBox();
   userJourneyObj.clickonChekOutEnd();
   userJourneyObj.clickOnPayByBankWireLink();
   userJourneyObj.clickOnIconfirmOrderBtn();
   
}

@Then("User is navigates to the corresponding link realted to {string}")
public void user_is_navigates_to_the_corresponding_link_realted_to(String string) {
	userJourneyObj.validateOrderConfirmationPage();
	userJourneyObj.validateOrderConfirmationText();
}*/



}
