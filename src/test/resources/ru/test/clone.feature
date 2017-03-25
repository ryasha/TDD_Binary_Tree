Feature: CloneTest

  Scenario: Test of clone method if Tree class
    Given list of numbers
      | 9  |
      | 6  |
      | 16 |
      | 4  |
      | 10 |
      | 7  |
      | 19 |
    When tree is filled
    Then the original tree and its clone must be equal