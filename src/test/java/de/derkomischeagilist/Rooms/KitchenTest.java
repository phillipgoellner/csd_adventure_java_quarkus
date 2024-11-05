package de.derkomischeagilist.Rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.junit.jupiter.api.Assertions.*;

class KitchenTest {

    private static final Logger log = LoggerFactory.getLogger(KitchenTest.class);
    private Kitchen kitchen;

    @BeforeEach
    void setup() {
        this.kitchen = new Kitchen();
    }

    @Test
    void drinkCoffee() {
        // when
        var result = kitchen.handleCommand("drink coffee");

        // then
        assertEquals("you feel great", result.toLowerCase());
    }

    @Test
    void testHelpText() {
        String help = kitchen.getHelp();
        assertThat(help, containsStringIgnoringCase("Help in the kitchen is useless, but just in case, "
                + "you can: add beans,add water,connect power,put in cup,make coffee<br/>"
                + "If you want to restart, just try to 'commit suicide'."));
    }
}
