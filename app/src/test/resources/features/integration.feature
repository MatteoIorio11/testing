Feature: Logic Interaction

  Scenario: The User interacts with 10x10 board.
    Given The board is empty
    When The user hits the position at x=0, y=0
    Then The returned value should be one

  Scenario: The User interacts with 10x10 board and hits two random positions.
    Given The board is empty
    When The user hits two random positions in the board:
    """
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 X 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 X 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    """
    Then The returned value should be two

  Scenario: The User interacts with 10x10 board, hits a random positions and finds out which are the neighbouring positions of a hit.
    Given The board is empty
    When The user hits a random cell in the board:
    """
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 X 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 0 0 0 0 0 0 0
    """
    Then all 8 adjacent cells are identified as neighbors

  Scenario: The User interacts with 10x10 board, hits two neighbouring positions and finds out that the positions start moving.
    Given The board is empty
    When The user hits two positions which are neighbouring and not at the boarder such as x=5, y=5 and x=6, y=6
    Then The hitted positions start moving

  Scenario: The User interacts with 10x10 board, moves a hitted positions outside the border and then the game is over.
    Given The board is empty
    When The user hits position x=0,y=0 and a neighbouring position such as x=1, y=1
    Then The game is over
