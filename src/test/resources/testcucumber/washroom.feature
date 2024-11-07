Feature: Washroom
  You can only enter the hallway if you wash your hands.

  Scenario: Use the door from the washroom to the hallway without washing hands
    Given I am in the washroom 
    And I did not wash my hands
    When I use the door to the hallway
    Then I am still in the washroom 
    And I don´t feel ready to leave
    

	Scenario: Use the door from the washroom to the hallway with washing hands
    Given I am in the washroom 
    And I did wash my hands
    When I use the door to the hallway
    Then I can go in the hallway

  
