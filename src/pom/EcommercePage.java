package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePage extends Base {
	
	private Data dataSet = new Data();
		
	public EcommercePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public void loginUser(String userEmail, String userPassword) {
		// Make Log In on web page
		waitUntilClickable(By.xpath(dataSet.signInXpath));
		click(By.xpath(dataSet.signInXpath));
		waitUntilPresent(By.xpath(dataSet.emailLoginXpath));
		writeText(userEmail, By.xpath(dataSet.emailLoginXpath));
		writeText(userPassword, By.xpath(dataSet.passwordLoginXpath));
		waitUntilClickable(By.xpath(dataSet.loginButtonXpath));
		click(By.xpath(dataSet.loginButtonXpath));

	}
	
	public void searchItem(String itemName) {
		// Search for the itemName in the search bar
		waitUntilClickable(By.xpath(dataSet.shopButtonXpath));
		click(By.xpath(dataSet.shopButtonXpath));
		waitUntilPresent(By.xpath(dataSet.searchInputXpath));
		writeText(itemName, By.xpath(dataSet.searchInputXpath));
		waitUntilClickable(By.xpath(dataSet.searchButtonXpath));
		click(By.xpath(dataSet.searchButtonXpath));
		
	}
		
	public void addItemToCart() {	
		// Select the item and then add two of them to the shopping cart
		waitUntilClickable(By.xpath(dataSet.secondItemXpath));
		click(By.xpath(dataSet.secondItemXpath));
		waitUntilClickable(By.xpath(dataSet.plusButtonXpath));
		click(By.xpath(dataSet.plusButtonXpath));
		waitUntilClickable(By.xpath(dataSet.addToCartButtonXpath));
		click(By.xpath(dataSet.addToCartButtonXpath));
				
	}

	public void checkOut() {
		// Here we expect to be in the shopping cart and start the checkout process
		waitUntilClickable(By.xpath(dataSet.checkOutXpath));
		click(By.xpath(dataSet.checkOutXpath));
		//waitUntilClickable(By.xpath(nextExtraInfoXpath));
		//click(By.xpath(nextExtraInfoXpath));
	}
	
	public void payProccess() {
		// Start the pay process (enter card number, etc.)
		waitUntilClickable(By.xpath(dataSet.cardRadioButtonXpath));
		click(By.xpath(dataSet.cardRadioButtonXpath));
		waitUntilClickable(By.xpath(dataSet.cardNumberXpath));
		writeTextSlow(dataSet.creditCardNum, By.xpath(dataSet.cardNumberXpath));
		waitUntilClickable(By.xpath(dataSet.cardHolderNameXpath));
		writeText(dataSet.creditCardHolderName, By.xpath(dataSet.cardHolderNameXpath));
		waitUntilClickable(By.xpath(dataSet.cardExpiryXpath));
		writeText(dataSet.creditCardDateMonth, By.xpath(dataSet.cardExpiryXpath));
		writeText(dataSet.creditCardDateYear, By.xpath(dataSet.cardExpiryXpath));
		waitUntilClickable(By.xpath(dataSet.cardCvvXpath));
		writeText(dataSet.creditCardCvv, By.xpath(dataSet.cardCvvXpath));
		waitUntilClickable(By.xpath(dataSet.payNowButtonXpath));
		click(By.xpath(dataSet.payNowButtonXpath));
		
	}
	
}
