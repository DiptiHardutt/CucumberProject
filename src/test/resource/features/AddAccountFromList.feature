@AddAccountFeature
Feature: Codefios Add Account functionality from List Account
  
Background: 
  Given User is on the codefios login page
  When User enters "username" from mysql database
  When User enters "password" from mysql database
  And User clicks on sign in button
  Then User should be able to land on dashboard page
  
  
@AddAccount
  Scenario Outline: User shouldbe able to Add account from List Account Page
   When User clicks on List Account button
   Then User should be able to land on List Account page 
   When User clicks on Add Account button
   Then User should be able to navigate to New Account window
   When User fill the AccountName as "<accountName>"
   When User fill the Description as "<description>"
   When User fill the Balance as "<balance>"
   When User fill the AccountNumber as "<accountNumber>"
   When User fill the ContactPerson as "<contactPerson>"
   And User clicks on the save button
   Then User should be able to land on List Account page
   Then User should be able to add new account
  Examples:
|accountName|description|balance|accountNumber|contactPerson|
|test|test Description|124|26734|test person|