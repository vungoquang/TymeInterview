package tyme.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import utils.AppiumUtils;
import utils.BasePO;

public class TymePO extends BasePO {

    /**
     * A base constructor that sets the page's driver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the before suite method.
     */
    public TymePO(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='API Demos']")
    public MobileElement lbApiDemos;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='App']")
    public MobileElement mnApp;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Activity']")
    public MobileElement mnActivity;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Soft Input Modes']")
    public MobileElement mnSoftInputModes;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Shows how different soft input modes impact application resizing due to an input method.']")
    public MobileElement txtSoftInputModes;

    @AndroidFindBy(id = "resize_mode")
    public MobileElement drlResizeMode;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][@text='Pan']")
    public MobileElement drlDisplayPanItem;

    @AndroidFindBy(xpath = "//*[@class='android.widget.CheckedTextView'][@text='Pan']")
    public MobileElement drliPan;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][(contains(@text,'This is a part of the application'))]")
    public MobileElement bxRed;

    @AndroidFindBy(id="saved")
    public MobileElement txtGreen;




    /**
     * This method use to check API Demos text existed after open app
     *
     * @param
     * @return
     */
    public void checkApiDemosTextDisplay(){
        lbApiDemos.isDisplayed();
    }


    /**
     * This method will tap on App menu item.
     *
     * @param
     * @ return
     */
    public void tapOnAppMenuItem(){
        mnApp.click();
    }

    /**
     * This method will tap on Activity menu item.
     *
     * @param
     * @ return
     */
    public void tapOnActivityMenuItem(){
        mnActivity.click();
    }

    /**
     * This method will swipe down list menu to bottom
     *
     * @param
     * @ return
     */
    public void swipeDownToBottom(){
        AppiumUtils.scrollToAnElementByText(driver,"Soft Input Modes");
    }

    /**
     * This method will tap on Soft Input Modes menu item.
     *
     * @param
     * @ return
     */
    public void tapOnSoftInputModesMenuItem(){
        mnSoftInputModes.click();
    }

    /**
     * This method will check Soft Input Modes Text Is Display .
     *
     * @param expectedMessage
     * @ return
     */
    public void checkSoftInputModesTextIsDisplay(String expectedMessage){
        String actualMessage= txtSoftInputModes.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }


    /**
     * This method will tap on Resize mode dropdown list .
     *
     * @param
     * @ return
     */
    public void tapOnResizeMode(){
        drlResizeMode.click();
    }

    /**
     * This method will tap on Pan dropdown list item .
     *
     * @param
     * @ return
     */
    public void tapOnPanItem(){
        drliPan.click();
    }


    /**
     * This method use to check item is displayed after select from dropdown list
     *
     * @param
     * @return
     */
    public void checkPanItemIsDisplay() {
//        WaitUtils.staticWait(10000);
        drlDisplayPanItem.isDisplayed();
    }

    /**
     * This method will check height of Red Box Larger Than height of Green Box .
     *
     * @param
     * @ return
     */
    public void checkRedBoxLargerThanGreenBox(){
        float heightOfRedBox= bxRed.getSize().getHeight();
        float heightOfGreenBox= txtGreen.getSize().getHeight();
        Assert.assertTrue(heightOfRedBox > heightOfGreenBox, "Rex box less than green box ");
    }

    /**
     * This method will clear all text and fill new text into Green Box .
     *
     * @param
     * @ return
     */
    public void clearAllTextsAndFillToGreenBox(String textContent){
        //clear all text
        txtGreen.click();
        txtGreen.clear();
        //fill value
        txtGreen.setValue(textContent);
        driver.hideKeyboard();
    }

    /**
     * This method will check height of Red Box Larger Than height of Green Box .
     *
     * @param
     * @ return
     */
    public void checkGreenBoxLargerThanRedBox(){
        float heightOfRedBox= bxRed.getSize().getHeight();
        float heightOfGreenBox= txtGreen.getSize().getHeight();
        Assert.assertTrue(heightOfRedBox < heightOfGreenBox, "Rex box less than green box ");
    }
}
