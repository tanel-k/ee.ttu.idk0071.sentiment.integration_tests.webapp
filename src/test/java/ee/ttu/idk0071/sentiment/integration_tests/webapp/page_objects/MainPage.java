package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.EnvironmentKeys;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.Locators;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public class MainPage extends BasePage {
	public void navigateTo() {
		String URL = System.getenv(EnvironmentKeys.ENV_KEY_MAIN_PAGE_URL);
		if (StringUtils.isEmpty(URL)) {
			Assert.fail(EnvironmentKeys.ENV_KEY_MAIN_PAGE_URL + " not set.");
		}
		
		contextSteps.navigateTo(URL);
	}

	public void checkIfOpen() {
		contextSteps.checkElementPresent(Locators.MAIN_PAGE_CONTAINER);
	}

	public void clickOpenLookupFormLink() {
		contextSteps.clickElement(Locators.MAIN_PAGE_LINK_LOOKUP_FORM);
	}

	public MainPage(ContextSteps contextSteps) {
		super(contextSteps);
	}
}
