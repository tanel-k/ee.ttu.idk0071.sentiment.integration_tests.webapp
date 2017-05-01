package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.EnvironmentKeys;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.Locators;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public class NewLookupForm extends BasePage {
	@Override
	public void navigateTo() {
		String URL = System.getenv(EnvironmentKeys.ENV_KEY_NEW_LOOKUP_FORM_URL);
		if (StringUtils.isEmpty(URL)) {
			Assert.fail(EnvironmentKeys.ENV_KEY_NEW_LOOKUP_FORM_URL + " not set.");
		}
		
		contextSteps.navigateTo(URL);
	}

	@Override
	public void checkIfOpen() {
		contextSteps.checkElementPresent(Locators.NEW_LOOKUP_FORM_CONTAINER);
	}

	public void checkPerformLookupEnabled() {
		contextSteps.checkElementAttributeWithRetry(Locators.NEW_LOOKUP_FORM_BUTTON_PERFORM_LOOKUP, "disabled", "", "Button was not enabled");
	}

	public void checkPerformLookupDisabled() {
		contextSteps.checkElementAttributeWithRetry(Locators.NEW_LOOKUP_FORM_BUTTON_PERFORM_LOOKUP, "disabled", "true", "Button was enabled");
	}

	public void setKeywordFieldValue(String keyword) {
		contextSteps.sendResolvedValueToElement(Locators.NEW_LOOKUP_FORM_INPUT_KEYWORD, keyword);
	}

	public void setEmailFieldValue(String email) {
		contextSteps.sendResolvedValueToElement(Locators.NEW_LOOKUP_FORM_INPUT_EMAIL, email);
	}

	public void selectFirstDomain() {
		contextSteps.selectFirstOption(Locators.NEW_LOOKUP_FORM_SELECT_DOMAIN);
	}

	public void checkIfLoaded() {
		contextSteps.waitUntilElementDisappearsOrFail(Locators.DIV_BLOCK_PAGE);
	}

	public void checkEmailFieldHasValue(String email) {
		contextSteps.checkElementValueAttributeWithRetry(Locators.NEW_LOOKUP_FORM_INPUT_EMAIL, email, true, "E-mail field did not have the expected value");
	}

	public void checkKeywordFieldHasValue(String keyword) {
		contextSteps.checkElementValueAttributeWithRetry(Locators.NEW_LOOKUP_FORM_INPUT_KEYWORD, keyword, true, "Keyword field did not have the expected value");
	}

	public void checkNoDomainsSelected() {
		contextSteps.checkSelectionEmpty(Locators.NEW_LOOKUP_FORM_SELECT_DOMAIN);
	}

	public void clickPerformLookup() {
		contextSteps.clickElement(Locators.NEW_LOOKUP_FORM_BUTTON_PERFORM_LOOKUP);
	}

	public void checkSubmissionDialogPresent() {
		contextSteps.checkElementPresent(Locators.NEW_LOOKUP_FORM_SUBMISSION_DIALOG_CONTAINER);
	}

	public void useLookupDetailLink() {
		contextSteps.clickElement(Locators.NEW_LOOKUP_FORM_LINK_LOOKUP_DETAIL);
		// this will open a new tab that we have to switch over to
		WebDriver driver = contextSteps.getDriver();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(driver.getWindowHandle())) {
				driver.close();
				driver.switchTo().window(handle);
				return;
			}
		}
	}

	public NewLookupForm(ContextSteps contextSteps) {
		super(contextSteps);
	}
}
