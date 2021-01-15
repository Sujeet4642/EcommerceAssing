@ui @journey
Feature: E-Commerce Shopping features

 Background: Navigation to the url
  Given User navigated to the home application url
  
  Scenario: User is able to shop for Tshirt for two quantity
   When User click on Tshirt link of the application 
    And  User clicks on the product as Faded short sleeves Tshirt 
    And User clicks on quantity and increase the quantity to "2"
    Then User is displayed Tshirt with blue colour and quantity to "2"
     
  Scenario: User is able to shop for Tshirt sizewise 
   When User click on Tshirt link of the application 
    And  User clicks on the product as Faded short sleeves Tshirt 
    And User clicks on dropdown and select size to L and clicks on Add to cart button
    Then User is displayed Tshirt with twice the quantity and selected size
  
  
   Scenario Outline: User is able to shop for Tshirt
    Given User navigated to the home application url
    When User clicks on "<Tshirt link>"
    Then User is navigates to the corresponding link realted to "<Tshirt link>"

    Examples:
    |Tshirt link|
    |Faded short sleeve Tshirt|
    |Quantity                 |
    |Size                     |
    |Add To cart              |
    |Proceed to checkout      |
    |Proceed to Checkout again|
    |click on checkbox        |
    |Pay by bank wire         |
    | I confirm my Order      |
 