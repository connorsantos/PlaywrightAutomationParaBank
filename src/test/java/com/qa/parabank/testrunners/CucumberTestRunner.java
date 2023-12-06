package com.qa.parabank.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Specify the path to your feature files
        glue = {"com.qa.parabank.stepdefinitions"},                 // Specify the package where your step definitions are located
        tags = "@createaccount",
        plugin = {"pretty", "html:target/cucumber-reports.html"} // Specify the plugins you want to use (e.g., "pretty" for console output, "html" for HTML reports)
)
public class CucumberTestRunner {
}
