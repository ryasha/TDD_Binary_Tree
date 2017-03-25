Feature: EqualsTest

  Scenario: Test equals method of Tree class
    Given list of nodes
      | 9  |
      | 6  |
      | 16 |
      | 4  |
      | 10 |
      | 7  |
      | 19 |
    When nodes are created
    Then equals must return true, when trees have same references
    And equals must return false, if the second tree does not exist
    And equals must return false, if roots are not equal
    And equals must return true, if trees have the same nodes
    And equals must return false, if trees have even one different node