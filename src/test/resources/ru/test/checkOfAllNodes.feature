Feature: CheckOfAllNodes

  Scenario: Checking values of nodes
    Given list of values
      | 9  |
      | 6  |
      | 16 |
      | 4  |
      | 10 |
      | 7  |
      | 19 |
    When values are inserted
    Then check all left sons
      | 9  | 6  |
      | 6  | 4  |
      | 16 | 10 |
    And check all right sons
      | 9  | 16 |
      | 6  | 7  |
      | 16 | 19 |