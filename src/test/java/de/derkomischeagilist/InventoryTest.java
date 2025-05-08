package de.derkomischeagilist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void init() {
        inventory = new Inventory();
    }

    @Test
    void inventoryTest() {
        assertThat(inventory.hasItem("test"), equalTo(false));

        // Add single item
        inventory.addItem("test");
        assertThat(inventory.hasItem("test"), equalTo(true));

        // Check duplicate item
        assertThat(inventory.addItem("test"), equalTo(false));

        // Remove single item
        inventory.removeItem("test");
        assertThat(inventory.hasItem("test"), equalTo(false));

        // Add and clear items
        inventory.addItem("test");
        inventory.clear();
        assertThat(inventory.hasItem("test"), equalTo(false));

        // Add multiple items and check representation
        inventory.addItem("test1");
        inventory.addItem("test2");
        assertThat(inventory.toString(), equalToIgnoringCase("test1, test2"));
        inventory.clear();
        assertThat(inventory.toString(), equalToIgnoringCase("empty"));
    }
}