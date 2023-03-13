package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Year: 2020-22
 * An abstract base for all of the Android tests within this package
 * Responsible for setting up the Appium test Driver
 *
 * author: vungo
 * project: POM_Automation_Framework
 */

@Listeners({ScreenshotUtility.class})
public abstract class BaseTest<alwaysRun> extends AppiumServer {
    /**
     * As driver static it will be created only once and used across all of the test classes.
     */
    public static AppiumDriver driver;
    public final static String APPIUM_SERVER_URL = PropertyUtils.getProperty("appium.server.url");

    public final static String PLATFORM = PropertyUtils.getProperty("android.platform");
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 30);


    /**
     * This method will run at the time of Test Suite so it will run at once through out the execution
     *
     * Appium is a client - server model:
     * So we need to set up appium client in order to connect to Device appium server.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUpAppium() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
            if(PLATFORM.equals("Android")){
            setDesiredCapabilitiesForAndroid(capabilities);
        }else{
            throw new Exception("Platform is not support");
        }
        driver = new AndroidDriver<>(new URL(APPIUM_SERVER_URL), capabilities);
    }

    /**
     * This method will be called everytime before your test runs
     */
    @BeforeTest
    public abstract void setUpPage();


    /**
     * This method will always execute after each test case, This will quit the WebDriver instance called at the last
     */
    @AfterMethod(alwaysRun = true)
    public void afterMethod(final ITestResult result){
        String fileName = result.getTestClass().getName() + "_" + result.getName();
        System.out.println("Test Case: [" + fileName + "] executed..!");
    }

    /**
     * This method will be called after class finishes the execution of all tests
     */
    @AfterClass
    public void afterClass() {
    }

    /**
     * At the end of the Test Suite(At last) this method would be called
     */
    @AfterSuite(alwaysRun = true)
    public void tearDownAppium() {
        quitDriver();
    }

    /**
     * It will set the DesiredCapabilities for the Android local execution
     *
     * @param desiredCapabilities
     */
    private void setDesiredCapabilitiesForAndroid(DesiredCapabilities desiredCapabilities) {
        String APP_NAME = PropertyUtils.getProperty("android.app.name");
        String APP_RELATIVE_PATH = PropertyUtils.getProperty("android.app.location") + APP_NAME;

        //Start appium server
        AppiumServer serverJava= new AppiumServer();
        serverJava.startServer();
        //Set capabilities for device


        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, PropertyUtils.getProperty("android.device.name"));
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyUtils.getProperty("android.platform"));
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyUtils.getProperty("android.platform.version"));
        desiredCapabilities.setCapability(MobileCapabilityType.APP, getAbsolutePath(APP_RELATIVE_PATH));
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, PropertyUtils.getProperty("android.app.full.reset"));
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, PropertyUtils.getProperty("android.app.no.reset"));
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    }


    /**
     * It will set the DesiredCapabilities for the Android local execution
     */
    public static WebDriver getScreenshotableWebDriver() {
        final WebDriver augmentedDriver = new Augmenter().augment(driver);
        return augmentedDriver;
    }

    /**
     * This will set implicit wait
     *
     * @param driver
     */
    private static void setTimeOuts(AppiumDriver driver) {
        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    /**
     * It will get absolute path from relative path
     * @param appRelativePath
     * @return absolutePath
     */
    private static String getAbsolutePath(String appRelativePath) {
        File file = new File(appRelativePath);
        return file.getAbsolutePath();
    }

    /**
     * This will quite the android driver instance
     * @param
     * @return
     */
    private void quitDriver() {
        try {
            this.driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}