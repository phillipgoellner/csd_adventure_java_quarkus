package de.derkomischeagilist;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class GameResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/game")
                .then()
                .statusCode(200)
                .body(containsString("Hangover"));
    }

}
