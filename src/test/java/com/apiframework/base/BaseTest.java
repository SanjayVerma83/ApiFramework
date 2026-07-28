package com.apiframework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class BaseTest {

    // Logger for all test classes
    protected Logger logger = LogManager.getLogger(this.getClass());

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {

        logger.info("========== Test Started ==========");

        requestSpec = new RequestSpecBuilder()
                .setContentType("application/x-www-form-urlencoded")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(5000L))
                .build();

        logger.info("RequestSpecification initialized successfully.");
    }
}