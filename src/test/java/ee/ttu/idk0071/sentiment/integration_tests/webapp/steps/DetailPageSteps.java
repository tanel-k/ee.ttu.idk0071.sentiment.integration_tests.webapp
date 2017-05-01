package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Then;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.DetailPage;

public class DetailPageSteps extends BaseSteps {
	@Then("^lookup detail page is open$")
	public void checkDetailPageOpen() {
		((DetailPage) page).checkIfOpen();
	}

	public DetailPageSteps(ContextSteps contextSteps) {
		super(contextSteps, new DetailPage(contextSteps));
	}
}
