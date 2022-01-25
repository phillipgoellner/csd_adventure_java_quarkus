Feature: hallway
  The hallway connects all rooms in our game.

  Scenario: Use the door from the washroom to the hallway
    Given I am in the washroom
    When I use the door to the hallway
    Then I am now in the hallway