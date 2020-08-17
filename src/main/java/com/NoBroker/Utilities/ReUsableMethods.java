package com.NoBroker.Utilities;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.asserts.Assertion;

import com.NoBroker.Utilities.ReUsableMethods;
import com.NoBroker.pages.BasePage;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;


public class ReUsableMethods extends BasePage {
    public ReUsableMethods() throws Exception {
        super();
        // TODO Auto-generated constructor stub
    }

    protected static WebDriverWait wait = new WebDriverWait(driver, 20);
    public static Actions action;
    public static boolean screenShotFlag = false;

    /**
     * This method is used to type the text character by character in the textbox
     *
     * @param locator     - Provide locator of element.
     * @param inputText   - Provide text input to be typed in the text box.
     * @param inputByText - Provide true to avoid char by char input
     */
    public static void inputText(MobileElement locator, String inputByChar) {
        MobileElement txtEle = locator;
        try {
            clearText(locator);
            txtEle.sendKeys(inputByChar);
        } catch (Exception e) {
            System.out.println("unable to enter input");
        }
    }

    /**
     * This method is used to clear text from a textbox.
     *
     * @param locator
     */
    public static void clearText(MobileElement locator) {
        try {
            MobileElement txtEle = locator;
            txtEle.clear();
        } catch (Exception e) {
            errorLogger(e, "clearText");
        }
    }

    /**
     * This method is used to scroll to bottom page.
     *
     * @param locator
     */
    public static void scrollingToBottomofAPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Method to verify
    public boolean Verification(String locator, String expectedtext) {
        boolean strverify = false;
        try {
            List<AndroidElement> elements = driver.findElements(By.xpath(locator));
            for (WebElement element : elements) {
                scrollingToBottomofAPage();
                if (element.getText().toString().contains(expectedtext)) {
                    System.out.println(expectedtext);
                    strverify = true;
                    break;
                } else {
                    strverify = false;
                }
            }

        } catch (Exception e) {

        }
        return strverify;
    }

  

    /**
     * Create swipe method for iOS XCUITest
     *
     * @param driver
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @param duration
     * @param howManySwipes
     */
  /*  public static void iOSSwipeScreen(int fromX, int fromY, int toX, int toY, double duration, int howManySwipes) {
        // Java
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < howManySwipes; i++) {
            Map<String, Object> params = new HashMap<>();
            params.put("duration", duration);
            params.put("fromX", fromX);
            params.put("fromY", fromY);
            params.put("toX", toX);
            params.put("toY", toY);
            //params.put("element", ((RemoteWebElement) element).getId());
            js.executeScript("mobile: dragFromToForDuration", params);
        }
    }
*/

    /**
     * This method is used to send keys which are related to functional - Ex.Keys.Up, Keys.Enter, Keys.Ctrl etc
     *
     * @param locator
     * @param nontextKeyToSend
     */
    public static void inputKeys(MobileElement locator, Keys nontextKeyToSend) {
        try {
            MobileElement txtEle = locator;
            txtEle.sendKeys(nontextKeyToSend);
        } catch (Exception e) {
            errorLogger(e, "inputKeys");
        }
    }


    /**
     * This method is used to click on any button or link etc.
     *
     * @param locator - Provide locator of element.
     */
    public static void clickElement(MobileElement locator) {
        try {      
        	Thread.sleep(5000);
            if (locator.isEnabled()) {
                locator.click();
            }
        } catch (Exception e) {
            errorLogger(e, "clickElement");
        }
    }

    public static void clickWebElement(WebElement ele) {
        try {
            if (ele.isEnabled()) {
                ele.click();
            }
        } catch (Exception e) {
            errorLogger(e, "clickWebElement");
        }
    }

    /**
     * This method is used to select radio button or to check the checkbox
     *
     * @param locator - Provide locator of element
     */
    public static void setCheckboxOrRadiobtn(MobileElement locator) {
        try {
            if (locator.isEnabled() && !locator.isSelected()) {
                locator.click();
            }
        } catch (Exception e) {
            errorLogger(e, "setCheckboxOrRadiobtn");
        }
    }

    /**
     * This method is used to click on check box to uncheck selection.
     *
     * @param locator - Provide locator of element
     */
    public static void unsetCheckbox(MobileElement locator) {
        try {
            MobileElement ele = locator;
            if ((ele.isEnabled() && ele.isSelected())) {
                ele.click();
            }
        } catch (Exception e) {
            errorLogger(e, "unsetCheckbox");
        }
    }

    /**
     * This method is used to select an option in drop down by text.
     *
     * @param locator - Provide locator element
     * @param text    - Provide text to be selected in drop down.
     */
    public static void selectByText(MobileElement locator, String text) {
        try {
            MobileElement drpEle = locator;
            Select sel = new Select(drpEle);
            sel.selectByVisibleText(text);
        } catch (Exception e) {
            errorLogger(e, "selectByText");
        }
    }

