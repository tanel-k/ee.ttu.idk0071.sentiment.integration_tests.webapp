@run
Feature: Perform lookup button is only enabled if the form is correctly filled

Scenario:
	# all form fields empty = disabled
	Given user opens new lookup form
	Then new lookup form is open
	And new lookup form is loaded
	And perform lookup button is disabled
	# keyword set, domain not selected, no email = disabled
	Given user sets keyword field to 'test'
	Then perform lookup button is disabled
	# keyword set, domain selected, no email = enabled
	Given user selects first domain option
	Then perform lookup button is enabled
	# keyword set, domain selected, bad email = disabled
	Given user sets e-mail field to 'bad-email'
	Then perform lookup button is disabled
	# keyword set, domain selected, good email = enabled
	Given user sets e-mail field to 'bad@email.com'
	Then perform lookup button is enabled
	# keyword set, domain selected, no email = enabled
	Given user sets e-mail field to ''
	Then perform lookup button is enabled
	# keyword empty, domain selected, no email = disabled
	Given user sets keyword field to ''
	Then perform lookup button is disabled