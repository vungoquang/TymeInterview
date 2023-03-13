package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

/**
 * This class contains custom appium/selenium methods for Webelement
 *
 * @author prat3ik
 */
public class AppiumUtils {

    /**
     * This method use to scroll to specific text on screen. It's only used for android
     * @param toText
     */
    public static WebElement scrollToAnElementByText(AppiumDriver driver, String toText) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + toText + "\"));"));
    }

    /**
     * This method is for static wait
     *
     * @param millis
     */
    public static void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }



}