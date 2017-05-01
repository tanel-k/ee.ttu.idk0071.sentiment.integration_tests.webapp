package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.BasePage;

public class BaseSteps {
	protected ContextSteps contextSteps;
	protected BasePage page;

	public BaseSteps(ContextSteps contextSteps, BasePage page) {
		this.contextSteps = contextSteps;
		this.page = page;
	}
}
