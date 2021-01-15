@ui @review
Feature: E-Commerce Shopping features
 
  Background: Navigation to the url
  Given User navigated to the home application url
  
 Scenario: User is able to select Tshirt
    When User click on Tshirt link of the application 
    And  User clicks on the product as Faded short sleeves Tshirt 
    And User clicks on send a review link and fill details
    Then User is displayed with the message as "New Comment added"
 
  
      |