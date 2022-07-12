# new feature
# Tags: optional

Feature: Login
  Scenario Outline: Login the Orange Page
    Given I open My application
    When type username "<user>"
    And type password "<secret>"
    Then Validate landing page
    Examples:
      | user | secret |
      |Admin|admin123|
