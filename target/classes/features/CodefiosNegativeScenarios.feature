@OtherCodefiosLoginFeature @Regression
Feature: Other Codefios billing page login functionality validation

Background:
Given User is on the codefios login page

@PositiveScenario1 @Smoke
Scenario: Other User should be able to login with valid credential
When User enters the username as "demo1@codefios.com"
When User enters the password as "abc123"
And User clicks on sign in button
Then User should be able to land on dashboard page

@NegativeScenario1
Scenario: Other User should be able to login with invalid credential
When User enters the username as "demo@codefios.com"
When User enters the password as "abc123"
And User clicks on sign in button
Then User should be able to land on dashboard page

@NegativeScenario2
Scenario: Other User should be able to login with invalid credential
When User enters the username as "demo1@codefios.com"
When User enters the password as "abc1234"
And User clicks on sign in button
Then User should be able to land on dashboard page

@NegativeScenario3
Scenario: Other User should be able to login with invalid credential
When User enters the username as "demo@codefios.com"
When User enters the password as "abc1234"
And User clicks on sign in button
Then User should be able to land on dashboard page

@NegativeScenario4
Scenario: Other User should be able to login with invalid credential
When User enters the username as ""
When User enters the password as ""
And User clicks on sign in button
Then User should be able to land on dashboard page