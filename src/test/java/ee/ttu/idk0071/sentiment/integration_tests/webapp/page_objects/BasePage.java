package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import org.openqa.selenium.WebDriver;

public class BasePage {
	protected WebDriver webDriver;

	protected WebDriver getDriver() {
		return webDriver;
	}

	public void navigateTo() {
		this.webDriver.get("http://aws-website-sentimentallydev-k5jwy.s3-website-us-east-1.amazonaws.com");
	}

	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
}
