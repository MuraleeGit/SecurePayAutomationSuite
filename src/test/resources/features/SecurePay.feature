@smoke

Feature: SecurePay contact us form filling

 Scenario Outline: Fill the contact us form on SecurePay
    Given I am on google search page
 	When I search in google for "<searchValue>"
 	And I click on SecurePay online payments website
    And I click on contact us link from SecurePay page
    And I verifies that contact us page is loaded
	Then I fill the contact us form

Examples:
|searchValue|
|securepay|
