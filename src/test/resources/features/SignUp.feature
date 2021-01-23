@ui @signUp
Feature: E-Commerce Shopping features
   
  Scenario: User is able to sign up in the application
   Given User navigated to the home application url
    When User clicks on sign up link of the application
    And  User enters email address as "sujeet55s1990@gmail.com" and clicks on Create an account button
    And  User is able to fill the details in the form and clicks on Register button 
    Then User account is created
   
    

 
  