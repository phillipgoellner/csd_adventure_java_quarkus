package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Loo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.endsWithIgnoringCase;

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
}
