package pom;

public class Data {
	// Testing URL
	String testingURL = "http://10368388-14-0-all.runbot63.odoo.com/"; // original
	// Data
	String userEmail = "demo";
	String userPassword = "demodemo";
	String itemName = "Drawer";
	
	// Payment Data
	String creditCardNum = "4242424242424242";
	String creditCardDateMonth = "11";
	String creditCardDateYear = "66";
	String creditCardCvv = "1234";
	String creditCardHolderName = "Mr. Test";
	
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
	
}
