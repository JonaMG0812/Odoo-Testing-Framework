package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class AllSuiteTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	EcommercePage ecommercePage;
	private String testingURL = "http://10321038-14-0-all.runbot52.odoo.com/";
	
	// Data
	private	String userEmail = "demo";
	private	String userPassword = "demo";
	private	String itemName = "Drawer";


@BeforeClass
public void beforeClass() {
	ecommercePage = new EcommercePage(driver, wait);
	driver = ecommercePage.firefoxDriverConnection();
	wait = ecommercePage.waitConst();
}

@BeforeMethod
public void beforeMethod() {
	
}

@AfterMethod
public void afterMethod() {
	//ecommercePage.visit(testingURL);	
}

@AfterClass
public void afterClass() {
	
}

@Test(description="This method validates Sign Up")
public void LoginTest() {
	ecommercePage.visit(testingURL);
	ecommercePage.loginUser(userEmail, userPassword);
	// TODO: Assert successful login
	ecommercePage.visit(testingURL);
}

@Test(description="This method validates 2 Items in the cart", dependsOnMethods="LoginTest")
public void AddItemToCartTest() {
	ecommercePage.addItemToCart(itemName);
}

@Test(description="This method validates the check out proccess", dependsOnMethods="AddItemToCartTest")
public void CheckOutTest() {
	ecommercePage.checkOut();
	// TODO: Assert the checkout message
	}

@Test(description="This method validates the payment proccess", dependsOnMethods="CheckOutTest")
public void PaymentTest() {
	ecommercePage.payProccess();
	// TODO: Assert the successful payment message.
}


}
