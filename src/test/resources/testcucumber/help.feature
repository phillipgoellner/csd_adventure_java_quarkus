Feature: We want help
  Ich möchte Hilfe bekommen, damit ich weiß, was ich überhaupt machen kann.

  Scenario: help on the loo
    Given I am on the loo
    When I ask for help
    Then I see "look around"
    And I see "go through door"

  Scenario: help in the washroom
    Given I am in the washroom
    When I ask for help
    Then I see "look around"
