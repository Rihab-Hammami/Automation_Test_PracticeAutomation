#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Form Fields

  Scenario: User fills out the form and submits successfully
    Given the user is on the form fields page
    When the user verifies the page title "Form Fields"
    And the user fills the name field with "rihab"
    And the user verifies the required field message "Required"
    And the user fills the password field with "rihab"
    And the user selects the following drinks:
      | drink1 |
      | drink2 |
      | drink3 |
      | drink4 |
      | drink5 |
    And the user selects the following colors:
      | color1 |
      | color2 |
      | color3 |
      | color4 |
      | color5 |
    And the user selects "Yes" from the dropdown
    And the user selects "No" from the dropdown
    And the user selects "Undecided" from the dropdown
    And the user verifies the selectable list options:
      | Selenium      |
      | Playwright    |
      | Cypress       |
      | Appium        |
      | Katalon Studio|
    And the user fills the email field with "rihabhammami633@gmail.com"
    And the user fills the message field with "hello"
    And the user submits the form
    Then the user should see the confirmation message "Message received!"
  

 