Feature: Free CRM Creat Contacts

Scenario Outline: Free CRM Create a new contact scenario

Given user is already on login Page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
And user clicks on login button
Then user is on home page
Then user meves to new contact page
Then user enters contact details "<firstname>" and "<lastname>" and "<position>"
Then close the browser

Examples:
| username | password | firstname | lastname | position |
| arahim   | arahim   | Gulab     | Rajabi   | Admin		|
| arahim   | arahim   | Farzad    | Qayoumi  | Director |