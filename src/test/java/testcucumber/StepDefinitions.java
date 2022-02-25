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

    @When("I use the door to the hallway")
    public void i_use_the_door_to_the_hallway() {
        lastResponse = adventure.tell("use door to hallway");
    }

    @Then("I am now in the hallway")
    public void i_am_now_in_the_hallway() {
        assertThat(lastResponse, containsStringIgnoringCase("welcome to the hallway"));
    }

    @Given("I am in the hallway")
    public void i_am_in_the_hallway() {
        i_am_playing_the_game();

        lastResponse = adventure.tell("use door to hallway");

        i_am_now_in_the_hallway();
    }

    @When("I use the door to the team office")
    public void i_use_the_door_to_the_team_office() {
        lastResponse = adventure.tell("use door to team office");
    }

    @Given("I am in the team office")
    public void i_am_in_the_team_office() {
        i_am_playing_the_game();

        lastResponse = adventure.tell("use door to team office");

        i_am_now_in_the_team_office();
    }

    @Then("I am now in the team office")
    public void i_am_now_in_the_team_office() {
        assertThat(lastResponse, containsStringIgnoringCase("stinky room"));
    }
}
