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

public class UpdateAccountTest extends BaseTest {

    @Test(priority = 1)
    public void updateAccount() {

        // Get Dynamic Test Data
        String name = TestDataStore.name;
        String email = TestDataStore.email;

        logger.info("Name  : {}", name);
        logger.info("Email : {}", email);

        // Send PUT Request
        Response response = given()
                .spec(requestSpec)
                .formParam("name", name)
                .formParam("email", email)
                .formParam("password", ExcelUtil.getCellData("CreateAccount", 1, 2))
                .formParam("title", ExcelUtil.getCellData("CreateAccount", 1, 3))
                .formParam("birth_date", ExcelUtil.getCellData("CreateAccount", 1, 14))
                .formParam("birth_month", ExcelUtil.getCellData("CreateAccount", 1, 15))
                .formParam("birth_year", ExcelUtil.getCellData("CreateAccount", 1, 16))
                .formParam("firstname", ExcelUtil.getCellData("CreateAccount", 1, 4))
                .formParam("lastname", "Updated Verma")
                .formParam("company", "OpenAI Pvt Ltd")
                .formParam("address1", "Electronic City")
                .formParam("address2", "Phase 1")
                .formParam("country", "India")
                .formParam("zipcode", "560100")
                .formParam("state", "Karnataka")
                .formParam("city", "Bangalore")
                .formParam("mobile_number", "9999999999")
                .when()
                .put(ConfigManager.getProperty("base.url") + EndPoints.UPDATE_ACCOUNT);

        // Print Response
        System.out.println("\n========== Update Account API ==========");
        System.out.println("Status Code  : " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Content-Type : " + response.getHeader("Content-Type"));
        System.out.println("========================================\n");

        System.out.println(response.asPrettyString());

        // HTTP Validation
        Assert.assertEquals(response.getStatusCode(), 200,
                "HTTP Status Code Validation Failed");

        Assert.assertTrue(response.getTime() < 5000,
                "Response Time Validation Failed");

        // Business Validation
        Assert.assertEquals(response.jsonPath().getInt("responseCode"), 200,
                "Business Response Code Validation Failed");

        Assert.assertEquals(response.jsonPath().getString("message"),
                "User updated!",
                "User Update Validation Failed");
    }
}