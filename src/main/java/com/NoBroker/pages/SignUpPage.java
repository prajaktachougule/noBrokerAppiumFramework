package com.NoBroker.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage extends BaseTest {
	HomePage homePage;

	public SignUpPage() {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	//select menu acc id: Navigate up
		//click on sign up: id: tvUserName
		//ensure sign up page header id: tv_signup_heading
		//give pho no to this id:et_signup_phone: 9686614101
		//click on continue:id:btn_signup
		//empty ph no error pop up: id:tv_signup_errEmptyPhone
		//sign up otp: id :et_signup_otp
	
	@AndroidFindBy(id = "tv_signup_heading")
	public MobileElement signUpPageTitle;
	
	@AndroidFindBy(id = "et_signup_phone")
	public MobileElement signUpPhNo_TextBox;
	
	@AndroidFindBy(id = "btn_signup")
	public MobileElement signUp_continue_Button;
	
	@AndroidFindBy(id = "tv_signup_errEmptyPhone")
	public MobileElement signUp_ErrorPopUp_Label;
	
	@AndroidFindBy(id = "et_signup_otp")
	public MobileElement signUp_OTP_Label;
	
	@AndroidFindBy(id = "tvUserName")
	public MobileElement signUp_User_Name;
	
	@AndroidFindBy(id = "tvUserEmail")
	public MobileElement signUp_User_Email;
	
	
	public static boolean isElementPresent(WebElement elementName, int timeout) {
		// long time = duration.getTime();
		
		// TimeUnit unit = duration.getTimeUnit();
		try {
			// duration.setTime(100, TimeUnit.MILLISECONDS);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(elementName));
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			// duration.setTime(time, unit);
		}

	}

	public HomePage clickOnSignUpContinue() throws Exception {
		SignUpPage.isElementPresent(signUp_continue_Button, 4000);
		signUp_continue_Button.click();
		return new HomePage();

	}
	
	

}
