package com.NoBroker.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ClickAndEarnPage extends BasePage {
	
	public ClickAndEarnPage() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

		// TODO Auto-generated constructor stub
	}
@AndroidFindBy(id = "clickEarnText")
	public MobileElement clickAndEarnTitle;
}
