package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.MainPage;

public class MainPageSteps {
	protected ContextSteps contextSteps;
	protected MainPage mainPage;

	@Given("^user opens main page$")
	public void userOpensMainPage() {
		this.mainPage.navigateTo();
	}

	@When("^user clicks link to open new lookup form$")
	public void clickOpenLookupFormLink() {
		this.mainPage.clickOpenLookupFormLink();
	}

	@Then("^main page is open$")
	public void checkMainPageOpen() {
		this.mainPage.checkIfOpen();
	}

	public MainPageSteps(ContextSteps contextSteps) {
		this.contextSteps = contextSteps;
		this.mainPage = new MainPage(contextSteps);
	}
}