    /**
     * This method is used to get selected option text from dropdown
     *
     * @param locator - Provide locator element
     * @return - return fetched text
     */
    public static String getTextFromDropdown(By locator) {

        WebElement drpEle = driver.findElement(locator);
        Select sel = new Select(drpEle);
        WebElement ele = sel.getFirstSelectedOption();
        return ele.getText();
    }

    public static boolean verifyValueInDropDown(MobileElement locator, String dropDownValue) {
        List<String> optionsList = getDropDownValues(locator);
        return optionsList.contains(dropDownValue);
    }

    public static List<String> getDropDownValues(WebElement locator) {
        List<String> optionList = new ArrayList<String>();
        try {
            WebElement element = locator;
            Select s = new Select(element);
            List<WebElement> options = s.getOptions();
            for (int i = 0; i < options.size(); i++) {
                optionList.add(options.get(i).getText());
            }
        } catch (Exception e) {
            errorLogger(e, "selectByText");
        }
        return optionList;
    }
	

    /**
     * This method is used to get text from a component
     *
     * @param locator - Provide locator element
     * @return - return fetched text
     */
    public static String getText(MobileElement locator) {
        //WebElement ele = driver.findElement(locator);
        String txtToFetch = locator.getText().trim();
        return txtToFetch;
    }


    /**
     * This method is used to get text from a component
     *
     * @param locator - Provide locator element
     * @return - return fetched text
     */
    public static String getText(WebElement ele) {
        //WebElement ele = driver.findElement(locator);
        String txtToFetch = ele.getText().trim();
        return txtToFetch;
    }


    /**
     * This method is used to fetch array of text from a component
     *
     * @param locator - Provide locator element
     * @return - returns array of text
     */
    public static String[] getTextArray(By locator) {
        List<AndroidElement> ele = driver.findElements(locator);
        String[] getElementText = new String[ele.size()];
        for (int i = 0; i < ele.size(); i++) {
            WebElement eleText = ele.get(i);
            if (eleText.getAttribute("value") != null)
                getElementText[i] = eleText.getAttribute("value");
            else
                getElementText[i] = eleText.getText();
        }
        return getElementText;
    }


    /**
     * This method is used to click on any button by injecting javascript.
     *
     * @param locator - Provide locator of element.
     */
    public static String jsGetText(By locator) {
        StringBuilder s = new StringBuilder("");
        try {
            WebElement ele = driver.findElement(locator);
            customSleep(2);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            s.append(executor.executeScript("return arguments[0].value;", ele));

        } catch (Exception e) {
            errorLogger(e, "jsClick");
        }
        return s.toString();
    }


    public static int getCountofElements(By locator) {
        List<AndroidElement> ele = driver.findElements(locator);
        return ele.size();
    }


    /**
     * This method is used to get text of any attribute
     *
     * @param locator       - Provide locator element
     * @param attributeType - Provide value of any attribute. (To get text provide "value")
     * @return return fetched text
     */
    public static String getAttributeValue(MobileElement locator, String attributeType) {
        String txtToFetch = locator.getAttribute(attributeType);
        if (txtToFetch != null)
            txtToFetch = txtToFetch.trim();
        return txtToFetch;
    }


    /**
     * This method is used to get css value of element
     *
     * @param locator       - Provide locator element
     * @param attributeType - Provide value of any attribute. (To get text provide "value")
     * @return return fetched text
     */
    public static String getCssValue(WebElement element, String attributeType) {
        String txtToFetch = element.getCssValue(attributeType).trim();
        return txtToFetch;
    }


    /**
     * This method is used to select an option in drop down by index.
     *
     * @param locator - Provide locator of element.
     * @param text    - Provide index to be selected in drop down.
     */
    public static void selectByIndex(By locator, int index) {
        try {
            WebElement drpEle = driver.findElement(locator);
            Select sel = new Select(drpEle);
            sel.selectByIndex(index);
        } catch (Exception e) {
            errorLogger(e, "selectByIndex");
        }
    }

    /**
     * This method is used to select an option in drop down by value.
     *
     * @param locator - Provide locator element
     * @param text    - Provide value(attribute) to be selected in drop down.
     */
    public static void selectByValue(By locator, String Value) {
        try {
            WebElement drpEle = driver.findElement(locator);
            Select sel = new Select(drpEle);
            sel.selectByValue(Value);
        } catch (Exception e) {
            errorLogger(e, "selectByValue");
        }
    }

    /**
     * This method is used to click on any button by injecting javascript.
     *
     * @param locator - Provide locator of element.
     */
    public static void jsClick(By locator) {
        try {
            WebElement ele = driver.findElement(locator);

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", ele);
        } catch (Exception e) {
            errorLogger(e, "jsClick");
        }
    }

