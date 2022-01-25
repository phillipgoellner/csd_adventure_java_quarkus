package testcucumber;

import de.derkomischeagilist.Adventure;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class StepDefinitions {

    private Adventure adventure;
    private String lastResponse;

    @Given("I am playing the game")
    public void i_am_playing_the_game() {
        adventure = new Adventure();
        adventure.Begin();
    }

    @When("I ask for help")
    public void i_ask_for_help() {
        lastResponse = adventure.tell("help");
    }

    @Then("I see {string}")
    public void i_see(String string) {
        assertThat(lastResponse, containsStringIgnoringCase(string));
    }


}
