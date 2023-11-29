package com.qa.parabank.pages;

import com.microsoft.playwright.Page;

public class AccountsOverviewPage extends BasePage{

    private String totalBalance = "b.ng-binding";

    public AccountsOverviewPage(Page page) {
        super(page);
    }

    public String getTotalBalance(){
        return page.locator(totalBalance).textContent();
    }
}
