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

    @BeforeEach
    void init() {
        teamOffice = new TeamOffice();
    }

    @Test
    void testHelp() {
        String helpText = teamOffice.getHelp();
        assertThat(helpText, not(equalTo("Try to type 'look around' or 'use door to hallway'.<br/>"
                + "If you want to restart, just try to 'commit suicide'.")));
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
    void HelpInTeamOfficeCommandToUseDoors() {
        String teamOfficeHelp = teamOffice.getHelp();
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look at first cubicle"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look at wall"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("use door to hallway"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look around"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("look at jukebox"));
        assertThat(teamOfficeHelp, containsStringIgnoringCase("commit suicide"));
    }
}
