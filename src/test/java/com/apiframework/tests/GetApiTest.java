package com.apiframework.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiframework.base.BaseTest;
import com.apiframework.config.ConfigManager;
import com.apiframework.config.EndPoints;

import io.restassured.response.Response;

public class GetApiTest extends BaseTest {

    @Test
    public void getAllProducts() {

        // Send GET Request
        Response response = given().spec(requestSpec)
                .when()
                .get(ConfigManager.getProperty("base.url") + EndPoints.PRODUCTS_LIST);

        // API Execution Details
        System.out.println("\n========== GET Products API ==========");
        System.out.println("Status Code  : " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Content-Type : " + response.getHeader("Content-Type"));
        System.out.println("======================================\n");

        // Uncomment only for debugging
        // System.out.println(response.asPrettyString());

        // Validations
        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Validation Failed");
        Assert.assertTrue(response.getTime() < 5000, "Response Time Validation Failed");
        Assert.assertEquals(response.getHeader("Content-Type"),
                "text/html; charset=utf-8",
                "Content-Type Validation Failed");
    }
}