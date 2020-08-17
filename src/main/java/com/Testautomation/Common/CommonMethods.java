package com.Testautomation.Common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class CommonMethods {
    public static AppiumDriver driver;
    public static int DEFAULT_TIMEOUT = 15;
    static Logger logger = Logger.getLogger(CommonMethods.class);

    public CommonMethods(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void turnOnImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    public void turnOffImplicitWaits(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void pauseExecutionFor(long lTimeInMilliSeconds) {
        try {
            Thread.sleep(lTimeInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageToLoad(MobileElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToDisAppear(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    
    public static MobileElement waitForElement(MobileElement arg) {
        //waitForPageToLoad(arg);
        MobileElement ml = arg;
        return ml;
    }

    public void swipeRightUntilLogOutScreen() {
        do {
            swipeRight();
        } while (!isElementPresent(By.id("")));
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void swipeLeftUntilTextExists(String expected) {
        do {
            swipeLeft();
        } while (!driver.getPageSource().contains(expected));
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;

        //new TouchAction(driver).press(startx, starty).waitAction(Duration.ofSeconds(2)).moveTo(endx, starty).release()
           //     .perform();
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        //new TouchAction(driver).longPress().waitAction(Duration.ofSeconds(3000)).moveTo(endx, starty)
         //       .release();
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

        logger.info("Current context" + driver.getContext());
    }

    /**
     * method to clickbackbutton
     *
     * @param miliSeconds
     */
    public void clickBackButton() {
        driver.navigate().back(); 
    }

    /**
     * method to agetcurrentmethodname
     *
     * @param miliSeconds
     */
    public String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    /**
     * method with boldHTML
     *
     * @param miliSeconds
     */
    public String withBoldHTML(String string) {
        if (!string.trim().isEmpty()) {
            return "<b>" + string + "</b>";
        } else {
            return "";
        }
    }

    /**
     * method to add verifications in login screen
     *
     * @param miliSeconds
     */

    public static String verification() {
        String strerrormsg = null;
        try {
            // waitForExpectedElement(driver, GETTINGERRORTEXT);
            strerrormsg = "pass";
        } catch (Exception e) {
            e.getMessage();
            strerrormsg = "fail";
        }
        return strerrormsg;
    }

    /**
     * SetDelay
     *
     * @param miliSeconds
     */
    public static void SetDelay(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            System.out.println("An error happened while in sleep");
        }
    }

    /**
     * Verify if a check box is checked
     *
     * @param driver, WebElement
     */
    public static boolean isSelected(AppiumDriver driver, WebElement obj) {
        if (obj.getAttribute("checked").equals("true"))
            return true;
        else
            return false;
    }

    /**
     * Check if element is present
     *
     * @param driver
     */
    public static boolean isElementPresent(AppiumDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    /**
     * Get text from element
     *
     * @param driver
     */
    public static String getText(AppiumDriver driver, MobileElement locator) {
        return locator.getText();
    }

    /**
     * Check if element is present inside a webElement
     *
     * @param driver
     */
    public static boolean isElementPresent(WebElement element, By locator) {
        return element.findElements(locator).size() > 0;
    }

    /* *//**
     * Turn ON - Airplane mode
     *
     * @param driver
     *//*
     * public static void turnOnAirplandeMode( AppiumDriver driver ) { if(driver
     * instance of io.appium.java_client.ios.IOSDriver) throw new
     * IllegalArgumentException("This operation is not supported currently with IOSDriver "
     * );
     *
     * NetworkConnectionSetting connection = new NetworkConnectionSetting(true,
     * false , false ); connection.setAirplaneMode( true ); ( ( AndroidDriver )
     * driver ).setNetworkConnection( connection ); ( ( AndroidBy ) driver
     * ).setConnection(Connection.AIRPLANE); }
     */

    /**
     * @param imgA the first image.
     * @param imgB the second image.
     * @return whether the images are both the same or not.
     * @throws IOException
     * @ Compares two images pixel by pixel.
     */
    public static boolean compareImages(String img1, String img2) throws IOException {
        BufferedImage imgA = null;
        try {
            imgA = ImageIO.read(new File(img1));
        } catch (IOException e) {
        }
        BufferedImage imgB = null;
        try {
            imgB = ImageIO.read(new File(img2));
        } catch (IOException e) {
        }

        // The images must be the same size.
        if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
            int width = imgA.getWidth();
            int height = imgA.getHeight();

            // Loop over every pixel.
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Compare the pixels for equality.
                    if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public static String getRandomWord(int length) {
        String r = "";
        for (int i = 0; i < length; i++) {
            r += (char) (Math.random() * 26 + 97);
        }
        return r;
    }

    /**
     * Generates random integer from a range
     *
     * @param min
     * @param max
     * @return - random integer
     */
    public static int getRandomNum(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    /**
     * Tewsts skipped
     *
     * @return - skipped list
     */
    public void onTestSkipped(ITestResult tr) {
        logger.info("[TEST IS SKIPPED -------- Test case " + tr.getMethod().getMethodName() + " skipped]");
    }

    /**
     * on test finish
     *
     * @return - failed teswt removal count
     */
    public void onFinish(ITestContext context) {
        Iterator<ITestResult> listOfFailedTests = context.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (context.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }
    }

    public static FileOutputStream getFileOutputStream(final String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        return fos;
    }

    public static InputStream loadInputStream(final String classpathLocation, final String fileSystemLocation)
            throws IOException {
        InputStream in = null;

        in = CommonMethods.class.getResourceAsStream(classpathLocation);
        if (in == null) {
            in = new FileInputStream(fileSystemLocation);
        }
        return in;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns test dat file path attached at test class
     *
     * @return the path string
     */
    public static String getTestDataFilePath(final String className) {
        String fileSep = File.separator;
        return System.getProperty("user.dir") + fileSep + "test" + fileSep + "resources" + fileSep + "testdata"
                + fileSep + className + ".xlsx";
    }

    /**
     * clicks mobile element
     *
     * @param locator
     * @return
     */
    public static void click(MobileElement locator) {
        waitForElement(locator);
        locator.click();


    }

    public void type(MobileElement locator, String input) {
        locator.sendKeys(input);
    }


    public void type(MobileElement locator, Keys input) {
        locator.sendKeys(input);
    }

    /**
     * clears element data
     *
     * @param locator
     */

    public void clear(MobileElement locator) {
        locator.clear();
    }

    /**
     * Returns current Date Time
     *
     * @return
     */
    public static String getDateTime() {
        String sDateTime = "";
        try {
            SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
            Date now = new Date();
            String strDate = sdfDate.format(now);
            String strTime = sdfTime.format(now);
            strTime = strTime.replace(":", "-");
            sDateTime = "D" + strDate + "_T" + strTime;
        } catch (Exception e) {
            System.err.println(e);
        }
        return sDateTime;
    }

    /**
     * cclears escreenshots
     *
     * @param locator
     */
    public static String takeSnapShotAndRetPath(WebDriver driver, String methodName) throws Exception {

        String FullSnapShotFilePath = "";

        try {
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            String sFilename = null;
            sFilename = "Screenshot-" + methodName + getDateTime() + ".png";
            FullSnapShotFilePath = System.getProperty("user.dir")
                    + "\\output\\ScreenShots\\" + sFilename;
            FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
        } catch (Exception e) {

        }

        return FullSnapShotFilePath;
    }

    public static String takeSnapShotAndRetPath(WebDriver driver) throws Exception {

        String FullSnapShotFilePath = "";
        try {
            logger.info("Taking Screenshot");
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            String sFilename = null;
            sFilename = "verificationFailure_Screenshot.png";
            FullSnapShotFilePath = System.getProperty("user.dir")
                    + "\\output\\ScreenShots\\" + sFilename;
            FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
        } catch (Exception e) {

        }

        return FullSnapShotFilePath;
    }

    public void movetToElementJavascript(MobileElement locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                locator);
    }

    public String getAttribute(MobileElement locator, String name) {
        return locator.getAttribute(name);
    }

    /**
     * Purpose:This Method return text value of Element.
     *
     * @param by
     * @return
     * @returnType: String
     */
    public static String getText(MobileElement locator) {
        return locator.getText().trim();
    }

    /**
     * Purpose:This Method drag and drop actions
     *
     * @param locator
     * @return
     */

    public void fnDragAndDrop(MobileElement locator) throws InterruptedException {
        WebElement Slider = locator;
        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(Slider);
        moveSlider.dragAndDropBy(Slider, 150, 0).build().perform();
    }

    /**
     * Checks if element is visible Purpose:
     *
     * @author:
     * @date:
     * @returnType: MobileElement
     */
    public static boolean isElementVisible(MobileElement locator) {
        try {
            Thread.sleep(8000);
            return locator.isDisplayed() ? true : false;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Checks if element is visible Purpose:
     *
     * @author:
     * @date:
     * @returnType: WebElement
     */
    public boolean isElementVisible(By by) {
        try {
            turnOffImplicitWaits(3);
            return driver.findElement(by).isDisplayed() ? true : false;
        } catch (Exception ex) {
            return false;
        } finally {
            turnOnImplicitWaits();
        }
    }

    //method to login screen
    public String verification(MobileElement locator) {
        String strerrormsg = null;
        try {
            waitForElement(locator);
            strerrormsg = "pass";
        } catch (Exception e) {
            e.getMessage();
            strerrormsg = "fail";

        }
        return strerrormsg;
    }

    // method to get error message
    public static String getAlertMessage(MobileElement locator) {
        String alertMessage = null;
        try {
            waitForElement(locator);
            alertMessage = locator.getText();
            System.out.println(alertMessage);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Element Not Found");
        }
        return alertMessage;
    }


    public void waitForElementPresent(MobileElement locator) {
        logger.info("wait started for " + locator);
        int timeout = 10;
        turnOffImplicitWaits(1);
        boolean isElementFound = false;
        for (int i = 1; i <= timeout; i++) {
            try {
                if (((Set) locator).size() == 0) {
                    pauseExecutionFor(1000);
                    logger.info("waiting...");
                    continue;
                } else {
                    logger.info("wait over,element found");
                    isElementFound = true;
                    //pauseExecutionFor(1000);
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
        turnOnImplicitWaits();
        if (isElementFound == false)
            logger.info("ELEMENT NOT FOUND");
    }

    public void waitForElementPresent(By locator, int timeout) {
        logger.info("wait started for " + locator);
        turnOffImplicitWaits(1);
        boolean isElementFound = false;
        for (int i = 1; i <= timeout; i++) {
            try {
                if (driver.findElements(locator).size() == 0) {
                    pauseExecutionFor(1000);
                    logger.info("waiting...");
                    continue;
                } else {
                    logger.info("wait over,element found");
                    isElementFound = true;
                    pauseExecutionFor(1000);
                    break;
                }
            } catch (Exception e) {
                continue;
            } finally {
                turnOnImplicitWaits();
            }
        }
        if (isElementFound == false)
            logger.info("ELEMENT NOT FOUND");
    }

    public void waitForElementIsPresent(By locator, int timeout) {
        logger.info("wait started for " + locator);
        turnOffImplicitWaits(1);
        boolean isElementFound = false;
        for (int i = 1; i <= timeout; i++) {
            Dimension d = driver.findElement(locator).getSize();
            if (d.getWidth() > 0 && d.getHeight() > 0) {
                isElementFound = true;
                logger.info("wait over,element found");
                break;
            } else {
                logger.info("waiting...");
                pauseExecutionFor(1000);
            }
        }
        turnOnImplicitWaits();
        if (isElementFound == false)
            logger.info("ELEMENT NOT FOUND");
    }

    public void quickWaitForElementPresent(By locator) {
        logger.info("quick wait started for " + locator);
        int timeout = 2;
        turnOffImplicitWaits(3);
        for (int i = 1; i <= timeout; i++) {
            try {
                if (driver.findElements(locator).size() == 0) {
                    pauseExecutionFor(1000);
                    logger.info("waiting...");
                    continue;
                } else {
                    logger.info("wait over,element found");
                    turnOnImplicitWaits();
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public void quickWaitForElementPresent(By locator, int timeout) {
        logger.info("quick wait started for " + locator);
        turnOffImplicitWaits(1);
        for (int i = 1; i <= timeout; i++) {
            try {
                if (driver.findElements(locator).size() == 0) {
                    pauseExecutionFor(1000);
                    logger.info("waiting...");
                    continue;
                } else {
                    logger.info("wait over,element found");
                    turnOnImplicitWaits();
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public void waitForElementNotPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
            logger.info("waiting for locator " + locator);
            wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
            logger.info("Element found");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void waitForElementNotPresent(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            logger.info("waiting for locator " + locator);
            wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
            logger.info("Element found");
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void selectFromList(List<WebElement> lstElementList, String sValueToBeSelected) throws Exception {
        logger.info("START OF FUNCTION->selectFromList");
        boolean flag = false;
        logger.info("Total element found --> " + lstElementList.size());
        logger.info("Value to be selected " + sValueToBeSelected + " from list" + lstElementList);
        for (WebElement e : lstElementList) {
            logger.info(">>>>>>>>>>>>>" + e.getText() + "<<<<<<<<<<<<<<<");
            if (e.getText().equalsIgnoreCase(sValueToBeSelected)) {
                logger.info("Value matched in list as->" + e.getText());
                e.click();
                flag = true;
                break;
            }
        }
        if (flag == false) {
            throw new Exception("No match found in the list for value->" + sValueToBeSelected);
        }
        logger.info("END OF FUNCTION->selectFromList");
    }

    public void clickByJS(MobileElement locator) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", locator);
    }

    public String validateErrorMessage() {
        return driver.getPageSource();
    }

    /**
     * Grabs any text contained inside of each of these error-related elements.
     *
     * @param elements
     * @return Extracts the text and returns a formatted string from the arg.
     */
    public static String extractText(List<WebElement> elements) {

        String msg = "";

        try {

            for (WebElement e : elements) {
                if (e.getText() != null && !e.getText().isEmpty()) {
                    msg += "\n\t" + e.getText();
                }
            }

        } catch (Exception ex) {
            // We actually risk running into stale-elements, as always.
            ex.printStackTrace();
        }

        return msg;
    }

    /**
     * A major side-effect of scrolling to an element trigger in a change in the
     * DOM and then will void the internal cache of the Web Element.
     * <p>
     * Note: This attempts to target Chrome browsers only not FF.
     *
     * @param driver
     * @param element
     */
    public static void scrollToElement(MobileElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    /**
     * Unlike {@link Utils#scrollToElement(WebDriver, WebElement)}, this will
     * scroll to the elment regardless of the browser type.
     *
     * @param driver
     * @param element
     */
    public static void scrollTo(WebDriver driver, WebElement element) {
        int yOffset = ((Locatable) element).getCoordinates().onPage().getY();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,"
                + yOffset + ");");
    }


}
