package com.NoBroker.testPages;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.NoBroker.pages.BasePage;
import com.NoBroker.pages.BaseTest;
import com.NoBroker.pages.HomePage;
import com.NoBroker.pages.PropertyAdPage;
import com.NoBroker.pages.SignUpPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignUpPageTest extends BasePage {
	HomePage homePage;
	SignUpPage signUpPage;

	public SignUpPageTest() throws Exception {
		super();
		Thread.sleep(10000);

		// TODO Auto-generated constructor stub
	}

	@BeforeTest()
	public void setUp() throws Exception, InterruptedException {
    	
		logger1.info("Issue created with set up\t");
		logger = extent.createTest("Set Up");
		initializationNoBroker();
		signUpPage = new SignUpPage();
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case setup is passTest", ExtentColor.GREEN));

	}
	@Test(priority = 1)
	public void verifySignUpTitle() {
		
		logger = extent.createTest("Verify User Name");
		SignUpPage.isElementPresent(signUpPage.signUpPageTitle, 4000);
		Assert.assertEquals(signUpPage.signUpPageTitle.getText(), "LOGIN/SIGNUP");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case verify UserName Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 2)
	public void ensureErrorPopUpMessageOnNullTextBox() {
		
		logger = extent.createTest("ensure Error PopUp Message On Null TextBox");
		signUpPage.signUp_continue_Button.click();
		Assert.assertEquals(signUpPage.signUp_ErrorPopUp_Label.getText(), "Please enter phone number");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case ensure Error PopUp Message On Null TextBox Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 3)
	public void verifySignUpWithInvalidValue() {
		
		logger = extent.createTest("verify Sign Up With Invalid Value");
		signUpPage.signUpPhNo_TextBox.sendKeys("96866");
		Assert.assertEquals(signUpPage.signUp_ErrorPopUp_Label.getText(), "Please enter 10 digit phone number");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case verify SignUp With Invalid Value Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 4)
	public void verifySignUpWithValidValue() {
		
		logger = extent.createTest("verify Sign Up With Valid Value");
		signUpPage.signUpPhNo_TextBox.sendKeys("9686614101");
		Assert.assertEquals(homePage.homePageTitle.getText(), "Find a Home Without a Broker");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case verify Sign Up With Valid Value Test is passTest", ExtentColor.GREEN));

	}

	@Test(priority = 5)
	public void verifyUserNameAndEmail() {
		
		logger = extent.createTest("verify User Name And Email");
		homePage.menuPageLink.click();
		Assert.assertEquals(signUpPage.signUp_User_Name.getText(), "Prajakta Chougule");
		Assert.assertEquals(signUpPage.signUp_User_Email.getText(), "prajaktachougule6531@gmail.com");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case verify User Name And Email Test is passTest", ExtentColor.GREEN));

	}

}
