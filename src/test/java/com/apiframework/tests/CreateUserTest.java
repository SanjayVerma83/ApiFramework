package com.apiframework.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiframework.base.BaseTest;
import com.apiframework.config.ConfigManager;
import com.apiframework.pojo.CreateUserRequest;
import com.apiframework.pojo.CreateUserResponse;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUserTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CreateUserTest.class);

    @Test
    public void createUser() {

        logger.info("========== Create User API Test Started ==========");

        // Create Request POJO
        CreateUserRequest request = new CreateUserRequest();
        request.setName("Sanjay");
        request.setJob("QA Engineer");

        logger.info("Sending POST request to ReqRes API...");

        // Send Request
        Response response = given()
                .baseUri(ConfigManager.getProperty("pojo.url"))
                .header("x-api-key", ConfigManager.getProperty("api.key"))
                .contentType(ContentType.JSON)
                .body(request)

        .when()
                .post("/users")

        .then()
                .extract()
                .response();

        logger.info("Response Received Successfully");

        // Print Raw Response
        System.out.println("=========== RAW RESPONSE ===========");
        System.out.println(response.asPrettyString());

        // Status Code Validation
        Assert.assertEquals(response.getStatusCode(), 201, "Status Code Mismatch");

        logger.info("Status Code Validated Successfully");

        // JSON Schema Validation
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema/CreateUserSchema.json"));

        logger.info("JSON Schema Validation Passed");

        // Deserialize Response
        CreateUserResponse responsePojo = response.as(CreateUserResponse.class);

        // Field Validations
        Assert.assertEquals(responsePojo.getName(), "Sanjay");
        Assert.assertEquals(responsePojo.getJob(), "QA Engineer");
        Assert.assertNotNull(responsePojo.getId());
        Assert.assertNotNull(responsePojo.getCreatedAt());

        logger.info("Response POJO Validation Passed");

        // Print POJO Values
        System.out.println("\n=========== POJO RESPONSE ===========");
        System.out.println("Name       : " + responsePojo.getName());
        System.out.println("Job        : " + responsePojo.getJob());
        System.out.println("ID         : " + responsePojo.getId());
        System.out.println("Created At : " + responsePojo.getCreatedAt());

        logger.info("========== Create User API Test Completed Successfully ==========");
    }
}