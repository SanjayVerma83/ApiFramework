package com.apiframework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {

        if (extent == null) {

            // Create HTML Report
            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");

            // Report Title
            spark.config().setDocumentTitle("API Automation Report");

            // Report Name
            spark.config().setReportName("REST Assured Test Execution Report");

            // Create ExtentReports Object
            extent = new ExtentReports();

            // Attach Reporter
            extent.attachReporter(spark);

            // System Information
            extent.setSystemInfo("Tester", "Sanjay");
            extent.setSystemInfo("Framework", "REST Assured + TestNG");
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }

        return extent;
    }
}