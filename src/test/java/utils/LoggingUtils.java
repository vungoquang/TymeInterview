package utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoggingUtils extends TestListenerAdapter {
    private File logFile;
    // It executes for on each test Start
    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        String testSuite = result.getTestContext().getName();
        String testName = testSuite + "_" + result.getName();
        System.out.println("Test Method Started :" + testSuite);
        System.out.println("Test Method Started :" + testName);
    }
    // It executes for only Passed tests
    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        if (logFile != null) {
            logFile.delete();
        }
        System.out.println(result.getName() + ":Passed");
    }
    // It executes for only Failed tests
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + ":Failed");
    }
    // It executes for only Skipped tests
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + ":Skipped");
        super.onTestSkipped(result);
        String testName = result.getName();
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File file = new File(System.getProperty("user.dir") + "/src/test/testreports" + testName + "_" + time + ".log");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// No need to implement all the methods. Can leave empty.
    }
    // It executes for on Suite start
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test on Start :" + context.getName());
    }
    // It executes for on Suite finish
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test on Finish :" + context.getName());
    }
}