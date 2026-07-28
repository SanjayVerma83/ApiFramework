package com.apiframework.tests;

import org.testng.annotations.Test;

import com.apiframework.base.BaseTest;
import com.apiframework.pojo.CreateUserRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SerializationDemoTest extends BaseTest {

    @Test
    public void createUserUsingPojo() {

        // Create POJO object
        CreateUserRequest request = new CreateUserRequest();

        // Set values
        request.setName("Sanjay");
        request.setJob("QA Engineer");

        // Send Request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(request)
        .when()
                .post("https://reqres.in/api/users");

        // Print Response
        System.out.println(response.asPrettyString());
    }
}