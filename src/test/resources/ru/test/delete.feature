Feature: DeleteTest

  Scenario: Test delete method of Tree class
    Given list of tree numbers
      | 9  |
      | 6  |
      | 16 |
      | 4  |
      | 10 |
      | 7  |
      | 19 |
    When tree created
    Then tree must remain the same after deleting nonexistent node
    And after deleting node 9, the node 10 becomes the root
    And after deleting node 19, the right son of the node 16 must become null
    And after deleting node 4, the right son of the node 6 must become null