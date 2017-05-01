@run
Feature: User can open new lookup form from main page

Scenario:
	Given user opens main page
	Then main page is open

	When user clicks link to open new lookup form
	Then new lookup form is open

	