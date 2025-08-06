package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.TeamOffice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * @author Jakob Silbereisen, Foconis Analytics GmbH
 */
public class TeamOfficeTest {

    private TeamOffice teamOffice;
    private Inventory inventory;

    @BeforeEach
    void init() {
        teamOffice = new TeamOffice();
        inventory = Inventory.getInstance();
        inventory.clear();
    }

    @Test
    void testHelp() {
        String helpText = teamOffice.getHelp();
        assertThat(helpText, not(equalTo("Try to type 'look around' or 'use door to hallway'.<br/>"
                + "If you want to restart, just try to 'restart drinking'.")));
    }


    @Test
    void LookingAroundLetsYouCharts() {
        String actualDescription = teamOffice.getDetailedDescription();
        assertThat(actualDescription, containsStringIgnoringCase("charts"));
    }

    @Test
    void LookingAroundLetsYouJukeBox() {
        String actualDescription = teamOffice.getDetailedDescription();
        assertThat(actualDescription, containsStringIgnoringCase("jukebox"));
    }

    @Test
    void LookAtJukeBox() {
        String actualDescription = teamOffice.handleCommand("look at jukebox");
        assertThat(actualDescription, containsStringIgnoringCase("Under Pressure"));
    }
    
    
    @Test
    void HelpInTeamOfficeCommandToUseDoors() {
        String teamOfficeHelp = teamOffice.getHelp();
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look at first cubicle"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look at wall"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("use door to hallway"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look around"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look at jukebox"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("restart drinking"));
    }

    @Test
    void EmptyCubicleWithCoinCommand() {
        teamOffice.lookedAtEmptyCubicle = false;
        String cubicleCommand = teamOffice.handleCommand("look at empty cubicle");
        assertThat(cubicleCommand, not(containsStringIgnoringCase("Sorry, I don't understand")));
        assertThat(cubicleCommand, containsStringIgnoringCase("coin"));

        assertThat(teamOffice.lookedAtEmptyCubicle, equalTo(true));
        assertThat(teamOffice.getHelp(), containsStringIgnoringCase("pick up coin"));
    }

    @Test
    void PickupCoinCommand() {
        teamOffice.lookedAtEmptyCubicle = true;

        String pickUpCoinCommand = teamOffice.handleCommand("pick up coin");
        assertThat(pickUpCoinCommand, not(containsStringIgnoringCase("Sorry, I don't understand")));
        assertThat(inventory.hasItem("coin"), equalTo(true));
    }

    @Test
    void PickUpCoinOnlyOnce() {
        String firstTryToPickUp = teamOffice.handleCommand("pick up coin");
        assertThat(firstTryToPickUp, containsStringIgnoringCase("pick"));
        assertThat(firstTryToPickUp, containsStringIgnoringCase("up"));
        assertThat(firstTryToPickUp, containsStringIgnoringCase("coin"));
        String secondTryToPickUp = teamOffice.handleCommand("pick up coin");
        assertThat(secondTryToPickUp, containsStringIgnoringCase("already have"));
        assertThat(secondTryToPickUp, containsStringIgnoringCase("coin"));
    }

    @Test
    void lookingAtjukeboxHelpText() {
        String insertCoin = teamOffice.handleCommand("insert coin");
        assertThat(insertCoin, containsStringIgnoringCase("inserted"));
        assertThat(insertCoin, containsStringIgnoringCase("coin"));
        assertThat(insertCoin, not(containsStringIgnoringCase("Sorry")));
    }
}
