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
    void HelpInHallwayContainsCommandToUseDoors() {
        String hallwayHelp = hallway.getHelp();
        assertThat(hallwayHelp, containsStringIgnoringCase("try to 'use spooky door'"));
        assertThat(hallwayHelp, containsStringIgnoringCase("use door to kitchen"));
        assertThat(hallwayHelp, containsStringIgnoringCase("use door to washroom"));
    }

    @Test
    void InspectingTheSpookyDoorRevealsTheKeypad() {
        String commandResult = hallway.handleCommand("inspect the spooky door");
        assertThat(commandResult, containsStringIgnoringCase("You see a rugged and sturdy steel door with cryptic symbols on it. Above the door is a sign saying \"EXIT\". "
        		+ "The door is covered in cobweb and next to it is a rusty keypad. The keypad has a post-it attached to saying \"Please enter number of Scrum values.\". "
        		+ "You could try to unlock the door with 'use keypad'."));
    }

    @Test
    void InputIsInterpretedAsKeypadCodeWhenFlagSet() {
        hallway.setActive();
        String commandResult = hallway.handleCommand("533");
        assertThat(commandResult, containsStringIgnoringCase("You made it"));
    }

    @Test
    void UsingTheKeypadOnceReturnsToNormalCommandInterpretation() {
        hallway.setActive();
        hallway.handleCommand("888");
        String commandResult = hallway.handleCommand("inspect the spooky door");
        assertThat(commandResult, containsStringIgnoringCase("You see a rugged and sturdy steel door with cryptic symbols on it."));
    }

    @Test
    void WrongKeypadCodeReturnsErrorMessage() {
        hallway.setActive();
        String commandResult = hallway.handleCommand("345");
        assertThat(commandResult, containsStringIgnoringCase("nothing happens"));
    }
}
