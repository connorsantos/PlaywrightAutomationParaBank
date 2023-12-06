package com.qa.parabank.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;

public class HomePage extends BasePage{
	// 1. String Locators - OR
	private String aboutUsLink = "a:text('About Us')";
	private String username = "input[name='username']";
	private String password = "input[name='password']";
	private String loginBtn = "input[value='Log In']";
	private String acctOvrvwHeader = "h1:text('Accounts Overview')";
	private String registerLnk = "a:text('Register')";


	// 2. page constructor:
	public HomePage(Page page) {
		super(page);
	}

	// 3. page actions/methods:
	public AboutUsPage navigateToAboutUsPage() {
		page.click(aboutUsLink);
		return new AboutUsPage(page);
	}

	public RegisterPage navigateToRegisterPage() {
		page.click(registerLnk);
		return new RegisterPage(page);
	}

	public AccountsOverviewPage doLogin(String user, String pass){
		page.fill(username, user);
		page.fill(password, pass);
		page.click(loginBtn);
		page.locator(acctOvrvwHeader).waitFor();
        if(page.locator(acctOvrvwHeader).isVisible()){
			return new AccountsOverviewPage(page);
		} else{
			throw new PlaywrightException("Login Failed. Please check credentials");
		}
	}


}
