package com.qa.parabank.base;

import java.util.Properties;

import com.qa.parabank.pages.AboutUsPage;
import com.qa.parabank.pages.AccountsOverviewPage;
import com.qa.parabank.pages.RegisterPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.parabank.factory.PlaywrightFactory;
import com.qa.parabank.pages.HomePage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homePage;
	protected AboutUsPage aboutUsPage;
	protected AccountsOverviewPage accountsOverviewPage;
	protected RegisterPage registerPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlaywrightFactory();

		prop = pf.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
