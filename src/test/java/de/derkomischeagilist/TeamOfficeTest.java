package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.TeamOffice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
		assertThat(helpText, equalTo("Try to type 'look around' or 'use door to hallway'.<br/>"
				+ "If you want to restart, just try to 'commit suicide'."));
	}
}
