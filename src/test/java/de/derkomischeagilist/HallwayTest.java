package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Hallway;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class HallwayTest {

    @Test
    void LookingAroundLetsYouSeeSpecialDoor() {
        final Hallway hallway = new Hallway();
        String actualDescription = hallway.getDetailedDescription();
        assertThat(actualDescription, containsStringIgnoringCase("At the end you see a spooky looking door."));
    }

    @Test
    void HelpInHallwayContainsCommandToInspectSpookyDoor() {
        final Hallway hallway = new Hallway();
        String hallwayHelp = hallway.getHelp();
        assertThat(hallwayHelp, containsStringIgnoringCase("try to 'inspect the spooky door'"));
    }

    @Test
    void InspectingTheSpookyDoorRevealsTheKeypad() {
        final Hallway hallway = new Hallway();
        String commandResult = hallway.handleCommand("inspect the spooky door");
        assertThat(commandResult, containsStringIgnoringCase("You see a rugged and sturdy steel door with cryptic symbols on it. The door is covered in cobweb and next to it is a rusty keypad. If you feel brave enough you could 'open the spooky door'?"));
    }

    @Test
    void TryingToOpenTheSpookyDoorRevealsItIsLocked() {
        final Hallway hallway = new Hallway();
        String commandResult = hallway.handleCommand("open the spooky door");
        assertThat(commandResult, containsStringIgnoringCase("It seems locked and doesn't budge."));
    }
}
