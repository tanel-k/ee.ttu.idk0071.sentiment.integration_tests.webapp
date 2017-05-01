package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.HistoryPage;

public class HistoryPageSteps extends BaseSteps {
	@When("^user opens history page$")
	public void userOpensMainPage() {
		page.navigateTo();
	}

	@When("^user selects first history domain option$")
	public void selectFirstDomain() {
		((HistoryPage) page).selectFirstDomain();
	}

	@When("^user sets history keyword field to '([^']*)'$")
	public void setKeywordTo(String keyword) {
		System.out.println(keyword);
		((HistoryPage) page).setKeywordFieldValue(keyword);
	}

	@When("^user clicks search button$")
	public void clickPerformLookup() {
		((HistoryPage) page).clickSearch();
	}

	@Then("^search button is disabled$")
	public void checkSearchDisabled() {
		((HistoryPage) page).checkSearchDisabled();
	}

	@Then("^search button is enabled$")
	public void checkSearchEnabled() {
		((HistoryPage) page).checkSearchEnabled();
	}

	@Then("^history page is open$")
	public void checkMainPageOpen() {
		page.checkIfOpen();
	}

	@Then("^history keyword field has value '([^']*)'$")
	public void checkKeyWordField(String keyword) {
		((HistoryPage) page).checkKeywordFieldHasValue(keyword);
	}

	@Then("^no history domains are selected$")
	public void checkNoDomainsSelected() {
		((HistoryPage) page).checkNoDomainsSelected();
	}

	public HistoryPageSteps(ContextSteps contextSteps) {
		super(contextSteps, new HistoryPage(contextSteps));
	}
}
