package com.apiframework.tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class BasicAuthTest {

    @Test
    public void basicAuthenticationExample() {

        Response response = given()
                .auth()
                .basic("admin", "password123")

        .when()
                .get("https://postman-echo.com/basic-auth");

        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println(response.asPrettyString());
    }
}