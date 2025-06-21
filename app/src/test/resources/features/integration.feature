Feature: Logic Interaction

  Scenario: The User interacts with 10x10 board.
    Given The board is empty
    When The user hits the position at x=0, y=0
    Then The returned value should be one

    Given The board is empty
    When The user hits position x=0, y=0 and x=7, y=7
    Then The returned value should be two

    Given The board is empty
    When The user hits position x=0,y=0 and a neighbouring position such as x=1, y=1
    Then The game is over
