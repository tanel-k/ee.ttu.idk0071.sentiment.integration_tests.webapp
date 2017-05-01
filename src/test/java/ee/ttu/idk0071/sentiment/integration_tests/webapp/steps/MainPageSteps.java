package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.MainPage;

public class MainPageSteps extends BaseSteps {
	@When("^user opens main page$")
	public void userOpensMainPage() {
		page.navigateTo();
	}

	@When("^user clicks link to open new lookup form$")
	public void clickOpenLookupFormLink() {
		((MainPage) page).clickOpenLookupFormLink();
	}

	@Then("^main page is open$")
	public void checkMainPageOpen() {
		page.checkIfOpen();
	}

	public MainPageSteps(ContextSteps contextSteps) {
		super(contextSteps, new MainPage(contextSteps));
	}
}
