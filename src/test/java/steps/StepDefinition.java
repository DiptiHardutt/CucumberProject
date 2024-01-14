package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DatabasePage;
import pages.ListAccountPage;
import pages.LoginPage;
import pages.TestBase;

public class StepDefinition extends TestBase{
	LoginPage loginPage;
	DatabasePage databasePage;
	ListAccountPage listAccountPage;
	@Before
	public void beforeRun() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		databasePage = new DatabasePage();
		listAccountPage = PageFactory.initElements(driver, ListAccountPage.class);;
	}
	
	@Given ("User is on the codefios login page")
	public void user_is_on_the_codefios_login_page(){
		
		driver.get("https://qa.codefios.com/login");
	}
	
	@When ("User enters {string} from mysql database")
		public void userEntersFromMysqlDatabase(String loginData) {
			/*
			 * if(loginData.equalsIgnoreCase("username")) {
			 * 
			 * }else if(loginData.equals("password")) {
			 * 
			 * }else {
			 * 
			 * }
			 */
		  switch(loginData) { 
		  
		  case "username":
			  loginPage.enterUserName(databasePage.getDataFromDatabase("user_name","SELECT * FROM login_data WHERE user_id=1;"));
//			  System.out.println("Username from DB: " +databasePage.getDataFromDatabase("user_name"));
			  	  break;
		  
		  case "password":
			  loginPage.enterPassword(databasePage.getDataFromDatabase("user_password","SELECT * FROM login_data WHERE user_id=1;"));
//			  System.out.println("Password from DB: " + databasePage.getDataFromDatabase("user_password") );
		  		  break;
		  
		  default: System.out.println("Unable to find Login data:"+ loginData); }
	}
	
	@When ("User enters the username as {string}")
	public void userEntersTheUsernameAs(String username) {
		loginPage.enterUserName(username);
}
			
	@When("User enters the password as {string}")
	public void user_enters_the_password_as(String password) {
		loginPage.enterPassword(password);
	}

	@And("User clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		loginPage.clickSignInButton();
	}

	@Then("User should be able to land on dashboard page")
	public void user_should_be_able_to_land_on_dashboard_page() {
	   String expectedTitle = "Codefios QA";
	   String actualTitle = loginPage.getPageTitle();
	   takesScreenshot(driver);
	   validateElement("Page Title is not matching",expectedTitle, actualTitle);
	  
	}
	@When("User clicks on List Account button")
	public void user_clicks_on_List_Account_button() {
		listAccountPage.clickOnListAccountMenuButton();
	}

	@Then("User should be able to land on List Account page")
	public void user_should_be_able_to_land_on_List_Account_page() {
		String expected = "Account List";
		listAccountPage.accountListAssertion(expected);
	}

	@When("User clicks on Add Account button")
	public void user_clicks_on_Add_Account_button() {
		listAccountPage.clickOnAddAccountButton();
	}

	@Then("User should be able to navigate to New Account window")
	public void user_should_be_able_to_navigate_to_New_Account_window() {
		String expected ="New Account";
		listAccountPage.newAccountAssertion(expected);
	}

	@Then("User fill all the required information")
	public void user_fill_all_the_required_information() {
		listAccountPage.insertAccountName("test");
		listAccountPage.insertDescription("test Description");
		listAccountPage.insertBalance("124");
		listAccountPage.insertAccountNumber("26734");
		listAccountPage.insertContactPerson("test person");
	}

	@Then("User clicks on the save button")
	public void user_clicks_on_the_save_button() {
		listAccountPage.clickOnSaveButton();
	}

	@Then("User should be able to add new account")
	public void user_should_be_able_to_add_new_account() {
		
	
	String number =databasePage.getDataFromDatabase("account_number", 
			"SELECT * FROM tbl_accounts WHERE account_number ="+listAccountPage.searchForNameAndAccount()+";");
	System.out.println("Account "+number+"exist in Database");
	}

	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
