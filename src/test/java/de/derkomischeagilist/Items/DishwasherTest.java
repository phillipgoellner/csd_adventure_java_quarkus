package de.derkomischeagilist.Items;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DishwasherTest {
    @Test
    void DishwasherHasCorrectBrand() {
        Dishwasher sut = new Dishwasher();

        assertThat(sut.brand, equalTo("ACME"));
    }

    @Test
    void LoadingDirtyKnivesIntoDishwasher() {
        Dishwasher sut = new Dishwasher();

        sut.loadDirtyKnives(5);

        assertThat(sut.dirtyKnivesLoaded, equalTo(5));
    }

    @Test
    void WashingDishesCleansDirtyKnives() {
        Dishwasher sut = new Dishwasher();
        sut.loadDirtyKnives(5);

        sut.startCleaning();

        assertThat(sut.cleanKnivesLoaded, equalTo(5));
    }
}
