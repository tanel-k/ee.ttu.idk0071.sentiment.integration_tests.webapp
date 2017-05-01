@run
Feature: Perform lookup button is only enabled if the form is correctly filled

Scenario:
	# all form fields empty = disabled
	Given user opens new lookup form
		And a random string of length '10' is stored with the key '#KEYWORD#'
	Then new lookup form is open
		And new lookup form is loaded
		And perform lookup button is disabled
		And e-mail field has value ''
		And keyword field has value ''

	# keyword set, domain not selected, no email = disabled
	When user sets keyword field to '#KEYWORD#'
	Then perform lookup button is disabled

	# keyword set, domain selected, no email = enabled
	When user selects first domain option
	Then perform lookup button is enabled

	# keyword set, domain selected, bad email = disabled
	When user sets e-mail field to 'bad-email'
	Then perform lookup button is disabled

	# keyword set, domain selected, good email = enabled
	When user sets e-mail field to 'good@email.com'
	Then perform lookup button is enabled

	# keyword set, domain selected, no email = enabled
	When user sets e-mail field to ''
	Then perform lookup button is enabled

	# keyword empty, domain selected, no email = disabled
	When user sets keyword field to ''
	Then perform lookup button is disabled
