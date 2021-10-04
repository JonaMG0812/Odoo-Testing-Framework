package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePage extends Base {
	
	// LOCATORS
	
	// Sign-In
	//String signInXpath = "//li/a[contains(@class,'nav-link font-weight-bold')]";
	String signInXpath = "//li/a[@href='/web/login']";
	String emailLoginXpath = "//div[@class='form-group field-login']/input[@id='login'][@name='login']";
	String passwordLoginXpath = "//div[@class='form-group field-password']/input[@id='password'][@name='password']";
	String loginButtonXpath = "//div[contains(@class, 'oe_login_buttons')]/button[@type='submit']";
	String userMenuSpanXpath = "//li[@class='o_user_menu']/a[@role='button']/span[@class='oe_topbar_name']";
	
	// Search Item
	String shopButtonXpath = "//a[@href='/shop']";
	String searchInputXpath = "//div[@role='search' and @class='input-group']/input[@type='search' and contains(@class, 'oe_search_box')]";
	// String searchButtonXpath = "//button[@type='submit' and contains(@class, 'oe_search_button')]";
	String searchButtonXpath = "//button[@class='btn btn-primary oe_search_button' and @type='submit']/parent::div[@class='input-group-append']";
	
	// Add item to cart
	String secondItemXpath = "//tr[1]/td[@class='oe_product'][2]/descendant::div/h6[contains(@class,'o_wsale_products_item_title')]/a";
	String plusButtonXpath = "//input[@name='add_qty']/following-sibling::div/a/i[contains(@class, 'fa-plus')]";
	String addToCartButtonXpath = "//*[@id='add_to_cart']";
	String checkOutXpath = "//div[contains(@class, 'oe_cart')]/div/div/a[2]";
	String nextExtraInfoXpath = "//a[@href='/shop/confirm_order']";
	
	// Pay
	String cardRadioButtonXpath = "//div[contains(@class, 'o_payment_acquirer_select')]/label/input[@type='radio' and @data-provider='test']";
	String cardNumberXpath = "//div/input[@id='cc_number' and @name='cc_number']";
	String cardHolderNameXpath = "//div/input[@id='cc_holder_name' and @name='cc_holder_name']";
	String cardExpiryXpath = "//div/input[@id='cc_expiry' and @name='cc_expiry']";
	String cardCvvXpath = "//div/input[@id='cvc' and @name='cvc']";
	String payNowButtonXpath = "//div/button[@id='o_payment_form_pay' and @type='submit']";
	String SuccessPayXpath = "//div[@class='card alert-success']";
	
	// Some Data
	String creditCardNum = "4242424242424242";
	String creditCardDateMonth = "11";
	String creditCardDateYear = "66";
	String creditCardCvv = "1234";
	String creditCardHolderName = "Mr. Test";
	  	
	
	public EcommercePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public void loginUser(String userEmail, String userPassword) {
		// Make Log In on web page
		waitUntilClickable(By.xpath(signInXpath));
		click(By.xpath(signInXpath));
		waitUntilPresent(By.xpath(emailLoginXpath));
		writeText(userEmail, By.xpath(emailLoginXpath));
		writeText(userPassword, By.xpath(passwordLoginXpath));
		waitUntilClickable(By.xpath(loginButtonXpath));
		click(By.xpath(loginButtonXpath));

	}
	
	public void searchItem(String itemName) {
		// Search for the itemName in the search bar
		waitUntilClickable(By.xpath(shopButtonXpath));
		click(By.xpath(shopButtonXpath));
		waitUntilPresent(By.xpath(searchInputXpath));
		writeText(itemName, By.xpath(searchInputXpath));
		waitUntilClickable(By.xpath(searchButtonXpath));
		click(By.xpath(searchButtonXpath));
		
	}
		
	public void addItemToCart() {	
		// Select the item and then add two of them to the shopping cart
		waitUntilClickable(By.xpath(secondItemXpath));
		click(By.xpath(secondItemXpath));
		waitUntilClickable(By.xpath(plusButtonXpath));
		click(By.xpath(plusButtonXpath));
		waitUntilClickable(By.xpath(addToCartButtonXpath));
		click(By.xpath(addToCartButtonXpath));
				
	}

	public void checkOut() {
		// Here we expect to be in the shopping cart and start the checkout process
		waitUntilClickable(By.xpath(checkOutXpath));
		click(By.xpath(checkOutXpath));
		//waitUntilClickable(By.xpath(nextExtraInfoXpath));
		//click(By.xpath(nextExtraInfoXpath));
	}
	
	public void payProccess() {
		// Start the pay process (enter card number, etc.)
		waitUntilClickable(By.xpath(cardRadioButtonXpath));
		click(By.xpath(cardRadioButtonXpath));
		waitUntilClickable(By.xpath(cardNumberXpath));
		writeTextSlow(creditCardNum, By.xpath(cardNumberXpath));
		waitUntilClickable(By.xpath(cardHolderNameXpath));
		writeText(creditCardHolderName, By.xpath(cardHolderNameXpath));
		waitUntilClickable(By.xpath(cardExpiryXpath));
		writeText(creditCardDateMonth, By.xpath(cardExpiryXpath));
		writeText(creditCardDateYear, By.xpath(cardExpiryXpath));
		waitUntilClickable(By.xpath(cardCvvXpath));
		writeText(creditCardCvv, By.xpath(cardCvvXpath));
		waitUntilClickable(By.xpath(payNowButtonXpath));
		click(By.xpath(payNowButtonXpath));
		
	}
	
}
