package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver driver;
	 
	 public static void initDriver() {
	  System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	 } 
	 
	 public void takesScreenshot(WebDriver driver) {
		 TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
//System.getProperty("user.dir") + "/screenshots/" + FileName + ".png"	
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+
					"/screenshots/"+ label +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	 public int generateRandomNum(int num) {
			Random random = new Random();
			int genratedRandomNum=random.nextInt(num);
			return genratedRandomNum;
		}
		
	 public void validateElement(String msg,String expected, String actual) {
		 Assert.assertEquals(msg, expected, actual);
	 }
	 	 
	 //Explicit wait 
	 public void waitForElement(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
}
