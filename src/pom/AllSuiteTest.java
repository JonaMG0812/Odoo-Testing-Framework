package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class AllSuiteTest {
	
	private WebDriver driver;
	private WebDriverWait wait;
	EcommercePage ecommercePage;
	private String testingURL = "http://10321038-14-0-all.runbot52.odoo.com/"; // original
	//private String testingURL = "https://10319909-14-0-all.runbot74.odoo.com/"; // 14 32hrs (2) (nextExtraInfoXpath)
	
	// Data
	private	String userEmail = "demo";
	private	String userPassword = "demo";
	private	String itemName = "Drawer";


@BeforeClass
	public void beforeClass() {
		ecommercePage = new EcommercePage(driver, wait);
		driver = ecommercePage.chromeDriverConnection();
		wait = ecommercePage.waitConst();
	}

@Test (description="This method validates Sign Up")
	public void LoginTest() {
		ecommercePage.visit(testingURL);
		Boolean asertionLoadPage = ecommercePage.isDisplayed(ecommercePage.signInXpath);
		Assert.assertTrue(asertionLoadPage,"The page could not be loaded.");
		ecommercePage.loginUser(userEmail, userPassword);
		Boolean asertionLogin = ecommercePage.isDisplayed(ecommercePage.userMenuSpanXpath);
		Assert.assertTrue(asertionLogin,"The login could not be made.");
		ecommercePage.visit(testingURL);
	}

@Test(description="This method validates a searching for an item on the catalog", dependsOnMethods="LoginTest")
	public void SearchItemTest() {
		ecommercePage.searchItem(itemName);
		Boolean asertionSearch = ecommercePage.isDisplayed(ecommercePage.secondItemXpath);
		Assert.assertTrue(asertionSearch,"The searching could not be made.");
	}

@Test (description="This method validates the adding of 2 items in the cart", dependsOnMethods="SearchItemTest")
	public void AddItemToCartTest() {
		ecommercePage.addItemToCart();
		Boolean asertionAddItem = ecommercePage.isDisplayed(ecommercePage.checkOutXpath);
		Assert.assertTrue(asertionAddItem,"The item adding could not be made.");
	}

@Test (description="This method validates the check out proccess", dependsOnMethods="AddItemToCartTest")
	public void CheckOutTest() {
		ecommercePage.checkOut();
		Boolean asertionCheckout = ecommercePage.isDisplayed(ecommercePage.cardRadioButtonXpath);
		Assert.assertTrue(asertionCheckout,"The checkout process could not be made.");
	}

@Test (description="This method validates the payment proccess", dependsOnMethods="CheckOutTest")
	public void PaymentTest() {
		ecommercePage.payProccess();
		Boolean asertionPayment = ecommercePage.isDisplayed(ecommercePage.SuccessPayXpath);
		Assert.assertTrue(asertionPayment,"The payment could not be made.");
	}
}
