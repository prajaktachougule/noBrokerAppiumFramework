package com.NoBroker.testPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NoBroker.Utilities.ReUsableMethods;
import com.NoBroker.pages.BasePage;
import com.NoBroker.pages.BuyPropertyPage;
import com.NoBroker.pages.HomePage;
import com.NoBroker.pages.SignUpPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class HomePageTest extends BasePage {
	HomePage homePage;
	SignUpPage signUpPage;
	BuyPropertyPage buyPropertyPage;

	public HomePageTest() throws Exception {
		// homePage = new HomePage();
		// super();
//		Thread.sleep(10000);

		// TODO Auto-generated constructor stub
	}

	@Test(priority = 1)
	public void setUp() throws Exception, InterruptedException {
		logger1.info("Issue created with set up\t");
		logger = extent.createTest("Set Up");
		homePage = new HomePage();
		initializationNoBroker();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case setup is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 2)
	public void verifyAllPermissions() throws Exception {

		logger = extent.createTest("verify All Permissions");
		homePage.permission.click();
		Assert.assertEquals(homePage.homePageTitle.getText(), "Find a Home Without a Broker");
		logger.log(Status.PASS,
				MarkupHelper.createLabel("Test Case verify All Permissions Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 3)
	public void verifyNoBrokerLogoDisplayed() {
		logger = extent.createTest("verify NoBroker Logo Displayed");
		Assert.assertEquals(homePage.homePageTitle.getText(), "Find a Home Without a Broker");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case verify NoBroker Logo Displayed Test is passTest",
				ExtentColor.GREEN));

	}

	@Test(priority = 4)
	public void verifyPackersNMoversfetureDisplayed() {
		logger = extent.createTest("verify PackersNMovers feture Displayed");
		Assert.assertTrue(homePage.clickOnMoverPackers.isDisplayed());
		logger.log(Status.PASS, MarkupHelper
				.createLabel("Test Case verify PackersNMovers feture Displayed Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 5)
	public void verifyPayRentFetureDisplayed() {

		logger = extent.createTest("verify PayRent Tag Displayed");
		Assert.assertEquals(homePage.clickOnPayRentPage.getText(), "Get upto ₹500 Cashback");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case verify PayRent Feture Displayed Test is passTest",
				ExtentColor.GREEN));

	}

	@Test(priority = 6)
	public void verifyClickNEarnFetureDisplyed() {
		logger = extent.createTest("verify ClickNEarn Feture Displyed");
		Assert.assertTrue(homePage.clickOnCLickAndEarn.isDisplayed());
		logger.log(Status.PASS,
				MarkupHelper.createLabel("Test Case verify All Permissions Test is passTest", ExtentColor.GREEN));

	}/*
		 * @Test(priority=7) public void verifyBuyLinkTest() throws Exception{
		 * 
		 * logger = extent.createTest("verify MenuList Link Test");
		 * homePage.buyLayoutButton.click(); homePage.clickOnbuyPropertiesLink();
		 * logger.log(Status.PASS,
		 * MarkupHelper.createLabel("Test Case verify MenuList Link test is passTest",
		 * ExtentColor.GREEN));
		 * 
		 * }
		 * 
		 * @Test(priority=7) public void verifyMenuListLinkTest() throws Exception{
		 * 
		 * logger = extent.createTest("verify MenuList Link Test");
		 * homePage.menuPageLink.click(); signUpPage=homePage.clickOnSignUpPageLink();
		 * logger.log(Status.PASS,
		 * MarkupHelper.createLabel("Test Case verify MenuList Link test is passTest",
		 * ExtentColor.GREEN));
		 * 
		 * }
		 */

}
