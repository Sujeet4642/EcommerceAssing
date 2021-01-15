@ui @login
Feature: E-Commerce Shopping features

 Background: Navigation to the URL
  Given User navigated to the home application url
  
  Scenario: User is able to login in the application
    When  User clicks on sign up link of the application
    And   User enters email address as "sujeet46s1990@gmail.com" and password as "suj123" and clicks on Signin button
    Then  User is login in the account

 