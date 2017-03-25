Feature: FindMinOfTree

  Scenario: Find minimum element of tree
    Given list of node values
      | 9  |
      | 6  |
      | 16 |
      | 4  |
      | 10 |
      | 7  |
      | 19 |
    When all nodes created
    Then min node must be '4'