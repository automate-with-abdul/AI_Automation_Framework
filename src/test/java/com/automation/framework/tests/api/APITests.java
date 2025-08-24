package com.automation.framework.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class APITests {
    
    @Test
    public void testGetUserDetails() {
        Response response = RestAssured
                .given()
                .baseUri("https://api.example.com")
                .when()
                .get("/users/1")
                .then()
                .extract().response();

        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("username"), "Bret");
        assertNotNull(response.jsonPath().getString("email"));
    }
}
