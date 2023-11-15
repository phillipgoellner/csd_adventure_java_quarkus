package de.derkomischeagilist;

import de.derkomischeagilist.Items.CoffeeMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CoffeeMakerTest {
    private CoffeeMaker coffeeMaker;

    @Test
    void testCoffeCanNotBeMadeWithoutPower() {
        coffeeMaker = new CoffeeMaker();
        assertThat(coffeeMaker.canMakeCoffee(), is(false));
        assertThat(coffeeMaker.whatsWrong(), containsString("There is no power connected"));
    }

    @Test
    void testCoffeCanNotBeMadeWithoutCoffeeBeans() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        assertThat(coffeeMaker.canMakeCoffee(), is(false));
        assertThat(coffeeMaker.whatsWrong(), containsString("There are no coffee beans in the machine"));
    }

    @Test
    void testCoffeCanNotBeMadeWithoutCup() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        coffeeMaker.addCoffeeBeans();
        assertThat(coffeeMaker.canMakeCoffee(), is(false));
        assertThat(coffeeMaker.whatsWrong(), containsString("There is no cup the machine"));
    }

    @Test
    void testCoffeCanNotBeMadeWithoutWater() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        coffeeMaker.addCoffeeBeans();
        coffeeMaker.putCupIn();
        assertThat(coffeeMaker.canMakeCoffee(), is(false));
        assertThat(coffeeMaker.whatsWrong(), containsString("There is no water in the machine"));
    }

    @Test
    void testCoffeCanBeMade() {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        coffeeMaker.addCoffeeBeans();
        coffeeMaker.putCupIn();
        coffeeMaker.addWater();
        assertThat(coffeeMaker.canMakeCoffee(), is(true));
    }

    @Test()
    void testMakingCoffeeTakesTime() {
        System.setProperty("TIME_TO_BREW_COFFEE_IN_MILLIS", "1000");
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.connectPower();
        coffeeMaker.addCoffeeBeans();
        coffeeMaker.putCupIn();
        coffeeMaker.addWater();

        var start = Instant.now();
        var result = coffeeMaker.handle("make coffee");
        var end = Instant.now();
        assertThat(result, containsString("You brewed a very nice looking cup of hot coffee."));
        var duration = end.getEpochSecond() - start.getEpochSecond();
        Assertions.assertTrue(duration >= 1);
        Assertions.assertTrue(duration < 60);
    }

    @Test
    void testCommandHandlerAddBeans() {
        coffeeMaker = new CoffeeMaker();
        assertThat(coffeeMaker.handle("add beans"), containsStringIgnoringCase("beans have been added"));
    }

    @Test
    void testCommandHandlerAddWater() {
        coffeeMaker = new CoffeeMaker();
        assertThat(coffeeMaker.handle("add water"), containsStringIgnoringCase("water has been added"));
    }

    @Test
    void testCommandListerFindsCommands() {
        coffeeMaker = new CoffeeMaker();
        assertThat(coffeeMaker.listCommands(), hasItem("add beans"));
    }
}
