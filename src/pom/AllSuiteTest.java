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
	Data dataSet;

@BeforeClass
	public void beforeClass() {
		ecommercePage = new EcommercePage(driver, wait);
		driver = ecommercePage.chromeDriverConnection();
		wait = ecommercePage.waitConst();
		dataSet = new Data();
	}

@Test(description="This method validates the correct loading of the main page")
	public void LoadMainPage() {
		ecommercePage.visit(dataSet.testingURL);
		Boolean asertionLoadPage = ecommercePage.isDisplayed(dataSet.signInXpath);
		Assert.assertTrue(asertionLoadPage,"The page could not be loaded.");
	}

@Test (description="This method validates the Sign Up", dependsOnMethods="LoadMainPage")
	public void LoginTest() {
		ecommercePage.loginUser(dataSet.userEmail, dataSet.userPassword);
		Boolean asertionLogin = ecommercePage.isDisplayed(dataSet.userMenuSpanXpath);
		Assert.assertTrue(asertionLogin,"The login could not be made.");
		ecommercePage.visit(dataSet.testingURL);
	}

@Test(description="This method validates a searching for an item on the catalog", dependsOnMethods="LoginTest")
	public void SearchItemTest() {
		ecommercePage.searchItem(dataSet.itemName);
		Boolean asertionSearch = ecommercePage.isDisplayed(dataSet.secondItemXpath);
		Assert.assertTrue(asertionSearch,"The searching could not be made.");
	}

@Test (description="This method validates the adding of 2 items in the cart", dependsOnMethods="SearchItemTest")
	public void AddItemToCartTest() {
		ecommercePage.addItemToCart();
		Boolean asertionAddItem = ecommercePage.isDisplayed(dataSet.checkOutXpath);
		Assert.assertTrue(asertionAddItem,"The item adding could not be made.");
	}

@Test (description="This method validates the check out proccess", dependsOnMethods="AddItemToCartTest")
	public void CheckOutTest() {
		ecommercePage.checkOut();
		Boolean asertionCheckout = ecommercePage.isDisplayed(dataSet.cardRadioButtonXpath);
		Assert.assertTrue(asertionCheckout,"The checkout process could not be made.");
	}

@Test (description="This method validates the payment proccess", dependsOnMethods="CheckOutTest")
	public void PaymentTest() {
		ecommercePage.payProccess();
		Boolean asertionPayment = ecommercePage.isDisplayed(dataSet.SuccessPayXpath);
		Assert.assertTrue(asertionPayment,"The payment could not be made.");
	}
}