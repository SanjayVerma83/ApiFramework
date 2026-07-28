package com.apiframework.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apiframework.base.BaseTest;
import com.apiframework.config.ConfigManager;
import com.apiframework.config.EndPoints;

import io.restassured.response.Response;

public class PostApiTest extends BaseTest {

    @Test(priority = 1)
    public void searchProduct() {

        Response response = given()
                .spec(requestSpec)
                .formParam("search_product", "top")
                .when()
                .post(ConfigManager.getProperty("base.url") + EndPoints.SEARCH_PRODUCT);

        System.out.println("\n========== Search Product API ==========");
        System.out.println("Status Code  : " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Content-Type : " + response.getHeader("Content-Type"));
        System.out.println("========================================\n");

        // Uncomment for debugging
        // System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Validation Failed");
        Assert.assertTrue(response.getTime() < 5000, "Response Time Validation Failed");
    }

    @Test(priority = 2)
    public void verifyLogin() {

        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("email", ConfigManager.getProperty("email"))
                .formParam("password", ConfigManager.getProperty("password"))
                .when()
                .post(ConfigManager.getProperty("base.url") + EndPoints.VERIFY_LOGIN);

        System.out.println("\n========== Verify Login API ==========");
        System.out.println("Status Code  : " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Content-Type : " + response.getHeader("Content-Type"));
        System.out.println("======================================\n");

        // Uncomment for debugging
        // System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200, "Status Code Validation Failed");
        Assert.assertTrue(response.getTime() < 5000, "Response Time Validation Failed");
    }
}