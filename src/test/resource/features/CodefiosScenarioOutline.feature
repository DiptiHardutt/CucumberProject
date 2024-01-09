@OtherCodefiosLoginFeature @Regression
Feature: Other Codefios billing page login functionality validation

Background:
Given User is on the codefios login page

@PositiveScenario1 @Smoke
Scenario Outline: Other User should be able to login with valid credential
When User enters the username as "<username>"
When User enters the password as "<password>"
And User clicks on sign in button
Then User should be able to land on dashboard page
Examples:
|username|password|
|demo@codefios.com|abc123|
|demo1@codefios.com|abc1234|
|demo@codefios.com|abc1234|
|									|				|

