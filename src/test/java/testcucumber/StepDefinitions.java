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

    @Given("I have {int} cukes in my belly")
    public void i_have_cukes_in_my_belly(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("I wait {int} hour")
    public void i_wait_hour(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("my belly should growl")
    public void my_belly_should_growl() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

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