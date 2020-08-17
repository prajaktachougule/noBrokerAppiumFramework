package com.NoBroker.testPages;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.NoBroker.Utilities.ReUsableMethods;
import com.NoBroker.pages.BasePage;
import com.NoBroker.pages.BuyPropertyPage;
import com.NoBroker.pages.PropertyAdPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class PropertyAdPageTest extends BasePage {
	
    PropertyAdPage propertyAdPage;

	public PropertyAdPageTest() throws Exception {
		super();
		Thread.sleep(10000);

		// TODO Auto-generated constructor stub
	}

    @BeforeTest()
	public void setUp() throws Exception, InterruptedException {
    	
		logger1.info("Issue created with set up\t");
		logger = extent.createTest("Set Up");
		initializationNoBroker();
		propertyAdPage = new PropertyAdPage();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case setup is passTest", ExtentColor.GREEN));

	}
	@Test(priority = 1)
	public void checkPostFreePropertyAdTitle() {
		
		logger = extent.createTest("check Post Free Property Ad Title");
		Assert.assertEquals(propertyAdPage.postPropertyAd_title.getText(), "For Property Owners");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case check Post Free Property Ad Title Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 2)
	public void verifyEditPropertyAd() {
		
		logger = extent.createTest("verify Edit Property Ad");
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_EditButton);
		Assert.assertEquals(propertyAdPage.postPropertyAd_Page1Title.getText(), "Property Details");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Edit Property Ad Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 3)
	public void verifyEnablePropertyForLeaseToNo() {
		
		logger = extent.createTest("verify Enable Property For Lease To No");
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_continue1);
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_continue2);
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_isLease);
		Assert.assertTrue(propertyAdPage.postPropertyAd_isLease.isEnabled(), "Lease radio butto not set to no");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Enable Property For Lease To No verify Error PopUp Without Locality Test is passTest", ExtentColor.GREEN));


	}@Test(priority = 4)
	public void checkUploadPhoto() {
		
		logger = extent.createTest("check Upload Photo");
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_continue3);
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_continue3);
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_uploadGallery);
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_imgAllowPermission);
		ReUsableMethods.actionClick(propertyAdPage.postPropertyAd_gallery);
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case check Upload Photo Test is passTest", ExtentColor.GREEN));


	}
	@Test(priority=5)
	public void verifyFinishPostingButtonDisplayed() {
		
	
	}
	@Test(priority=5)
	public void verifyExitPostingAlert() {
		
		logger = extent.createTest("verify Exit Posting Alert");
		Assert.assertEquals(propertyAdPage.discardAlertMessage.getText(), " ");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Exit Posting Alert Test is passTest", ExtentColor.GREEN));
 

	}
}
