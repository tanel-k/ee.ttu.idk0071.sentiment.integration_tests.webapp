@run
Feature: Search button is only enabled if the form is correctly filled

Scenario:
	Given a random string of length '10' is stored with the key '#KEYWORD#'
	When user opens history page
	Then history page is open
		And history keyword field has value ''
		And no history domains are selected
		And search button is disabled

	When waits for page to unlock
		And user sets history keyword field to '#KEYWORD#'
	Then search button is disabled

	When user sets history keyword field to ''
		And user selects first history domain option
	Then search button is disabled

	When user sets history keyword field to '#KEYWORD#'
	Then search button is enabled

	