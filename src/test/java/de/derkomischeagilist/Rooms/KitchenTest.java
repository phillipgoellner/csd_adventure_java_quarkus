package de.derkomischeagilist.Rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KitchenTest {

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

}
