package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Hallway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class HallwayTest {

    private Hallway hallway;

    @BeforeEach
    void setUp() {
        hallway = new Hallway();
    }

    @Test
    void LookingAroundLetsYouSeeSpecialDoor() {
        String actualDescription = hallway.getDetailedDescription();
        assertThat(actualDescription, containsStringIgnoringCase("At the end you see a spooky looking door."));
    }

    @Test
    void LookingAroundLetsYouSeePoster() {
        String actualDescription = hallway.getDetailedDescription();
        assertThat(actualDescription, containsStringIgnoringCase("poster"));
    }

    @Test
    void HelpInHallwayContainsCommandToUseDoors() {
        String hallwayHelp = hallway.getHelp();
        assertThat(hallwayHelp, containsStringIgnoringCase("try to 'inspect the spooky door'"));
        assertThat(hallwayHelp, containsStringIgnoringCase("use door to kitchen"));
        assertThat(hallwayHelp, containsStringIgnoringCase("use door to washroom"));
    }


    @Test
    void HelpInHallwayContainsHintToPoster() {
        String hallwayHelp = hallway.getHelp();
        assertThat(hallwayHelp, containsStringIgnoringCase("'inspect the poster'"));
    }

    @Test
    void testHelpLineBreak() {
        String helpText = hallway.getHelp();
        assertThat(helpText, containsStringIgnoringCase("<br/>If you want to restart, just try to 'restart drinking'."));
    }

    @Test
    void InspectingTheSpookyDoorRevealsTheKeypad() {
        String commandResult = hallway.handleCommand("inspect the spooky door");
        assertThat(commandResult, containsStringIgnoringCase("You see a rugged and sturdy steel door with cryptic symbols on it. Above the door is a sign saying \"EXIT\". "
        		+ "The door is covered in cobweb and next to it is a rusty keypad."
        		+ "You could try to unlock the door with 'use keypad'."));
    }

    @Test
    void InspectingThePosterRevealsScrumValues() {
        String commandResult = hallway.handleCommand("inspect the poster");
        assertThat(commandResult, containsStringIgnoringCase("<span>~~^^~~~~ ~~~~~^^^^~~~ ~~~~~^^^~~</span>\n"));
        assertThat(commandResult, containsStringIgnoringCase("We pinned the 5&#65039;&#8419 mighty Scrum \n"));
        assertThat(commandResult, containsStringIgnoringCase("Values, they are : \n"));
        assertThat(commandResult, containsStringIgnoringCase("  <span style=\"margin-left:200px\"> • Commitment</span>\n"));
        assertThat(commandResult, containsStringIgnoringCase("  <span style=\"margin-left:40px\"> • Courage</span>\n"));
        assertThat(commandResult, containsStringIgnoringCase("   • Focus\n"));
        assertThat(commandResult, containsStringIgnoringCase("  <span style=\"margin-left:160px\"> • Openness</span>\n"));
        assertThat(commandResult, containsStringIgnoringCase("   • Respect\n"));
    }

    @Test
    void InputIsInterpretedAsKeypadCodeWhenFlagSet() {
        hallway.activateKeypad();
        String commandResult = hallway.handleCommand("5");
        assertThat(commandResult, containsStringIgnoringCase("You made it"));
    }

    @Test
    void UsingTheKeypadOnceReturnsToNormalCommandInterpretation() {
        hallway.activateKeypad();
        hallway.handleCommand("888");
        String commandResult = hallway.handleCommand("inspect the spooky door");
        assertThat(commandResult, containsStringIgnoringCase("You see a rugged and sturdy steel door with cryptic symbols on it."));
    }

    @Test
    void WrongKeypadCodeReturnsErrorMessage() {
        hallway.activateKeypad();
        String commandResult = hallway.handleCommand("345");
        assertThat(commandResult, containsStringIgnoringCase("nothing happens"));
    }
}
