package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;


public class FirstTest {
	// TODO: Make the class receive somehow the URL via CLI
	// Note: If the following URL is not displayed as expected choose a build from https://runbot.odoo.com
	String testingURL = "http://10298630-14-0-all.runbot64.odoo.com/";
	// Locators
	String signInXpath = "//li/a[@class='nav-link font-weight-bold']";
	String emailLoginXpath = "//div[@class='form-group field-login']/input[@id='login'][@name='login']";
	String passwordLoginXpath = "//div[@class='form-group field-password']/input[@id='password'][@name='password']";
	String loginButtonXpath = "//div[contains(@class, 'oe_login_buttons')]/button[@type='submit']";
	String userMenuSpanXpath = "//li[@class='o_user_menu']/a[@role='button']/span[@class='oe_topbar_name']";
	  
	  
	WebDriver driver;
	WebDriverWait wait;

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "..\\drivers\\chromedriver.exe");
	  // Above we assume that our workspace have a directory called "drivers" with our webdrivers.
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  wait = new WebDriverWait(driver, 10);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get(testingURL);
	  // Maybe we can assert that the browser actually loads the Web page
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(signInXpath)));

  }
  
  @Test(description="This method validates Sign Up")
  public void signUpTest() {
	  driver.findElement(By.xpath(signInXpath)).click();
	  System.out.println("We are currently on the following URL " + driver.getCurrentUrl());
	  // Maybe we can assert that the URL is testingURL + /web/login
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailLoginXpath)));
	  driver.findElement(By.xpath(emailLoginXpath)).sendKeys("demo");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passwordLoginXpath)));
	  driver.findElement(By.xpath(passwordLoginXpath)).sendKeys("demo");
	  driver.findElement(By.xpath(loginButtonXpath)).click();
	  // Here maybe we can assert for the User Name (contains demo) in the button with userMenuSpanXpath,
	  // or even the existence of the span itself. 
	  	  
  }
  
  @Test(description="This method validates an Item in the cart", dependsOnMethods="signUpTest")
  public void itemInCartTest() {
	  String shopButtonXpath = "//a[@href='/shop']";
	  String searchInputXpath = "//div[@role='search' and @class='input-group']/input[@type='search' and contains(@class, 'oe_search_box']";
	  String searchButtonXpath = "//button[@type='submit' and contains(@class, 'oe_search_button')]";
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shopButtonXpath)));
	  driver.findElement(By.xpath(shopButtonXpath)).click();
	  driver.findElement(By.xpath(searchInputXpath)).sendKeys("Drawer");
	  driver.findElement(By.xpath(searchButtonXpath)).click();
	  
	  
  }
 
  @AfterMethod
  public void afterMethod() {
	  
  }
  
  @AfterClass
  public void afterClass() {
  }

}
