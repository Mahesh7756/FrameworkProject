package keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import keywordFramework.exceptions.InvalidBrowserNameException;

public class Keyword {
	static WebDriver driver = null;

	/**
	 * This keyword can be used to launch the specified browser. Browser name must
	 * be one of the following;
	 * <ol>
	 * <li>Chrome</li>
	 * <li>Firefox</li>
	 * <li>Safari</li>
	 * 
	 * @author maheshjadhav
	 * @param browserName
	 */
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			//throw new InvalidBrowserNameException(browserName);
			 //System.err.println("Invalid browser name: " + browserName);
			throw new InvalidBrowserNameException (browserName);
		}

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void closeBrowser() {
		driver.close();

	}

	public void quiteBrowser() {
		driver.quit();

	}

	public void enterText(WebElement element, String text) {

		element.sendKeys(text);
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("ID")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("XPATH")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("CSS")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("CLASS")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("NAME")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElement(By.xpath(locatorValue));
		} else {
			System.err.println("Invalid locator type");
			return null;
		}

	}

	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (locatorType.equalsIgnoreCase("ID")) {
			elements = driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("XPATH")) {
			elements = driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("CSS")) {
			elements = driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("CLASS")) {
			elements = driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("NAME")) {
			elements = driver.findElements(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			elements = driver.findElements(By.tagName(locatorValue));
		} else {
			System.err.println("Invalid locator type");
		}
		return elements;
	}

	public static void enterText(String locator, String text) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		getWebElement(locatorType, locatorValue).sendKeys(text);

	}

	public void enterText(String locatorType, String locatorValue, String text) {
		if (locatorType.equalsIgnoreCase("ID")) {
			driver.findElement(By.id(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("XPATH")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("CSS")) {
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("CLASS")) {
			driver.findElement(By.className(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("NAME")) {
			driver.findElement(By.name(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(text);
		} else {
			System.err.println("Invalid locator type");
		}
	}

	public void clickOn(WebElement element) {
		element.click();

	}

	public static void clickOn(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("#")[1];
		getWebElement(locatorType, locatorValue).click();

	}

	public void hitKey(String locatorType, String locatorValue, Keys key) {
		getWebElement(locatorType, locatorValue).sendKeys(key);

	}

	public static void hitKey(int keyCode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keyCode);

	}

	public static List<String> getTexts(String locatorType, String locatorValue) {
		List<String> items = new ArrayList<String>();
		List<WebElement> elements = getWebElements(locatorType, locatorValue);
		for (WebElement element : elements) {
			items.add(element.getText());
		}
		return items;
	}
}
