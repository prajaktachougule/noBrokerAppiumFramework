package com.NoBroker.testPages;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.NoBroker.pages.BasePage;
import com.NoBroker.pages.PayRentPage;
import com.NoBroker.pages.PropertyAdPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class PayRentPageTest extends BasePage {
	
	public PayRentPageTest() throws Exception {
		super();
		Thread.sleep(10000);

		// TODO Auto-generated constructor stub
	}

	PayRentPage payRentPage;
	@BeforeTest()
	public void setUp() throws Exception, InterruptedException {
    	
		logger1.info("Issue created with set up\t");
		logger = extent.createTest("Set Up");
		initializationNoBroker();
		payRentPage = new PayRentPage();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case setup is passTest", ExtentColor.GREEN));

	}
	@Test(priority = 1)
	public void VerifyPayRentPageDisplayed() {
		logger = extent.createTest("Verify Pay Rent Page Displayed");
		Assert.assertEquals(payRentPage.PayRentPageTitle.getText(), "Pay And Rent");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case Verify Pay Rent Page Displayed Test is passTest", ExtentColor.GREEN));

	}
}
