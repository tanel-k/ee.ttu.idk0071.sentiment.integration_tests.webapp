package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public class BasePage {
	protected ContextSteps contextSteps;

	public BasePage(ContextSteps contextSteps) {
		this.contextSteps = contextSteps;
	}
}
