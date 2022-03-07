Feature: Shower

  Scenario: A new shower
    Given I got a shower
    When I check the condition
    Then I should see that the shower is new

  Scenario: A used shower
    Given I got a shower from a friend
    When I check the condition
    Then I should see that the shower is used