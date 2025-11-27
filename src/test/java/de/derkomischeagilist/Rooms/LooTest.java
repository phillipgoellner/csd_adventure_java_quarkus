package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Rooms.Loo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.endsWithIgnoringCase;
import static org.junit.Assert.assertEquals;

public class LooTest {
    private Loo loo;

    @BeforeEach
    void setUp() {
        loo = new Loo();
    }

    @Test
    void flushTheToilet() {
        String commandResult = loo.handleCommand("flush toilet");
        assertThat(commandResult, containsStringIgnoringCase("Hsh, the stench has decreased drastically! You can breathe again :)"));
    }

    @Test
    void lookDown() {
        String commandResult = loo.getDetailedDescription();
        assertThat(commandResult, endsWithIgnoringCase("When you look down, you see your dropped pants."));
    }

    @Test
    void testHelp() {
        String helpText = loo.getHelp();
        assertThat(helpText, containsStringIgnoringCase("Try to 'look around', 'look at magazines', "
                + "'look at toilet paper', 'flush toilet' or just 'use door to washroom' "
                + "to escape the smell.<br/>"
                + "If you want to restart, just try to 'restart drinking'."));
    }

    @Test
    @DisplayName("When I look at toilet paper 1st time Then I get 1st message")
    void testLookAtToiletPaper() {
        String commandResult = lookAtToiletPaper();
        String expectedResult = "“Scrum Master: Nobody ever comes to my retros...";
        assertThat(commandResult, containsStringIgnoringCase(expectedResult));
    }

    @Test
    @DisplayName("When I look at toilet paper 2nd time Then I get 2nd message")
    void testLookAtToiletPaper_step2() {
        lookAtToiletPaper();
        String commandResult = lookAtToiletPaper();
        String expectedResult = "Another one states: “A foo walks into a bar.“ More to read on the floor.";
        assertThat(commandResult, containsStringIgnoringCase(expectedResult));
    }

    @Test
    @DisplayName("When I look at toilet paper 3rd time Then I get 3rd message")
    void testLookAtToiletPaper_step3() {
        lookAtToiletPaper();
        lookAtToiletPaper();
        String commandResult = lookAtToiletPaper();
        String expectedResult = "My developers are way too slow.";
        assertThat(commandResult, containsStringIgnoringCase(expectedResult));
    }

    @Test
    @DisplayName("When I look at toilet paper 4th time Then I get 4th message")
    void testLookAtToiletPaper_step4() {
        lookAtToiletPaper();
        lookAtToiletPaper();
        lookAtToiletPaper();
        String commandResult = lookAtToiletPaper();
        String expectedResult = "“Developers: We have too many meetings.“";
        assertThat(commandResult, containsStringIgnoringCase(expectedResult));
    }

    @Test
    @DisplayName("When I look at toilet paper 5th time Then I get 5th message")
    void testLookAtToiletPaper_step5() {
        lookAtToiletPaper();
        lookAtToiletPaper();
        lookAtToiletPaper();
        lookAtToiletPaper();
        String commandResult = lookAtToiletPaper();
        String expectedResult = "Why am I still looking at toilet paper?";
        assertThat(commandResult, containsStringIgnoringCase(expectedResult));
    }

    @Test
    @DisplayName("When I look at toilet paper 6th time Then I get 1st message again")
    void testLookAtToiletPaper_step6() {
        lookAtToiletPaper();
        lookAtToiletPaper();
        lookAtToiletPaper();
        lookAtToiletPaper();
        lookAtToiletPaper();
        String commandResult = lookAtToiletPaper();
        String expectedResult = "“Scrum Master: Nobody ever comes to my retros...";
        assertThat(commandResult, containsStringIgnoringCase(expectedResult));
    }

    private String lookAtToiletPaper() {
        return loo.handleCommand("look at toilet paper");
    }
}
