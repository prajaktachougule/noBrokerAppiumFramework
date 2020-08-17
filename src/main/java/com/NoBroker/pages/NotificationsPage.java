package com.NoBroker.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotificationsPage extends BaseTest{
public NotificationsPage() {
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

@AndroidFindBy(id = "relativeLayoutInbox")
public MobileElement selectChatButton;

@AndroidFindBy(id = "tv_welcome_text")
public MobileElement notificationChatWelcomeText;

@AndroidFindBy(id = "myInboxText")
public MobileElement nottificationsTitle;


}
