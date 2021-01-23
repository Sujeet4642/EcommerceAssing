@ui @journey
Feature: E-Commerce Shopping features

Background: Navigation to the url
  Given User navigated to the home application url
  
Scenario: User is able to shop for Tshirt for selected quantity and size 
 When User click on Tshirt link of the application 
 And  User clicks on the product as Faded short sleeves Tshirt 
 And User clicks on quantity and increase the quantity to two
 And User clicks on dropdown and select size to L and clicks on Add to cart button
 Then User is displayed Tshirt with twice the quantity and selected size
  
  
Scenario: User is able to add Tshirt in AddToCart
  When User click on Tshirt link of the application
  And  User clicks on the product as Faded short sleeves Tshirt 
  And User clicks on quantity and increase the quantity to two
  And User clicks on dropdown and select size to L and clicks on Add to cart button
  Then User sees the Pop Up that Product Successfully Added to Cart
  And  Check Total Price is twice the amount fetched earlier
  
  
 Scenario: User is able to shop for selected item
 When User click on Tshirt link of the application
 And  User clicks on the product as Faded short sleeves Tshirt 
 And User clicks on quantity and increase the quantity to two
 And User clicks on dropdown and select size to L and clicks on Add to cart button
 And User clicks on Proceed to Checkout
 And User Click on Proceed to Check out again and reach till payment and click on Terms and condition check box
 And User On Payment Page click on Pay by bank wire and Click on I confirm my Order
 Then User displayed with message "Your order on My Store is complete."
 