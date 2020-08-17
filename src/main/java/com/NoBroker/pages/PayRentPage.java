package com.NoBroker.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PayRentPage extends BaseTest {
	
	public PayRentPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	@AndroidFindBy(id = "action_bar")
	public MobileElement PayRentPageTitle;
}


