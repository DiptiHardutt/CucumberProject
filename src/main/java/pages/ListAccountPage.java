package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ListAccountPage extends TestBase{
	WebDriver driver;
	String insertedAccountname;
	String insertedAccNum;
	
	public ListAccountPage(WebDriver driver) {
		this.driver=driver;
	}
	
	// Element Library
	@FindBy(css="a[title='List Accounts']") WebElement listAccountMenuButton;
	@FindBy(xpath="//button[text()='Add Account']") WebElement addAccountButton;
	@FindBy(css="input[id='account_name']") WebElement accountName;
	@FindBy(css="textarea[id='description']") WebElement description;
	@FindBy(css="input[id='balance']") WebElement balance;
	@FindBy(css="input[id='account_number']") WebElement accountNumber;
	@FindBy(css="input[id='contact_person']") WebElement contactPerson;
	@FindBy(css="button[id='accountSave']") WebElement saveButton;
	@FindBy(xpath="//table/tbody/tr") List<WebElement> tableRows;
	@FindBy(xpath="//strong[text()='Account List']") WebElement accountListDashboardPage;
	@FindBy(css="#accountModalLabel") WebElement newAccountWindow;
	@FindBy(css="a[id='yesBtn']") WebElement yesButton;
	
		
	
	// Methods to interact with the elements
	public void clickOnListAccountMenuButton() {
		listAccountMenuButton.click();
	}
	public void clickOnAddAccountButton() {
		addAccountButton.click();
	}
	public void accountListAssertion(String expected) {
		waitForElement(accountListDashboardPage);
		String actual = accountListDashboardPage.getText();
		validateElement("Account List Page not found",expected,actual);
	}
	public void newAccountAssertion(String expected) {
		waitForElement(newAccountWindow);
		String actual = newAccountWindow.getText();
		validateElement("New Account Page not found",expected,actual);
	}
	public void insertAccountName(String Accountname) {
		insertedAccountname=Accountname+generateRandomNum(999);
		accountName.sendKeys(insertedAccountname);
	}
	public void insertDescription(String descriptionText) {
		description.sendKeys(descriptionText);
	}
	public void insertBalance(String num) {
		balance.sendKeys(num);
	}
	public void insertAccountNumber(String accNum) {
		insertedAccNum=accNum+generateRandomNum(9999);
		accountNumber.sendKeys(insertedAccNum);
	}
	public void insertContactPerson(String nameOfPerson) {
		contactPerson.sendKeys(nameOfPerson);
	}
	public void clickOnSaveButton() {
		saveButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//table/tbody/tr[1]/td[2]
	//table/tbody/tr[1]//button[1]
	String beforeXpath = "//table/tbody/tr[";
	String afterXpath = "]/td[2]";
	String afterXpathnum="]/td[3]";
	String afterXpathButton ="]//button[1]";
	public String searchForNameAndAccount() {
		waitForElement(accountListDashboardPage);
//		System.out.println("In search for name and account");
		int size = tableRows.size();
		for(int i=1;i<size;i++) {
			String actualNameXpath = beforeXpath + i + afterXpath;
//			WebElement name = driver.findElement(By.xpath(beforeXpath+i+afterXpath));
//			System.out.println(name);
			String actualName = driver.findElement(By.xpath(beforeXpath+i+afterXpath)).getText();
			String actualAccountNum=driver.findElement(By.xpath(beforeXpath+i+afterXpathnum)).getText();
		if(actualName.contains(insertedAccountname)&& actualAccountNum.contains(insertedAccNum)) {
			System.out.println("account exist");
			//to delete account
//			driver.findElement(By.xpath(beforeXpath+i+afterXpathButton)).click();
//			yesButton.click();
			break;
		}
	
		}
		return insertedAccNum;
		
	}

}
