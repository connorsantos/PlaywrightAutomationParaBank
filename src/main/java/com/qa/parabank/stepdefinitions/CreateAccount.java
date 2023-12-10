package com.qa.parabank.stepdefinitions;

import com.qa.parabank.TestObjects.Customer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import com.qa.parabank.stepdefinitions.BaseStepDefinitions.*;

import java.sql.SQLOutput;

import static com.qa.parabank.stepdefinitions.BaseStepDefinitions.*;

public class CreateAccount{
    Customer customer = new Customer(
            "connor",
            "santos",
            "123 add st",
            "lakewood",
            "CO",
            "22222",
            "2213",
            "123456",
            "connorsantos",
            "passtest"
    );
    @Before
    public void beforeScenario(Scenario scenario) {
        BaseStepDefinitions.setup("edge",scenario);
    }

    @After
    public void afterScenario(Scenario scenario) {
        BaseStepDefinitions.teardown();
    }



    @Given("I am on the Register Page")
    public void theUserIsOnTheRegisterPage() {
        registerPage = homePage.navigateToRegisterPage();
        System.out.println(registerPage.getPageTitle());
        scenario.log(registerPage.getPageTitle());
    }

    @When("I fill out the sign in form and click register")
    public void fillOutForm() {
        registerPage.registerUser(customer);
        scenario.log(customer.getFirstName()+ " " +customer.getLastName());
    }

    @Then("Account should be created successfully")
    public void checkForCreatedAccount(){
        String expected = "Welcome " + customer.getUsername()+registerPage.getUserEnding();
        String actual = page.locator(registerPage.getSccsmessage()).textContent();
        System.out.println(expected);
        System.out.println(actual);

        if(expected.equalsIgnoreCase(actual)){
            scenario.log("Expected: " + expected + "\n" +
                              "Actual:   " + actual + "\n" +
                              "PASS");
        } else {
            scenario.log("Expected: " + expected + "\n" +
                              "Actual:   " + actual + "\n" +
                              "FAIL");
        }

        Assert.assertEquals(expected,actual);

    }
}
