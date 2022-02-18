package de.derkomischeagilist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdventureTest {

    private Adventure adventure;

    @BeforeEach
    void setUp() {
        adventure = new Adventure();
    }

    @Test
    void currentTimeLooksGood() {
        assertThat("timestamp", TimeService.currentTimeInEuropeBerlin(), greaterThan(-1));
    }

    @Test
    void AdventureStartsOnTheLoo() {
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
    }



    @Test
    void LookingAroundInTheLooThenICanSeeMagazines() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("magazines"));
    }

    @Test
    void LookingAroundInTheLooThenIWillFindScrumDeveloperCard() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("certified scrum developer"));
        assertThat(actual, containsStringIgnoringCase("card"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAScrumGuide() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("scrum guide"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAUsedMickyMouseMagazine() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("used micky mouse magazine"));
    }

    @Test
    void EnteringAnInvalidCommandResultsInWhatResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, endsWithIgnoringCase("What???"));
    }

    @Test
    void EnteringAnInvalidCommandStillIncludesPreviousResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void GoingThroughDoorInTheLooThenICanSeeTheWashRoom() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the wash room
        String actual = adventure.tell("go through door");
        //Then i can see the wash room
        assertThat(actual, containsStringIgnoringCase("wash room"));
    }

    @Test
    void LookingAroundInTheWashRoomThenIWillFindDoorAndSink() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the wash room
        adventure.tell("go through door");
        //When I look around
        String actual = adventure.tell("look around");
        //Then i can see a sink and a door
        assertThat(actual, containsStringIgnoringCase("nasty sink"));
    }

    @Test
    void GoingThroughDoorInTheTeamRoomThenIAmGreetedByMyTeammates() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("use door to team office");
        //Then i am greeted by my teammates
        assertThat(actual, containsStringIgnoringCase("Your smelly Teammates greet you in the usual manner: 'Hey, you moron! ;)'"));
    }
}
