package com.qa.parabank.pages;

import com.microsoft.playwright.Page;

public class AboutUsPage extends BasePage {

    private String aboutUsH1Title = "div#rightPanel h1";

    public AboutUsPage(Page page) {
        super(page);
    }

    public String getAboutUsH1Title(){
        return aboutUsH1Title;
    }

    public boolean headerExists() {
        return page.isVisible(aboutUsH1Title);
    }


}
