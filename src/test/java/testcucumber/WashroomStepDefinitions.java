package testcucumber;

import de.derkomischeagilist.Adventure;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class WashroomStepDefinitions {
	
	private Adventure adventure;
    private String lastResponse;
	
	@Before
    public void setUp() {
		 adventure = new Adventure();
	     lastResponse = adventure.Begin(); 
    }
	
	@Given("I did not wash my hands")
	public void i_did_not_wash_my_hands() {
		//do nothing
	}

	@Then("I am still in the washroom")
	public void i_am_still_in_the_washroom() {
		 assertEquals(adventure.whereAreWe(), "Washroom");
	}

	@Then("I don´t feel ready to leave")
	public void i_don_t_feel_ready_to_leave() {
		assertThat(lastResponse, containsStringIgnoringCase("Your hands feel sticky"));
	}
	
	@Given("I am in the washroom")
	public void i_am_in_the_washroom() {
		lastResponse = adventure.tell("use door to washroom");
        assertThat(lastResponse, containsStringIgnoringCase("looks like a wash room"));
	}

	@When("I use the door to the hallway")
	public void i_use_the_door_to_the_hallway() {
		lastResponse = adventure.tell("use door to hallway");
	}

	@Given("I did wash my hands")
	public void i_did_wash_my_hands() {
		lastResponse = adventure.tell("wash hands");
		assertThat(lastResponse, containsStringIgnoringCase("So you happily wash your hands"));
	}
	
	 @Then("I can go in the hallway")
	    public void i_am_now_in_the_hallway() {
	        assertThat(lastResponse, containsStringIgnoringCase("welcome to the hallway"));
	    }

}
