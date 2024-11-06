package de.derkomischeagilist;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

/**
 * @author Jakob Silbereisen, Foconis Analytics GmbH
 */
@QuarkusTest
public class CommandResourceTest {

	@Inject
	private AdventureService adventureService;

	private CommandResource commandResource;

	@BeforeEach
	void init() {
		commandResource = new CommandResource(adventureService);
	}

	@Test
	public void testSwitchRoom() {
		String initialResponse = commandResource.game(""); // Nothing should happen, we get the previous response
		assertThat(initialResponse, containsStringIgnoringCase("you are in the loo"));
		assertThat(commandResource.game("use door to washroom"), containsStringIgnoringCase("you are in the washroom"));
	}
}
