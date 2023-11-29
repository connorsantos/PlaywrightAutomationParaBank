package com.qa.parabank.tests;

import com.qa.parabank.base.BaseTest;
import com.qa.parabank.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutUsPageTest extends BaseTest {

    @Test(priority = 1)
    public void aboutUsPageTitleTest() {
        aboutUsPage = homePage.navigateToAboutUsPage();
        String actAboutUsPageTitle = aboutUsPage.getPageTitle();

        Assert.assertEquals(actAboutUsPageTitle, AppConstants.ABOUT_US_PAGE_TITLE);
        System.out.println("page act title: " + actAboutUsPageTitle);
    }

    @Test(priority = 2)
    public void aboutUsHeaderExists() {
        Assert.assertTrue(aboutUsPage.elementExists(aboutUsPage.getAboutUsH1Title()));
    }

}
