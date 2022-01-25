Feature: We want help
  Ich möchte Hilfe bekommen, damit ich weiß, was ich überhaupt machen kann.

  Scenario: help does not only say WTF
    Given I am playing the game
    When I ask for help
    Then I see "there is no help for you"