    /**
     * This method is used to find whether element is displayed or not.
     *
     * @param locator
     * @return
     */
    public static boolean isElementDisplayed(MobileElement locator) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        boolean flag = false;
        try {
            MobileElement ele = locator;
            if (ele.isDisplayed())
                flag = true;
            return flag;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }


    /**
     * This method is used to find whether element is displayed or not.
     *
     * @param locator
     * @return
     */
    public static boolean isWebElementDisplayed(WebElement ele) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        boolean flag = false;
        try {
            if (ele.isDisplayed())
                flag = true;
            return flag;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }


    /**
     * This method is used to find whether element is enabled or not.
     *
     * @param locator
     * @return
     */
    public static boolean isElementEnabled(By locator) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean flag = false;
        WebElement ele = driver.findElement(locator);
        try {
            if (ele.isEnabled())
                flag = true;
            else
                flag = false;
            return flag;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }


    /**
     * This method is used to find whether element is selected or not.
     *
     * @param locator
     * @return
     */
    public static boolean isElementSelected(MobileElement locator) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean flag = false;
        MobileElement ele = locator;
        try {
            if (ele.isSelected())
                flag = true;
            else
                flag = false;
            return flag;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }


    /**
     * This method is used to verify any text.
     *
     * @param locator
     * @return
     */
    public static boolean verifyText(MobileElement locator, String expectedText) {
        boolean flag = false;
        String actualText;
        try {
            if (getText(locator).equalsIgnoreCase(""))
                actualText = getAttributeValue(locator, "value");
            else
                actualText = getText(locator);

            if (!actualText.equalsIgnoreCase("") && actualText.equalsIgnoreCase(expectedText))
                flag = true;
            else
                flag = false;
        } catch (Exception e) {
            return false;
        }
        return flag;
    }

    /**
     * @param locator      - Provide locator to which assertion need to be done
     * @param expectedText - Expected text should be passed
     * @return
     */
    public static boolean assertText(MobileElement locator, String expectedText) {
        boolean flag = false;
        String actualText;
        try {
            actualText = getText(locator);
            if (actualText.equalsIgnoreCase("")) {
                actualText = getAttributeValue(locator, "value");
                if (actualText.equalsIgnoreCase("")) {
                    Logger.getLogger(ReUsableMethods.class.getName()).info("No text to fetch for locator : " + locator);
                }
            }
            Assert.assertEquals(actualText, expectedText);
        } catch (Exception e) {
            return false;
        }
        return flag;
    }

    /**
     * @param locator      - Provide locator to which assertion need to be done
     * @param expectedText - Expected text should be passed
     * @return
     */
    public static void assertTextComparison(String actual, String expected, boolean flag, String message) {
        try {
            if (flag == true)
                Assert.assertEquals(actual, expected, message);
            else
                Assert.assertNotSame(actual, expected, message);
        } catch (Exception e) {
            ;
        }
    }

    /**
     * @param locator      - Provide locator to which assertion need to be done
     * @param expectedText - Expected text should be passed
     * @return
     */
    public static boolean softAssertText(MobileElement locator, String expectedText) {
        boolean flag = false;
        String actualText;
        try {
            actualText = getText(locator);
            if (actualText.equalsIgnoreCase("")) {
                actualText = getAttributeValue(locator, "value");
                if (actualText.equalsIgnoreCase("")) {
                    Logger.getLogger(ReUsableMethods.class.getName()).info("No text to fetch for locator : " + locator);
                }
            }
            Assert.assertEquals(actualText, expectedText);
        } catch (Exception e) {
            return false;
        }
        return flag;
    }

    /**
     * This method is used to assert locator/element presence
     *
     * @param locator - Locator to be asserted
     * @param flag    - pass 'true' if element should present
     *                and pass 'false' if element should not present
     */
    public static void assertElementPresence(MobileElement locator, boolean flag, String message) {
        try {
            if (flag == true)
                Assert.assertEquals(isElementDisplayed(locator), true, message);
            else
                Assert.assertEquals(isElementDisplayed(locator), false, message);
        } catch (Exception e) {
            ;
        }
    }


    /**
     * This method is used to assert boolean values
     *
     * @param actual - actual boolean
     */
    public static void assertBoolean(boolean actual, boolean flag, String message) {
        if (flag == true)
            Assert.assertTrue(actual, "AssertFail=====>" + message);
        else
            Assert.assertFalse(actual, "AssertTrue=====>" + message);
    }

