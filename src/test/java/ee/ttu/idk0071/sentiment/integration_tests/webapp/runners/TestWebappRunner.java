package ee.ttu.idk0071.sentiment.integration_tests.webapp.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
	features = "features",
	format = {
		"pretty",
		"html:target/cucumber-html-report",
		"json:target/integration_cucumber.json"
	},
	tags = {"@run"},
	glue = "ee.ttu.idk0071.sentiment.integration_tests.webapp.steps"
) 
public class TestWebappRunner {
	
}
