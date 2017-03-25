Feature: RootNotNull

  Scenario: Check root on null value
    Given value of root '9'
    When insert this value
    Then root must be '9'