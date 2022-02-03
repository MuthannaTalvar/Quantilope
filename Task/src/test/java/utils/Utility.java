package utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Utility {

	/**
	 * This Method is used to wait for a condition, as well as the frequency
	 * with which we want tFo check the condition
	 * 
	 * @param driver
	 * @param locator
	 * @return WebElement
	 */
	@SuppressWarnings("deprecation")
	public static WebElement checkElementClick(WebDriver driver, By locator) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(55, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(Throwable.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return driver.findElement(locator);
	}

	/**
	 * This Method is used to click the given object
	 * 
	 * @param driver
	 * @param locator
	 */
	public static void clickAction(WebDriver driver, By locator) {
		checkElementClick(driver, locator).click();
	}

	/**
	 * This Method is used to enter a text in given edit box of the application
	 * 
	 * @param driver
	 * @param locator
	 * @param stringToPass
	 */
	public static void sendKeysAction(WebDriver driver, By locator, String stringToPass) {
		checkElementClick(driver, locator).sendKeys(stringToPass);
	}

	/**
	 * This Method is used to stop the execution for given time
	 * 
	 * @param tSeconds
	 */
	public static void wait(int tSeconds) {
		tSeconds = tSeconds * 1000;
		try {
			Thread.sleep(tSeconds);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * This Method is used to get the text of the given element
	 * 
	 * @param driver
	 * @param locator
	 */
	public static String gettext(WebDriver driver, By locator) {
		return driver.findElement(locator).getText().trim();
	}

	/**
	 * This Method is used to get all list elements
	 * 
	 * @param driver
	 * @param locator
	 * @return List
	 */
	public static List<WebElement> ListElements(WebDriver driver, By locator) {
		List<WebElement> ListElements = driver.findElements(locator);
		return ListElements;
	}

	/**
	 * This Method is used to mousehover on the element
	 * 
	 * @param driver
	 * @param locator
	 */
	public static void moveToElementObject(WebDriver driver, By locator) {
		new Actions(driver).moveToElement(Utility.checkElementClick(driver, locator)).pause(1000).build().perform();
	}
	
	/**
	 * This Method is used to get the text of the given element
	 * 
	 * @param driver
	 * @param locator
	 */
	public static String getattribute(WebDriver driver, By locator, String name) {
		return driver.findElement(locator).getAttribute(name).trim();
	}
}
