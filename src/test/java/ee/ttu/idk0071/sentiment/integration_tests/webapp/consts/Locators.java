package ee.ttu.idk0071.sentiment.integration_tests.webapp.consts;

import org.openqa.selenium.By;

public class Locators {
	public static final By MAIN_PAGE_CONTAINER = By.xpath("//div[@gui-id='main-page-container']");
	public static final By MAIN_PAGE_LOOKUP_FORM_LINK = By.xpath("//a[@gui-id='lookup-form-link']");
	public static final By NEW_LOOKUP_FORM_CONTAINER = By.xpath("//div[@gui-id='lookup-form-container']");
	public static final By BUTTON_PERFORM_LOOKUP = By.xpath("//button[@gui-id='btn-perform-lookup']");
	public static final By INPUT_KEYWORD = By.xpath("//input[@gui-id='keyword-input']");
	public static final By INPUT_EMAIL = By.xpath("//input[@gui-id='email-input']");
	public static final By SELECT_DOMAIN = By.xpath("//select[@gui-id='domain-select']");
	public static final By DIV_BLOCK_PAGE = By.cssSelector("div.blockUI.blockOverlay");
}
