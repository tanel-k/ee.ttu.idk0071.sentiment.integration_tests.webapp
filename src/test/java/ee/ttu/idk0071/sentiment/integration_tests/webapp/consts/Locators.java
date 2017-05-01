package ee.ttu.idk0071.sentiment.integration_tests.webapp.consts;

import org.openqa.selenium.By;

public class Locators {
	// main page locators
	public static final By MAIN_PAGE_CONTAINER = By.xpath("//div[@gui-id='main-page-container']");
	public static final By MAIN_PAGE_LINK_LOOKUP_FORM = By.xpath("//a[@gui-id='lookup-form-link']");

	// new lookup form locators
	public static final By NEW_LOOKUP_FORM_CONTAINER = By.xpath("//div[@gui-id='lookup-form-container']");
	public static final By NEW_LOOKUP_FORM_SUBMISSION_DIALOG_CONTAINER = By.xpath("//ai-dialog-body[@gui-id='lookup-submission-dialog']");
	public static final By NEW_LOOKUP_FORM_BUTTON_PERFORM_LOOKUP = By.xpath("//button[@gui-id='btn-perform-lookup']");
	public static final By NEW_LOOKUP_FORM_INPUT_KEYWORD = By.xpath("//input[@gui-id='keyword-input']");
	public static final By NEW_LOOKUP_FORM_INPUT_EMAIL = By.xpath("//input[@gui-id='email-input']");
	public static final By NEW_LOOKUP_FORM_SELECT_DOMAIN = By.xpath("//select[@gui-id='domain-select']");
	public static final By NEW_LOOKUP_FORM_LINK_LOOKUP_DETAIL = By.xpath("//a[@gui-id='lookup-detail-link']");

	// detail page locators
	public static final By DETAIL_PAGE_CONTAINER = By.xpath("//div[@gui-id='lookup-detail-container']");

	// app-wide locators
	public static final By DIV_BLOCK_PAGE = By.cssSelector("div.blockUI.blockOverlay");
}
