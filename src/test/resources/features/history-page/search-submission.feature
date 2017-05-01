@run
Feature: Click on search leads to results shown under search section

Scenario:
	Given a random string of length '10' is stored with the key '#KEYWORD#'
	When user opens history page
	Then history page is open
		And search button is disabled

	When waits for page to unlock
		And user sets history keyword field to '#KEYWORD#'
		And user selects first history domain option
	Then search button is enabled

	When user clicks search button
		And waits for page to unlock
	Then page contains text: 'Historic sentiment data for #KEYWORD#' with case ignored
