package com.apiframework.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiframework.base.BaseTest;
import com.apiframework.config.ConfigManager;
import com.apiframework.config.EndPoints;
import com.apiframework.utils.ExcelUtil;
import com.apiframework.utils.TestDataStore;

import io.restassured.response.Response;

public class DeleteAccountTest extends BaseTest {

    @Test(priority = 1)
    public void deleteAccount() {

        // Get Dynamic Email
        String email = TestDataStore.email;

        // Password remains same from Excel
        String password = ExcelUtil.getCellData("CreateAccount", 1, 2);

        logger.info("Email : {}", email);

        // Send DELETE Request
        Response response = given()
                .spec(requestSpec)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete(ConfigManager.getProperty("base.url") + EndPoints.DELETE_ACCOUNT);

        // Print Response Details
        System.out.println("\n========== Delete Account API ==========");
        System.out.println("Status Code  : " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Content-Type : " + response.getHeader("Content-Type"));
        System.out.println("========================================\n");

        System.out.println(response.asPrettyString());

        // HTTP Validations
        Assert.assertEquals(response.getStatusCode(), 200,
                "HTTP Status Code Validation Failed");

        Assert.assertTrue(response.getTime() < 5000,
                "Response Time Validation Failed");

        // Business Validations
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200,
                "Business Response Code Validation Failed");

        Assert.assertEquals(response.jsonPath().getString("message"),
                "Account deleted!",
                "Account Deletion Validation Failed");
    }
}