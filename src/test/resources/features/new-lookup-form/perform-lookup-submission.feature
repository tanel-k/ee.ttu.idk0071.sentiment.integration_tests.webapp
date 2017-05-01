@run
Feature: Perform lookup returns id and clears inputs

Scenario:
	Given user opens new lookup form
		And a random string of length '10' is stored with the key '#KEYWORD#'
	Then new lookup form is open
		And new lookup form is loaded
		And perform lookup button is disabled

	When user sets keyword field to '#KEYWORD#'
		And user selects first domain option
	Then perform lookup button is enabled
		And keyword field has value '#KEYWORD#'

	When user clicks perform lookup button
		And waits for page to unlock
	Then submission dialog is present
		And perform lookup button is disabled
		And e-mail field has value ''
		And keyword field has value ''

	When user clicks lookup detail link
		And waits for page to unlock
	Then lookup detail page is open
		And page contains text: '#KEYWORD# lookup' with case ignored
