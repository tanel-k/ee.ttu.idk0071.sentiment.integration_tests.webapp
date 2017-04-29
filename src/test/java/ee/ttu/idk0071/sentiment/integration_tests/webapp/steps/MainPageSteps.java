package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Given;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.MainPage;

public class MainPageSteps {
	private ContextSteps contextSteps;
	private MainPage mainPage;

	@Given("^user opens the main page$")
	public void userOpensMainPage() {
		this.mainPage = new MainPage(contextSteps.getDriver());
		this.mainPage.navigateTo();
	}

	public MainPageSteps(ContextSteps contextSteps) {
		this.contextSteps = contextSteps;
	}
}
