Feature: Product management validation
  Background:
    Given Admin is on product creation page

  Scenario: Negative price should not be allowed
    When Admin enters -100 as price
    And Admin clicks Save button
    Then Validation error message should be displayed

  Scenario: Product name exceeds maximum length
    When Admin enters 256 characters product name
    And Admin clicks Save button
    Then Validation error message should be displayed