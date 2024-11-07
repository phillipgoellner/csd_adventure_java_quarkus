Feature: hallway
  The hallway connects all rooms in our game.

  Scenario: Use the door from the hallway to the team office
    Given I am in the hallway
    When I use the door to the team office
    Then I am now in the team office