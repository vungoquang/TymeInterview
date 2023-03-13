package tyme.testcases.android;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tyme.pageobjects.TymePO;
import utils.BaseTest;
import utils.PropertyUtils;

import java.io.IOException;
import java.util.Properties;

public class TymeDemo extends BaseTest {
    TymePO getAPIDemoPO;
    Properties loadMessageData;

    public TymeDemo() throws IOException {
        this.loadMessageData= PropertyUtils.readPropertiesFile("src/test/java/tyme/testdata/Message.properties");
    }

    @BeforeTest
    @Override
    public void setUpPage() {

    }

    @Test(groups= {"Smoke"})
    public void tymeDemoTestCase(){
        getAPIDemoPO = new TymePO(driver);
        getAPIDemoPO.checkApiDemosTextDisplay();
        getAPIDemoPO.tapOnAppMenuItem();
        getAPIDemoPO.tapOnActivityMenuItem();
        getAPIDemoPO.swipeDownToBottom();
        getAPIDemoPO.tapOnSoftInputModesMenuItem();
        getAPIDemoPO.checkSoftInputModesTextIsDisplay(loadMessageData.getProperty("soft_input_mode"));
        getAPIDemoPO.tapOnResizeMode();
        getAPIDemoPO.tapOnPanItem();
        getAPIDemoPO.checkPanItemIsDisplay();
        getAPIDemoPO.checkRedBoxLargerThanGreenBox();
        getAPIDemoPO.clearAllTextsAndFillToGreenBox(loadMessageData.getProperty("input_25_lines"));
        getAPIDemoPO.checkGreenBoxLargerThanRedBox();
    }

}
