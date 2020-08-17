package com.NoBroker.pages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BuyPropertyPage extends BasePage {

	public BuyPropertyPage()throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	@AndroidFindBy(id = "yesPhoneState")
	public MobileElement permission;

	@AndroidFindBy(id = "searchProperty")
	public MobileElement searchPropertyButton;

	@AndroidFindBy(id = "buyLayout")
	public MobileElement buyLayoutButton;

	@AndroidFindBy(id = "searchEditHome")
	public MobileElement homePage_searchField;

	@AndroidFindBy(id = "spinnergo")
	public MobileElement searchCity;
	
	@AndroidFindBy(id = "android:id/text1")
	public MobileElement selectCity;
	
	@AndroidFindBy(id = "searchEditBar")
	public MobileElement buyPropertyPage_searchLocality;

	@AndroidFindBy(id = "action_bar_container")
	public MobileElement searchLocality;
	
	@AndroidFindBy(id = "localityAutoCompleteTxt")
	public MobileElement selectLocality;
	
	@AndroidFindBy(id = "logo")
	public MobileElement selectLocalityArea;
	
	
	
	

	@AndroidFindBy(id = "nearByRadio")
	public MobileElement checkIncludenearByproperties;

	@AndroidFindBy(id = "bhktwo")
	public MobileElement select2BHK;
	
	@AndroidFindBy(id = "bhkthree")
	public MobileElement select3BHK;

	@AndroidFindBy(id = "searchRentSeekBar")
	public MobileElement priceRange;


	@AndroidFindBy(id = "filterReady")
	public MobileElement selectReadyProperty;

	@AndroidFindBy(id = "searchProperty")
	public MobileElement searchProperty;

	@AndroidFindBy(id = "(//android.widget.FrameLayout[1]/android.widget.ImageView)/[1]")
	public MobileElement selectProperty;

	//android.widget.FrameLayout[1]/android.widget.ImageView

	@AndroidFindBy(id = "description")
	public MobileElement propertyDescription;
	
	@AndroidFindBy(id = "btnScheduleVisitSponsored")
	public MobileElement sheduleVisit;
	
	@AndroidFindBy(id = "tvHeader")
	public MobileElement sheduleVisitHeader;
	
	@AndroidFindBy(id = "rb_pick_date")
	public MobileElement selectDate;

	@AndroidFindBy(accessibility = "18 August 2020")
	public MobileElement selectDateFromCalender;

	@AndroidFindBy(id = "button1")
	public MobileElement selectOkOnCalender;

	@AndroidFindBy(id = "rb_6_8")
	public MobileElement selectTimeSlot;

	@AndroidFindBy(id = "imgClose")
	public MobileElement closeVisitPage;
	
	@AndroidFindBy(xpath = "android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ImageView")
	public MobileElement closePropertyPage;
	
	@AndroidFindBy(id = "home_icon")
	public MobileElement closePropertyListPage;
	
	@AndroidFindBy(id = "backSearch")
	public MobileElement closeBuyPropertyPage;
	
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.ImageView[3]")
	public MobileElement shortListedProperty;
	
	

	/*


	WebElement from = driver
			.findElement(By.xpath("(//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout)[1]"));

	WebElement to = driver
			.findElement(By.xpath("(//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout)[2]"));

	TouchAction t = new TouchAction(driver);
	t.longPress(longPressOptions().withElement(element(to)).withDuration(ofSeconds(7))).moveTo(element(from)).release().perform();
	Thread.sleep(3000);

	t.longPress(longPressOptions().withElement(element(to)).withDuration(ofSeconds(7))).moveTo(element(from)).release().perform();
	Thread.sleep(3000);

*/
	
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"RK in Jay Shivshakti\"));");
	//Thread.sleep(3000);
	
	//@findBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]")).click();
	
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Description\"));");
//	driver.findElement(MobileByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceIdMatches(".*id/your_scrolling_container_id")).scrollIntoView("
    //                + "new UiSelector().text(\"Description\"));");
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");


	
}
