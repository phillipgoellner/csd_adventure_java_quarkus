Feature: TeamOffice

  Scenario: Choosing correct song in jukebox
    Given I am in the team office room
    And I have looked at jukebox
    When I have chosen the song "11"
    Then The jukebox has been started to play the song - "Oh Happy Day"

  Scenario: Choosing unsupported song in jukebox
    Given I am in the team office room
    And I have looked at jukebox
    When I have chosen the song "23"
    Then An error page is displayed

