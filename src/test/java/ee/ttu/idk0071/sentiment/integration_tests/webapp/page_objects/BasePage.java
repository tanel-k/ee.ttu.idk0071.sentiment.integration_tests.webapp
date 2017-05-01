package ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects;

import ee.ttu.idk0071.sentiment.integration_tests.webapp.steps.ContextSteps;

public abstract class BasePage {
	protected ContextSteps contextSteps;

	public abstract void checkIfOpen();
	public abstract void navigateTo();

	public BasePage(ContextSteps contextSteps) {
		this.contextSteps = contextSteps;
	}
}
