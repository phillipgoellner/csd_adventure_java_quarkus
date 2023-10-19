package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.WashRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class WashRoomTest {
    private WashRoom washRoom;

    @BeforeEach
    void setUp() {
        washRoom = new WashRoom();
    }

    @Test
    void PuttingPaperTowelsInBin() {
        String commandResult = washRoom.handleCommand("put paper towels in the bin");
        assertThat(commandResult, containsStringIgnoringCase("Bin has been filled with used paper towels."));
    }
}
