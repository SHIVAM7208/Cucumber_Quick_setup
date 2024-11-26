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
Feature: Emeritus FE TestCases
  verifying all FE testcases for Emeritus
  
  Background: for login
  	Given Website URL Open
		When Userer input email and password
  

  @tag1
  Scenario: Valid User Login
   	Given after sucessfully login
		Then verify the title of page. 
		
	@tag2 @FE_48
	  Scenario: All Links of Account are clickable.
    Given after sucessfully login
    And Click on the Account button
    Then verify all links of Account are clickable
  


 # @tag2
  #	Scenario Outline: Title of your scenario outline
  #  Given I want to write a step with <name>
  #  When I check for the <value> in step
  #  Then I verify the <status> in step

   # Examples: 
    #  | name  | value | status  |
     # | name1 |     5 | success |

