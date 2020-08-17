package com.NoBroker.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PropertyAdPage extends BaseTest {

	public PropertyAdPage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.Button")
	public MobileElement postPropertyAd_EditButton;
	
	
	@AndroidFindBy(id = "postPropertyDetailHeader")
	public MobileElement postPropertyAd_Page1Title;
	
	
	@AndroidFindBy(id = "message")
	public MobileElement discardAlertMessage;
	
	@AndroidFindBy(id = "button1")
	public MobileElement discardAlert_Ok;
	
	
	@AndroidFindBy(id = "btnStartPosting")
	public MobileElement postPropertyAd_newPostButton;
	
	@AndroidFindBy(id = "postProperty1Header")
	public MobileElement postPropertyAd_title;
	
	@AndroidFindBy(id = "spinnercityPostProperty1")
	public MobileElement postPropertyAd_selectCity;
	
	@AndroidFindBy(accessibility ="Residential")
	public MobileElement postPropertyAd_resedencialId;
	
	@AndroidFindBy(id = "rb_rent")
	public MobileElement postPropertyAd_adType;
	
	@AndroidFindBy(id = "contpage1")
	public MobileElement postPropertyAd_continue1;
	
	@AndroidFindBy(id = "apartmentTypeSpinner")
	public MobileElement postPropertyAd_apartmentType;
	
	@AndroidFindBy(id = "bhkTypeSpinner")
	public MobileElement postPropertyAd_bhkType;
	
	@AndroidFindBy(id = "propertySizeEdit")
	public MobileElement postPropertyAd_sizeTextBox;
	
	@AndroidFindBy(id = "propertyAgeSpinner")
	public MobileElement postPropertyAd_propertyAge;
	
	@AndroidFindBy(id = "floorSpinnerFirst")
	public MobileElement postPropertyAd_selectFloor;
	
	@AndroidFindBy(id = "floorSpinnerTotal")
	public MobileElement postPropertyAd_selectToatlFloor;
	
	@AndroidFindBy(id = "contPage3")
	public MobileElement postPropertyAd_continue2;
	
	@AndroidFindBy(id = "postPropertyLocality")
	public MobileElement postPropertyAd_selectLocality;//chinchwad
	
	@AndroidFindBy(id = "postPropertyAddress")
	public MobileElement postPropertyAd_selectLocalityAddress;//chinchwad railway station
	
	@AndroidFindBy(id = "contpage2")
	public MobileElement postPropertyAd_continue3;
	
	@AndroidFindBy(id = "no")
	public MobileElement postPropertyAd_isLease;
	
	@AndroidFindBy(id = "enterAmountEdit")
	public MobileElement postPropertyAd_expectedRent;//30000
	
	@AndroidFindBy(id = "depositLayout")
	public MobileElement postPropertyAd_expectedDeposit;
	
	@AndroidFindBy(id = "spinnerMaintenance")
	public MobileElement postPropertyAd_maintenance;
	
	@AndroidFindBy(id = "calenderPost4")
	public MobileElement postPropertyAd_selectCalender;
	
	@AndroidFindBy(accessibility = "19 August 2020")
	public MobileElement postPropertyAd_selectDate;
	
	@AndroidFindBy(id = "button1")
	public MobileElement postPropertyAd_calenderOk;
	
	@AndroidFindBy(id = "furnishingTypeSpinner")
	public MobileElement postPropertyAd_furnishingType;
	
	@AndroidFindBy(id = "parkingspinnerlayout")
	public MobileElement postPropertyAd_parking;
	
	@AndroidFindBy(id = "tenantTypeSpinner")
	public MobileElement postPropertyAd_prefferedTenants;
	
	@AndroidFindBy(id = "contPage4")
	public MobileElement postPropertyAd_continue4;
	
	@AndroidFindBy(id = "bathroomEdit")
	public MobileElement postPropertyAd_bathrooms;
	
	@AndroidFindBy(id = "whoSpinner")
	public MobileElement postPropertyAd_whoWillShow;
	
	@AndroidFindBy(id = "contPage5")
	public MobileElement postPropertyAd_continue5;
	
	@AndroidFindBy(id = "gallery")
	public MobileElement postPropertyAd_gallery;
	
	@AndroidFindBy(id = "permission_message")
	public MobileElement postPropertyAd_uploadGallery;
	
	@AndroidFindBy(id = "permission_allow_button")
	public MobileElement postPropertyAd_imgAllowPermission;
	
	@AndroidFindBy(id = "image_view_album_image[1]")
	public MobileElement postPropertyAd_selectImage;
	
	@AndroidFindBy(id = "menu_item_add_image")
	public MobileElement postPropertyAd_addImg;
	
	@AndroidFindBy(id = "finish_posting")
	public MobileElement postPropertyAd_finishPosting;
	
	@AndroidFindBy(id = "postPropertyConfBack")
	public MobileElement postPropertyAd_discardPostPropertyPage;
	
	@AndroidFindBy(id = "imgBack")
	public MobileElement postPropertyAd_backFromPropertyOwner;
}
	