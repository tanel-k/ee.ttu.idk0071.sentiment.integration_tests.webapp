package ee.ttu.idk0071.sentiment.integration_tests.webapp.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import ee.ttu.idk0071.sentiment.integration_tests.webapp.page_objects.NewLookupForm;

public class NewLookupFormSteps {
	protected ContextSteps contextSteps;
	protected NewLookupForm newLookupForm;

	@Given("^user opens new lookup form$")
	public void openMainPage() {
		this.newLookupForm.navigateTo();
	}

	@When("^user clicks perform lookup button$")
	public void clickPerformLookup() {
		this.newLookupForm.clickPerformLookup();
	}

	@When("^user sets keyword field to '([^']*)'$")
	public void setKeywordTo(String keyword) {
		this.newLookupForm.setKeywordFieldValue(keyword);
	}

	@When("^user sets e-mail field to '([^']*)'$")
	public void setEmailTo(String email) {
		this.newLookupForm.setEmailFieldValue(email);
	}

	@When("^user selects first domain option$")
	public void selectFirstDomain() {
		this.newLookupForm.selectFirstDomain();
	}

	@Then("^new lookup form is open$")
	public void checkLookupFormOpen() {
		this.newLookupForm.checkIfOpen();
	}

	@Then("^new lookup form is loaded$")
	public void checkLookupFormLoaded() {
		this.newLookupForm.checkIfLoaded();
	}

	@Then("^e-mail field has value '([^']*)'$")
	public void checkEmailFieldValue(String email) {
		this.newLookupForm.checkEmailFieldHasValue(email);
	}

	@Then("^no domains are selected")
	public void checkNoDomainsSelected() {
		this.newLookupForm.checkNoDomainsSelected();
	}

	@Then("^keyword field has value '([^']*)'$")
	public void checkKeyWordField(String keyword) {
		this.newLookupForm.checkKeywordFieldHasValue(keyword);
	}

	@Then("^perform lookup button is disabled")
	public void checkPerformLookupDisabled() {
		this.newLookupForm.checkPerformLookupDisabled();
	}

	@Then("^perform lookup button is enabled")
	public void checkPerformLookupEnabled() {
		this.newLookupForm.checkPerformLookupEnabled();
	}

	public NewLookupFormSteps(ContextSteps contextSteps) {
		this.contextSteps = contextSteps;
		this.newLookupForm = new NewLookupForm(contextSteps);
	}
}
