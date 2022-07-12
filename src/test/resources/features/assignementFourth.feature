# new feature
# Tags: optional

Feature: A description
  Background: I am logged into Orange Application.
    Given when I am in OrangeHRP Application
  Scenario: Validate visibility of the main navigation bar
    Given The user enters the site
    When He needs to see the main navigation options
    Then The navigation are visible