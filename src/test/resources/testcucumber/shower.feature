Feature: Shower

  Scenario: One can create a new shower
    Given I got a shower
    When I check the condition
    Then I should see that the shower is new