package com.qa.parabank.pages;

import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage (Page page){
        this.page = page;
    }

    // Common method to navigate to a URL
    public void navigateTo(String url) {
        page.navigate(url);
    }

    // Common method to get the page title
    public String getPageTitle() {
        return page.title();
    }

    // Common method to get the current URL
    public String getCurrentURL() {
        return page.url();
    }

    public boolean elementExists(String locator) {
        return page.isVisible(locator);
    }


}
