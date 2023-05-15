package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ClientResourceTest {

    @Test
    public void testClientEndpoint() {
        given()
          .when().get("/client")
          .then()
             .statusCode(500);
    }

}