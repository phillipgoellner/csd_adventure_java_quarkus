package testcucumber;

import de.derkomischeagilist.Adventure;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StepDefinitions {

    private Adventure adventure;
    private String lastResponse;

    private void assertThatTheLooIsTheInitialRoom() {
        assertThat(lastResponse, containsStringIgnoringCase("on the loo"));
    }

    @Given("I am playing the game")
    public void i_am_playing_the_game() {
        adventure = new Adventure();
        lastResponse = adventure.Begin();

        assertThat(lastResponse, is(not(emptyString())));
    }

    @Given("I am on the loo")
    public void i_am_on_the_loo() {
        i_am_playing_the_game();
        assertThatTheLooIsTheInitialRoom();
    }

    @Given("I am in the washroom")
    public void i_am_in_the_washroom() {
        i_am_playing_the_game();

        lastResponse = adventure.tell("go through door");

        assertThat(lastResponse, containsStringIgnoringCase("looks like a wash room"));
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
