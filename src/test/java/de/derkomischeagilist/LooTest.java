package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Loo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class LooTest {
    private Loo loo;

    @BeforeEach
    void setUp() {
        loo = new Loo();
    }

    @Test
    void flushTheToilet() {
        String commandResult = loo.handleCommand("flush toilet");
        assertThat(commandResult, containsStringIgnoringCase("The toilet is clean for the next person."));
    }
}
