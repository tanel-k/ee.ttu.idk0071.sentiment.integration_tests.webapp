package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.utils.Poller;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.utils.Poller.PollFailedException;
import junit.framework.Assert;

public class ContextSteps {
	private static final int DEFAULT_TIMEOUT_SECONDS = 10;
	private static final long DEFAULT_COOLDOWN_SECONDS = 2;
	private static final int DEFAULT_RETRIES = 5;

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void navigateTo(String URL) {
		driver.get(URL);
	}

	public void checkElementPresent(By locator) {
		getElementOrFail(locator);
	}

	public void clickElement(By locator) {
		WebElement clickable = getElementOrFail(locator);
		clickable.click();
	}

	public void checkElementValueAttributeWithRetry(By locator, String expectedValue, String failureMessage) {
		expectedValue = StringUtils.defaultString(expectedValue, "");
		checkElementAttributeWithRetry(locator, "value", expectedValue, failureMessage);
	}

	public void checkElementAttributeWithRetry(final By locator, final String attribute, final String expectedValue, String failureMessage) {
		Poller poller = new Poller();
		Poller.Condition condition = new Poller.Condition() {
			public boolean isTrue() {
				WebElement element = getElementWithTimeout(locator);
				String value = element.getAttribute(attribute);
				value = StringUtils.defaultString(value, "");
				return value.equals(expectedValue);
			}
		};
		
		poller.setCooldown(DEFAULT_COOLDOWN_SECONDS, TimeUnit.SECONDS)
			.setRetries(DEFAULT_RETRIES)
			.setCondition(condition);
		
		try {
			poller.poll();
		} catch (PollFailedException ex) {
			Assert.fail(failureMessage);
		}
	}

	public void sendKeysToElement(By locator, String value) {
		WebElement element = getElementOrFail(locator);
		value = StringUtils.defaultString(value, "");
		element.clear();
		element.sendKeys(value);
	}

	public void selectFirstOption(By selectLocator) {
		WebElement element = getElementOrFail(selectLocator);
		Select select = new Select(element);
		if (select.getOptions().isEmpty()) {
			Assert.fail("Select element has no options");
		} else {
			System.out.println("selecting");
			WebElement firstOption = select.getOptions().get(0);
			select.selectByVisibleText(firstOption.getText());
		}
	}

	public void clearSelect(By selectLocator) {
		WebElement element = getElementOrFail(selectLocator);
		Select select = new Select(element);
		select.deselectAll();
	}

	public void checkSelectionEmpty(By selectLocator) {
		WebElement element = getElementOrFail(selectLocator);
		Select select = new Select(element);
		Assert.assertTrue("Selection was not empty", select.getAllSelectedOptions().isEmpty());
	}

	public void waitUntilElementDisappearsOrFail(By locator) {
		waitUntilElementDisappearsOrFail(locator, DEFAULT_TIMEOUT_SECONDS);
	}

	public void waitUntilElementDisappearsOrFail(By locator, int timeout) {
		try {
			waitForElementToDisappear(locator, timeout);
		} catch (TimeoutException ex) {
			Assert.fail("Element failed to disappear");
		}
	}

	protected void waitForElementToDisappear(By locator, int timeoutSeconds) {
		(new WebDriverWait(getDriver(), timeoutSeconds))
			.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	protected WebElement getElementOrFail(By locator) {
		return getElementOrFail(locator, DEFAULT_TIMEOUT_SECONDS);
	}

	protected WebElement getElementOrFail(By locator, int timeoutSeconds) {
		WebElement element = null;
		
		try {
			element = getElementWithTimeout(locator, timeoutSeconds);
		} catch (TimeoutException ex) {
			// NOTE: this stops execution
			Assert.fail("Could not locate element in time");
		}
		
		return element;
	}

	protected WebElement getElementWithTimeout(By locator) throws TimeoutException {
		return (new WebDriverWait(getDriver(), DEFAULT_TIMEOUT_SECONDS))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected WebElement getElementWithTimeout(By locator, int timeoutSeconds) throws TimeoutException {
		return (new WebDriverWait(getDriver(), timeoutSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@cucumber.annotation.Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
	}

	@cucumber.annotation.After
	public void tearDown() {
		driver.close();
	}
}
