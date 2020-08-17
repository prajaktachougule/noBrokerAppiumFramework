package com.NoBroker.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.NoBroker.Utilities.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasePage {
	public static AndroidDriver<AndroidElement> driver;

	WebDriverWait wait;
	// TouchAction touchAction;
	public static Properties prop;
	private AppiumDriverLocalService appiumDriverService;
	public static final String testDataExcelFileName = "";
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentHtmlReporter htmlReporter;

	public static Logger logger1;
	protected AppiumDriverLocalService service;

	@BeforeTest
	public void testDataSetup() {
		logger1 = Logger.getLogger("Logger_file");
		PropertyConfigurator.configure("/Prajakta/Prajakta/Appium/AppiumTestDemo/src/main/resources/log4j.properties");
	}

	@BeforeSuite
	public void Setup() throws IOException {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"E:\\Prajakta\\Prajakta\\Appium\\AppiumTestDemo\\src\\main\\java\\com\\config\\properties\\config.properties");
			System.getProperties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "No Broker");
		extent.setSystemInfo("Environment", "Mobile Automation Testing");
		extent.setSystemInfo("User Name", "Prajakta Chougule");

		htmlReporter.config().setDocumentTitle("App Automation ");
		htmlReporter.config().setReportName("No Broker App Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	public BasePage() throws Exception {
		
		  try { prop = new Properties(); FileInputStream fis = new FileInputStream(
		  "E:\\Prajakta\\Prajakta\\Appium\\AppiumTestDemo\\src\\main\\java\\com\\config\\properties\\config.properties"
		  ); System.getProperties(); prop.load(fis); } catch (FileNotFoundException e)
		  { e.printStackTrace();
		  
		  }
		 
	}

	// @Parameters({"deviceName","port"})
	@BeforeTest(alwaysRun = true)

	public void initializationNoBroker() throws Exception {

		String deviceName = prop.getProperty("deviceName");

		{

			DefaultExecutor executor = new DefaultExecutor();
			DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			/*
			CommandLine launchEmul = new CommandLine("‎⁨//Applications⁩");
			launchEmul.addArgument("--vm-name");
			launchEmul.addArgument("\"" + deviceName + "\"");
			executor.setExitValue(1);
			executor.execute(launchEmul, resultHandler);
			*/
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "PrajaktaEmulator");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "150");
			dc.setCapability("appPackage", "com.nobroker.app");
			dc.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
			dc.setCapability("autoGrantPermissions", "true");
			dc.setCapability("autoAcceptAlerts", "true");

			dc.setCapability("platformVersion", "10");

			// dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.10:4723/wd/hub"), dc);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

	} /*
		 * @AfterMethod public void getResult(ITestResult result) throws Exception{
		 * if(result.getStatus() == ITestResult.FAILURE){ logger.log(Status.FAIL,
		 * "Test Case Failed is "+result.getName()); //MarkupHelper is used to display
		 * the output in different colors logger.log(Status.FAIL,
		 * MarkupHelper.createLabel(result.getName() + " - Test Case Failed",
		 * ExtentColor.RED)); logger.log(Status.FAIL,
		 * MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed",
		 * ExtentColor.RED)); String screenshotPath = TestUtil.getScreenshot(driver,
		 * result.getName()); //To add it in the extent report //
		 * logger.log(Status.FAIL,
		 * MarkupHelper.createCodeBlocklogger.addScreenCaptureFromPath(screenshotPath));
		 * }else if(result.getStatus() == ITestResult.SKIP){ logger.log(Status.SKIP,
		 * "Test Case Skipped is "+result.getName()); logger.log(Status.SKIP,
		 * MarkupHelper.createLabel(result.getName() + " - Test Case Skipped",
		 * ExtentColor.ORANGE)); }
		 */

	@AfterSuite

	public void endReport() {
		extent.flush();

	}

}
