package com.NoBroker.pages;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidDriver;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class BaseTest {

	
	public static AndroidDriver<AndroidElement> driver;
@BeforeClass
	public static void main(String args[]) throws MalformedURLException, InterruptedException {

		//File filePath = new File(System.getProperty("user.dir"));
		//File appDir = new File(filePath, "/src/main/java/App");
		//File app = new File(appDir, "NoBroker.apk");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "PrajaktaEmulator");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		dc.setCapability("appPackage", "com.nobroker.app");
		dc.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
		dc.setCapability("platformVersion", "10");

		// dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
		
		
}
}


