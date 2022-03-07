package testcucumber;

import de.derkomischeagilist.Items.Dishwasher;
import de.derkomischeagilist.Items.Shower;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

public class ShowerStepDefinitions {

    private Shower shower;
    private String showerCondition;

    @Given("I got a shower")
    public void i_got_a_shower() {
        this.shower = new Shower();

        assertThat(this.shower, instanceOf(Shower.class));
    }

    @When("I check the condition")
    public void i_check_the_condition() {
        this.showerCondition = this.shower.getCondition();
    }

    @Then("I should see that the shower is new")
    public void i_should_see_that_the_shower_is_new(){
        assertThat(this.showerCondition, equalTo(Shower.CONDITION_NEW));
    }
}
