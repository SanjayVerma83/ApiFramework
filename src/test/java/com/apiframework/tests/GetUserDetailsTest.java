package com.apiframework.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiframework.base.BaseTest;
import com.apiframework.config.ConfigManager;
import com.apiframework.config.EndPoints;
import com.apiframework.utils.ExcelUtil;

import io.restassured.response.Response;

public class GetUserDetailsTest extends BaseTest {

    @Test(priority = 1)
    public void getUserDetails() {

        // Read Email from Excel
        String email = ExcelUtil.getCellData("CreateAccount", 1, 1);

        System.out.println("Email : " + email);

        // Send GET Request
        Response response = given().spec(requestSpec)
                .queryParam("email", email)
                .when()
                .get(ConfigManager.getProperty("base.url") + EndPoints.GET_USER_DETAILS);

        // Print Response Details
        System.out.println("\n========== Get User Details API ==========");
        System.out.println("Status Code  : " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Content-Type : " + response.getHeader("Content-Type"));
        System.out.println("==========================================\n");

        System.out.println(response.asPrettyString());

        // HTTP Validations
        Assert.assertEquals(response.getStatusCode(), 200, "HTTP Status Code Validation Failed");
        Assert.assertTrue(response.getTime() < 5000, "Response Time Validation Failed");

        // Business Validations
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200,
                "Business Response Code Validation Failed");

        Assert.assertEquals(response.jsonPath().getString("user.email"), email,
                "Email Validation Failed");

    }
}