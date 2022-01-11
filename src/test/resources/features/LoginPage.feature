@login
Feature: Log in Clickcar
  As user I want to log in with my credential successfully

  Background: 
    Given User is on Login page

  @smoke
  Scenario: User login successfully with default credentials
    When User input default email and password
    And User click Login button
    Then User login successfully

  #@data-driven
  #Scenario Outline: User login with specific credentials
    #When User input email "<email>" and password "<password>"
    #And User click Login button
    #Then Verify that log in status is "<status>"
#
    #Examples: 
      #| email                  | password  | status  |
      #| hoangnd1@smartosc.com  | Hoang123  | Success |
      #| hoangnd1@smartosc.com  | Hoang1234 | Failed  |
