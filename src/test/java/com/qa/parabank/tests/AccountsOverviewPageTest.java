package com.qa.parabank.tests;

import com.qa.parabank.base.BaseTest;
import com.qa.parabank.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountsOverviewPageTest extends BaseTest {

    @Test(priority = 1)
    public void accountsOverviewPageTitleTest() {
        accountsOverviewPage = homePage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
        String actAboutUsPageTitle = accountsOverviewPage.getPageTitle();

        Assert.assertEquals(actAboutUsPageTitle, AppConstants.ACCOUNTS_OVERVIEW_PAGE_TITLE);
        System.out.println("page act title: " + actAboutUsPageTitle);
    }


    @Test(priority = 2)
    public void getAccountsTotalTest() {
        String totalBalance = accountsOverviewPage.getTotalBalance();
        System.out.println("Total Balance is " + totalBalance);
        Assert.assertNotNull(totalBalance);

    }


}
