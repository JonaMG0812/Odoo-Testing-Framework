package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

//Workaround for formatted inputs
import org.openqa.selenium.JavascriptExecutor; 


public class FirstTest {
	// TODO: Make the class receive somehow the URL via CLI
	// Note: If the following URL is not displayed as expected choose a build from https://runbot.odoo.com
	String testingURL = "http://10298630-14-0-all.runbot64.odoo.com/";
	// LOCATORS
	// Sign-In
	String signInXpath = "//li/a[contains(@class,'nav-link font-weight-bold')]";
	String emailLoginXpath = "//div[@class='form-group field-login']/input[@id='login'][@name='login']";
	String passwordLoginXpath = "//div[@class='form-group field-password']/input[@id='password'][@name='password']";
	String loginButtonXpath = "//div[contains(@class, 'oe_login_buttons')]/button[@type='submit']";
	String userMenuSpanXpath = "//li[@class='o_user_menu']/a[@role='button']/span[@class='oe_topbar_name']";
	// Search Item/Add item to cart
	String shopButtonXpath = "//a[@href='/shop']";
	String searchInputXpath = "//div[@role='search' and @class='input-group']/input[@type='search' and contains(@class, 'oe_search_box')]";
	String searchButtonXpath = "//button[@type='submit' and contains(@class, 'oe_search_button')]";
	String secondItemXpath = "//tr[1]/td[@class='oe_product'][2]/descendant::div/h6[contains(@class,'o_wsale_products_item_title')]/a";
	String plusButtonXpath = "//input[@name='add_qty']/following-sibling::div/a/i[contains(@class, 'fa-plus')]";
	String checkOutXpath = "//div[contains(@class, 'oe_cart')]/div/div/a[2]";
	
	// Some Data
	String creditCardNum = "4242424242424242";
	String creditCardDateMonth = "11";
	String creditCardDateYear = "66";
	String creditCardCvv = "1234";
	String creditCardHolderName = "Mr. Test";
	  
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	JavascriptExecutor jsexecutor;

  @BeforeClass
  public void beforeClass() {
	  // System.setProperty("webdriver.gecko.driver", "..\\drivers\\geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver", "..\\drivers\\chromedriver.exe");
	  // Above we assume that our workspace have a directory called "drivers" with our webdrivers.
	  // driver = new FirefoxDriver();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  wait = new WebDriverWait(driver, 10);
	  actions = new Actions(driver);
	  jsexecutor = (JavascriptExecutor)driver;
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
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(shopButtonXpath)));
	  // Go to the shop and search for a drawer 
	  driver.findElement(By.xpath(shopButtonXpath)).click();
	  driver.findElement(By.xpath(searchInputXpath)).sendKeys("Drawer");
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchButtonXpath)));
	  //
	  searchButtonXpath = "//button[@class='btn btn-primary oe_search_button' and @type='submit']/parent::div[@class='input-group-append']";
	  driver.findElement(By.xpath(searchButtonXpath)).click();
	  // Select Item and add it to the shopping cart.
	  driver.findElement(By.xpath(secondItemXpath)).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(plusButtonXpath)));
	  driver.findElement(By.xpath(plusButtonXpath)).click();
	  driver.findElement(By.id("add_to_cart")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkOutXpath)));
	  driver.findElement(By.xpath(checkOutXpath)).click();
	  // Pay out
	  String cardRadioButtonXpath = "//div[contains(@class, 'o_payment_acquirer_select')]/label/input[@type='radio' and @data-provider='test']";
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardRadioButtonXpath)));
	  driver.findElement(By.xpath(cardRadioButtonXpath)).click();
	  String cardNumberXpath = "//div/input[@id='cc_number' and @name='cc_number']";
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardNumberXpath)));
	  actions.moveToElement(driver.findElement(By.xpath(cardNumberXpath))).perform();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cardNumberXpath)));
	  // TODO: Find alternative way to correct the following lines. (A error maybe related to the field behavior: Animation?)
	  driver.findElement(By.xpath(cardNumberXpath)).sendKeys(creditCardNum);
	  driver.findElement(By.xpath(cardNumberXpath)).sendKeys(creditCardNum);
	  driver.findElement(By.xpath(cardNumberXpath)).sendKeys(creditCardNum);
	  driver.findElement(By.xpath(cardNumberXpath)).sendKeys(creditCardNum);
	  String cardHolderNameXpath = "//div/input[@id='cc_holder_name' and @name='cc_holder_name']";
	  actions.moveToElement(driver.findElement(By.xpath(cardHolderNameXpath))).perform();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cardHolderNameXpath)));
	  driver.findElement(By.xpath(cardHolderNameXpath)).click();
	  driver.findElement(By.xpath(cardHolderNameXpath)).sendKeys(creditCardHolderName);
	  String cardExpiryXpath = "//div/input[@id='cc_expiry' and @name='cc_expiry']";
	  driver.findElement(By.xpath(cardExpiryXpath)).click();
	  driver.findElement(By.xpath(cardExpiryXpath)).clear();
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cardExpiryXpath)));
	  driver.findElement(By.xpath(cardExpiryXpath)).sendKeys(creditCardDateMonth);
	  driver.findElement(By.xpath(cardExpiryXpath)).sendKeys(creditCardDateYear);
	  //jsexecutor.executeScript("document.getElementByXpath('"+cardExpiryXpath+"').value='"+creditCardDate+"';");
	  //jsexecutor.executeScript("$x('//div/input[@id='cc_expiry' and @name='cc_expiry']').value='11 / 22'");
	  String cardCvvXpath = "//div/input[@id='cvc' and @name='cvc']";
	  driver.findElement(By.xpath(cardCvvXpath)).click();
	  driver.findElement(By.xpath(cardCvvXpath)).sendKeys(creditCardCvv);
	  String payNowButtonXpath = "//div[contains(@class, 'o_payment_form')]/div/button[@id='o_payment_form_pay' and @type='submit']";
	  driver.findElement(By.xpath(payNowButtonXpath)).click();
	  
  }
 
  @AfterMethod
  public void afterMethod() {
	  
  }
  
  @AfterClass
  public void afterClass() {
  }

}
