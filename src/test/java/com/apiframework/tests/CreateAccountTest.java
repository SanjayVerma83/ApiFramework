package com.apiframework.tests;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiframework.base.BaseTest;
import com.apiframework.config.ConfigManager;
import com.apiframework.config.EndPoints;
import com.apiframework.payload.PayloadBuilder;
import com.apiframework.utils.ExcelUtil;

import io.restassured.response.Response;

public class CreateAccountTest extends BaseTest {

    @Test(priority = 1)
    public void createAccount() {

        // ===============================
        // Read Test Data from Excel
        // ===============================
        logger.info("========== Create Account Test Started ==========");
        logger.info("Name  : " + ExcelUtil.getCellData("CreateAccount", 1, 0));
        logger.info("Email : " + ExcelUtil.getCellData("CreateAccount", 1, 1));

        // ===============================
        // Build Request Payload
        // ===============================
        Map<String, String> payload = PayloadBuilder.createAccountPayload();

        logger.info("Request Payload : " + payload);

        // ===============================
        // Send POST Request
        // ===============================
        logger.info("Sending Create Account API Request...");
        logger.info("Endpoint : "
                + ConfigManager.getProperty("base.url") + EndPoints.CREATE_ACCOUNT);

        Response response = given()
                .spec(requestSpec)
                .formParams(payload)
                .when()
                .post(ConfigManager.getProperty("base.url") + EndPoints.CREATE_ACCOUNT);

        // ===============================
        // Log Response Details
        // ===============================
        logger.info("========== API Response ==========");
        logger.info("Status Code  : " + response.getStatusCode());
        logger.info("Response Time: " + response.getTime() + " ms");
        logger.info("Content-Type : " + response.getHeader("Content-Type"));

        logger.info("Response Body:");
        logger.info(response.asPrettyString());

        // ===============================
        // HTTP Validations
        // ===============================
        Assert.assertEquals(response.getStatusCode(), 200,
                "HTTP Status Code Validation Failed");

        Assert.assertTrue(response.getTime() < 5000,
                "Response Time Validation Failed");

        // ===============================
        // Business Validations
        // ===============================
        Assert.assertEquals(response.jsonPath().getInt("responseCode"),
                201,
                "Business Response Code Validation Failed");

        Assert.assertEquals(response.jsonPath().getString("message"),
                "User created!",
                "User Creation Validation Failed");

        // ===============================
        // Success Logs
        // ===============================
        logger.info("All Validations Passed Successfully.");
        logger.info("Create Account API Executed Successfully.");
        logger.info("========== Create Account Test Completed ==========");
    }
}