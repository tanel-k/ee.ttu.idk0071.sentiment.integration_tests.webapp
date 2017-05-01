package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.EnvironmentKeys;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.Locators;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public class NewLookupForm extends BasePage {
	public void navigateTo() {
		String URL = System.getenv(EnvironmentKeys.ENV_KEY_NEW_LOOKUP_FORM_URL);
		if (StringUtils.isEmpty(URL)) {
			Assert.fail(EnvironmentKeys.ENV_KEY_NEW_LOOKUP_FORM_URL + " not set.");
		}
		
		this.contextSteps.navigateTo(URL);
	}

	public void checkIfOpen() {
		this.contextSteps.checkElementPresent(Locators.NEW_LOOKUP_FORM_CONTAINER);
	}

	public void checkPerformLookupEnabled() {
		this.contextSteps.checkElementAttributeWithRetry(Locators.BUTTON_PERFORM_LOOKUP, "disabled", null, "Button was not enabled");
	}

	public void checkPerformLookupDisabled() {
		this.contextSteps.checkElementAttributeWithRetry(Locators.BUTTON_PERFORM_LOOKUP, "disabled", "true", "Button was enabled");
	}

	public void setKeywordFieldValue(String keyword) {
		this.contextSteps.sendKeysToElement(Locators.INPUT_KEYWORD, keyword);
	}

	public void setEmailFieldValue(String email) {
		this.contextSteps.sendKeysToElement(Locators.INPUT_EMAIL, email);
	}

	public void selectFirstDomain() {
		this.contextSteps.selectFirstOption(Locators.SELECT_DOMAIN);
	}

	public void checkIfLoaded() {
		this.contextSteps.waitUntilElementDisappearsOrFail(Locators.DIV_BLOCK_PAGE);
	}

	public NewLookupForm(ContextSteps contextSteps) {
		super(contextSteps);
	}
}
