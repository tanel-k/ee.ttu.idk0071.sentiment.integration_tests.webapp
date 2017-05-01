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
		this.contextSteps.checkElementAttributeWithRetry(Locators.NEW_LOOKUP_FORM_BUTTON_PERFORM_LOOKUP, "disabled", "", "Button was not enabled");
	}

	public void checkPerformLookupDisabled() {
		this.contextSteps.checkElementAttributeWithRetry(Locators.NEW_LOOKUP_FORM_BUTTON_PERFORM_LOOKUP, "disabled", "true", "Button was enabled");
	}

	public void setKeywordFieldValue(String keyword) {
		this.contextSteps.sendKeysToElement(Locators.NEW_LOOKUP_FORM_INPUT_KEYWORD, keyword);
	}

	public void setEmailFieldValue(String email) {
		this.contextSteps.sendKeysToElement(Locators.NEW_LOOKUP_FORM_INPUT_EMAIL, email);
	}

	public void selectFirstDomain() {
		this.contextSteps.selectFirstOption(Locators.NEW_LOOKUP_FORM_SELECT_DOMAIN);
	}

	public void checkIfLoaded() {
		this.contextSteps.waitUntilElementDisappearsOrFail(Locators.DIV_BLOCK_PAGE);
	}

	public void checkEmailFieldHasValue(String email) {
		this.contextSteps.checkElementValueAttributeWithRetry(Locators.NEW_LOOKUP_FORM_INPUT_EMAIL, email, "E-mail field did not have the expected value");
	}

	public void checkKeywordFieldHasValue(String keyword) {
		this.contextSteps.checkElementValueAttributeWithRetry(Locators.NEW_LOOKUP_FORM_INPUT_KEYWORD, keyword, "Keyword field did not have the expected value");
	}

	public void checkNoDomainsSelected() {
		this.contextSteps.checkSelectionEmpty(Locators.NEW_LOOKUP_FORM_SELECT_DOMAIN);
	}

	public NewLookupForm(ContextSteps contextSteps) {
		super(contextSteps);
	}
}
