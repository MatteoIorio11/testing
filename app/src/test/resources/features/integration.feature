Feature: Logic Interaction

  Scenario: Hitting a new cell on an empty 10x10 board.
    Given The board is empty
    When The user hits the position at x=0, y=0
    Then The returned value should be one
