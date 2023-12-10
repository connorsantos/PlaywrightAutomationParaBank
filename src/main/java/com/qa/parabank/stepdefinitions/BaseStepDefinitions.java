package com.qa.parabank.stepdefinitions;

import com.microsoft.playwright.Page;
import com.qa.parabank.factory.PlaywrightFactory;
import com.qa.parabank.pages.AboutUsPage;
import com.qa.parabank.pages.AccountsOverviewPage;
import com.qa.parabank.pages.HomePage;
import com.qa.parabank.pages.RegisterPage;
import io.cucumber.java.*;

import java.util.Properties;

public class BaseStepDefinitions {
    protected static PlaywrightFactory pf;
    protected static Page page;
    protected static  Properties prop;
    protected static  HomePage homePage;
    protected AboutUsPage aboutUsPage;
    protected AccountsOverviewPage accountsOverviewPage;
    protected static RegisterPage registerPage;
    protected static Scenario scenario;

    public static void setup(String browserName, Scenario scenario) {
        BaseStepDefinitions.scenario = scenario;
        System.out.println(scenario.getName());

        pf = new PlaywrightFactory();

        prop = pf.init_prop();

        if (browserName != null) {
            prop.setProperty("browser", browserName);
        }

        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    public static void teardown() {
        System.out.println("Page Closing");
        //page.context().browser().close();
    }
}
