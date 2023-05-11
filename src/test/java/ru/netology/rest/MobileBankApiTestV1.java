package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {

        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200);
    }

    @Test
    void matchesJsonSchema() {

        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")// код теста
                .then()
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
