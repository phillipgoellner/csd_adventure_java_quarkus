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
}
