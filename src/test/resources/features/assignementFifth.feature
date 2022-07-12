# new feature
# Tags: optional
@SmokeTest
Feature: A description
  Background: I am logged into Orange Application.
    Given when I am in OrangeHRP Application
    Then Login to Application
    When Dashboard page is available
  Scenario: A scenario
    Given I want to logout
    When I click on logout
    Then I am returned to the login Page