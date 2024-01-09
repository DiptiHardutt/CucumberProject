$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:features/AddAccountFromList.feature");
formatter.feature({
  "name": "Codefios Add Account functionality from List Account",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AddAccountFeature"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on the codefios login page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.StepDefinition.user_is_on_the_codefios_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"username\" from mysql database",
  "keyword": "When "
});
formatter.match({
  "location": "steps.StepDefinition.userEntersFromMysqlDatabase(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters \"password\" from mysql database",
  "keyword": "When "
});
formatter.match({
  "location": "steps.StepDefinition.userEntersFromMysqlDatabase(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on sign in button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.StepDefinition.user_clicks_on_sign_in_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to land on dashboard page",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.StepDefinition.user_should_be_able_to_land_on_dashboard_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User shouldbe able to Add account from List Account Page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AddAccountFeature"
    },
    {
      "name": "@AddAccount"
    }
  ]
});
formatter.step({
  "name": "User clicks on List Account button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.StepDefinition.user_clicks_on_List_Account_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to land on List Account page",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.StepDefinition.user_should_be_able_to_land_on_List_Account_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on Add Account button",
  "keyword": "When "
});
formatter.match({
  "location": "steps.StepDefinition.user_clicks_on_Add_Account_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to navigate to New Account window",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.StepDefinition.user_should_be_able_to_navigate_to_New_Account_window()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User fill all the required information",
  "keyword": "When "
});
formatter.match({
  "location": "steps.StepDefinition.user_fill_all_the_required_information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on the save button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.StepDefinition.user_clicks_on_the_save_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should be able to add new account",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.StepDefinition.user_should_be_able_to_add_new_account()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});