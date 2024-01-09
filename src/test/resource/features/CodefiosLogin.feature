@CodefiosLoginFeature @Regression
Feature: Codefios billing page login functionality validation

Background: 
	Given User is on the codefios login page
	When User enters the username as "demo1@codefios.com"

@PositiveScenario @Smoke 
Scenario: User should be able to login with valid credential
	When User enters the password as "abc123"
	And User clicks on sign in button
	Then User should be able to land on dashboard page

@NegativeScenario @Sanity
Scenario: User should be able to login with invalid credential
	When User enters the password as "abc1234"
	And User clicks on sign in button
	Then User should be able to land on dashboard page