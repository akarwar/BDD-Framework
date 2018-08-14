#Feature: Free CRM Login Feature

#Scenario: Free CRM Login Test Scenario
# BDD without example keyword
#Given user is already on login Page
#When title of login page is Free CRM
#Then user enters "arahim" and "arahim"
#And user clicks on login button
#Then user is on home page

Feature: Free CRM Login Feature

Scenario Outline: Free CRM Login Test Scenario
# BDD with example keyword
Given user is already on login Page
When title of login page is Free CRM
Then user enters "<username>" and "<password>"
And user clicks on login button
Then user is on home page
Then close the browser

Examples:
| username | password |
| arahim   | arahim   |
| arahim1  | arahim2  |