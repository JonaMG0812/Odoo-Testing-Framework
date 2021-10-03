package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Base(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "..\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver firefoxDriverConnection() {
		System.setProperty("webdriver.gecko.driver", "..\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
	
	public WebDriverWait waitConst() {
		wait = new WebDriverWait(driver, 10);
		return wait;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void writeText(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void writeTextSlow(String inputText, By locator) {
		for (int i = 0; i < inputText.length(); i++) {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			driver.findElement(locator).sendKeys(Character.toString(inputText.charAt(i)));
		}
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean idDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	// TODO: Write the wait methods
	public void waitUntilPresent(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
	
	public void waitUntilClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void visit(String url) {
		driver.get(url);
	}

}
