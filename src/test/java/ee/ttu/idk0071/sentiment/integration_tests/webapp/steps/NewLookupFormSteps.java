package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.NewLookupForm;

public class NewLookupFormSteps extends BaseSteps {
	@When("^user opens new lookup form$")
	public void openMainPage() {
		page.navigateTo();
	}

	@When("^user clicks perform lookup button$")
	public void clickPerformLookup() {
		((NewLookupForm) page).clickPerformLookup();
	}

	@When("^user clicks lookup detail link$")
	public void clickLookupDetailLink() {
		((NewLookupForm) page).useLookupDetailLink();
	}

	@When("^user sets keyword field to '([^']*)'$")
	public void setKeywordTo(String keyword) {
		((NewLookupForm) page).setKeywordFieldValue(keyword);
	}

	@When("^user sets e-mail field to '([^']*)'$")
	public void setEmailTo(String email) {
		((NewLookupForm) page).setEmailFieldValue(email);
	}

	@When("^user selects first domain option$")
	public void selectFirstDomain() {
		((NewLookupForm) page).selectFirstDomain();
	}

	@Then("^new lookup form is open$")
	public void checkLookupFormOpen() {
		page.checkIfOpen();
	}

	@Then("^new lookup form is loaded$")
	public void checkLookupFormLoaded() {
		((NewLookupForm) page).checkIfLoaded();
	}

	@Then("^e-mail field has value '([^']*)'$")
	public void checkEmailFieldValue(String email) {
		((NewLookupForm) page).checkEmailFieldHasValue(email);
	}

	@Then("^no domains are selected$")
	public void checkNoDomainsSelected() {
		((NewLookupForm) page).checkNoDomainsSelected();
	}

	@Then("^keyword field has value '([^']*)'$")
	public void checkKeyWordField(String keyword) {
		((NewLookupForm) page).checkKeywordFieldHasValue(keyword);
	}

	@Then("^perform lookup button is disabled$")
	public void checkPerformLookupDisabled() {
		((NewLookupForm) page).checkPerformLookupDisabled();
	}

	@Then("^perform lookup button is enabled$")
	public void checkPerformLookupEnabled() {
		((NewLookupForm) page).checkPerformLookupEnabled();
	}

	@Then("^submission dialog is present$")
	public void checkSubmissionDialogPresent() {
		((NewLookupForm) page).checkSubmissionDialogPresent();
	}

	public NewLookupFormSteps(ContextSteps contextSteps) {
		super(contextSteps, new NewLookupForm(contextSteps));
	}
}
