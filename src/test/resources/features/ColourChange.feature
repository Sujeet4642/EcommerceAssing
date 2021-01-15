@ui @colour
Feature: E-Commerce Shopping features
 
  Background: Navigation to the url
  Given User navigated to the home application url
  
 Scenario: User is able to select Tshirt colour
    When User click on Tshirt link of the application 
    And  User clicks on the product as Faded short sleeves Tshirt 
    And User clicks on colour blue link 
    Then User is displayed Tshirt with blue colour
 