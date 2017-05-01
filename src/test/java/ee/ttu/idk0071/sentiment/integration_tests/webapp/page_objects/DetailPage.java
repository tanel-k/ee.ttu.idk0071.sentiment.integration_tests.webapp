package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.consts.Locators;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public class DetailPage extends BasePage {
	public DetailPage(ContextSteps contextSteps) {
		super(contextSteps);
	}

	public void checkIfOpen() {
		contextSteps.checkElementPresent(Locators.DETAIL_PAGE_CONTAINER);
	}
}
