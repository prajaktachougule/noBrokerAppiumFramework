package com.NoBroker.testPages;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.NoBroker.pages.BasePage;
import com.NoBroker.pages.ClickAndEarnPage;
import com.NoBroker.pages.NotificationsPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ClickAndEarnPageTest extends BasePage {
	
	ClickAndEarnPage clickAndEarnPage;
	
	public ClickAndEarnPageTest() throws Exception {
		super();
		Thread.sleep(10000);

		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest()
	public void setUp() throws Exception, InterruptedException {
    	
		logger1.info("Issue created with set up\t");
		logger = extent.createTest("Set Up");
		initializationNoBroker();
		clickAndEarnPage = new ClickAndEarnPage();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case setup is passTest", ExtentColor.GREEN));

	}
	@Test(priority = 1)
	public void verifyClickAndEarnPageTitle() {
		Assert.assertEquals(clickAndEarnPage.clickAndEarnTitle.getText(), "Click And Earn");

	}

	

}
