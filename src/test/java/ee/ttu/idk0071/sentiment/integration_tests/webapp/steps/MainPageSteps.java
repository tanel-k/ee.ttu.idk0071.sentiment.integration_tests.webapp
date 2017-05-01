package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.MainPage;

public class MainPageSteps extends BaseSteps {
	@Given("^user opens main page$")
	public void userOpensMainPage() {
		((MainPage) page).navigateTo();
	}

	@When("^user clicks link to open new lookup form$")
	public void clickOpenLookupFormLink() {
		((MainPage) page).clickOpenLookupFormLink();
	}

	@Then("^main page is open$")
	public void checkMainPageOpen() {
		((MainPage) page).checkIfOpen();
	}

	public MainPageSteps(ContextSteps contextSteps) {
		super(contextSteps, new MainPage(contextSteps));
	}
}
