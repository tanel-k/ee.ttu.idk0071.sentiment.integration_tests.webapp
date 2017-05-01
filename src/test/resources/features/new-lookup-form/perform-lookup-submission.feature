@run
Feature: Perform lookup returns id and clears inputs

Scenario:
	Given user opens new lookup form
	Then new lookup form is open
		And new lookup form is loaded
		And perform lookup button is disabled

	When user sets keyword field to 'easyjet'
		And user selects first domain option
	Then perform lookup button is enabled
		And keyword field has value 'easyjet'

	When user clicks perform lookup button
		And waits for page to unlock
	Then perform lookup button is disabled
		And e-mail field has value ''
		And keyword field has value ''
	