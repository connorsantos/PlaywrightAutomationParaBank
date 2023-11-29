package com.qa.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.parabank.base.BaseTest;
import com.qa.parabank.constants.AppConstants;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}

	@Test
	public void homePageURLTest() {
		String actualURL = homePage.getCurrentURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}

	/*@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
				{ "Macbook" }, 
				{ "iMac" }, 
				{ "Samsung" }
		};
	}*/

	/*@Test(dataProvider = "getProductData")
	public void searchTest(String productName) throws InterruptedException {
		Thread.sleep(5000);
		String actualSearchHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - " + productName);
	}*/

}
