package com.NoBroker.testPages;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.NoBroker.Utilities.ReUsableMethods;
import com.NoBroker.pages.BasePage;
import com.NoBroker.pages.NotificationsPage;
import com.NoBroker.pages.PayRentPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class NotificationsPageTest extends BasePage {
	NotificationsPage notificationsPage;
	public NotificationsPageTest() throws Exception {
		super();
		Thread.sleep(10000);

		// TODO Auto-generated constructor stub
	}
	@BeforeTest()
	public void setUp() throws Exception, InterruptedException {
    	
		logger1.info("Issue created with set up\t");
		logger = extent.createTest("Set Up");
		initializationNoBroker();
		notificationsPage = new NotificationsPage();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case setup is passTest", ExtentColor.GREEN));

	}
	@Test(priority = 1)
	public void verifyNotificationsPage() {
		
		logger = extent.createTest("verify Notifications Page");
		Assert.assertEquals(notificationsPage.nottificationsTitle.getText(), "Notifications");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Notifications Page Test is passTest", ExtentColor.GREEN));

	}
	@Test(priority = 2)
	public void verifyInboxDisplayed() {
		logger = extent.createTest("verify Inbox Displayed");
		Assert.assertTrue(notificationsPage.selectChatButton.isDisplayed(), "Chat box not displayed");
		ReUsableMethods.actionClick(notificationsPage.selectChatButton);
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Inbox Displayed Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 3)
	public void verifyUserTitle() {
		logger = extent.createTest("verify User Title");
		Assert.assertEquals(notificationsPage.selectChatButton.getText(), "Welcome back, Prajakta Chougule");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify User Title Test is passTest", ExtentColor.GREEN));


	}

}
