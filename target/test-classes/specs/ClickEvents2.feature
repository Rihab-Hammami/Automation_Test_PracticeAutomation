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
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Click Events cat
    Given I am in page click events
    When I click for the animal
    Then I verify the sound displayed
    
  Scenario: Click Events dog
    Given I am in page click events
    When I click for the animal dog
    Then I verify the sound displayed of dog 
  Scenario: Click Events pig
    Given I am in page click events
    When I click for the animal pig
    Then I verify the sound displayed of pig
    
  Scenario: Click Events cow
    Given I am in page click events
    When I click for the animal cow
    Then I verify the sound displayed of cow
    
    
      
  
      
    