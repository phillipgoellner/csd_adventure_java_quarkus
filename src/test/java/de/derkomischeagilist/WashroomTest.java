package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.WashRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

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
				+ "If you want to restart, just try to 'commit suicide'."));
	}
}
