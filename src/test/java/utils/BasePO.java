package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

/**
 * Year: 2020/22
 *
 * author: vungo
 * project: POM_Automation_Framework
 */
public class BasePO {
    public final static int IMPLICIT_WAIT = PropertyUtils.getIntegerProperty("implicitWait", 15);
    protected final AppiumDriver driver;

    /**
     * A base constructor that sets the page's driver
     *
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     *
     * @param driver the appium driver created in the beforesuite method.
     */
    protected BasePO(AppiumDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(IMPLICIT_WAIT)), this);
    }

}