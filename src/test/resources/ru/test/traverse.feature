Feature: TraverseTree

  Scenario: Check traverse method of Tree class
    Given list of data
      | 9  |
      | 6  |
      | 16 |
      | 4  |
      | 10 |
      | 7  |
      | 19 |
    Given list for checking inOrder type
      | 4  |
      | 6  |
      | 7  |
      | 9  |
      | 10 |
      | 16 |
      | 19 |
    Given list for checking preOrder type
      | 9  |
      | 6  |
      | 4  |
      | 7  |
      | 16 |
      | 10 |
      | 19 |
    Given list for checking postOrder type
      | 4  |
      | 7  |
      | 6  |
      | 10 |
      | 19 |
      | 16 |
      | 9  |
    When nodes are inserted
    Then check inOrder type of traverse
    And check preOrder type of traverse
    And check postOrder type of traverse