# new feature
# Tags: optional

Feature: Login
  Scenario Outline: Invalid Login
    Given I open My application
    When type username "<user>"
    And type password "<secret>"
    Then Validate that I am not login since the credential were incorrect
    Examples:
      | user | secret |
      |Admin|admin1234|