    /**
     * This method is used to assert locator/element presence
     *
     * @param locator - Locator to be asserted
     * @param flag    - pass 'true' if element should present
     *                and pass 'false' if element should not present
     */
    public static void softAssertElementPresence(MobileElement locator, boolean flag, String message) {
        try {
            if (flag == true)
                Assert.assertEquals(isElementDisplayed(locator), true, message);
            else
                Assert.assertEquals(isElementDisplayed(locator), false, message);
        } catch (Exception e) {
            ;
        }
    }

    /**
     * This method is used to assert locator/element presence
     *
     * @param actualText   - Actual Text
     * @param expectedText -Expected Text
     * @param message      - message to be asserted if actual and expected values are different
     * @param flag         - pass 'true' if text value should be equal
     *                     and pass 'false' if text value should not be equal
     */
    public static void softAssertTextComparison(String actualText, String expectedText, boolean flag, String message) {
        if (flag == true)
            Assert.assertEquals(actualText, expectedText, message);
        else
            Assert.assertNotSame(actualText, expectedText, message);
    }

    /**
     * This method is used to assert boolean values
     *
     * @param actual  - actual boolean
     * @param flag    - provide 'true' to validate availability
     * @param message - message to be asserted if actual if false
     */
    public static void softAssertBoolean(boolean actual, boolean flag, String message) {
        if (flag == true)
            Assert.assertTrue(actual, message);
        else
            Assert.assertFalse(actual, message);
    }

    /**
     * This method is used to assert boolean values
     *
     * @param actual   - actual boolean
     * @param expected - expected boolean
     * @param message  - message to be asserted if actual and expected values are different
     */
    //public static void assertAllSoftAssertions() {
    //    Assert.asssss
    //}

    /**
     * This method is used to return web element.
     *
     * @param locator - Provide locator of element.
     */
    public static WebElement webElement(By locator) {
        try {
            return driver.findElement(locator);
        } catch (Exception e) {
            errorLogger(e, "Locator not found - webElement");
            Assert.fail("Locator not found" + locator);
        }
        return null;
    }

    /**
     * This method is used to return mobile elements.
     *
     * @param locator - Provide locator of element.
     */

    public static List<MobileElement> mobileElements(List<MobileElement> locator) {
        return locator;
    }


