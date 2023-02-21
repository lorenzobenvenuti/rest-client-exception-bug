package it.lorenzobenvenuti.quarkus;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(WireMockExtensions.class)
public class GreetingResourceTest {

    @Test
    public void helloEndpointReturnsA500WhenTheRestClientCallFails() {
        given()
          .when().get("/hello/bar")
          .then()
             .statusCode(500);
    }

    @Test
    public void helloEndpointReturnsTheExpectedResponse() {
        given()
                .when().get("/hello/fizzbuzz")
                .then()
                .statusCode(200)
                .body("value", equalTo("fizzbuzz"));
    }

}