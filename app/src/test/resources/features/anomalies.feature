Feature: Logic Interaction with invalid inputs from the user
  Scenario: The user interacts with a board and because of some bug he hits a position outside the grid.
    Given A board with an edge of 10.
    When The user hits a position outside from the board.
    Then The system must handle this problem and avoid to save the input position.