    /**
     * This method is used to pause execution until element is visible.
     *
     * @param locator - Provide locator of element.
     * @param timeout - Provide timeout in seconds.
     * @return
     */
    public static WebElement wdWaitVisibility(By locator, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            WebElement loc = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return loc;
        } catch (Exception e) {
            errorLogger(e, "wdWaitVisibility");
        }
        return null;
    }


    /**
     * This method is used to pause execution until element is invisible.
     *
     * @param locator - Provide locator of element.
     * @param timeout - Provide timeout in seconds.
     * @return
     */
    public static Boolean wdWaitInVisibility(By locator, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Boolean loc = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return loc;
        } catch (Exception e) {
            errorLogger(e, "wdWaitInVisibility");
        }
        return null;
    }
    
    /*
     * */
     
    public static boolean isElementPresent(WebElement elementName, int timeout){
        //long time = duration.getTime();
        //TimeUnit unit = duration.getTimeUnit(); 
 	try{
                // duration.setTime(100, TimeUnit.MILLISECONDS);
 	        WebDriverWait wait = new WebDriverWait(driver, timeout);
 	        wait.until(ExpectedConditions.visibilityOf(elementName));
 	        return true;
 	}catch(Exception e){
 	    return false;
 	}
        finally {
              //duration.setTime(time, unit);
       }
	
	}


    /**
     * This method is used to pause execution until element is clickable.
     *
     * @param locator - Provide locator of element.
     * @param timeout - Provide timeout in seconds.
     * @return
     */
    public static WebElement wdWaitClickable(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
            return ele;
        } catch (Exception e) {
            errorLogger(e, "wdWaitClickable");
        }
        return null;
    }


    /**
     * This method is used to wait and switch between frames.
     *
     * @param locator
     * @param timeout
     * @return
     */
    public static WebElement wdWaitForFrameAndSwitchToIt(By locator, long timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            WebElement ele = (WebElement) wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
            return ele;
        } catch (Exception e) {
            errorLogger(e, "wdWaitForFrameAndSwitchToIt");
        }
        return null;
    }


    /**
     * This method is used to wait for an element with fluent wait.
     *
     * @param locator - Locator at which it should wait
     * @param timeout - Timeout
     *                TODO: Need to test this method with a valid scenario.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void wdFluentWaitVisibility(final By locator, long timeout) {
        try {
            FluentWait wait = new FluentWait(driver);
            wait.withTimeout(30, TimeUnit.SECONDS);
            wait.pollingEvery(3, TimeUnit.SECONDS);
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            errorLogger(e, "wdFluentWaitVisibility");
        }
    }


    /**
     * This method is used to switch between windows.
     *
     * @param - Provide window title.
     */
    public static void switchToWindow(String windowTitle) {
        try {
            Set<String> winhandles = driver.getWindowHandles();
            for (String currentWindow : winhandles) {
                driver.switchTo().window(currentWindow);
                String title = driver.getTitle();
                if (title.equalsIgnoreCase(windowTitle)) {
                    break;
                }
            }
        } catch (Exception e) {
            errorLogger(e, "switchToWindow");
        }
    }

    //for letters
    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    //for numbers
    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    /**
     * This method returns a random number.
     */
    public static int genarateRandomNumber() {
        return Integer.parseInt("" + new Random().nextInt(1234));
    }


   /* *//**
     * This method is used to switch between frames
     *
     * @param switchTodefaultframe - Provide true or false for switching to default frame as required
     * @param frameLocator         - Provide locator of element
     * @param divEle
     *//*
    public static void switchToFrame(Boolean switchTodefaultframe, By frameLocator, WebElement... divEle) {
        try {
            if (switchTodefaultframe) {
                driver.switchTo().defaultContent();
            }
            int x = divEle.length;
            if (x > 0) {
                driver.switchTo().frame(divEle[0].findElement(frameLocator));
            } else {
                driver.switchTo().frame(driver.findElement(frameLocator));
            }
        } catch (Exception e) {
            errorLogger(e, "switchToFrame");
        }
    }*/

    /**
     * This method is used to switch root frame
     */
    public static void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public static void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    /**
     * This method is used to wait for 3 sec.
     *
     * @param timeOut
     */
    public static void customSleep(long timeOut) {
        try {
            Thread.sleep(timeOut * 1000);
        } catch (InterruptedException e) {
            errorLogger(e, "customSleep");
        }
    }

    /**
     * This method is used to wait for a locator during execution with thread sleep.
     */
    public static void customSleep(By locator, int timeOut) {
        try {
            for (int i = 1; i <= timeOut; i++) {
                if (!driver.findElement(locator).isDisplayed())
                    Thread.sleep(1000);
                else
                    break;
            }
        } catch (InterruptedException e) {
            errorLogger(e, "customSleep");
        }
    }

    /**
     * This method is used to right click on the web element
     *
     * @param ele - web element
     */
    public static void actionContextClick(By locator) {
        try {
            action = new Actions(driver);
            action.contextClick(driver.findElement(locator)).perform();
        } catch (Exception e) {
            errorLogger(e, "contextClick");
        }
    }


    /**
     * This method is used to click on the web element with Actions class
     *
     * @param ele - web element
     */
    public static void actionClick(WebElement ele) {
        try {
            action = new Actions(driver);
            action.click(ele).perform();
        } catch (Exception e) {
            errorLogger(e, "actionClick");
        }
    }

    /**
     * This method is used to click on the web element with Actions class
     *
     * @param ele - web element
     */
    public static void actionClick(By locator) {
        try {
            action = new Actions(driver);
            action.click(driver.findElement(locator)).perform();
        } catch (Exception e) {
            errorLogger(e, "actionClick");
        }
    }


    /**
     * This method is used to double click on the web element with Actions class
     *
     * @param ele
     */
    public static void actionDoubleClick(By locator) {
        try {
            WebElement ele = driver.findElement(locator);
            action = new Actions(driver);
            action.doubleClick(ele).perform();
        } catch (Exception e) {
            errorLogger(e, "actionClick");
        }
    }


    /**
     * This method is used to send keys with Actions class
     *
     * @param value
     */
    public static void actionSendKeysWithEnter(String value) {
        try {
            action = new Actions(driver);
            action.sendKeys(value).sendKeys(Keys.ENTER).perform();
        } catch (Exception e) {
            errorLogger(e, "actionSendKeys");
        }
    }


    /**
     * This method is used to send non text keys Actions class
     *
     * @param value
     */
    public static void actionInputKeys(Keys value) {
        try {
            action = new Actions(driver);
            action.sendKeys(value).perform();
        } catch (Exception e) {
            errorLogger(e, "actionSendKeys");
        }
    }


    /**
     * This method is used to move mouse pointer on the web element with Actions class
     *
     * @param loc
     */
    public static void actionMoveToElement(By locator) {
        try {
            action = new Actions(driver);
            WebElement ele = driver.findElement(locator);
            action.moveToElement(ele).perform();
        } catch (Exception e) {
            errorLogger(e, "Move action");
        }
    }

    /**
     * This method is used to move mouse pointer on the web page to given offset with Actions class
     *
     * @param ele
     * @param x
     * @param y
     */
    public static void actionMoveToElementOffset(By locator, int x, int y) {
        try {
            WebElement ele = driver.findElement(locator);
            action = new Actions(driver);
            action.moveToElement(ele, x, y).click().perform();
        } catch (Exception e) {
            errorLogger(e, "Move to element action");
        }
    }


    /**
     * This method is used to move mouse cursor with robot class
     */
    public static void moveCursor() {
        try {
            Robot robot = new Robot();
            robot.mouseMove(0, 70);
        } catch (Exception e) {
            errorLogger(e, "actionSendKeys");
        }
    }

    /**
     * This method is used to launch URL
     *
     * @param url
     */
    public static void urlToLogin(String url) {
        try {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            errorLogger(e, "urlToLogin");
        }

        if (driver.getPageSource().contains("This site canít be reached")) {
            Assert.fail("This site canít be reached --- Check Apache Tomee Service Status or Check hostname in config.properties");
        } else if (driver.getPageSource().contains("HTTP Status 500 - Unexpected exception")) {
            Assert.fail("HTTP Status 500 - Unexpected exception --- Check Monitor Service Status");
        } else {
            //Logger.getLogger(ReusableMethods.class.getName()).info("URL launch is successful");
        }
    }


    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public enum Navigation {
        REFRESH("Refresh"),
        FORWARD("Forward"),
        BACK("Back");
        private final String type;

        private Navigation(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    /**
     * This method is used to refresh webpage
     */
    public static void pageNavigation(Navigation navigate) {
        if (navigate.toString().equalsIgnoreCase("Refresh"))
            driver.navigate().refresh();
        else if (navigate.toString().equalsIgnoreCase("forward"))
            driver.navigate().forward();
        else if (navigate.toString().equalsIgnoreCase("back"))
            driver.navigate().back();
    }

    /**
     * This method is used to close the current window
     */
    public static void wdClose() {
        try {
            driver.close();
        } catch (Exception e) {
            errorLogger(e, "wdClose");
        }
    }

    /**
     * This method is used to close all the instances of this driver
     */
    public static void wdQuit() {
        try {
            driver.quit();
        } catch (Exception e) {
            errorLogger(e, "wdQuit");
        }
    }


    /**
     * This method is used to find size (height and width) of an element
     *
     * @param locator
     * @return type of this method is {height, width}
     */
    public static int[] sizeOfElement(MobileElement locator) {
        int[] size = new int[2];
        int height = 0, width = 0;
        if (isElementDisplayed(locator)) {
            height = locator.getSize().getHeight();
            width = locator.getSize().getWidth();
            size[0] = height;
            size[1] = width;
        }
        return size;
    }

    /**
     * This method is used for getting date and time stamp
     *
     * @return
     */
    public static String dateTimeFormatting(String requiredFormat) {
        Date todaysDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(requiredFormat);
        String formattedDate = formatter.format(todaysDate);
        return formattedDate;
    }

    /**
     * This method is used to increment date or time for a required period of time
     *
     * @param actualDate     - Date & Time can be system or custom.
     * @param inputType      - Date or time to be incremented
     * @param incrementTo    - Value to be increased to.
     * @param dateTimeFormat
     * @return
     * @throws ParseException
     */
    public static String dateTimeIncrementer(String actualDate, int inputType, int incrementTo, String dateTimeFormat) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(dateTimeFormat); //Sample date format is MM/dd/yyyy h:mm a
        Date expectedDate = format.parse(actualDate);

        Calendar calendarAdd = Calendar.getInstance();
        calendarAdd.setTime(expectedDate);
        calendarAdd.add(inputType, incrementTo);

        String convertedDate = format.format(calendarAdd.getTime());
        return convertedDate;
    }

    /**
     * This method is used to increment or decrement date for a required number of days
     *
     * @param requiredFormat        - In which format date has to be converted and returned
     * @param actualDate            - Date & Time can be system or custom.
     * @param daysToIncrmtORDcrmt   - Number Days to be incremented or decremented (For increment pass '+' and for decrement pass '-'))
     * @param monthsToIncrmtORDcrmt - Number of Months to be incremented or decremented
     * @param yearsToIncrmtORDcrmt  - Number of Years to be incremented or decremented
     * @return
     * @throws ParseException
     */
    public static String dateIncrementerORDecrementer(String requiredFormat, String actualDate, int daysToIncrmtORDcrmt, int monthsToIncrmtORDcrmt, int yearsToIncrmtORDcrmt) {
        SimpleDateFormat format = new SimpleDateFormat(requiredFormat);
        Date expectedDate = null;
        try {
            expectedDate = format.parse(actualDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        Calendar calendarAdd = Calendar.getInstance();
        calendarAdd.setTime(expectedDate);
        if (daysToIncrmtORDcrmt != 0)
            calendarAdd.add(Calendar.DATE, daysToIncrmtORDcrmt);
        if (monthsToIncrmtORDcrmt != 0)
            calendarAdd.add(Calendar.MONTH, monthsToIncrmtORDcrmt);
        if (yearsToIncrmtORDcrmt != 0)
            calendarAdd.add(Calendar.YEAR, yearsToIncrmtORDcrmt);

        String convertedDate = format.format(calendarAdd.getTime());
        return convertedDate;
    }

    /**
     * This method is used to take screenshot.
     *
     * @param fileName
     * @return
     */
    public static String screenShot(String fileName) {
        screenShotFlag = true;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Results/Screenshots/" + fileName + "_" + dateTimeFormatting("ddMM_HHmmss") + ".jpg"));
        } catch (IOException e) {
            errorLogger(e, "screenShot");
        }
        return fileName;
    }

    /**
     * This method contains logger and screenshot & can be used for catch blocks
     *
     * @param e
     * @param screenShotName
     */
    public static void errorLogger(Exception e, String screenShotName) {
        Assert.fail(screenShotName, e);
        Logger.getLogger(ReUsableMethods.class.getName()).error(e, e);
        screenShot(screenShotName);
    }

    public static int getIndexOfString(String string, String subString, int fromIndex) {

        int index = string.indexOf(subString);
        int count = 1;
        while (index >= 0 && fromIndex > count) {
            while (count < fromIndex) {
                index = string.indexOf(subString, index + subString.length());
                count++;
            }
        }
        return index;
    }

    public static String getPortionOfString(String text, int beginIndex, int endIndex) {
        return text.substring(beginIndex, endIndex);
    }

    /**
     * This method is used to create webelement
     *
     * @param base
     * @param locator
     * @return
     */
    public static WebElement elementFinder(WebElement base, By locator) {
        customSleep(1);
        WebElement ele = base.findElement(locator);
        return ele;
    }

    /**
     * This method is used to convert hexadecimal string into RGB string
     *
     * @param hexaValue take hexa format value ex:#4c1130
     */
    public static String getRGBValue(String hexaValue) {
        String pattern = null;
        final int[] rgb = new int[3];
        for (int i = 0; i < 3; i++) {
            rgb[i] = Integer.parseInt(hexaValue.replace("#", "").substring(i * 2, i * 2 + 2), 16);
        }
        pattern = +rgb[0] + ", " + rgb[1] + ", " + rgb[2];
        return pattern;
    }

    public enum ColorCodes {
        COLOR_BLACK("#000000"),

        COLOR_WHITE("#FFFFFF"),

        COLOR_SILVER("#C0C0C0"),

        COLOR_GRAY("#808080"),

        COLOR_RED("#FF0000"),

        COLOR_MAROON("#800000"),

        COLOR_YELLOW("#FFFF00"),

        COLOR_OLIVE("#808000"),

        COLOR_LIME("#00FF00"),

        COLOR_GREEN("#008000"),

        COLOR_AQUA("#00FFFF"),

        COLOR_TEAL("#008080"),

        COLOR_BLUE("#0000FF"),

        COLOR_NAVY("#000080"),

        COLOR_FUCHSIA("#FF00FF"),

        COLOR_PURPLE("#800080");

        private final String color;

        private ColorCodes(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    public enum FontStyle {
        FONT_BOLD("bold"),

        FONT_ITALIC("italic"),

        FONT_UNDERLINE("underline"),

        FONT_UNDEFINED("undefined");

        private final String fontFamily;

        private FontStyle(String fontFamily) {
            this.fontFamily = fontFamily;
        }

        @Override
        public String toString() {
            return fontFamily;
        }
    }

    /**
     * This method is used to get values form list.
     *
     * @param locator - Provide locator of element.
     *//*
	public static String getElements(List<WebElement> locator) {
		try {

			locator.click();

		} catch (Exception e) {
			errorLogger(e, "clickElement");
		}
	}

	String list=null;

	return list;
}*/
    public static String getScreenshot(String screenshotName) throws Exception {
        // below line is just to append the date format with the screenshot name to
        // avoid duplicate names
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src
        // folder
        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
                + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        // Returns the captured file path
        return destination;
    }

    public static void screenShot(ITestResult result) {
        screenShotFlag = true;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Results/Screenshots/" + result + "_"
                    + dateTimeFormatting("ddMM_HHmmss") + ".jpg"));
        } catch (IOException e) {
            errorLogger(e, "screenShot");
        }
    }

    // Capture Screen Shot and save in the location
    public static String captureScreenshot(String screenShotName) {
        String path = "";
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date dt = new Date();
        String html = "";
        try {
            System.out.println(dateFormat.format(dt));
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            html = covertScreenshotToBase64(source, screenShotName);
            path = System.getProperty("user.dir") + File.separator + "screenshots";
            createDirectory(path);
            FileUtils.copyFile(source, new File(path + File.separator + dateFormat.format(dt) + "_" + screenShotName + ".png"));
            System.out.println("screenshot is taken");

        } catch (Exception e) {
            System.out.println("exception while taking screenshot" + e.getMessage());
        }
        return html;
    }

    @SuppressWarnings("resource")
    public static String covertScreenshotToBase64(File file, String name) {
        try {
            FileInputStream fis = new FileInputStream(file);
            byte byteArray[] = new byte[(int) file.length()];
            fis.read(byteArray);
            String imageString = Base64.encodeBase64String(byteArray);
            return doImageClickAnimation(imageString, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String doImageClickAnimation(String img, String screenName) {

        String image = "<img onclick='clickImage(this)' src=\"data:image/png;base64, " + img + "\" alt=\"" + screenName + "\" width=\"320\" height=\"569\"/>";
        return image;
    }

    public static boolean createDirectory(String directory) {
        File fileDirectory = new File(directory);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
            return true;
        }
        return false;
    }

    @SuppressWarnings("resource")
    public static String convertScreenshotToBase64(File file, String name) {
        try {
            FileInputStream fis = new FileInputStream(file);
            byte byteArray[] = new byte[(int) file.length()];
            fis.read(byteArray);
            String imageString = Base64.encodeBase64String(byteArray);
            return doImageClickAnimation(imageString, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Swipe left or right in the images carousel
     *
     * @param string direction "left" or "right" -- lower case
     * @param int    number of swipes created by Reddi
     */
    @SuppressWarnings("deprecation")
    public void swipeImagesCarousel(String someDirection, int numberOfSwipes) {
        Dimension size;
        // Get the size of screen.
        size = driver.manage().window().getSize();
        // System.out.println(size);

        // Find swipe x points from screen's with and height.
        // Find x1 point which is at right side of screen.
        int x1 = (int) (size.width * 0.20);
        // Find x2 point which is at left side of screen.
        int x2 = (int) (size.width * 0.90);
        int y1 = (int) (size.height * 0.80);
        TouchAction action = new TouchAction((MobileDriver) driver);
        if (someDirection == "left") {
            // Find element to swipe from right to left.
            WebElement ele1 = (WebElement) driver.findElementByXPath("//android.widget.TextView[3]");
            // Create swipe action chain and perform horizontal(right to left) swipe.
            // Here swipe to point x1 Is at left side of screen. So It will swipe element
            // from right to left.
          //  action.longPress(ele1).moveTo(x1, y1).release().perform();
        }
        ;
        if (someDirection == "right") {
            // Find element to swipe from left to right.
            WebElement ele2 = (WebElement) driver.findElementByXPath("//android.widget.TextView[2]");
            // Create swipe action chain and perform horizontal(left to right) swipe.
            // Here swipe to point x2 Is at right side of screen. So It will swipe element
            // from left to right.
           // action.longPress(ele2).moveTo(x2, y1).release().perform();
        }
    }

    /**
  

    /**
     * @param elelment
     * @return
     * @throws Exception
     * @author reddi
     * @summary-scroll actionsand swipe down
     * @date-10/07/2018
     */
    public static void scroll_IOS(MobileElement locator, String direction) throws Exception {
        //WebElement elements = driver.findElementByAccessibilityId("match_to_order_table_view");
        MobileElement elements = locator;
        //WebElement elements = driver.findElementByAccessibilityId(locaotr);
        for (int second = 0; ; second++) {
            if (second >= 15) {
                break;
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap scrollObjects = new HashMap();
            scrollObjects.put("direction", direction);
            scrollObjects.put("element", ((RemoteWebElement) elements).getId());
            js.executeScript("mobile: scroll", scrollObjects);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("scroll stopped working");
            }
        }
    }

    public static void swipe_IOS(List<MobileElement> locator,int x, String direction) throws Exception {
        
        List<MobileElement> elements = locator;        
        for (int second = 0; ; second++) {
            if (second >= 5) {
                break;
            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap scrollObjects = new HashMap();
            scrollObjects.put("direction", direction);
            scrollObjects.put("element", ((RemoteWebElement) locator.get(x)).getId());
            js.executeScript("mobile: swipe", scrollObjects);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("scroll stopped working");
            }
        }
    }


    /**
     * @param element
     * @return true or false boolean whether element present
     * @throws Exception
     * @author reddi
     * @summary-scroll actions and swipe down
     * @date-10/07/2018
     */
    public static boolean swipeToDirection_iOS_XCTestElement(MobileElement el, String direction) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, String> swipeObject = new HashMap<String, String>();
            if (direction.equals("d")) {
                swipeObject.put("direction", "down");
            } else if (direction.equals("u")) {
                swipeObject.put("direction", "up");
            } else if (direction.equals("l")) {
                swipeObject.put("direction", "left");
            } else if (direction.equals("r")) {
                swipeObject.put("direction", "right");
            }
            swipeObject.put("element", el.getId());
            js.executeScript("mobile:swipe", swipeObject);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}