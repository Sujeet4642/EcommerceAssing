@ui @send
Feature: E-Commerce Shopping features
  
  Background: Navigation to the url
  Given User navigated to the home application url
  When User click on Tshirt link of the application
  And  User clicks on the product as Faded short sleeves Tshirt
  
  Scenario: User is able to select Tshirt  
    Then User is able to see result
    
  Scenario: User is able to sent Tshirt to the friend
  And User clicks on Send to a friend link of the application and clicks on send button
  Then User is displayed with the message as "Your e-mail has been sent successfully"
   