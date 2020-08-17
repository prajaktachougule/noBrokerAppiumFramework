package com.NoBroker.testPages;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NoBroker.Utilities.ExcelUtils1;
import com.NoBroker.Utilities.ReUsableMethods;
import com.NoBroker.pages.BasePage;
import com.NoBroker.pages.BuyPropertyPage;
import com.NoBroker.pages.HomePage;
import com.Testautomation.Common.SwipeElementDirection;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class BuyPropertyPageTest extends BasePage {

	BuyPropertyPage buypropertyPage;
	HomePage homePage;
	
	public BuyPropertyPageTest() throws Exception {

		// TODO Auto-generated constructor stub
	}

	@BeforeTest()
	public void setUp() throws Exception, InterruptedException {
		logger1.info("Issue created with set up\t");
		logger = extent.createTest("Set Up");
		buypropertyPage = new BuyPropertyPage();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case setup is passTest", ExtentColor.GREEN));

	}
/*
	@Test(priority = 0)
	public void verifyErrorPopUpWithoutLocality() {
		
		logger = extent.createTest("verify Error PopUp Without Locality");
		buypropertyPage.permission.click();
		buypropertyPage.homePage_searchField.click();
		buypropertyPage.
		Assert.assertEquals(buypropertyPage.buyPropertyPage_searchLocality, "Please enter locality");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Error PopUp Without Locality Test is passTest", ExtentColor.GREEN));

	}*/

	//@Test(dataProvider="CityDetails", priority=1)
	@Test(priority=1)
	public void verifyListOfCityDropdown() throws InterruptedException {
		ReUsableMethods.isElementPresent(buypropertyPage.permission, 4000);
		logger = extent.createTest("verify Error PopUp Without Locality");
		ReUsableMethods.actionClick(buypropertyPage.permission);
		ReUsableMethods.actionClick(buypropertyPage.homePage_searchField);
		ReUsableMethods.isElementPresent(buypropertyPage.buyLayoutButton, 4000);

		ReUsableMethods.actionClick(buypropertyPage.buyLayoutButton);
		ReUsableMethods.isElementPresent(buypropertyPage.searchCity, 4000);
		ReUsableMethods.actionClick(buypropertyPage.searchCity);
		ReUsableMethods.actionClick(buypropertyPage.selectCity);
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Error PopUp Without Locality Test is passTest", ExtentColor.GREEN));


	}
	
	//@Test(dataProvider="CityDetails", priority=3)
	@Test(priority=3)
	public void verifySearchLocality() throws InterruptedException {
		
		logger = extent.createTest("verify Search Locality");
		ReUsableMethods.isElementPresent(buypropertyPage.selectLocality, 4000);
		buypropertyPage.selectLocality.click();
		buypropertyPage.selectLocality.sendKeys("Chinchwad");
		buypropertyPage.selectLocalityArea.click();
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Search Locality Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 4)
	public void verifyIncludeNearByPropertiesCheckbox() throws InterruptedException {
		
		logger = extent.createTest("verify Error PopUp Without Locality");
		ReUsableMethods.setCheckboxOrRadiobtn(buypropertyPage.checkIncludenearByproperties);
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Error PopUp Without Locality Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 5)
	public void verifyNoOfBedrooms() throws InterruptedException {
		
		logger = extent.createTest("verify No Of Bedrooms");
		ReUsableMethods.isElementPresent(buypropertyPage.select2BHK, 4000);

		ReUsableMethods.setCheckboxOrRadiobtn(buypropertyPage.select2BHK);
		ReUsableMethods.isElementPresent(buypropertyPage.select3BHK, 4000);

		ReUsableMethods.setCheckboxOrRadiobtn(buypropertyPage.select3BHK);
		//Assert.assertTrue(buypropertyPage.select2BHK.isSelected(), "2 BHK button not selcted");
		//Assert.assertTrue(buypropertyPage.select3BHK.isSelected(), "3 BHK button not selcted");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify No Of Bedrooms Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 6)
	public void verifyPriceRange() {
		
		logger = extent.createTest("verify Price Range");
		Assert.assertTrue(buypropertyPage.priceRange.isDisplayed(), "Price Range element not displayed");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Price Range Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 7)
	public void verifypropertyStatus() throws InterruptedException {
		
		logger = extent.createTest("verify property Status");
		ReUsableMethods.actionClick(buypropertyPage.selectReadyProperty);
		ReUsableMethods.isElementPresent(buypropertyPage.searchPropertyButton, 4000);
		//Assert.assertTrue(buypropertyPage.selectReadyProperty.isSelected(), "Property status not selcted");
		ReUsableMethods.actionClick(buypropertyPage.searchPropertyButton);

		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify property Status Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 9)
	public void verifyPropertiesDescriptionDispaly() {

		logger = extent.createTest("verify Properties Description Dispaly");
		ReUsableMethods.actionClick(buypropertyPage.searchPropertyButton);
		ReUsableMethods.scrollingToBottomofAPage();
		Assert.assertFalse(buypropertyPage.propertyDescription.getText().isEmpty());
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Properties Description Dispaly Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 10)
	public void verifySheduleVisit() {
		
		logger = extent.createTest("verify Shedule Visit");
		ReUsableMethods.actionClick(buypropertyPage.sheduleVisit);
		Assert.assertEquals(buypropertyPage.sheduleVisitHeader.getText(), "Shedule your FREE visit today");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Shedule Visit Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 11)
	public void verifyAvailableTimeSlot() {
		
		logger = extent.createTest("verify Available Time Slot");
		ReUsableMethods.actionClick(buypropertyPage.selectDate);
		ReUsableMethods.actionClick(buypropertyPage.selectDateFromCalender);
		ReUsableMethods.actionClick(buypropertyPage.selectOkOnCalender);
		ReUsableMethods.actionClick(buypropertyPage.selectTimeSlot);
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Available TimeSlot Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 12)
	public void verifyCloseVisitPage() {
		
		logger = extent.createTest("verify Close Visit Page");
		ReUsableMethods.actionClick(buypropertyPage.closeVisitPage);
		Assert.assertTrue(buypropertyPage.sheduleVisit.isDisplayed(), "It not come back to respected property page");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Close Visit Page Test is passTest", ExtentColor.GREEN));


	}

	@Test(priority = 13)
	public void verifyShortlistProperty() {
		
		logger = extent.createTest("verify Shortlist Property");
		ReUsableMethods.actionClick(buypropertyPage.shortListedProperty);
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Shortlist Property Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 14)
	public void verifyClosePropertyPage() {
		
		logger = extent.createTest("verify Close Property Page");
		ReUsableMethods.actionClick(buypropertyPage.closePropertyPage);
		ReUsableMethods.actionClick(buypropertyPage.closePropertyListPage);
		ReUsableMethods.actionClick(buypropertyPage.closeBuyPropertyPage);
		Assert.assertEquals(homePage.homePageTitle.getText(), "Find a Home Without Broker");
		logger.log(Status.PASS,MarkupHelper.createLabel("Test Case verify Close Property Page Test is passTest", ExtentColor.GREEN));

	}
	/*
	@DataProvider
	 
    public Object[][] CityDetails() throws Exception{
 
         Object[][] testObjArray = ExcelUtils1.getTableArray("E:\\Prajakta\\Prajakta\\Appium\\AppiumTestDemo\\src\\main\\java\\com\\NoBroker\\TestData\\NoBrokerCityNames.xlsx","Sheet1");
 
         return (testObjArray);
 
 }
*/
}
