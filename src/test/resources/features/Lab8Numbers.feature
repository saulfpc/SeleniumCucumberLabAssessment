# new feature
# Tags: optional

Feature: Multiplication

  Scenario: The sum of a list of numbers should
  be calculated
    Given a list of numbers
      | 4 |
      | 5 |
      | 6 |
    When I Multiply them
    Then should I get 120