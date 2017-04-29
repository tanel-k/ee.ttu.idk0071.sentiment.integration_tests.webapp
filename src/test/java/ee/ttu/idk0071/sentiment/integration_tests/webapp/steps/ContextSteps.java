package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.annotation.After;
import cucumber.annotation.Before;

public class ContextSteps {
	private static boolean initialized = false;
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	@Before
	public void setUp() throws Exception {
		if (!initialized) {
			driver = new ChromeDriver();
			initialized = true;
		}
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
