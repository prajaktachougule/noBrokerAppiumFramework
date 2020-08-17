package com.NoBroker.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BasePage {

	HomePage homePage;
	SignUpPage signUpPage;

	public HomePage() throws Exception {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "yesPhoneState")
	public MobileElement permission;

	@AndroidFindBy(id = "permission_allow_button")
	public MobileElement allow1;

	@AndroidFindBy(id = "permission_allow_button")
	public MobileElement allow2;

	@AndroidFindBy(id = "permission_allow_button")
	public MobileElement allow3;

	@AndroidFindBy(accessibility = "Navigate up")
	public MobileElement menuPageLink;

	@AndroidFindBy(id = "tvUserName")
	public MobileElement signUpPageLink;
	
	@AndroidFindBy(id = "buyLayout")
	public MobileElement buyLayoutButton;

	@AndroidFindBy(id = "searchEditHome")
	public MobileElement homePage_searchField;

	
	
	@AndroidFindBy(id = "homeTitle")
	public MobileElement homePageTitle;
	
	@AndroidFindBy(xpath = "//tvMenuText[3]")
	public MobileElement selectPropertyShortlisted;
	
	@AndroidFindBy(id = "clPnm")
	public MobileElement clickOnMoverPackers;

	@AndroidFindBy(id = "tvPayRentTag")
	public MobileElement clickOnPayRentPage;

	@AndroidFindBy(id = "imgClickEarn")
	public MobileElement clickOnCLickAndEarn;
	
	@AndroidFindBy(id = "postPropertyHomeText")
	public MobileElement postPropertyad;
	
	@AndroidFindBy(xpath = "bell")
	public MobileElement clickOnNotification;
	
	
	
	
	
	
	

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
	/*
	public BuyPropertyPage clickOnbuyPropertiesLink() throws Exception {
		HomePage.isElementPresent(homePage_searchField, 4000);
		homePage_searchField.click();
		return new BuyPropertyPage();

	}

	public SignUpPage clickOnSignUpPageLink() throws Exception {
		HomePage.isElementPresent(signUpPageLink, 4000);
		signUpPageLink.click();
		return new SignUpPage();

	}*/
}