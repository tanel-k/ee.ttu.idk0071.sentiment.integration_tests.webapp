package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.EnvironmentKeys;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.Locators;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public class HistoryPage extends BasePage {
	@Override
	public void navigateTo() {
		String URL = System.getenv(EnvironmentKeys.ENV_KEY_HISTORY_PAGE_URL);
		if (StringUtils.isEmpty(URL)) {
			Assert.fail(EnvironmentKeys.ENV_KEY_HISTORY_PAGE_URL + " not set.");
		}
		
		contextSteps.navigateTo(URL);
	}

	@Override
	public void checkIfOpen() {
		contextSteps.checkElementPresent(Locators.HISTORY_PAGE_CONTAINER);
	}

	public void selectFirstDomain() {
		contextSteps.selectFirstOption(Locators.HISTORY_PAGE_SELECT_DOMAIN);
	}

	public void checkSearchEnabled() {
		contextSteps.checkElementAttributeWithRetry(Locators.HISTORY_PAGE_BUTTON_SEARCH, "disabled", "", "Button was not enabled");
	}

	public void checkSearchDisabled() {
		contextSteps.checkElementAttributeWithRetry(Locators.HISTORY_PAGE_BUTTON_SEARCH, "disabled", "true", "Button was enabled");
	}

	public void setKeywordFieldValue(String keyword) {
		contextSteps.sendResolvedValueToElement(Locators.HISTORY_PAGE_INPUT_KEYWORD, keyword);
	}

	public void checkKeywordFieldHasValue(String keyword) {
		contextSteps.checkElementValueAttributeWithRetry(Locators.HISTORY_PAGE_INPUT_KEYWORD, keyword, true, "Keyword field did not have the expected value");
	}

	public void checkNoDomainsSelected() {
		contextSteps.checkSelectionEmpty(Locators.HISTORY_PAGE_SELECT_DOMAIN);
	}

	public void clickSearch() {
		contextSteps.clickElement(Locators.HISTORY_PAGE_BUTTON_SEARCH);
	}

	public HistoryPage(ContextSteps contextSteps) {
		super(contextSteps);
	}
}
