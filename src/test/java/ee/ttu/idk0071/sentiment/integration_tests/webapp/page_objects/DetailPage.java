package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.Locators;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public class DetailPage extends BasePage {
	@Override
	public void checkIfOpen() {
		contextSteps.checkElementPresent(Locators.DETAIL_PAGE_CONTAINER);
	}

	@Override
	public void navigateTo() {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public DetailPage(ContextSteps contextSteps) {
		super(contextSteps);
	}
}
