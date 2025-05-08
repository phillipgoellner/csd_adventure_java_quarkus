package de.derkomischeagilist;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory inventory = Inventory.getInstance();

    @AfterEach
    void init() {
        inventory.clear();
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
        assertThat(inventory.toString(), equalToIgnoringCase("empty"));
        inventory.addItem("test1");
        inventory.addItem("test2");
        assertThat(inventory.toString(), equalToIgnoringCase("test1, test2"));
    }

    @Test
    void inventoryReferencesTest() {
        assertThat(inventory.hasItem("test"), equalTo(false));

        inventory.addItem("test");
        Inventory inventoryReference = Inventory.getInstance();
        assertThat(inventoryReference.hasItem("test"), equalTo(true));

        inventoryReference.clear();
        assertThat(inventory.hasItem("test"), equalTo(false));
    }
}