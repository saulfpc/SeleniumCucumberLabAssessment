# new feature
# Tags: optional

Feature: A description
  Background: I am logged into Orange Application.
    Given when I am in OrangeHRP Application
    Then Login to Application
    When Dashboard page is available
  @SmokeTest @RegressionTest
  Scenario Outline: search in directory
    Given The user wants to find a specific employee
    When I search the user with the name "<name>"
    Then Find the employee with "<name>"
    Examples:
      | name         |
      | Odis Adalwin |