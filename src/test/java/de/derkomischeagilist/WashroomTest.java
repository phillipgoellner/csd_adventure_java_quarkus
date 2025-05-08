package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.WashRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * @author Jakob Silbereisen, Foconis Analytics GmbH
 */
public class WashroomTest {

	private WashRoom washroom;

	@BeforeEach
	void init() {
		this.washroom = new WashRoom();
	}

	@Test
	void testHelp() {
		String helpText = washroom.getHelp();
		assertThat(helpText, equalTo("Try to type 'look around', 'read DoD', 'use door to hallway', 'use door to loo', "
				+ "'put paper towels in the bin' or 'wash hands'.<br/>"
				+ "If you want to restart, just try to 'restart drinking'."));
	}

	@Test
	void testTooVagueDetailedDescription() {
		String detailedDescription = washroom.getDetailedDescription();
		assertThat(detailedDescription, not(containsStringIgnoringCase("On the other side of the room you see another door.")));
	}

	@Test
	void testDoorDescriptionsinDetailedDescription() {
		String detailedDescription = washroom.getDetailedDescription();
		assertThat(detailedDescription, containsStringIgnoringCase("door"));
		assertThat(detailedDescription, containsStringIgnoringCase("leads to"));
		assertThat(detailedDescription, containsStringIgnoringCase("loo"));
		assertThat(detailedDescription, containsStringIgnoringCase("hallway"));
	}

	@Test
	void testConfusingDetailedDescription() {
		String detailedDescription = washroom.getDetailedDescription();
		assertThat(detailedDescription, not(containsStringIgnoringCase("On the other side")));
	}
}
